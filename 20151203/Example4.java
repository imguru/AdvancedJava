import java.time.*;
import java.util.TimeZone;

class Example4 {
    public static void main(String[] args) {
        Date date = new Date(2015, 12, 25);
        System.out.println(date);

        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();
    
        LocalDate localDate = LocalDate.of(2015, 12, 25);
        System.out.println(localDate);
        int year = localDate.getYear();
        Month month = localDate.getMonth();            
        DayOfWeek week = localDate.getDayOfWeek();      

        System.out.println("" + year + month + week);

        System.out.println(localDate.lengthOfMonth());
        System.out.println(localDate.isLeapYear());         

        LocalTime time = LocalTime.of(12, 15, 30); 
        int hour = time.getHour();
        int min = time.getMinute();
        int sec = time.getSecond();
        System.out.println("" + hour + ":" + min + ":" + sec);

        LocalDate d = LocalDate.parse("2014-03-18");
        LocalTime t = LocalTime.parse("12:15:30");

        LocalDateTime dt = LocalDateTime.of(d, t);
        System.out.println(dt);


        ZoneId zone = TimeZone.getDefault().toZoneId();
        System.out.println(zone);
    }
}
