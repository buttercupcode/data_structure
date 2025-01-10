import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class JustForFun {


    public static void main(String[] args) {
        JustForFun jf = new JustForFun();

        System.out.println(jf.calculate("2024-11-15T12:00:00-08:00", ("America/New_York"), "2024-11-16 16:00:00.000"));
    }

    public long calculate(String checkInDateUser, String hotelTimeZn, String checkInHotelTime) {
        // not sure what format you are getting
        ZonedDateTime zdt = ZonedDateTime.parse(checkInDateUser);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime dateTime = (LocalDateTime.parse(checkInHotelTime, formatter));

        long out = ChronoUnit.HOURS.between(zdt.withZoneSameInstant(ZoneId.of(hotelTimeZn)), dateTime.atZone(ZoneId.of(hotelTimeZn)));
        return out;
    }
}
