package org.loy.controller;

import org.loy.api.ILoyApi;
import org.loy.common.context.LoyParam;
import org.loy.common.context.LoyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class LoginController extends BaseController{
    @Autowired
    private ILoyApi iLoyApi;

    /***
     * 登录
     * @return
     */
    @RequestMapping("login")
    public LoyResult login(){
        LoyParam loyParam = new LoyParam("userService", "login");
        LoyResult loyResult = iLoyApi.callNoTx(loyParam);
        return loyResult;
    }

}
