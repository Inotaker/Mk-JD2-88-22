package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.api.IUserStorage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api.HibernateInitializer;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api.entity.UserEntity;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.mapper.UserMapper;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class HibernateStorageUser implements IUserStorage {

    private static final HibernateStorageUser instance = new HibernateStorageUser();
    private static final UserMapper mapper = UserMapper.getInstance();

    @Override
    public User selectOne(String username) {
        EntityManager manager = HibernateInitializer.getInstance().getManager();
        manager.getTransaction().begin();

        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = query.from(UserEntity.class);
        query.select(root).where(root.get("username").in(username));

        try {
            UserEntity userEntity = manager.createQuery(query).getSingleResult();
            manager.getTransaction().commit();
            return mapper.toDto(userEntity);
        } catch (NoResultException e) {
            return null;
        } finally {
            manager.close();
        }
    }

    @Override
    public void insert(User user) {
        EntityManager manager = HibernateInitializer.getInstance().getManager();
        manager.getTransaction().begin();

        this.add(user, manager);

        manager.getTransaction().commit();
        manager.close();
    }

    public void add(User user, EntityManager manager) throws RollbackException {
        if (this.selectOne(user.getUsername()) != null) {
            manager.close();
            throw new IllegalArgumentException("Пользователь с логином " + user.getUsername() + " уже существует");
        }

        if (manager == null) {
            manager = HibernateInitializer.getInstance().getManager();
        }

        UserMapper userMapper = new UserMapper();
        manager.persist(userMapper.toEntity(user));
    }

    public static HibernateStorageUser getInstance() {
        return instance;
    }

}

