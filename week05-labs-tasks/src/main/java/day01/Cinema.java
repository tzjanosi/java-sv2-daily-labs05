package day01;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cinema {
    private List<Movie> moviesList = new ArrayList<>();

    public void addMovie(Movie movie){
        moviesList.add(movie);
    }
    public String findMovieByTime(LocalDateTime time){
        List<String> moviesOutList = new ArrayList<>();
        for(Movie movie:moviesList){
            if(isTimeCorrect(movie,time)){
                moviesOutList.add(movie.getTitle());
            }
        }
        return moviesOutList.toString();
    }

    private boolean isTimeCorrect(Movie movie, LocalDateTime time) {
        List<LocalDateTime> dateTimesList = movie.getDateTimesList();
        for(LocalDateTime dateTime:dateTimesList){
            if(time.equals(dateTime)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        cinema.addMovie(new Movie("Titanic", Arrays.asList(
                LocalDateTime.of(2021,11,8,12,45),
                LocalDateTime.of(2021,11,8,22,25)
        )));
        cinema.addMovie(new Movie("Jurassic Park", Arrays.asList(
                LocalDateTime.of(2021,11,8,19,45),
                LocalDateTime.of(2021,11,8,20,25),
                LocalDateTime.of(2021,11,8,22,25)
        )));

        System.out.println(cinema.findMovieByTime(LocalDateTime.of(2021,11,8,10,45))); // []
        System.out.println(cinema.findMovieByTime(LocalDateTime.of(2021,11,8,19,45))); // [Jurassic Park]
        System.out.println(cinema.findMovieByTime(LocalDateTime.of(2021,11,8,22,25))); // [Titanic, Jurassic Park]

    }

}
