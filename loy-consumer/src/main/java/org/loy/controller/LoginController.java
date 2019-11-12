package org.loy.controller;

import org.loy.api.ILoyApi;
import org.loy.common.context.LoyParam;
import org.loy.common.context.LoyResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class LoginController extends BaseController {
    private ILoyApi iLoyApi;

    @RequestMapping("login")
    public LoyResult login(){
        LoyParam loyParam = new LoyParam("customerService", "login");
        LoyResult loyResult = iLoyApi.login(loyParam);
        return loyResult;
    }

}
