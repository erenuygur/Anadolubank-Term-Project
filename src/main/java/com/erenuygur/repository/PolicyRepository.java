package com.erenuygur.repository;

import com.erenuygur.model.CustomerPolicy;
import com.erenuygur.model.Policy;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


@NoArgsConstructor
@Data
public class PolicyRepository {
    private SessionFactory sessionFactory;

    public Policy create(Policy policy) {
        return new Policy();
    }


    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Policy getPolicy(int id) throws Exception {
        Session session = this.sessionFactory.openSession();
        Policy foundPolicy = session.get(Policy.class, id);
        if (foundPolicy != null) {
            return foundPolicy;
        }
        throw new Exception("CustomerPolicy does not exist!");
    }

    public List<Policy> getAllPolicy() {
        try {
            Session session = this.sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Policy> criteriaQuery = criteriaBuilder.createQuery(Policy.class);
            Root<Policy> root = criteriaQuery.from(Policy.class);

            CriteriaQuery<Policy> criteriaQuery2 = criteriaQuery.select(root);
            Query query = session.createQuery(criteriaQuery2); // Query<Policy>
            List<Policy> policyList = query.getResultList();
            return policyList;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<Policy>();
        }
    }


    public LinkedHashMap<String, Integer> getPolicyName() {
        Session session = this.sessionFactory.openSession();
        LinkedHashMap<String, Integer> policyNameAndTotalPayment = new LinkedHashMap<>();
        String sql = "select p.\"name\",count(*) as quantitiy from customer_policy cp,policy p  " +
                "where cp.agency_id =p.id group by p.\"name\"\n";

        List<Object> list = session.createNativeQuery(sql).getResultList();

        for (int i = 0; i < list.size(); i++) {
            Object[] row = (Object[]) list.get(i);
            String policyName = row[0].toString();
            int amount = ((BigInteger) row[1]).intValue();

            policyNameAndTotalPayment.put(policyName, amount);
        }
        return policyNameAndTotalPayment;
    }


}
