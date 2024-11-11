package com.research.poll.marketingresearchcompany.repository;

import com.research.poll.marketingresearchcompany.domain.ResearchRequest;
import com.research.poll.marketingresearchcompany.domain.ResearchRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResearchRequestRepository extends JpaRepository<ResearchRequest, Long> {

    List<ResearchRequest> findAllByStatus(ResearchRequestStatus status);

}