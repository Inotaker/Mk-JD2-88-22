package by.it.academy.Mk_JD2_88_22.classwork.service.api.jackson;

import by.it.academy.Mk_JD2_88_22.classwork.dto.jackson.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getStudentsList();

    void addStudent(Student student);
}
