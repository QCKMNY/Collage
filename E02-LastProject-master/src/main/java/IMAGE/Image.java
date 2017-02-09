package IMAGE;

/**
 * Created by Alex on 07.02.2017.
 */
public class Image {

        private String name;
        private String sourceUri;

    public Image() {
    }

    public Image(String name, String sourceUri) {
        this.name = name;
        this.sourceUri = sourceUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceUri() {
        return sourceUri;
    }

    public void setSourceUri(String sourceUri) {
        this.sourceUri = sourceUri;
    }
}

