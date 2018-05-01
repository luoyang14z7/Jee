package com.yang;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.yang.UserJDBCTemplate;
import java.util.List;
@Controller
public class UserController {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ModelAndView user() {
        return new ModelAndView("user", "command", new UserLogin());
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String adduser(@ModelAttribute("SpringWeb")UserLogin userLogin,ModelMap model) {


        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate) context.getBean("userJDBCTemplate");
           userJDBCTemplate.adduser(userLogin.getUsername(),userLogin.getPassword());
/*        List<UserLogin> listusers = userJDBCTemplate.listusers();
        model.addAttribute("listusers", listusers);*/
        model.addAttribute("username",userLogin.getUsername());
        model.addAttribute("password", userLogin.getPassword());

        return "ok";
    }


   /* public UserController() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate) context.getBean("userJDBCTemplate");
        UserLogin userLogin = new UserLogin();
     *//*   userJDBCTemplate.adduser(userLogin.getUsername(),userLogin.getPassword());*//*
        userJDBCTemplate.adduser("asda","sdasd");
    }*/
}
