package by.it.academy.Mk_JD2_88_22.homework.hw1.services.api;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.Pageable;
import by.it.academy.Mk_JD2_88_22.homework.hw1.model.AuditUser;

import java.util.List;

public interface IAuditUserStorage {
    Long create(AuditUser audit);
    Long create(AuditUser audit1, AuditUser audit2);
    List<AuditUser> read(Pageable pageable);
}
