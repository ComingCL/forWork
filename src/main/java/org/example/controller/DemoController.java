package org.example.controller;

import org.example.annotation.SystemLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/29 13:35
 */
@Controller
@RequestMapping("/demo")
@SystemLog(title = "DemoController")
public class DemoController {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("hello", "xxx");
        return "hello";
    }
}
