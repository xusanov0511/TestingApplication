package com.company.testingsystem.server.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class History {
    private UUID userId;
    private String subject;
    private int score;
    private int maxScore;
    private Date time;

    public History(UUID userId, String subject, int score, int maxScore) {
        this.userId = userId;
        this.subject = subject;
        this.score = score;
        this.maxScore = maxScore;
        this.time = new Date();
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
