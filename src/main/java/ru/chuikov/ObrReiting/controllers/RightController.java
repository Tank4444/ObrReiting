package ru.chuikov.ObrReiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.chuikov.ObrReiting.entity.Right;
import ru.chuikov.ObrReiting.services.RightService;
import ru.chuikov.ObrReiting.services.impl.RightServiceImpl;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/right")
public class RightController {
    @Autowired
    private RightServiceImpl rightService;

    private int testint=0;

    @RequestMapping(path = "/add",method = RequestMethod.GET,produces = "application/json")
    public void addRandom()
    {
        rightService.addRight(new Right(String.valueOf(testint)));
        testint=testint+10;
    }
    @RequestMapping(path = "/show",method = RequestMethod.GET,produces = "application/json")
    public List<Right> show()
    {
        return rightService.getAll();
    }

}
