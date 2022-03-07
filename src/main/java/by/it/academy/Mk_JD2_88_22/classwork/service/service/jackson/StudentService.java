package by.it.academy.Mk_JD2_88_22.classwork.service.service.jackson;

import by.it.academy.Mk_JD2_88_22.classwork.dto.jackson.Student;
import by.it.academy.Mk_JD2_88_22.classwork.service.api.jackson.IStudentService;

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
