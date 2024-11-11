package com.research.poll.marketingresearchcompany.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateResearchRequestDto {

    private Long clientId;
    private List<CreateQuestionDto> questions;
    private Boolean hasDataAnalyst;

}
