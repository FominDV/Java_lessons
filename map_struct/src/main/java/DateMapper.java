import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DateMapper {

    private final static SimpleDateFormat dateTimeFormatter;
    private final static DateTimeFormatter d;

    static {
        dateTimeFormatter = new SimpleDateFormat("dd.MM.yyyy HH.mm");
        d = DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm");

    }

    ZoneId zoneId = ZoneId.of("Asia/Singapore");


    public String asString(LocalDateTime date) {
        ZonedDateTime zonedDateTime = date.atZone(TimeZone.getDefault().toZoneId());
        ZonedDateTime zonedDateTime1 = zonedDateTime.withZoneSameInstant(zoneId);
        return d.format(zonedDateTime1);

    }

    public LocalDateTime asDate(String date) {
        return LocalDateTime.parse(date, d);
    }
}
