package com.company.testingsystem.server.service;

import com.company.testingsystem.server.dto.Result;
import com.company.testingsystem.server.dto.UserDTO;
import com.company.testingsystem.server.model.History;
import com.company.testingsystem.server.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class AuthService {
    Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
    Gson gson = new Gson();

    public Result signUp(UserDTO userDTO) {
        Path path = Path.of("./files/USER.json");
        User user = checkUsername(userDTO.username());
        if (user != null) {
            return new Result("This user already exist", false);
        }
        if (!checkParams(userDTO).success()) {
            return checkParams(userDTO);
        }

        user = new User(userDTO.name(), userDTO.username(), userDTO.password(), UUID.randomUUID());

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile()))) {
            Map<User, List<History>> userListMap = new TreeMap<>();
            if(path.toFile().length() != 0){
                userListMap = gsonBuilder.fromJson(bufferedReader, new TypeToken<Map<User, List<History>>>() {});
            }
            userListMap.put(user, new ArrayList<>());
            String json = gsonBuilder.toJson(userListMap);
            bufferedWriter.write(json);
        } catch (IOException e) {
            System.out.println("Fayllar bilan muammo");
        }
        return new Result("User successfully register", true);
    }

    public Result checkParams(UserDTO userDTO) {
        try {
            String name = userDTO.name();
            String username = userDTO.username();
            String password = userDTO.password();
            String confirmPassword = userDTO.confirmPassword();

            if (name.isBlank() || username.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                return new Result("Empty field entered, Try again !!!", false);
            }
            if (!Objects.equals(password, confirmPassword)) {
                return new Result("Password don't mach ?!", false);
            }

            final String PASSWORD_PATTERN =
                    "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!$%^&+=])(?=\\S+$).{8,}$";
            if (!password.matches(PASSWORD_PATTERN)) {
                return new Result("""
                        Password length must be between 8 and 16
                        Password should have upper case letters
                        Password should have lower case letters
                        Password should have digit characters
                        Password should have at least one characters(!,.@#$%^&*_<>)
                        """, false);
            }
            return new Result("", true);
        } catch (Exception e ){
            return new Result(e.getMessage(), false);
        }
    }

    public User checkUsername(String username) {
        Path path = Path.of("./files/USER.json");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
            if(path.toFile().length() == 0){
                return null;
            }
            Map<User, List<History>> users = gson.fromJson(bufferedReader,
                    new TypeToken<Map<User, List<History>>>() {});
            for (User user : users.keySet()) {
                if(Objects.equals(user.getUsername(), username)){
                   return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Result login(UserDTO userDTO) {
//        if (!checkParams(userDTO).success()) {
//            return checkParams(userDTO);
//        }
//
//        String username = userDTO.username();
//        String password = userDTO.password();
//
//        User user = checkUsername(username);
//        if (user == null || !Objects.equals(user.getPassword(), password)) {
//            return new Result("Wrong username or password", false);
//        }
//
//        return new Result("Welcome " + user.getName() + " !!!", true);

        // todo
        return null;
    }

    public User getUserById(UUID id) {
//        Path path = Path.of("./files/USER.json");
//        Gson gson = new Gson();
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
//            Map<User, List<History>> users = gson.fromJson(bufferedReader,
//                    new TypeToken<Map<User, List<History>>>() {});
//
//            for (User user : users.keySet()) {
//                if (Objects.equals(user.getId(), id)) return user;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // todo
        return null;
    }


    public Result changePassword(UUID id, String currentPassword,
                                 String password, String confirmPassword) {
//        User user = getUserById(id);
//        if (!Objects.equals(user.getPassword(), currentPassword)) {
//            return new Result("Wrong current password", false);
//        }
//        if (!Objects.equals(password, confirmPassword)) {
//            return new Result("New password don't match", false);
//        }
//
//        final String PASSWORD_PATTERN =
//                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–{}]:;',?./*~^+=<>]).{8,16}$";
//        if (!password.matches(PASSWORD_PATTERN)) {
//            return new Result("""
//                    Password length must be between 8 and 16
//                    Password should have upper case letters
//                    Password should have lower case letters
//                    Password should have digit characters
//                    Password should have at least one characters(!,.@#$%^&*_<>)
//                    """, false);
//        }
//        Gson gson = new Gson();
//        Path path = Path.of("./files/USER.json");
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile()));
//             BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
//            ArrayList<User> users = gson.fromJson(bufferedReader, new TypeToken<ArrayList<User>>() {
//            });
//            for (User user1 : users) {
//                if (Objects.equals(user1, user)) {
//                    user1.setPassword(password);
//                    break;
//                }
//            }
//            String json = gson.toJson(users);
//            bufferedWriter.write(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new Result("PAssword successfully changed", true);
        // todo
        return null;
    }
}
