package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.api;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.Pageable;
import by.it.academy.Mk_JD2_88_22.homework.hw1.model.AuditUser;

import java.util.ArrayList;
import java.util.List;

public interface IAuditUserStorage {
    ArrayList<AuditUser> select();

    Long insert(AuditUser auditUser);

    List<AuditUser> select(Pageable pageable);
}
