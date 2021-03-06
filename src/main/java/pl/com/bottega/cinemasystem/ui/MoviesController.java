package pl.com.bottega.cinemasystem.ui;

import org.springframework.web.bind.annotation.*;
import pl.com.bottega.cinemasystem.api.AdminPanel;
import pl.com.bottega.cinemasystem.api.CreateMovieRequest;
import pl.com.bottega.cinemasystem.api.UpdatePricesRequest;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private AdminPanel adminPanel;

    public MoviesController(AdminPanel adminPanel) {
        this.adminPanel = adminPanel;
    }

    @PutMapping
    public void create(@RequestBody CreateMovieRequest request) {
        adminPanel.createMovie(request);
    }

    @PutMapping("/{movieId}/prices")
    public void updatePrices(@PathVariable Long movieId, @RequestBody UpdatePricesRequest request) {
        request.setMovieId(movieId);
        adminPanel.updatePrices(request);
    }
}