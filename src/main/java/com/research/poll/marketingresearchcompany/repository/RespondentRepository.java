package com.research.poll.marketingresearchcompany.repository;

import com.research.poll.marketingresearchcompany.domain.Respondent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RespondentRepository extends JpaRepository<Respondent, Long> {

    @Query("SELECT r FROM Respondent r " +
            "WHERE (:gender IS NULL OR r.gender = :gender) " +
            "AND (:country IS NULL OR r.country = :country) " +
            "AND (:favoriteFilm IS NULL OR r.favoriteFilmDesc = :favoriteFilm) " +
            "AND (:minAge IS NULL OR r.age >= :minAge) " +
            "AND (:maxAge IS NULL OR r.age <= :maxAge)")
    List<Respondent> findByCriteria(
            @Param("gender") String gender,
            @Param("country") String country,
            @Param("favoriteFilm") String favoriteFilm,
            @Param("minAge") Integer minAge,
            @Param("maxAge") Integer maxAge);

}