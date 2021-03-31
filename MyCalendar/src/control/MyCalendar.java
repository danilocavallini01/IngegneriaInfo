package control;

import model.Appointment;
import model.AppointmentCollection;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class MyCalendar {
    private AppointmentCollection allAppointment;

    public MyCalendar() {
        this.allAppointment = new AppointmentCollection();
    }

    public void add(Appointment app) {
        this.allAppointment.add(app);
    }

    public boolean remove(Appointment app) {
        int index = this.allAppointment.indexOf(app);
        if(index == -1) {
            return false;
        }
        allAppointment.remove(index);

        return true;
    }

    public AppointmentCollection getDayAppointments(LocalDate date) {
        LocalDateTime startDate = date.atStartOfDay();
        LocalDateTime endDate = startDate.plusDays(1);

        return this.getAppointmentsIn(startDate,endDate);
    }

    public AppointmentCollection getWeekAppointments(LocalDate date) {
        TemporalField fieldISO = WeekFields.of(Locale.ITALY).dayOfWeek();
        LocalDateTime startDate = LocalDateTime.of(date.with(fieldISO, 1), LocalTime.of(0,0));
        LocalDateTime endDate = startDate.plusWeeks(1);

        return this.getAppointmentsIn(startDate,endDate);
    }

    public AppointmentCollection getMonthAppointments(LocalDate date) {
        LocalDateTime startDate = LocalDateTime.of(date.getYear(),date.getMonth(),1,1,1);
        LocalDateTime endDate = startDate.plusMonths(1);

        return this.getAppointmentsIn(startDate,endDate);
    }

    private boolean isOverlapped(LocalDateTime start, LocalDateTime end, LocalDateTime search_start, LocalDateTime search_end) {
        if(end.isBefore(search_end)) {
            if(end.isAfter(search_start)) {
                return true;
            } else {
                return false;
            }
        } else {
            if(start.isBefore(search_end)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private AppointmentCollection getAppointmentsIn(LocalDateTime start, LocalDateTime end) {
        AppointmentCollection foundedAppointments = new AppointmentCollection();

        for( int i=0; i < this.allAppointment.size(); i++) {
            Appointment app = this.allAppointment.get(i);
            if(this.isOverlapped(app.getFrom(),app.getTo(),start,end)) {
                foundedAppointments.add(app);
            }
        }

        return foundedAppointments;
    }

    public AppointmentCollection getAllAppointments() {
        return allAppointment;
    }


}
