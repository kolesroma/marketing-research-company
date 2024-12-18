package com.research.poll.marketingresearchcompany.repository;

import com.research.poll.marketingresearchcompany.domain.Answer;
import com.research.poll.marketingresearchcompany.domain.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findAllByRespondentRespondentId(Long respondentId);

    List<Answer> findAllByQuestionQuestionIdIn(List<Long> questionIds);

}