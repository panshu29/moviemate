package com.anshu.moviemate.theatres.repository;

import com.anshu.moviemate.theatres.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {


    @Query("SELECT t FROM Theatre t JOIN t.shows s WHERE s.date = :date AND s.movieCode = :movieCode AND t.city = :city")
    List<Theatre> findByDateMovieAndCity(@Param("date") LocalDate date, @Param("movieCode") String movieCode, @Param("city") String city);
}
