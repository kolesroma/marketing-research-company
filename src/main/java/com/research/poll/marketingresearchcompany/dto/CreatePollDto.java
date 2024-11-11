package com.research.poll.marketingresearchcompany.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePollDto {

    private String gender;
    private String country;
    private String favoriteFilm;
    private Integer minAge;
    private Integer maxAge;

}
