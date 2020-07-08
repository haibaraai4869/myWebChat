package domain;

public class UsernamePicPathMap {

    private String username;
    private String picPath;

    @Override
    public String toString() {
        return "UsernamePicPathMap{" +
                "username='" + username + '\'' +
                ", picPath='" + picPath + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
