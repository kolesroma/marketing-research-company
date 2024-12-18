package com.research.poll.marketingresearchcompany.controller;

import com.research.poll.marketingresearchcompany.domain.Answer;
import com.research.poll.marketingresearchcompany.domain.Question;
import com.research.poll.marketingresearchcompany.dto.AnswerDto;
import com.research.poll.marketingresearchcompany.mapper.AnswerMapper;
import com.research.poll.marketingresearchcompany.repository.AnswerRepository;
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
    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    @GetMapping
    public List<AnswerDto> getQuestions(@PathVariable Long requestId) {
        List<Question> questions = questionRepository.findAllByResearchRequestId(requestId);
        List<Long> questionIds = questions.stream().map(Question::getQuestionId).toList();
        List<Answer> answers = answerRepository.findAllByQuestionQuestionIdIn(questionIds);
        return answerMapper.toDtos(answers);
    }

}