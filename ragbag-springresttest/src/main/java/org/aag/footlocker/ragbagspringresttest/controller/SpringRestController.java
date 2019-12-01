package org.aag.footlocker.ragbagspringresttest.controller;

import org.aag.footlocker.ragbagspringresttest.beans.CursoBean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "TestRest")
public class SpringRestController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CursoBean test(){
        return new CursoBean(1,"Test",3,new Date());
    }
}
