package com.shaw.controller;

import com.shaw.pojo.User;
import com.shaw.service.UserService;
import com.shaw.util.DataMsg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName: UserController
 * @Description:
 * @Author Lindsey Shaw
 * @Date 2018/9/2
 **/
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/success")
    public String success() {
        return "success";
    }


    @RequestMapping("/toPage")
    public String toHomePage() {
        System.out.println("a");
        return "login";
    }

    @RequestMapping("/list")
    @ResponseBody
    public DataMsg findAll() {
        List<User> all = userService.findAll();
        return DataMsg.success(all);
    }

    @RequestMapping("/get/{name}")
    @ResponseBody
    public DataMsg getUser(@PathVariable String name) {
        return DataMsg.success(userService.findUserByName(name));
    }

    /**
     * 
     * @Description: 处理登录信息
     * @param user
     * @return String
     * @author Lindsey Shaw
     * @date 2018/9/11 13:33
     */
    @RequestMapping(value = "/enter", method = RequestMethod.POST)
    @ResponseBody
    public DataMsg login(User user, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        try {
            subject.logout();
            subject.login(token);
            boolean authenticated = subject.isAuthenticated();
            System.out.println("登录状态" + authenticated);
        } catch (Exception e) {
            return DataMsg.error("登录失败");
        }
        return DataMsg.success("登录成功");
    }

}
