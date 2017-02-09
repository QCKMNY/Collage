package Entity;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by Alex on 08.02.2017.
 */
public class CollageEntity {
    @Id
    @Column(name = "idCollage")
    private String userID;

    @Column(name = "idUser")
    private String uniqueEmailCode;

    @Column(name = "name")
    private String name;

}
