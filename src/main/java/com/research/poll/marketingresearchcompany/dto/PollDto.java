package com.research.poll.marketingresearchcompany.dto;

import com.research.poll.marketingresearchcompany.domain.ResearchRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PollDto {

    private Long id;
    private RespondentDto respondent;
    private ResearchRequestDto researchRequest;
}
