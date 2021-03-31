package model;

import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Appointment {
    private String description;
    private LocalDateTime from;
    private LocalDateTime to;

    public Appointment(String description, LocalDateTime from, LocalDateTime to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }
    public Appointment(String description, LocalDateTime from, Duration duration) {
        this.description = description;
        this.from = from;
        this.to = from.plus(duration);
    }

    public String getDescription() {
        return description;
    }

    public Duration getDuration() {
        return Duration.between(from,to);
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public void setDuration(Duration duration) {
        this.to = from.plus(duration);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Locale locale = new Locale("it","IT");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT,locale);

        s.append("Appointment{")
                .append(description)
                .append("} -Da ")
                .append(dateFormat.format(from))
                .append(" -a ")
                .append(dateFormat.format(to));

        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(description, that.description) && Objects.equals(from, that.from) && Objects.equals(to, that.to);
    }

}
