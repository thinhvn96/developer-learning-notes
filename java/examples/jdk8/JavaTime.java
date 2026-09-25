import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/** JDK 8. Compile check: javac --release 8 JavaTime.java */
public class JavaTime {
    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1990, 5, 17);            // human date, no zone
        LocalDate next = birthday.plusDays(30);                    // returns a NEW object
        System.out.println(birthday + " -> " + next + " (original unchanged)");

        Instant start = Instant.parse("2026-01-01T00:00:00Z");     // machine time
        Instant end = start.plusSeconds(3 * 3600 + 30 * 60);
        System.out.println("Duration: " + Duration.between(start, end));          // seconds-based
        System.out.println("Period:   " + Period.between(birthday, LocalDate.of(2026, 5, 20))); // date-based

        ZonedDateTime tokyo = start.atZone(ZoneId.of("Asia/Tokyo"));
        System.out.println("Same instant in Tokyo: " + tokyo);
    }
}
