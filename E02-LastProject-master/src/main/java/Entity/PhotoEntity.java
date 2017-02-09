package Entity;

import javax.persistence.*;

/**
 * Created by Alex on 08.02.2017.
 */
@Entity
@Table(name = "photo")
public class PhotoEntity {
    @Id
    @Column(name = "photoID")
    private String photoID;

//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//    @JoinColumn(name = "userID")
@Column(name = "userID")
   private String userID;

    public PhotoEntity() {
    }

    public PhotoEntity(String photoID, String userID) {
        this.photoID = photoID;
        this.userID = userID;
    }

    public String getPhotoID() {
        return photoID;
    }

    public void setPhotoID(String photoID) {
        this.photoID = photoID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
