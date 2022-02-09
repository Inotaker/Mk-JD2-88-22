package by.it.academy.Mk_JD2_88_22.service.api;

import by.it.academy.Mk_JD2_88_22.service.dto.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getStudentsList();

    void addStudent(Student student);
}
