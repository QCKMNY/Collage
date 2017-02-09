package DAO.Impl;

import DAO.PhotoDAO;
import Entity.PhotoEntity;
import Entity.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alex on 09.02.2017.
 */
@Repository("photoDAO")
@Transactional
public class PhotoDAOImpl implements PhotoDAO {
    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;


    @Override
    public void createPhoto(PhotoEntity photo) {
        sessionFactory.getCurrentSession().save(photo);
        }

    @Override
    public void updatePhoto(PhotoEntity photo) {
        PhotoEntity mergedPhoto = (PhotoEntity) sessionFactory.getCurrentSession().merge(photo);
        sessionFactory.getCurrentSession().update(mergedPhoto);

    }

    @Override
    public List<PhotoEntity> getPhotosByUser(UserEntity user) {
        String photosHQL = "FROM PhotoEntity WHERE userID = :userId";
            Query query = sessionFactory.getCurrentSession().createQuery(photosHQL);
            query.setParameter("userId", user.getUserID());
            return  query.list();
        //uniqueResult();
    }

}
