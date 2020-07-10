package dao.impl;

import dao.UserRelationDao;
import domain.UserRelation;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class UserRelationDaoImpl implements UserRelationDao {
    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<UserRelation> findAllRelation(String username1) {
        try {
            String sql="select * from userRelation where username1 = ? and requestConform = 'Y'";
            List<UserRelation> relationList = jt.query(sql, new BeanPropertyRowMapper<UserRelation>(UserRelation.class), username1);
            return relationList;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean addUserByUsername(String username1,String username2) {
        try {
            String sql ="insert into userRelation (username1,username2) values (?,?)";
            jt.update(sql,username1,username2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteUserByUsername(String username1, String username2) {
        try {
            String sql="delete from userRelation where username1=? and username2 = ? or username1 = ? and username2 = ?";
            jt.update(sql,username1,username2,username2,username1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int countFriendByUsername(String username1) {
        try {
            String sql="select count(*) from userRelation where username1 = ?";
            Integer friendNum = jt.queryForObject(sql,Integer.class, username1);
            return friendNum;
        } catch (DataAccessException e) {
            return 0;
        }
    }
    @Override
    public void addExchangeFriend1(String username1, String username2) {
        try {
            String sql ="update userRelation set requestConform = 'Y' where username1 = ? and username2 = ?";
            jt.update(sql,username1,username2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addExchangeFriend2(String username2, String username1) {
        try {
            String sql ="insert into userRelation (username1,username2,requestConform) values (?,?,'Y')";
            jt.update(sql,username2,username1);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
