package com.research.poll.marketingresearchcompany.controller;

import com.research.poll.marketingresearchcompany.domain.Client;
import com.research.poll.marketingresearchcompany.domain.Poll;
import com.research.poll.marketingresearchcompany.domain.Question;
import com.research.poll.marketingresearchcompany.domain.ResearchRequest;
import com.research.poll.marketingresearchcompany.domain.ResearchRequestStatus;
import com.research.poll.marketingresearchcompany.domain.Respondent;
import com.research.poll.marketingresearchcompany.dto.CreatePollDto;
import com.research.poll.marketingresearchcompany.dto.CreateQuestionDto;
import com.research.poll.marketingresearchcompany.dto.CreateResearchRequestDto;
import com.research.poll.marketingresearchcompany.dto.UpdateResearchRequestDto;
import com.research.poll.marketingresearchcompany.repository.PollRepository;
import com.research.poll.marketingresearchcompany.repository.QuestionRepository;
import com.research.poll.marketingresearchcompany.repository.ResearchRequestRepository;
import com.research.poll.marketingresearchcompany.repository.RespondentRepository;
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
public class PollController {

    private final ResearchRequestRepository researchRequestRepository;
    private final QuestionRepository questionRepository;
    private final PollRepository pollRepository;
    private final RespondentRepository respondentRepository;

    @GetMapping("/polls")
    public List<Poll> getPolls(@RequestParam Long respondentId) {
        return pollRepository.findByRespondentRespondentId(respondentId);
    }

    @PostMapping("/{requestId}/polls")
    public void createPolls(@PathVariable Long requestId,
                            @RequestBody CreatePollDto createPollDto) {
        List<Respondent> acceptedRespondents = respondentRepository.findByCriteria(createPollDto.getGender(), createPollDto.getCountry(), createPollDto.getFavoriteFilm(),
                createPollDto.getMinAge(), createPollDto.getMaxAge());
        acceptedRespondents.stream()
                .map(respondent -> Poll.builder()
                        .researchRequest(ResearchRequest.builder().id(requestId).build())
                        .respondent(respondent)
                        .build())
                .forEach(pollRepository::save);
    }

}