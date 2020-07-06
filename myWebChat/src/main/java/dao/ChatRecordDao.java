package dao;

import domain.ChatRecord;

import java.util.List;

public interface ChatRecordDao {
    List<ChatRecord> findAllRecord(String username1,String username2);

    boolean isFriend(String username1,String username2);
}
