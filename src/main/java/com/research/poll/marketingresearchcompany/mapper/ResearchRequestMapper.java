package com.research.poll.marketingresearchcompany.mapper;

import com.research.poll.marketingresearchcompany.domain.ResearchRequest;
import com.research.poll.marketingresearchcompany.dto.ResearchRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResearchRequestMapper {

    List<ResearchRequestDto> toDtos(List<ResearchRequest> researchRequests);

    ResearchRequestDto toDto(ResearchRequest researchRequest);

}
