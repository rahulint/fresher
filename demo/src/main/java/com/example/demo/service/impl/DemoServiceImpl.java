package com.example.demo.service.impl;

import com.example.demo.common.MessageTypeConst;
import com.example.demo.model.DemoModel;
import com.example.demo.model.common.ResponseModel;
import com.example.demo.repository.IDemoRepository;
import com.example.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    IDemoRepository iDemoRepo;

    /**
     * This function do some TODO logic
     */
    @Override
    public ResponseModel addDemo(DemoModel model) {
        ResponseModel response=null;
        /*
            Use java optional ifpresentorelse function to check some thing exists (if exists throw an exception
            with some custom message) otherwise save in db.
         */
        response=ResponseModel.builder().message("Success message").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).
                statusCode(HttpStatus.OK).build();
        return response;
    }
}
