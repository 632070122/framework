package com.hengshui.controller;

import com.hengshui.domain.User;
import com.hengshui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public String findALl(Model model) {
        System.out.println("Controller的findAll方法执行");
        List<User> list = userService.findAll();
        System.out.println(list);
        model.addAttribute("list",list);
        return "success";
    }

    @RequestMapping("/saveUser")
    public void saveUser(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.saveUser(user);
        response.sendRedirect(request.getContextPath()+"findAll");
        return ;
    }
}
