package by.it.academy.Mk_JD2_88_22.classwork.controllers.mains;

import by.it.academy.Mk_JD2_88_22.classwork.storage.hibernate.FlightsEntity;
import by.it.academy.Mk_JD2_88_22.classwork.storage.hibernate.HibernateInitializer;
import org.apache.http.entity.FileEntity;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class HibernateMain1 {
    public static void main(String[] args) {
        HibernateInitializer hibernateInitializer = HibernateInitializer.getInstance();
        EntityManager manager = hibernateInitializer.getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<FlightsEntity> query = builder.createQuery(FlightsEntity.class);
        Root<FlightsEntity> from = query.from(FlightsEntity.class);
        query.select(from);

        List<FlightsEntity> resultList = manager.createQuery(query).getResultList();
        for (FlightsEntity flights : resultList) {
            System.out.println(flights);
        }



    }
}
