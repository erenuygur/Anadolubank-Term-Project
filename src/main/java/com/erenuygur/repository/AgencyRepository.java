package com.erenuygur.repository;

import com.erenuygur.model.Agency;
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
public class AgencyRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Agency getAgency(int id) throws Exception {
        Session session = this.sessionFactory.openSession();
        Agency foundAgency = session.get(Agency.class, id);
        if (foundAgency != null) {
            return foundAgency;
        }
        throw new Exception("Agency does not exist!");
    }

    public List<Agency> getAllAgency() {
        try {
            Session session = this.sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Agency> criteriaQuery = criteriaBuilder.createQuery(Agency.class);
            Root<Agency> root = criteriaQuery.from(Agency.class);

            CriteriaQuery<Agency> criteriaQuery2 = criteriaQuery.select(root);
            Query query = session.createQuery(criteriaQuery2); // Query<Agency>
            List<Agency> agencyList = query.getResultList();
            return agencyList;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<Agency>();
        }
    }


}
