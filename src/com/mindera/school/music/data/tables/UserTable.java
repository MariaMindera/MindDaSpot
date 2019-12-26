package com.mindera.school.music.data.tables;

import com.mindera.school.music.UserOnline;
import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.mindera.school.music.services.Services.USER_ONLINE;

public class UserTable extends Table<User> {
    public boolean userOnline(String email, String password) throws SQLException {
        ResultSet resultSet = sql.con.prepareCall("Call get_user_id_by_email_password('"+ email + "', '" + password + "');").executeQuery();
        if(resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt(1));

            USER_ONLINE.setUser();
            return true;
        }

    }
}
