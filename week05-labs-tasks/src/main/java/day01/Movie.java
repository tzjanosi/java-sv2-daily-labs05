package day01;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String Title;
    private List<LocalDateTime> dateTimesList = new ArrayList<>();

    public Movie(String title, List<LocalDateTime> dateTimesList) {
        Title = title;
        this.dateTimesList = dateTimesList;
    }

    public String getTitle() {
        return Title;
    }

    public List<LocalDateTime> getDateTimesList() {
        return dateTimesList;
    }
}
