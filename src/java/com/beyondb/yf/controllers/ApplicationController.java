/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beyondb.yf.controllers;

/**
 *
 * @author Retror
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    ModelAndView index() {
        logger.info("ApplicationController#index");
        return new ModelAndView("index");
    }
}
