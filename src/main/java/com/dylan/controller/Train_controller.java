package com.dylan.controller;

import com.dylan.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Train_controller {

    @Autowired
    private TrainService trainService;

    @RequestMapping("/toTrain")
    public String toTrain(){
        return "admin/train/train";
    }
}
