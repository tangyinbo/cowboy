package com.cowboy.web.controller;/**
 * Created by Administrator on 2017/12/14/0014.
 */

import com.cowboy.log.annotation.RequestParamResultLogPrint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-14 15:05
 **/
@Controller
public class TestController {
    @RequestMapping("/test")
    @RequestParamResultLogPrint
    public void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message","it's forword ");
        //req.getRequestDispatcher("webapp/sys2.html").forward(req,resp);
        resp.sendRedirect("webapp/sys2.html");

    }
}
