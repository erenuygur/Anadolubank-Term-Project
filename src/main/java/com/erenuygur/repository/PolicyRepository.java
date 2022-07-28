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
import java.util.ArrayList;
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
}
