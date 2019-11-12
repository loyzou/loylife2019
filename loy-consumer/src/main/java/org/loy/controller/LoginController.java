package org.loy.controller;

import org.loy.api.user.IUserApi;
import org.loy.common.context.LoyResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class LoginController extends BaseController {
    private ILoyApi iLoyApi;

    @RequestMapping("login")
    public LoyResult login(){
        LoyResult loyResult = new LoyResult();
        loyResult.setSuccess(false);
        return loyResult;
    }

}
