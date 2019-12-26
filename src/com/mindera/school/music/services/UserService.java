package com.mindera.school.music.services;

import com.mindera.school.music.ui.Mapper;
import com.mindera.school.music.data.rows.User;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.data.tables.UserTable;
import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.Request;

import static com.mindera.school.music.data.tables.Tables.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserService {
    private UserTable userTable;
    private CountryTable countryTable;
    private Mapper mapper;
    private Request request;

    public UserService() {
        this.userTable = USER_TABLE;
        this.countryTable = COUNTRY_TABLE;
        this.mapper = new Mapper();
        this.request = new Request();
    }

    public void add(List<KeyValue> keyValueList) {
        User user = new User();

        user.setId(userTable.getNewId());

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
                user.setName(keyValue.getValue().toString());
            }
            if (keyValue.getName().equals("Birthdate")) {
                user.setBirthdate((Date) keyValue.getValue());
            }
            if (keyValue.getName().equals("Gender")) {
                user.setGender((Character) keyValue.getValue());
            }
            if (keyValue.getName().equals("Country")) {
                user.setCountryId(mapper.getCountryIdByName(keyValue.getValue().toString()));
            }
            if (keyValue.getName().equals("Email")) {
                if(userTable.verifyIfAlreadyExistsEmail(keyValue.getValue().toString())) {
                    System.out.println("This user already exits.");
                    return;
                }
                user.setEmail(keyValue.getValue().toString());
            }
            if (keyValue.getName().equals("Password")) {
                user.setPassword(keyValue.getValue().toString());
            }
        }

        userTable.add(user);
    }

    public void removeUser(int id) {
        userTable.remove(id);
    }

    public User findUser(int id) {
        return userTable.findById(id);
    }

    public List<User> findAllUsers() {
        return userTable.findAll();
    }

    public void printAllUsers() {
        List<User> userList = findAllUsers();

        if(userList.isEmpty()) {
            System.out.println("There is no users.");
            return;
        }

        for (User user : userList) {
            System.out.println("User id: " + user.getId());
            System.out.println("Name: " + user.getName() + '\n');
        }
    }

    public void printUser(int id) {
        User user = findUser(id);
        if(user == null) {
            System.out.println("There is no user with this id.");
            return;
        }

        System.out.println("User id: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Birthdate: " + user.getBirthdate());
        System.out.println("Gender: " + user.getGender());
        System.out.println("Country: " + countryTable.findById(user.getCountryId()).getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword() + '\n');
    }

    public void userOnline(List<KeyValue> list) throws SQLException {
        String email = "";
        String password = "";

        for (KeyValue keyValue : list) {
            if (keyValue.getName().equals("Email")) {
                email = (String) keyValue.getValue();
            }
            if (keyValue.getName().equals("Password")) {
                password = (String) keyValue.getValue();
            }
        }

        boolean login = userTable.userOnline(email, password);

        while(!login) {
            System.out.println("Invalid email or password.");
            request.hasString("Email", "Email:");
            request.hasString("Password", "Password:");
            list = request.ask();

            for (KeyValue keyValue : list) {
                if (keyValue.getName().equals("Email")) {
                    email = (String) keyValue.getValue();
                }
                if (keyValue.getName().equals("Password")) {
                    password = (String) keyValue.getValue();
                }
            }

            login = userTable.userOnline(email, password);
        }
    }
}
