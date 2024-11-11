package com.research.poll.marketingresearchcompany.repository;

import com.research.poll.marketingresearchcompany.domain.Bonus;
import com.research.poll.marketingresearchcompany.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BonusRepository extends JpaRepository<Bonus, Long> {
}