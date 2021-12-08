package com.project;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBConnect extends JdbcDaoSupport implements DataConnect{
    @Override
    public void insertRow(User user) {
        JdbcTemplate template = getJdbcTemplate();
        String insertQuery = "insert into user(username,password) values(?,?)";
        Object[] values = {user.getUsername(),user.getPassword()};
        template.update(insertQuery,values);
    }

    @Override
    public void updateRow(User user) {
        JdbcTemplate template = getJdbcTemplate();
        String updateQuery = "update user set username=? where password=?";
        Object[] values = {user.getUsername(),user.getPassword()};
        template.update(updateQuery,values);
    }

    @Override
    public void deleteRow(User user) {
        JdbcTemplate template = getJdbcTemplate();
        String deleteQuery = "delete from user where username = ? and password= ?";
        Object[] values = {user.getUsername(),user.getPassword()};
        template.update(deleteQuery,values);
    }

    @Override
    public Object retrieveRecord(String username) {
        String selectQuery = "select * from user";
        List<User> data = getJdbcTemplate().query(selectQuery,
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user = new User();
                        user.setUsername(resultSet.getString(1));
                        user.setPassword(resultSet.getString(2));
                        System.out.println("Row number : "+ i);
                        return  user;
                    }
                }
        );
        //Another overloaded method
       /* String selQuery = "select username,password from user where username = ?";
        List<User> l1 = getJdbcTemplate().query(selQuery,<RowMapper code...>,username(condition pass in where clause))*/

        return data;
    }
}
