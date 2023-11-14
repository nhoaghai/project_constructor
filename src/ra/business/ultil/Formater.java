package ra.business.ultil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formater {
    private static String formatLocalDateTime(LocalDateTime localDateTime){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss - yyyy/MM/dd");
        return dateTimeFormatter.format(localDateTime);
    }
}
