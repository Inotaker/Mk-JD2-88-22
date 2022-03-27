package by.it.academy.Mk_JD2_88_22.homework.hw1.controllers.main;

import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Pageable;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.AuditUser;
import by.it.academy.Mk_JD2_88_22.homework.hw1.storage.sql.SQLDBAuditUserStorage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.service.api.IAuditUserStorage;

import java.time.LocalDateTime;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        IAuditUserStorage auditUserStorage = SQLDBAuditUserStorage.getInstance();

        AuditUser auditUser = new AuditUser(LocalDateTime.now(),
                "Регистрация",
                User.Builder.createBuilder().setLogin("Inotak").build(),
                null
        );

        AuditUser renameUser = new AuditUser(LocalDateTime.now(),
                "Переименование",
                User.Builder.createBuilder().setLogin("Inotak").build(),
                User.Builder.createBuilder().setLogin("Inotak").build()
        );

        auditUserStorage.create(auditUser);
        auditUserStorage.create(renameUser);

        List<AuditUser> read = auditUserStorage.read(Pageable.of(1, 20));

        System.out.println(read);
    }
}