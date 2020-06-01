package com.hengshui.controller;
import com.hengshui.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("account")
public class ResponseController {

    @RequestMapping("rtValueString")
    public String rtValueString(Model model){
        System.out.println("rtValueString执行了");
        User user = new User();
        user.setUsername("abc");
        user.setAge(22);
        model.addAttribute("user",user);
        return "success";
    }

    @RequestMapping("/rtVoidForward")
    public void rtVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        return;
    }

    @RequestMapping("/rtSendRedirect")
    public void rtSendRedirect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath()+"/com.com.hengshui.request.jsp");
        return;
    }

    @RequestMapping("/com/hengshui/response")
    public void response(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("你好");
        return;
    }


    @RequestMapping("rtModelAndView")
    public ModelAndView rtModelAndView(){
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setUsername("小明");
        user.setAge(22);
        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }


    @RequestMapping("/rtForward")
    public String rtForward(){
        return "forward:/WEB-INF/pages/success.jsp";
    }

    @RequestMapping("/rtRedirect")
    public String rtRedirect(){
        return "redirect:/com.com.hengshui.request.jsp";
    }

    @RequestMapping("/textAjax")
    public @ResponseBody User textAjax(@RequestBody User u){
        System.out.println("成功访问到textAjax");
        System.out.println(u);
        User user = new User();
        user.setUsername("小明");
        user.setAge(22);
        return user;
    }
}
