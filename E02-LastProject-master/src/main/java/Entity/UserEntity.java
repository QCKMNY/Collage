package Entity;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "suser")
public class UserEntity implements Serializable {

    @Id
    @Column(name = "userID")
    private String userID;

    @Column(name = "uniqueEmailCode")
    private String uniqueEmailCode;

    @Column(name = "email")
    private String email;

    @Column(name = "passwordHash")
    private String passwordHash;

    @Column(name = "confirmation")
    private boolean confirmation;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "statusId")
//    private List<ApplicationEntity> applicationsById;

    public UserEntity(String userID, String email, String password) {
        this.userID = userID;
        this.email = email;
        this.confirmation=false;
        this.passwordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        this.uniqueEmailCode = java.util.UUID.randomUUID().toString();
    }

    public UserEntity() {
    }

    public UserEntity(String userID, String uniqueEmailCode, String email, String passwordHash, boolean confirmation) {
        this.userID = userID;
        this.uniqueEmailCode = uniqueEmailCode;
        this.email = email;
        this.passwordHash = passwordHash;
        this.confirmation = confirmation;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUniqueEmailCode() {
        return uniqueEmailCode;
    }

    public void setUniqueEmailCode(String uniqueEmailCode) {
        this.uniqueEmailCode = uniqueEmailCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }
}
