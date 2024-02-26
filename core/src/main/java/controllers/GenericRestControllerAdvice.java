package controllers;

import dto.ErrorResponseDto;
import execptions.ElementNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GenericRestControllerAdvice {
    @ExceptionHandler(ElementNotFoundException.class)
    ErrorResponseDto handleElementNotFoundException(ElementNotFoundException ex, WebRequest webRequest) {
        return ErrorResponseDto.builder()
                .apiPath(webRequest.getDescription(false))
                .errorCode(HttpStatus.NOT_FOUND)
                .errorMessage(ex.getMessage())
                .errorTime(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ErrorResponseDto handleIllegalArgumentException(IllegalArgumentException ex, WebRequest webRequest) {
        return ErrorResponseDto.builder()
                .apiPath(webRequest.getDescription(false))
                .errorCode(HttpStatus.BAD_REQUEST)
                .errorMessage(ex.getMessage())
                .errorTime(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(Exception.class)
    ErrorResponseDto handleGeneralException(Exception ex, WebRequest webRequest) {
        return ErrorResponseDto.builder()
                .apiPath(webRequest.getDescription(false))
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .errorMessage(ex.getMessage())
                .errorTime(LocalDateTime.now())
                .build();
    }


}
