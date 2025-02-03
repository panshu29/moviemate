package com.anshu.moviemate.theatres.service;

import com.anshu.moviemate.theatres.model.Show;
import com.anshu.moviemate.theatres.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public Show createShow(Show show) {
        return showRepository.save(show);
    }

    public Show updateShow(Long id, Show showDetails) {
        Show show = showRepository.findById(id).orElseThrow();
        show.setDate(showDetails.getDate());
        show.setStartTime(showDetails.getStartTime());
        show.setEndTime(showDetails.getEndTime());
        show.setMovieCode(showDetails.getMovieCode());
        show.setStatus(showDetails.getStatus());
        return showRepository.save(show);
    }

    public void deleteShow(Long id) {
        showRepository.deleteById(id);
    }
}
