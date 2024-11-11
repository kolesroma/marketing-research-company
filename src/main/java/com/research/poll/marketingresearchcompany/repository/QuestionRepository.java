package com.research.poll.marketingresearchcompany.repository;

import com.research.poll.marketingresearchcompany.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByResearchRequestId(Long researchRequestId);

}