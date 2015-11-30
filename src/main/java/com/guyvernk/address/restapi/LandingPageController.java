package com.guyvernk.address.restapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class LandingPageController {
    @RequestMapping({"/"})
    public String showHomePage(Map<String, Object> model) {
        return "index";
    }
}
