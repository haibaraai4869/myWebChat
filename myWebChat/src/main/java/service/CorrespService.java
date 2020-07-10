package service;

import domain.UserRelation;
import domain.CorrespondRecord;

import java.util.List;

public interface CorrespService {
    List<CorrespondRecord> getAllChatRecord(String username1,String username2);

    void addChatRecords(String senduser, String acceptuser, String chatTime, String chatRecord);

    List<UserRelation> getAllFriendRequest(String username2);
}
