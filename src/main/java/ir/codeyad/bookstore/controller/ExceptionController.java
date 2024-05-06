package ir.codeyad.bookstore.controller;

import ir.codeyad.bookstore.dto.response.ExceptionResponse;
import ir.codeyad.bookstore.execption.RuleExecption;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {
    private final MessageSourceAccessor messageSourceAccessor;

    public ExceptionController(MessageSourceAccessor messageSourceAccessor) {
        this.messageSourceAccessor = messageSourceAccessor;
    }


    @ExceptionHandler
    public ResponseEntity<List<ExceptionResponse>> handleRuleException(RuleExecption ruleExecption) {

        return ResponseEntity.status(400).body(Collections.singletonList(ruleExceptionToExceptionResponse(ruleExecption)));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        return ResponseEntity.status(402).body(MethodArgumentNotValidExceptionToExceptionResponse(methodArgumentNotValidException));
    }

    private ExceptionResponse ruleExceptionToExceptionResponse(RuleExecption ruleExecption) {
        return ExceptionResponse.builder().
                message(messageSourceAccessor.getMessage(ruleExecption.getMessage())).
                code(ruleExecption.getMessage()).build();
    }

    private List<ExceptionResponse> MethodArgumentNotValidExceptionToExceptionResponse(MethodArgumentNotValidException methodArgumentNotValidException){
        return methodArgumentNotValidException.getFieldErrors().stream().map(error -> ExceptionResponse.builder().
                message(error.getDefaultMessage()).code(error.getDefaultMessage()).build()).collect(Collectors.toList());
    }

}
