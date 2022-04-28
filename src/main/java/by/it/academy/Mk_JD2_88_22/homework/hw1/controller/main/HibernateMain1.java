package by.it.academy.Mk_JD2_88_22.homework.hw1.controller.main;

import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api.HibernateInitializer;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HibernateMain1 {
    public static void main(String[] args) {
        HibernateInitializer initializer = HibernateInitializer.getInstance();
        EntityManager manager = initializer.getManager();

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = builder.createQuery(UserEntity.class);
        Root<UserEntity> from = query.from(UserEntity.class);
        query.select(from);

        List<UserEntity> resultList = manager.createQuery(query).getResultList();
        for (UserEntity user : resultList) {
            System.err.println(user);
        }



    }
}
