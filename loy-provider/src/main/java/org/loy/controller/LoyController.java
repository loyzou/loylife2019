package org.loy.controller;

import org.loy.api.ILoyApi;
import org.loy.common.context.LoyParam;
import org.loy.common.context.LoyResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoyController implements ILoyApi {

    @RequestMapping("/callNoTx")
    public LoyResult callNoTx(@RequestBody LoyParam params) {
        return null;
    }

    @RequestMapping("/call")
    public LoyResult call(@RequestBody LoyParam params) {
        return null;
    }
}
