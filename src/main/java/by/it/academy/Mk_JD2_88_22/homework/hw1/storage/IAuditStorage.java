package by.it.academy.Mk_JD2_88_22.homework.hw1.storage;

import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Pageable;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.AuditUser;

import java.util.List;

public interface IAuditStorage {
    Long create(AuditUser auditUser);
    List<AuditUser> read(Pageable pageable);
}
