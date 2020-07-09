package domain;

import java.util.Date;

public class CorrespondRecord {
    private String senduser;
    private String acceptuser;
    private Date chatTime;
    private String chatRecord;

    @Override
    public String toString() {
        return "CorrespondRecord{" +
                "senduser='" + senduser + '\'' +
                ", acceptuser='" + acceptuser + '\'' +
                ", chatTime=" + chatTime +
                ", chatRecord='" + chatRecord + '\'' +
                '}';
    }

    public String getSenduser() {
        return senduser;
    }

    public void setSenduser(String senduser) {
        this.senduser = senduser;
    }

    public String getAcceptuser() {
        return acceptuser;
    }

    public void setAcceptuser(String acceptuser) {
        this.acceptuser = acceptuser;
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
}
