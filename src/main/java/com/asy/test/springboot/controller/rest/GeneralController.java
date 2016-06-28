package com.asy.test.springboot.controller.rest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by asy
 */

@RestController
public class GeneralController implements ErrorController {

    private static final String PATH_ERROR = "/error";

    @RequestMapping("/ping")
    public String index() {
        return "Pong !";
    }

    @RequestMapping(value = PATH_ERROR)
    public ResponseEntity<?> error(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        exception.printStackTrace();
        return new ResponseEntity("Exception is thrown : " + response.getStatus(), HttpStatus.BAD_REQUEST);
    }

    @Override
    public String getErrorPath() {
        return PATH_ERROR;
    }
}
