package pl.com.bottega.cinemasystem.infrastructure;

import org.springframework.stereotype.Repository;
import pl.com.bottega.cinemasystem.domain.Movie;
import pl.com.bottega.cinemasystem.domain.MovieRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JPAMoviesRepository implements MovieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Movie movie) {
        entityManager.persist(movie);
    }

    @Override
    public Movie load(Long movieId) {
        return entityManager.createQuery(
                "FROM Movie m WHERE m.movieId = :movieId",
                Movie.class)
                .setParameter("movieId", movieId)
                .getSingleResult();
    }

    @Override
    public Movie load(String title) {
        return entityManager.createQuery(
                "FROM Movie m WHERE m.title = :title",
                Movie.class)
                .setParameter("title", title)
                .getSingleResult();
    }
}