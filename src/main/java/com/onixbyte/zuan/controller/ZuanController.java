package com.onixbyte.zuan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.onixbyte.zuan.service.ZuanService;

/**
 * ZuanController
 *
 * @author Zihlu Wang
 * @since 22 Sept, 2023
 */
@RestController
@RequestMapping("/zuan")
public class ZuanController {

    private static final Logger log = LoggerFactory.getLogger(ZuanController.class);

    private final ZuanService zuanService;

    @Autowired
    public ZuanController(ZuanService zuanService) {
        this.zuanService = zuanService;
    }

    @GetMapping("/")
    public String randomOne(@RequestParam(required = false) String level) {
        return zuanService.getRandomOne(level).getText();
    }

}
