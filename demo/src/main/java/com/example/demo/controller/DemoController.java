package com.example.demo.controller;

import com.example.demo.common.MessageTypeConst;
import com.example.demo.model.DemoModel;
import com.example.demo.model.common.LoggingResponseModel;
import com.example.demo.model.common.ResponseModel;
import com.example.demo.service.IDemoService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/demo")
@Slf4j
public class DemoController {
    @Autowired
    Gson gson;

    @Autowired
    IDemoService iDemoService;

    @PostMapping(value = "/adddemo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> addDemo(@RequestBody String request){
        LoggingResponseModel msgStart = LoggingResponseModel.builder()
                .message("Start Add Demo")
                .messageTypeId(MessageTypeConst.SUCCESS)
                .build();
        log.info(gson.toJson(msgStart));

        ResponseModel response = iDemoService.addDemo(gson.fromJson(request, DemoModel.class));
        HttpStatus status = response.getStatusCode() != null ? response.getStatusCode() : HttpStatus.NOT_FOUND;

        LoggingResponseModel msgEnd = LoggingResponseModel.builder()
                .message("End Add Demo")
                .messageTypeId(MessageTypeConst.SUCCESS)
                .build();

        log.info(gson.toJson(msgEnd));
        return new ResponseEntity<ResponseModel>(response, status);
    }
}
