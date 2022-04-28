package by.it.academy.Mk_JD2_88_22.classwork.sql;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.Pageable;
import by.it.academy.Mk_JD2_88_22.homework.hw1.services.api.IAuditUserStorage;
import by.it.academy.Mk_JD2_88_22.homework.hw1.model.User;
import by.it.academy.Mk_JD2_88_22.homework.hw1.model.AuditUser;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SQLDBAuditUserStorage implements IAuditUserStorage {
    private final static SQLDBAuditUserStorage instance = new SQLDBAuditUserStorage();

    private final DataSource ds;

    public SQLDBAuditUserStorage() {
        this.ds = SQLDBInitializer.getInstance().getDataSource();
    }

    @Override
    public Long create(AuditUser audit) {
        if (audit == null) {
            throw new IllegalArgumentException("Аудит не может быть null");
        }

        String sql = "INSERT INTO messenger.audit_user (text, author, dt_create, \"user\") VALUES (?,?,?,?);\n";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, new String[]{"id"});
        ) {
            conn.setAutoCommit(false);

            ps.setObject(1, audit.getText());
            ps.setObject(2, audit.getAuthor() != null ? audit.getAuthor().getUsername() : null);
            ps.setObject(3, audit.getDtCreate());
            ps.setObject(4, audit.getUser().getUsername());

            ps.executeUpdate();

            conn.commit();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Ошибка выполнение SQL", e);
        }
    }


    @Override
    public Long create(AuditUser audit1, AuditUser audit2) {
        if (audit1 == null || audit2 == null) {
            throw new IllegalArgumentException("Аудит не может быть null");
        }

        String sql = "INSERT INTO messenger.audit_user(text, author, dt_create, \"user\")\n" +
                "\tVALUES (?, ?, ?, ?);" +
                "INSERT INTO messenger.audit_user(text, author, dt_create, \"user\")\n" +
                "\tVALUES (?, ?, ?, ?);";
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, new String[]{"id"});
        ) {
            conn.setAutoCommit(false);

            ps.setObject(1, audit1.getText());
            ps.setObject(2, audit1.getAuthor() != null ? audit1.getAuthor().getUsername() : null);
            ps.setObject(3, audit1.getDtCreate());
            ps.setObject(4, audit1.getUser().getUsername());

            ps.setObject(5, audit2.getText());
            ps.setObject(6, audit2.getAuthor() != null ? audit2.getAuthor().getUsername() : null);
            ps.setObject(7, audit2.getDtCreate());
            ps.setObject(8, audit2.getUser().getUsername());

            ps.execute();

            conn.rollback();
            conn.commit();
            return 1l;
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка выполнение SQL", e);
        }
    }

    @Override
    public List<AuditUser> read(Pageable pageable) {
        Integer limit = null;
        Integer offset = null;

        if (pageable != null) {
            if (pageable.getSize() > 0) {
                limit = pageable.getSize();
            }

            if (limit != null && pageable.getPage() > 0) {
                offset = (pageable.getPage() - 1) * limit;
            }
        }

        List<AuditUser> data = new ArrayList<>();

        String sql = "select \n" +
                "audit.id as audit_id,\n" +
                "audit.text as audit_text,\n" +
                "audit.author as audit_author,\n" +
                "audit.dt_create as audit_dt_create,\n" +
                "audit.user as audit_user,\n" +
                "\n" +
                "obj.username  as obj_username,\n" +
                "obj.fio  as obj_fio,\n" +
                "obj.birth_date  as obj_birth_date,\n" +
                "\n" +
                "author.username as author_username,\n" +
                "author.fio  as author_fio,\n" +
                "author.birth_date  as author_birth_date\n" +
                "\n" +
                "from messenger.audit_user audit\n" +
                "left join messenger.users author on audit.author = author.username\n" +
                "left join messenger.users obj on audit.user = obj.username;";

        if (limit != null) {
            sql += "\n LIMIT " + limit;
        }
        if (offset != null) {
            sql += "\n OFFSET " + offset;
        }
        sql += ";";

        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
        ) {

            int index = 1;
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("id");
                    LocalDateTime dtCreate = rs.getObject("dt_create", LocalDateTime.class);
                    String text = rs.getString("text");
                    User user = User.Builder.createBuilder()
                            .setLogin(rs.getString("user"))
                            .setFio(rs.getString("obj_fio"))
                            .setBirthday(rs.getObject("obj_dt_birthday", LocalDate.class))
                            .build();
                    User author = User.Builder.createBuilder()
                            .setLogin(rs.getString("author"))
                            .setFio(rs.getString("author_fio"))
                            .setBirthday(rs.getObject("author_dt_birthday", LocalDate.class))
                            .build();
                    AuditUser audit = new AuditUser(id, dtCreate, text, user, author);
                    data.add(audit);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка выполнение SQL", e);
        }
        return data;
    }

    public static SQLDBAuditUserStorage getInstance() {
        return instance;
    }
}
