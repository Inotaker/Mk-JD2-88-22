
package by.it.academy.Mk_JD2_88_22.service.api.dto.pool;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class SavedPool implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDateTime time;
    private final Pool pool;

    public SavedPool(LocalDateTime time, Pool pool) {
        this.time = time;
        this.pool = pool;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Pool getPool() {
        return pool;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM);
        return "Голос | Время: " + time.format(dtf) + ", данные о голосе: " + pool;
    }
}
