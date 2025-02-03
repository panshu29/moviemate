package com.anshu.moviemate.theatres.controller;

import com.anshu.moviemate.theatres.model.Show;
import com.anshu.moviemate.theatres.model.Theatre;
import com.anshu.moviemate.theatres.service.ShowService;
import com.anshu.moviemate.theatres.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;
    @Autowired
    private ShowService showService;

    @GetMapping
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @PostMapping
    public Theatre createTheatre(@RequestBody Theatre Theatre) {
        return theatreService.createTheatre(Theatre);
    }

    @PutMapping("/{id}")
    public Theatre updateTheatre(@PathVariable Long id, @RequestBody Theatre Theatre) {
        return theatreService.updateTheatre(id, Theatre);
    }

    @DeleteMapping("/{id}")
    public void deleteTheatre(@PathVariable Long id) {
        theatreService.deleteTheatre(id);
    }

    /*
    Browse theatres currently running the show (movie selected) in the town, including show timing by a chosen date
     GET /api/theatres/shows?date={}&movieName={}&city={}
     */
    @GetMapping("/shows")
    public ResponseEntity<List<Theatre>> getTheatersWithShows(
            @RequestParam LocalDate date,
            @RequestParam String movieName,
            @RequestParam String city) {

        List<Theatre> theaters = theatreService.getTheatersWithShows(date, movieName, city);

        return ResponseEntity.ok(theaters);
    }


    @PostMapping("/shows")
    public Show createShow(@RequestBody Show show) {
        return showService.createShow(show);
    }

    @PutMapping("/shows/{id}")
    public Show updateShow(@PathVariable Long id, @RequestBody Show show) {
        return showService.updateShow(id, show);
    }

    @DeleteMapping("/shows/{id}")
    public void deleteShow(@PathVariable Long id) {
        showService.deleteShow(id);
    }
}

