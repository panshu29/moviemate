package com.anshu.moviemate.theatres.service;

import com.anshu.moviemate.theatres.model.Theatre;
import com.anshu.moviemate.theatres.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre createTheatre(Theatre Theatre) {
        return theatreRepository.save(Theatre);
    }

    public Theatre updateTheatre(Long id, Theatre TheatreDetails) {
        Theatre Theatre = theatreRepository.findById(id).orElseThrow();
        Theatre.setName(TheatreDetails.getName());
        Theatre.setCity(TheatreDetails.getCity());
        return theatreRepository.save(Theatre);
    }

    public void deleteTheatre(Long id) {
        theatreRepository.deleteById(id);
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }


    public  List<Theatre> getTheatersWithShows(LocalDate date, String movieCode, String city) {
        List<Theatre> theatres = theatreRepository.findByDateMovieAndCity(date, movieCode, city);
        return theatres;
    }
}
