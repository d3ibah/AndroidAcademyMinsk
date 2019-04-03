package by.androidacademyminsk.les_05_Retrofit.entity.github;

public class GithubRepo {

    private String name;
    private String owner;
    private String url;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return(name + " " +  url);
    }
}
