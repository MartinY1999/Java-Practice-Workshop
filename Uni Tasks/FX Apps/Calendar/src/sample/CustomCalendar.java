package sample;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CustomCalendar {
    private YearMonth calendar;

    public CustomCalendar(int month, int year){
        this.calendar = YearMonth.of(year, month);
    }

    public String getMonth(){
        return this.calendar.getMonth().name();
    }

    public int getMonthAsInt(){
        return this.calendar.getMonthValue();
    }

    public int getYear(){
        return this.calendar.getYear();
    }

    public int daysInMonth(){
        return this.calendar.lengthOfMonth();
    }

    public int getFirstDayOfMonth(){
        return LocalDate.of(getYear(), getMonthAsInt(), 1).getDayOfWeek().getValue();
    }
}
