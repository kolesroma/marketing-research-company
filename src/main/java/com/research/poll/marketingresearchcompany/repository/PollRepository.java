package com.research.poll.marketingresearchcompany.repository;

import com.research.poll.marketingresearchcompany.domain.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PollRepository extends JpaRepository<Poll, Long> {

    List<Poll> findByRespondentRespondentId(Long respondentId);

}