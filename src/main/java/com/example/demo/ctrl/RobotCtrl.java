package com.example.demo.ctrl;

import com.example.demo.nlp.tools.CBTokenizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("robot")
public class RobotCtrl {

    @GetMapping("test")
    public String test(){
        String[] tokens = CBTokenizer.tokens("Would you please help to grant permission.");
        for (String s : tokens) {
            System.out.println(s);
        }
        return "okkkkkkk";
    }
}
