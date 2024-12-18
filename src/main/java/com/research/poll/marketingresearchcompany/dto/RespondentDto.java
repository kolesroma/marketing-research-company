package com.research.poll.marketingresearchcompany.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespondentDto {

    private Long respondentId;
    private String name;
    private String surname;
    private int age;
    private String gender;
    private String country;
    private String favoriteFilmDesc;

}
