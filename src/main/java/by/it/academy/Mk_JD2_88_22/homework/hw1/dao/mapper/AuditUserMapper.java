package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.mapper;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.AuditUser;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api.entity.AuditUserEntity;

public class AuditUserMapper  {
    private static final AuditUserMapper instance = new AuditUserMapper();

    public static AuditUserMapper getInstance() {
        return instance;
    }

    public AuditUser toDto(AuditUserEntity entity){
        return new AuditUser(entity.getId(),entity.getDtCreate(), entity.getText(), entity.getUser(),entity.getAuthor());
    }
    public AuditUserEntity toEntity(AuditUser dto){
        AuditUserEntity auditUserEntity = new AuditUserEntity();
        auditUserEntity.setUser(dto.getUser());
        auditUserEntity.setDtCreate(dto.getDtCreate());
        auditUserEntity.setId(dto.getId());
        auditUserEntity.setText(dto.getText());
        auditUserEntity.setAuthor(dto.getAuthor());
        return auditUserEntity;
    }
}
