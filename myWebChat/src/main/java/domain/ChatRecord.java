package domain;

import java.util.Date;

public class ChatRecord {
    private String username1;
    private String username2;
    private String requestConform;

    public String getRequestConform() {
        return requestConform;
    }

    public void setRequestConform(String requestConform) {
        this.requestConform = requestConform;
    }

    public String getUsername1() {
        return username1;
    }

    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    public String getUsername2() {
        return username2;
    }

    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    @Override
    public String toString() {
        return "ChatRecord{" +
                "username1='" + username1 + '\'' +
                ", username2='" + username2 + '\'' +
                ", requestConform='" + requestConform + '\'' +
                '}';
    }
}
