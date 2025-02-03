package com.anshu.moviemate.theatres.repository;

import com.anshu.moviemate.theatres.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}