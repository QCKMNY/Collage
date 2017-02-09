package DAO;

import Entity.PhotoEntity;
import Entity.UserEntity;

import java.util.List;

/**
 * Created by Alex on 09.02.2017.
 */
public interface PhotoDAO {

    void createPhoto(PhotoEntity photo);
    void updatePhoto(PhotoEntity photo);
    List<PhotoEntity> getPhotosByUser(UserEntity user);
}
