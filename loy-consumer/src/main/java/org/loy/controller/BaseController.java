package org.loy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 基础控制类
 */
@Component
public class BaseController {
    @Autowired
    public HttpServletRequest request;
    @Autowired
    public HttpServletResponse response;
}
