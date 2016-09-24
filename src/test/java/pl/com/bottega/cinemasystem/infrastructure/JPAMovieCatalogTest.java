package pl.com.bottega.cinemasystem.infrastructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.cinemasystem.api.ListMoviesInCinemaResponse;
import pl.com.bottega.cinemasystem.api.MovieCatalog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration({"/application.xml","/mock-auth-context.xml"})
@TestPropertySource({"/jdbc-test.properties", "/hibernate-test.properties"})
@WebAppConfiguration
@Sql("/fixtures/moviesInCinema.sql")
public class JPAMovieCatalogTest {

    @Autowired
    private MovieCatalog jpaMovieCatalog;

    @PersistenceContext
    private EntityManager entityManager;

    private Long testId = 3L;
    private LocalDate testDate = LocalDate.of(2916, 9, 20);


    @Test
    @Transactional
    @Sql("/fixtures/moviesInCinema.sql")
    public void listAllMoviesInCinema(){
        ListMoviesInCinemaResponse response = jpaMovieCatalog.listMoviesInCinema(testId, testDate);

        assertTrue(response.getMovies().size() ==1);

    }

}