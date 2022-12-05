package com.example.demo.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import com.example.demo.model.DemoModel;
import com.example.demo.repository.IDemoRepository;
import com.example.demo.service.IDemoService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class DemoTests {

    @Autowired
    private IDemoService iDemoservice;

    @MockBean
    IDemoRepository iDemoRepo;

    @Test
    @Order(1)
    public void givenDemoWhenSaveThenStatusOk() {
        DemoModel saveDemoModel=new DemoModel();
        saveDemoModel.setName("Test name");
        iDemoRepo.save(saveDemoModel);
        when(iDemoRepo.save(saveDemoModel)).thenReturn(saveDemoModel);
        assertEquals(HttpStatus.OK, iDemoservice.addDemo(saveDemoModel).getStatusCode());
    }
}
