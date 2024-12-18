package com.research.poll.marketingresearchcompany.mapper;

import com.research.poll.marketingresearchcompany.domain.Poll;
import com.research.poll.marketingresearchcompany.domain.ResearchRequest;
import com.research.poll.marketingresearchcompany.dto.PollDto;
import com.research.poll.marketingresearchcompany.dto.ResearchRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PollMapper {

    List<PollDto> toDtos(List<Poll> polls);

}
