package com.asy.test.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by asy
 */

@Controller
public class IndexPageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView mav) {
        mav.setViewName("index.jsp");
        return mav;
    }

}
