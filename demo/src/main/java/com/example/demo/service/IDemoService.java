package com.example.demo.service;

import com.example.demo.model.DemoModel;
import com.example.demo.model.common.ResponseModel;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

@Validated
public interface IDemoService {
     ResponseModel addDemo(@Valid DemoModel model);
}
