package service;

import domain.ChatRecord;
import domain.User;

import java.util.List;


public interface UserService {
    List<ChatRecord> findAllRelation(String username1);
}
