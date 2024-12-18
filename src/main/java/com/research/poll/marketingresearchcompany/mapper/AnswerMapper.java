package com.research.poll.marketingresearchcompany.mapper;

import com.research.poll.marketingresearchcompany.domain.Answer;
import com.research.poll.marketingresearchcompany.domain.Poll;
import com.research.poll.marketingresearchcompany.dto.AnswerDto;
import com.research.poll.marketingresearchcompany.dto.PollDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    List<AnswerDto> toDtos(List<Answer> answers);

}
