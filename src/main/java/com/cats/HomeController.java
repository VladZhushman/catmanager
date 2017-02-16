package com.cats;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vlad on 16.02.17.
 */

@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String home(){
        return "test";
    }
}
