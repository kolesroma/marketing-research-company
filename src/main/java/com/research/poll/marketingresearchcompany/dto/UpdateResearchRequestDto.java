package com.research.poll.marketingresearchcompany.dto;

import com.research.poll.marketingresearchcompany.domain.ResearchRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateResearchRequestDto {

    private ResearchRequestStatus status;

}
