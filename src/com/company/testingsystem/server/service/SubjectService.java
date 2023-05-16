package com.company.testingsystem.server.service;

import com.company.testingsystem.server.dto.Result;
import com.company.testingsystem.server.dto.SubjectDTO;
import com.company.testingsystem.server.repository.Database;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Set;

public class SubjectService {

    public Result addSubject(SubjectDTO subjectDTO) {
//        String name = subjectDTO.subjectName();
//        if(name == null || name.isBlank()){
//            return new Result("Subject is required", false);
//        }
//        Path path = Path.of("./files");
//        if (!Files.exists(path)) {
//            try {
//                Files.createDirectory(path);
//            } catch (IOException e) {
//                return new Result(e.getMessage(), false);
//            }
//        }
//
//        Path file = path.resolve("SUBJECT.json");
//        if(!Files.exists(file)){
//            try {
//                Files.createFile(file);
//            } catch (IOException e) {
//                return new Result(e.getMessage(), false);
//            }
//        }
//
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        Set<String> subjects = Database.questionMap.keySet();
//        if (!subjects.add(name)) {
//            return new Result("This subject already added", false);
//        }
//
//        String json = gson.toJson(subjects);
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile()))) {
//            writer.write(json);
//        } catch (IOException e) {
//            return new Result(e.getMessage(), false);
//        }
//
//        Database.questionMap.put(name, new ArrayList<>());
//        return new Result("Subject successfully added", true);

        // todo
        return null;
    }

    public Set<String> getSubjects() {
//        Path path = Path.of("./files/SUBJECT.json");
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
//            return gson.fromJson(bufferedReader, new TypeToken<Set<String>>(){});
//        } catch (IOException e) {
//            return null;
//        }
        // todo
        return null;
    }

    public boolean trueIndex(int index) {
        return (index <= getSubjects().size() && index >= 1);
    }
}
