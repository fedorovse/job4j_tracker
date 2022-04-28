package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    /**
     * Map в качестве ключа содержит студентов
     * в качестве значения Set сообщений (название предмета и оценка по нему)
     */
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    /**
     * Поиск студента в Map по аккаунту
     * @param account String - аккаунт студента
     * @return Optional Студент обернутый в Optional
     */
    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student s: students.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    /**
     * Поиск Subject содержащего название предмета и оценку
     * по аккаунту студента и названию предмета
     * @param account String аккаунт студента
     * @param name String название предмета
     * @return Optional Сообщение Subject обернутое в Optional
     */
    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> rsl = Optional.empty();
        Optional<Student> s = findByAccount(account);
        if (s.isPresent()) {
            Set<Subject> subjects = students.get(s.get());
            for (Subject subj : subjects) {
                if (name.equals(subj.getName())) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }
}