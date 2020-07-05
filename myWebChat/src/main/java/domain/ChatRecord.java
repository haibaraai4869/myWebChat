package domain;

import java.util.Date;

public class ChatRecord {
    private String username1;
    private String username2;
    private Date chatTime;
    private String chatRecord;

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

    public Date getChatTime() {
        return chatTime;
    }

    public void setChatTime(Date chatTime) {
        this.chatTime = chatTime;
    }

    public String getChatRecord() {
        return chatRecord;
    }

    public void setChatRecord(String chatRecord) {
        this.chatRecord = chatRecord;
    }

    @Override
    public String toString() {
        return "ChatRecord{" +
                "username1='" + username1 + '\'' +
                ", username2='" + username2 + '\'' +
                ", chatTime=" + chatTime +
                ", chatRecord='" + chatRecord + '\'' +
                '}';
    }
}
