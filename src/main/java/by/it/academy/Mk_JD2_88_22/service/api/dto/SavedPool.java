
package by.it.academy.Mk_JD2_88_22.service.api.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class SavedPool {
    private final LocalDateTime time;
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

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM,FormatStyle.MEDIUM);
        return "Голос | Время: " + time.format(dtf) + ", данные о голосе: " + pool;
    }
}