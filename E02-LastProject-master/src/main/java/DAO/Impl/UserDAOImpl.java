package DAO.Impl;

import Controller.EmailController;
import DAO.UserDAO;
import Entity.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Criteria;

import javax.annotation.Resource;
import java.util.List;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

    private List<UserEntity> users;
    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Override
    public UserEntity getUserByID(String userID) {
        String photosHQL = "FROM UserEntity WHERE userID = :userId";
        Query query = sessionFactory.getCurrentSession().createQuery(photosHQL);
        query.setParameter("userId", userID);
        return  (UserEntity)query.uniqueResult();
    }

    @Override
    public UserEntity getUserByUniqueEmailCode(String uniqueEmailCode) {
        String photosHQL = "FROM UserEntity WHERE uniqueEmailCode = :uniqueEmailCode";
        Query query = sessionFactory.getCurrentSession().createQuery(photosHQL);
        query.setParameter("uniqueEmailCode", uniqueEmailCode);
        return  (UserEntity)query.uniqueResult();
    }
    @Override
    public void createUser(UserEntity client) {
        sessionFactory.getCurrentSession().save(client);
        EmailController.sendConfirmation(client.getEmail(),client.getUniqueEmailCode());
    }

    @Override
    public void updateUser(UserEntity user) {
        UserEntity mergedUser = (UserEntity) sessionFactory.getCurrentSession().merge(user);
        sessionFactory.getCurrentSession().update(mergedUser);
    }
    @Override
    public List<UserEntity> getUsers() {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);

        users = criteria.list();

        return users;
    }



}
