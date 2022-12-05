package com.example.demo.model.common;

import com.example.demo.common.MessageTypeConst;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Builder
public class LoggingResponseModel {
	private HttpStatus statusCode;
	private String message;
	private MessageTypeConst messageTypeId;
}

