package com.research.poll.marketingresearchcompany.controller;

import com.research.poll.marketingresearchcompany.domain.Client;
import com.research.poll.marketingresearchcompany.domain.Question;
import com.research.poll.marketingresearchcompany.domain.ResearchRequest;
import com.research.poll.marketingresearchcompany.domain.ResearchRequestStatus;
import com.research.poll.marketingresearchcompany.dto.CreateQuestionDto;
import com.research.poll.marketingresearchcompany.dto.CreateResearchRequestDto;
import com.research.poll.marketingresearchcompany.dto.ResearchRequestDto;
import com.research.poll.marketingresearchcompany.dto.UpdateResearchRequestDto;
import com.research.poll.marketingresearchcompany.mapper.ResearchRequestMapper;
import com.research.poll.marketingresearchcompany.repository.QuestionRepository;
import com.research.poll.marketingresearchcompany.repository.ResearchRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/research-requests")
public class ResearchRequestController {

    private final ResearchRequestRepository researchRequestRepository;
    private final QuestionRepository questionRepository;
    private final ResearchRequestMapper researchRequestMapper;

    @GetMapping
    public List<ResearchRequestDto> getAllResearchRequests(@RequestParam ResearchRequestStatus status) {
        List<ResearchRequest> researchRequests = researchRequestRepository.findAllByStatus(status);
        return researchRequestMapper.toDtos(researchRequests);
    }

    @PostMapping
    public Long createResearchRequest(@RequestBody CreateResearchRequestDto createResearchRequestDto) {
        ResearchRequest researchRequest = ResearchRequest.builder()
                .client(Client.builder().clientId(createResearchRequestDto.getClientId()).build())
                .status(ResearchRequestStatus.CREATED)
                .build();
        researchRequestRepository.save(researchRequest);
        List<CreateQuestionDto> questions = createResearchRequestDto.getQuestions();
        questions.stream().map(createQuestionDto ->
                Question.builder()
                        .researchRequest(researchRequest)
                        .description(createQuestionDto.getDescription())
                        .build()
        ).forEach(questionRepository::save);
        return researchRequest.getId();
    }

    @PutMapping("/{id}")
    public void updateResearchRequest(@PathVariable Long id,
                                      @RequestBody UpdateResearchRequestDto updateResearchRequestDto) {
        ResearchRequest researchRequest = researchRequestRepository.findById(id).orElseThrow();
        ResearchRequestStatus newStatus = updateResearchRequestDto.getStatus();
        researchRequest.setStatus(newStatus);
        researchRequestRepository.save(researchRequest);
    }

}