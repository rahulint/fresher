package com.example.demo.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Builder
public class ResponseModel {
	private HttpStatus statusCode;
	private String message;
	private Integer messageTypeId;
}

