package tkpd.tokopedia.com.simpleretrofit.model;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("director")
    private String director;
    @SerializedName("description")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
