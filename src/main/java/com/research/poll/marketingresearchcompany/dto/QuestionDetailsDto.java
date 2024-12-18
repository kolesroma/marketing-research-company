package com.research.poll.marketingresearchcompany.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDetailsDto {

    private Long questionId;
    private String description;

}
