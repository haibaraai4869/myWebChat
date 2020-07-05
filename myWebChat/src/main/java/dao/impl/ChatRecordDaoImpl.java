package dao.impl;

import dao.ChatRecordDao;
import domain.ChatRecord;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class ChatRecordDaoImpl implements ChatRecordDao {
    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<ChatRecord> findAllRecord(String username1, String username2) {
        return null;
    }

    @Override
    public boolean isFriend(String username1, String username2) {
        return false;
    }
}
