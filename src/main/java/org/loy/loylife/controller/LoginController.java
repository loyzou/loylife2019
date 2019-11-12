package org.loy.loylife.controller;

import org.loy.common.context.LoyResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class LoginController extends BaseController {

    @RequestMapping("login")
    public LoyResult login(){
        LoyResult loyResult = new LoyResult();
        loyResult.setSuccess(false);
        return loyResult;
    }

}
