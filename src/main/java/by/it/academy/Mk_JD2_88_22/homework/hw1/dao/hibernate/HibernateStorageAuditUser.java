package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.Pageable;
import by.it.academy.Mk_JD2_88_22.homework.hw1.model.AuditUser;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.api.IAuditUserStorage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api.HibernateInitializer;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api.entity.AuditUserEntity;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.mapper.AuditUserMapper;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class HibernateStorageAuditUser implements IAuditUserStorage {

    private static final HibernateStorageAuditUser instance = new HibernateStorageAuditUser();

    public static HibernateStorageAuditUser getInstance() {
        return instance;
    }

    @Override
    public ArrayList<AuditUser> select() {
        return null;
    }

    @Override
    public Long insert(AuditUser auditUser) {
        EntityManager manager = HibernateInitializer.getInstance().getManager();
        manager.getTransaction().begin();

        Long result = this.insert(auditUser, manager);

        manager.getTransaction().commit();
        manager.close();

        return result;
    }

    //для HibernateStorageUserWithAuditDecorator
    public Long insert(AuditUser auditUser, EntityManager manager) {
        if (manager == null) {
            manager = HibernateInitializer.getInstance().getManager();
        }

        AuditUserMapper mapper = new AuditUserMapper();
        AuditUserEntity auditUserEntity = mapper.toEntity(auditUser);

        manager.persist(auditUserEntity);

        return auditUserEntity.getId();
    }

    @Override
    public List<AuditUser> select(Pageable pageable) {
        Integer limit = null;
        Integer offset = null;

        if (pageable != null) {
            if (pageable.getSize() > 0) {
                limit = pageable.getSize();
            }

            if (limit != null && pageable.getPage() > 0) {
                offset = (pageable.getPage() - 1) * limit;
            }
        }

        EntityManager manager = HibernateInitializer.getInstance().getManager();
        manager.getTransaction().begin();

        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<AuditUserEntity> query = cb.createQuery(AuditUserEntity.class);
        Root<AuditUserEntity> root = query.from(AuditUserEntity.class);
        query.select(root);

        List<AuditUserEntity> entities = manager.createQuery(query)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();

        manager.getTransaction().commit();

        List<AuditUser> result = new ArrayList<>();
        AuditUserMapper mapper = new AuditUserMapper();

        for (AuditUserEntity entity : entities) {
            result.add(mapper.toDto(entity));
        }

        return result;
    }
}
