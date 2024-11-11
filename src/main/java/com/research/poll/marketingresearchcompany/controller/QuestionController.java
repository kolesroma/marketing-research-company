package com.research.poll.marketingresearchcompany.controller;

import com.research.poll.marketingresearchcompany.domain.Poll;
import com.research.poll.marketingresearchcompany.domain.Question;
import com.research.poll.marketingresearchcompany.repository.PollRepository;
import com.research.poll.marketingresearchcompany.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/research-requests/{requestId}/questions")
public class QuestionController {

    private final QuestionRepository questionRepository;
    private final PollRepository pollRepository;

    @GetMapping
    public List<Question> getQuestions(@PathVariable Long requestId) {
        return questionRepository.findAllByResearchRequestId(requestId);
    }

}