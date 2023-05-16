package com.company.testingsystem.server.model;

import java.util.Set;
import java.util.UUID;

public class Question {
    private final UUID id;
    private String description;
    private String correctAnswer;
    private Set<String> variants;

    public Question(UUID id, String description, String correctAnswer, Set<String> variants) {
        this.id = id;
        this.description = description;
        this.correctAnswer = correctAnswer;
        this.variants = variants;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    public Set<String> getVariants() {
        return variants;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                ", description='" + description + '\'' +
                ", variants=" + variants +
                '}';
    }
}
