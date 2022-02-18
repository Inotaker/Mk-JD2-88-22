
package by.it.academy.Mk_JD2_88_22.classwork.dto.polls;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class SavedPoll implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDateTime time;
    private final Poll poll;

    public SavedPoll(LocalDateTime time, Poll poll) {
        this.time = time;
        this.poll = poll;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Poll getPool() {
        return poll;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM);
        return "Голос | Время: " + time.format(dtf) + ", данные о голосе: " + poll;
    }
}
