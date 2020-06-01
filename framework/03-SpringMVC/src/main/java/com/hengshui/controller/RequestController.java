package com.hengshui.controller;
import com.hengshui.domain.Account;
import com.hengshui.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/user")
@SessionAttributes(value = {"msg"})
public class RequestController {

    @RequestMapping(path = "/requestMapping",method = {RequestMethod.GET},params = "username",headers = {"Accept"})
    public String requestMapping(String username){
        System.out.println("username的值是"+username);
        return "success";
    }

    @RequestMapping("/javaBean1")
    public String javaBean1(User user){
        System.out.println("username的值是"+user.getUsername());
        System.out.println("age的值是"+user.getAge());
        return "success";
    }

    @RequestMapping("/javaBean2")
    public String javaBean2(User user){
        System.out.println("成功访问到requestMapping,并跳转页面");
        System.out.println("username的值是"+user.getUsername());
        System.out.println("age的值是"+user.getAge());
        System.out.println("金额的值是"+user.getAccount().getMoney());
        return "success";
    }

    @RequestMapping("/javaBean3")
    public String javaBean3(User user){
        System.out.println("username的值是"+user.getUsername());
        System.out.println("age的值是"+user.getAge());
        List<Account> accountList = user.getAccountList();
        for (Account account : accountList) {
            Double money = account.getMoney();
            System.out.println("金额的值是"+money);
        }
        return "success";
    }

    @RequestMapping("/javaBean4")
    public String javaBean4(User user){
        System.out.println("username的值是"+user.getUsername());
        System.out.println("age的值是"+user.getAge());
        Map<String, Account> accountMap = user.getAccountMap();
        for(String key : accountMap.keySet()){
            Account value = accountMap.get(key);
            System.out.println(key+":"+value.getMoney());
        }
        return "success";
    }


    @RequestMapping("/servletApi")
    public String servletApi(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        System.out.println(response);
        return "success";
    }

    @RequestMapping("/requestParam")
    public String requestParam(@RequestParam(name = "name",required = true) String username){
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/requestBody")
    public String requestBody(@RequestBody(required = true) String body){
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/pathVariable/{uid}")
    public String pathVariable(@PathVariable(name = "uid") String id){
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/requestHeader")
    public String requestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println(header);
        return "success";
    }

    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println(cookieValue);
        return "success";
    }

    @ModelAttribute
    public void startModelAttribute(String username,Map<String,User> map){
        User user = new User();
        user.setUsername(username);
        user.setAge(22);
        map.put("user",user);
    }

    @RequestMapping("/modelAttribute")
    public String modelAttribute(@ModelAttribute("user") User user){
        System.out.println(user);
        return "success";
    }

    /*@ModelAttribute
    public User startModelAttribute(String username){
        User user = new User();
        user.setUsername(username);
        user.setAge(22);
        return user;
    }

    @RequestMapping("/modelAttribute")
    public String modelAttribute(User user){
        System.out.println(user);
        return "success";
    }*/

    @RequestMapping("/sessionAttribute")
    public String sessionAttribute(Model model, ModelMap modelMap, SessionStatus sessionStatus){
        model.addAttribute("msg","美美");    //存储session域中
        String msg = (String)modelMap.get("msg"); //获取session域
        System.out.println(msg);
        sessionStatus.setComplete();              //删除
        return "success";
    }
}
/**
 * @RequestMapping 前端的映射映射路径
 *      path = 用于指定路径
 *      value = 用于指定路径
 *      method = {}用于指定请求的方法,get,post
 *      params = 用于指定请求参数的条件
 *      headers = 发送的请求中必须包含请求头
 * @RequestParam 指定前端传递过来的参数
 *      name = 前端传递过来的key值
 *      required = 设置true表示必须传递,默认值
 * @RequestBody 获取整个请求体的内容
 *      required = 设置true表示必须传递,默认值
 * @PathVariable 拥有绑定url中的占位符
 *      name 指定url中的占位符名称
 * @RequestHeader 用于获取消息请求头
 *      name 指定头的key
 * @CookieValue 用于把指定cookie名称的值传入控制器方法参数
 *      value 指定 cookie的key
 * @ModelAttribute 作用于方法上该方法优先执行
 * @SessionAttribute 用于执行控制器之间的方法参数共享,存到session域中
 *      value 指定属性名称
 *      type 指定属性类型
 *
 *
 **/
















