package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.mindera.school.music.services.Services.USER_ONLINE;

public class UserTable extends Table {
    public UserTable(String table) {
        super(table);
    }

    public boolean verifyExistsEmail(String email) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call verify_email_exists('" + email + "');");

        return resultSet.next();
    }

    public boolean userOnline(String email, String password) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_user_id_by_email_password('" + password + "', '" + email + "');");

        if (resultSet.next()) {
            USER_ONLINE.setUserID(resultSet.getInt("user_id"));
            return true;
        }

        return false;
    }

    public void add(User user) throws SQLException {
        sql.statement.executeUpdate("Call add_user('" + user.getName() + "', '" + user.getBirthdate() + "', '"
                + user.getGender() + "', " + user.getCountryId() + ", '" + user.getEmail() + "', '" + user.getPassword()
                + "');");
    }

    public User findById(int id) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_user_by_id(" + id + ");");

        if (resultSet.next()) {
            return new User(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4).charAt(0),
                    resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7));
        }

        return null;
    }

    public List<User> findAll() throws SQLException {
        List<User> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_all_user();");

        while (resultSet.next()) {
            list.add(new User(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4).charAt(0),
                    resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7)));
        }

        return list;
    }
}
