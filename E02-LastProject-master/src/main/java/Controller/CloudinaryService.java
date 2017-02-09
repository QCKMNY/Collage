package Controller;

import com.cloudinary.Api;
import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 09.02.2017.
 */

@Repository("cloudinaryService")
public class CloudinaryService {
    private Api api;
    private Cloudinary cloudinary;

    String imageHtml(String imageID){return cloudinary.url().format("jpg")
            .transformation(new Transformation().width(100).height(150).crop("fill"))
            .imageTag(imageID, cloudinary.asMap("alt",imageID,"id",imageID,"class","CloudinaryImage"));}// with id
    //.imageTag(imageID, cloudinary.asMap("alt","Sample Image","class","CloudinaryImage"));}//no id

    CloudinaryService(){
        Map config = ObjectUtils.asMap(
                "cloud_name", "depejwdfb",
                "api_key", "338123839493786",
                "api_secret", "Xgz-nPcxLOxufon5WPG518aZ8iM");

        cloudinary=new Cloudinary(config);
        api = cloudinary.api();
    }
    public List<String> getPhotoByUserID(String userID) throws Exception {
        return mapParser(api.resources(ObjectUtils.emptyMap()));
    }
    public List<String> getAllPhoto() throws Exception {
       return mapParser(api.resources(ObjectUtils.emptyMap()));
    }
    private List mapParser(Map map){
        List <String> endResult=new LinkedList<String>();
        List<Map> lists= (List<Map>) map.get("resources");
        for(Map i : lists) endResult.add(imageHtml((String) i.get("public_id")));
    return endResult;
    }

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }

    public Cloudinary getCloudinary() {
        return cloudinary;
    }

    public void setCloudinary(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }
//    public String getPhotoDiv(){
//        <div class="ui-draggable makeMeDraggable" style="position: relative;">
//        return
//    }
}
