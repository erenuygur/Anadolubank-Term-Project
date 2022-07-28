package com.erenuygur.repository;

import com.erenuygur.model.Agency;
import com.erenuygur.model.CustomerPolicy;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@NoArgsConstructor
@Data
public class CustomerPolicyRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public CustomerPolicy getCustomerPolicy(int id) throws Exception {
        Session session = this.sessionFactory.openSession();
        CustomerPolicy foundCustomerPolicy = session.get(CustomerPolicy.class, id);
        if (foundCustomerPolicy != null) {
            return foundCustomerPolicy;
        }
        throw new Exception("CustomerPolicy does not exist!");
    }

    public List<CustomerPolicy> getAllCustomerPolicy() {
        try {
            Session session = this.sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<CustomerPolicy> criteriaQuery = criteriaBuilder.createQuery(CustomerPolicy.class);
            Root<CustomerPolicy> root = criteriaQuery.from(CustomerPolicy.class);

            CriteriaQuery<CustomerPolicy> criteriaQuery2 = criteriaQuery.select(root);
            Query query = session.createQuery(criteriaQuery2); // Query<CustomerPolicy>
            List<CustomerPolicy> customerPolicyList = query.getResultList();

            return customerPolicyList;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<CustomerPolicy>();
        }
    }

    public LinkedHashMap<String, Double> getTotalAmountByYear() {
        Session session = this.sessionFactory.openSession();
        LinkedHashMap<String, Double> totalAmountByYearList = new LinkedHashMap<>();

        String hql = " select extract (year from cp.date) as year, sum(insuranceAmount) from CustomerPolicy " +
                "cp group by extract (year from cp.date) order by extract (year from cp.date)";
        List<Object> list = session.createQuery(hql).getResultList();

        for (int i = 0; i < list.size(); i++) {
            Object[] row = (Object[]) list.get(i);
            String year = row[0].toString();
            double payment = (double) row[1];

            totalAmountByYearList.put(year,payment);
        }

        return totalAmountByYearList;
    }

}
