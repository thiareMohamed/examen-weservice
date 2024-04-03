package sn.thiare.web.rest.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @PostMapping("/dayfinder")
    public ResponseEntity<Map<String, String>> getDay(@RequestBody String date) {

        System.out.println("=====================");
        System.out.println("date: "+ date);

        Map<String, String> response = new HashMap<>();
        response.put("date", date);

        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateFormat = LocalDate.parse(date, formatter);
        DayOfWeek day = dateFormat.getDayOfWeek();
        response.put("dayOfWeek", day.toString());
        return ResponseEntity.ok(response);
    }
}
