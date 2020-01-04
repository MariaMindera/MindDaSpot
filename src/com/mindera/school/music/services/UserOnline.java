package com.mindera.school.music.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.mindera.school.music.services.Services.SQL_CONNECTION;

public class UserOnline {
    private int userID = 0;
    private boolean adm;
    private boolean legalAge;

    public UserOnline() {
    }

    public boolean isLegalAge() {
        return legalAge;
    }

    private void setLegalAge() throws SQLException {
        ResultSet resultSet = SQL_CONNECTION.statement.executeQuery("SELECT age_by_user_id(" + userID + ");");
        if (resultSet.next()) {
            legalAge = resultSet.getInt(1) > 17;
        }
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) throws SQLException {
        this.userID = userID;

        if (userID == 1) {
            setAdm(true);
        } else {
            setAdm(false);
        }

        setLegalAge();
    }

    public boolean isAdm() {
        return adm;
    }

    private void setAdm(boolean adm) {
        this.adm = adm;
    }
}
