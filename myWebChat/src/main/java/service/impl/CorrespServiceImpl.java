package service.impl;

import dao.CorrespDao;
import dao.impl.CorrespDaoImpl;
import domain.UserRelation;
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
    public List<UserRelation> getAllFriendRequest(String username2) {
        CorrespDao correspdao = new CorrespDaoImpl();
        List<UserRelation> allFriendRequest = correspdao.getAllFriendRequest(username2);
        return allFriendRequest;
    }
}
