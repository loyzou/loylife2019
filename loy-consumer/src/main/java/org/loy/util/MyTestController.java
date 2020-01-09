package org.loy.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController {
    @Autowired
    private LoyService loyService;

    @RequestMapping("say")
    public void say(){
        loyService.say();
    }
}
