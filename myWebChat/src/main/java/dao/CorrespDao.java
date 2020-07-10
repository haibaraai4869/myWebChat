package dao;

import domain.ChatRecord;
import domain.CorrespondRecord;

import java.util.List;

public interface CorrespDao {
    List<CorrespondRecord> getAllChatRecord(String username1, String username2);

    void addChatRecords(String senduser, String acceptuser, String chatTime, String chatRecord);

    List<ChatRecord> getAllFriendRequest(String username2);
}
