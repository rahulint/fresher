package com.example.demo.advise;

import com.example.demo.common.MessageTypeConst;
import com.example.demo.exception.RecordFoundException;
import com.example.demo.model.common.LoggingResponseModel;
import com.example.demo.model.common.ResponseModel;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {

    @Autowired
    Gson gson;

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(Exception.class)
    public ResponseModel handleUnprocessableException(Exception ex) {
        String msg= ex.getMessage();
        ResponseModel errorResponse=null;
        errorResponse = ResponseModel.builder()
                .message(msg)
                .messageTypeId(MessageTypeConst.ERROR.getMessage())
                .statusCode(HttpStatus.UNPROCESSABLE_ENTITY)
                .build();
        log.error(gson.toJson(LoggingResponseModel.builder()
                .message(msg)
                .messageTypeId(MessageTypeConst.ERROR)
                .statusCode(HttpStatus.UNPROCESSABLE_ENTITY)
                .build()));
        return errorResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(RecordFoundException.class)
    public ResponseModel handleRecordFoundException(RecordFoundException ex) {
        String msg= ex.getMessage();
        ResponseModel response=null;
        response = ResponseModel.builder()
                .message(msg)
                .messageTypeId(MessageTypeConst.SUCCESS.getMessage())
                .statusCode(HttpStatus.OK)
                .build();
        return response;
    }
}
