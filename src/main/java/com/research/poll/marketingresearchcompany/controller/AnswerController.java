package com.research.poll.marketingresearchcompany.controller;

import com.research.poll.marketingresearchcompany.domain.Answer;
import com.research.poll.marketingresearchcompany.domain.Question;
import com.research.poll.marketingresearchcompany.domain.Respondent;
import com.research.poll.marketingresearchcompany.dto.AnswerDto;
import com.research.poll.marketingresearchcompany.dto.CreateAnswerDto;
import com.research.poll.marketingresearchcompany.mapper.AnswerMapper;
import com.research.poll.marketingresearchcompany.repository.AnswerRepository;
import com.research.poll.marketingresearchcompany.repository.PollRepository;
import com.research.poll.marketingresearchcompany.repository.QuestionRepository;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/answers")
public class AnswerController {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    @PostMapping
    public Long createAnswers(@RequestBody CreateAnswerDto createAnswerDto) {
        Long questionId = createAnswerDto.getQuestionId();
        Long respondentId = createAnswerDto.getRespondentId();
        Answer answer = Answer.builder()
                .answerDesc(createAnswerDto.getAnswerDesc())
                .question(Question.builder().questionId(questionId).build())
                .respondent(Respondent.builder().respondentId(respondentId).build())
                .build();
        return answerRepository.save(answer).getAnswerId();
    }

    @GetMapping
    public List<AnswerDto> getAnswers(@RequestParam Long respondentId) {
        List<Answer> answers = answerRepository.findAllByRespondentRespondentId(respondentId);
        return answerMapper.toDtos(answers);
    }

}