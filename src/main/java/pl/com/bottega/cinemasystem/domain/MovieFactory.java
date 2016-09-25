package pl.com.bottega.cinemasystem.domain;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinemasystem.api.CreateMovieRequest;

@Component
public class MovieFactory {

    public Movie createMovie(CreateMovieRequest request) {
        return new Movie(request.getTitle(), request.getDescription(), request.getMinAge(), request.getActors(),
                request.getGenres(), request.getLength());
    }
}