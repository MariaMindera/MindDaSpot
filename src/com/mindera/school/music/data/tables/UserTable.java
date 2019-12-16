package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.User;

import java.util.List;

public class UserTable extends Table<User> {
    public boolean verifyIfAlreadyExistsEmail(String email) {
        List<User> userList = getBackend();
        for (User user : userList) {
            if (email.equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }
}
