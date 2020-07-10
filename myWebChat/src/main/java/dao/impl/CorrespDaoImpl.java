package dao.impl;

import dao.CorrespDao;
import domain.ChatRecord;
import domain.CorrespondRecord;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

public class CorrespDaoImpl implements CorrespDao {
    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<CorrespondRecord> getAllChatRecord(String username1, String username2) {
        String sql="select * from correspInfo where (senduser = ? and acceptuser = ?) or " +
                "(senduser = ? and acceptuser = ?)";//多条件查询要复习
        List<CorrespondRecord> list = jt.query(sql, new BeanPropertyRowMapper<CorrespondRecord>(CorrespondRecord.class), username1, username2,username2,username1);
        return list;
    }

    @Override
    public void addChatRecords(String senduser, String acceptuser, String chatTime, String chatRecord) {
        String sql="insert into correspInfo (senduser,acceptuser,chatTime,chatRecord) values (?,?,?,?)";
        jt.update(sql,senduser,acceptuser,chatTime,chatRecord);
    }

    @Override
    public List<ChatRecord> getAllFriendRequest(String username2) {
        try {
            String sql="select * from chatRecord where username2 = ? and requestConform is NULL";
            List<ChatRecord> foundRequest = jt.query(sql, new BeanPropertyRowMapper<ChatRecord>(ChatRecord.class), username2);
            return foundRequest;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
