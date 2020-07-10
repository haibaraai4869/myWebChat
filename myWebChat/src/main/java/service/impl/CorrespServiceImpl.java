package service.impl;

import dao.CorrespDao;
import dao.UserDao;
import dao.impl.CorrespDaoImpl;
import dao.impl.UserDaoImpl;
import domain.ChatRecord;
import domain.CorrespondRecord;
import service.CorrespService;

import java.util.List;

public class CorrespServiceImpl implements CorrespService {

    @Override
    public List<CorrespondRecord> getAllChatRecord(String username1, String username2) {
        CorrespDao correspdao = new CorrespDaoImpl();
        List<CorrespondRecord> allChatRecord = correspdao.getAllChatRecord(username1, username2);
        return allChatRecord;
    }

    @Override
    public void addChatRecords(String senduser, String acceptuser, String chatTime, String chatRecord) {
        CorrespDao correspdao = new CorrespDaoImpl();
        correspdao.addChatRecords(senduser,acceptuser,chatTime,chatRecord);
    }

    @Override
    public List<ChatRecord> getAllFriendRequest(String username2) {
        CorrespDao correspdao = new CorrespDaoImpl();
        List<ChatRecord> allFriendRequest = correspdao.getAllFriendRequest(username2);
        return allFriendRequest;
    }
}
