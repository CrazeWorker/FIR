package com.taotao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {
    @RequestMapping(path = "/")
    public String showIndexPage(){
        return "index";
    }

    @RequestMapping(path = "/{page}")
    public String showItemPage(@PathVariable String page) {
        return page;
    }
}
