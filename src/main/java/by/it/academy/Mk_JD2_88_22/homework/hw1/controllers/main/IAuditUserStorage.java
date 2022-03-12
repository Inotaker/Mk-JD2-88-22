package by.it.academy.Mk_JD2_88_22.homework.hw1.controllers.main;

import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Pageable;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dto.audit.AuditUser;

import java.util.List;

public interface IAuditUserStorage {
    Long create(AuditUser audit);
    Long create(AuditUser audit1, AuditUser audit2);
    List<AuditUser> read(Pageable pageable);
}
