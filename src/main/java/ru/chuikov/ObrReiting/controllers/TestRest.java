package ru.chuikov.ObrReiting.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("test")
public class TestRest {
    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public HashMap getOK()
    {
        HashMap hm=new HashMap();
        hm.put("result","OK");
        return hm;
    }
}
