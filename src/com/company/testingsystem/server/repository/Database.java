package com.company.testingsystem.server.repository;

import com.company.testingsystem.server.enums.Role;
import com.company.testingsystem.server.model.History;
import com.company.testingsystem.server.model.Question;
import com.company.testingsystem.server.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public interface Database {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Path path = Path.of("./files/USER.json");

    Map<String, List<Question>> questionMap = new TreeMap<>();
    Map<User, List<History>> solveMap = new TreeMap<>();

    static void loadData(){
        User admin = new User("Elon Musk", "elon77",
                "123", UUID.randomUUID(), Role.TEACHER);


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile()));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
//            Map<User, List<History>> userList = gson.fromJson(bufferedReader,
//                    new TypeToken<Map<User, List<History>>>() {});
//            if(userList != null){
//                for (User user : userList.keySet()) {
//                    if(Objects.equals(user, admin)){
//                        return;
//                    }
//                }
//            }
            solveMap.put(admin, new ArrayList<>());
            String json = gson.toJson(solveMap);
            bufferedWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
