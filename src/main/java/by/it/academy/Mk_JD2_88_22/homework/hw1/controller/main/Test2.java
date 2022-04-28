package by.it.academy.Mk_JD2_88_22.homework.hw1.controller.main;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.Pageable;
import by.it.academy.Mk_JD2_88_22.homework.hw1.model.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.model.AuditUser;
import by.it.academy.Mk_JD2_88_22.classwork.sql.SQLDBAuditUserStorage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.services.api.IAuditUserStorage;

import java.time.LocalDateTime;
import java.util.List;

public class Test2 {
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

//            auditUserStorage.create(auditUser, renameUser);

            List<AuditUser> read = auditUserStorage.read(Pageable.of(1, 20));

            System.out.println(read);
        }
}
