package by.it.academy.Mk_JD2_88_22.service;

import by.it.academy.Mk_JD2_88_22.service.api.IStudentService;
import by.it.academy.Mk_JD2_88_22.service.dto.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentService implements IStudentService {
    private static final StudentService instance = new StudentService();
    private List<Student> students = new ArrayList<>();

    @Override
    public List<Student> getStudentsList() {
        return Collections.unmodifiableList(this.students);
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    public static StudentService getInstance() {
        return instance;
    }
}
