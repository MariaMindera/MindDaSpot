package com.mindera.school.music.services;

import com.mindera.school.music.data.rows.User;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.data.tables.UserTable;
import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.Mapper;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;
import java.util.List;

import static com.mindera.school.music.data.tables.Tables.COUNTRY_TABLE;
import static com.mindera.school.music.data.tables.Tables.USER_TABLE;

public class UserService {
    private UserTable userTable;
    private CountryTable countryTable;
    private Mapper mapper;

    public UserService() {
        this.userTable = USER_TABLE;
        this.countryTable = COUNTRY_TABLE;
        this.mapper = new Mapper();
    }

    public void add(List<KeyValue> keyValueList) throws SQLException {
        User user = new User();

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
                user.setName(keyValue.getValue().toString());
            }
            if (keyValue.getName().equals("Birthdate")) {
                user.setBirthdate((String) keyValue.getValue());
            }
            if (keyValue.getName().equals("Gender")) {
                char gender = (char) keyValue.getValue();

                while (true) {
                    if (gender == 'M' || gender == 'F') {
                        user.setGender(gender);
                        break;
                    }

                    Request newRequest = new Request();
                    newRequest.hasChar("Gender", "Invalid letter. What is your gender? [F/M]: ");
                    List<KeyValue> newList = newRequest.ask();
                    gender = (char) newList.get(0).getValue();
                }
            }
            if (keyValue.getName().equals("Country")) {
                user.setCountryId(mapper.getCountryIdByName(keyValue.getValue().toString()));
            }
            if (keyValue.getName().equals("Email")) {
                if (userTable.verifyExistsEmail(keyValue.getValue().toString())) {
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

    public void removeByName(String name) throws SQLException {
        int id = findIdByName(name);
        if (id == 0) {
            System.out.println("This user doesn't exists.");
        } else {
            userTable.removeById(id);
        }
    }

    public int findIdByName(String name) throws SQLException {
        return userTable.findIdByName(name);
    }

    public User find(int id) throws SQLException {
        return userTable.findById(id);
    }

    public List<User> findAll() throws SQLException {
        return userTable.findAll();
    }

    public void printAll() throws SQLException {
        List<User> userList = findAll();

        if (userList.isEmpty()) {
            System.out.println("There is no users.");
            return;
        }

        for (User user : userList) {
            System.out.println("User id: " + user.getId());
            System.out.println("Name: " + user.getName() + '\n');
        }
    }

    public void print(int id) throws SQLException {
        User user = find(id);
        if (user == null) {
            System.out.println("There is no user.");
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

        while (!login) {
            Request newRequest = new Request();

            System.out.println("Invalid email or password.");

            newRequest.hasString("Email", "Email:");
            newRequest.hasString("Password", "Password:");
            List<KeyValue> newList = newRequest.ask();

            for (KeyValue keyValue : newList) {
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
