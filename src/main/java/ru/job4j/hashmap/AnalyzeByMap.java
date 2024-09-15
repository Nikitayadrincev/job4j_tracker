package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double averagScore = 0D;
        int countPupil = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                averagScore += (double) subject.score() / pupil.subjects().size();
            }
            countPupil++;
        }
        return averagScore / countPupil;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> averagScoreByPupil = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double averagScore = 0D;
            for (Subject subject : pupil.subjects()) {
                averagScore += subject.score();
            }
            averagScore /= pupils.size();
            averagScoreByPupil.add(new Label(pupil.name(), averagScore));
        }

        return averagScoreByPupil;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> averagScoreBySubject = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), subject.score() + score);
            }
        }

        for (String key : map.keySet()) {
            double value = (double) map.get(key) / map.size();
            averagScoreBySubject.add(new Label(key, value));
        }

        return averagScoreBySubject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> studentScore = new ArrayList<>();
        for (Label label : averageScoreByPupil(pupils)) {
            studentScore.add(new Label(label.name(), label.score() * pupils.size()));
        }
        studentScore.sort(Comparator.naturalOrder());
        return studentScore.get(studentScore.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> subjectScore = new ArrayList<>();
        for (Label label : averageScoreBySubject(pupils)) {
            subjectScore.add(new Label(label.name(), label.score() * pupils.size()));
        }
        subjectScore.sort(Comparator.naturalOrder());
        return subjectScore.get(subjectScore.size() - 1);
    }
}
