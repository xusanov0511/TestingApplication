package com.company.testingsystem.server.service;

import com.company.testingsystem.server.dto.QuestionDTO;
import com.company.testingsystem.server.dto.Result;
import com.company.testingsystem.server.model.Question;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class QuestionService {
    public List<Question> getQuestionList(String subject) {
//        Map<String, List<Question>> allQuestions = new TreeMap<>();
//        Path path = Path.of("./files/QUESTION.json");
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        try (BufferedReader bufferedReader = new BufferedReader(
//                new FileReader(path.toFile()))) {
//            allQuestions =  gson.fromJson(bufferedReader,
//                    new TypeToken<Map<String, List<Question>>>(){});
//            return allQuestions.get(subject);
//
//        } catch (IOException e) {
//            return null;
//        }

        // todo
        return null;
    }

    public Result addQuestion(QuestionDTO questionDTO) {
//        String subject = questionDTO.subject();
//        String description = questionDTO.description();
//        String ca = questionDTO.correctAnswer();
//        String w1 = questionDTO.w1();
//        String w2 = questionDTO.w2();
//
//        if(subject == null || description == null || ca == null || w1 == null || w2 == null){
//            return new Result("null value cannot be given", false);
//        }
//        if(subject.isBlank() || description.isBlank() || ca.isBlank() || w1.isBlank() || w2.isBlank()){
//            return new Result("an empty value cannot be given", false);
//        }
//        if(Objects.equals(ca, w1) || Objects.equals(w1, w2) || Objects.equals(ca, w2)){
//            return new Result("it is not possible to give the same option", false);
//        }
//        Question question = new Question(UUID.randomUUID(), description, ca,
//                new HashSet<>(Set.of(w1, w2, ca)));
//        Path path = Path.of("./files");
//        if (!Files.exists(path)) {
//            try {
//                Files.createDirectory(path);
//            } catch (IOException e) {
//                return new Result(e.getMessage(), false);
//            }
//        }
//
//        Path file = path.resolve("QUESTION.json");
//        if(!Files.exists(file)){
//            try {
//                Files.createFile(file);
//            } catch (IOException e) {
//                return new Result(e.getMessage(), false);
//            }
//        }
//
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String json = gson.toJson(question);
//
//        try (BufferedWriter bufferedWriter = new BufferedWriter(
//                new FileWriter(file.toFile(), true))) {
//            bufferedWriter.write(json);
//        } catch (IOException e) {
//            return new Result(e.getMessage(), false);
//        }
        // todo...
        return null;
    }
}
