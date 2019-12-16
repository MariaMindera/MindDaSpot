package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.User;

import java.util.List;

public class UserTable extends Table<User> {
    public boolean verifyIfAlreadyExistsEmail(String email) {
        for (User user : backend) {
            if (email.equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }
}
