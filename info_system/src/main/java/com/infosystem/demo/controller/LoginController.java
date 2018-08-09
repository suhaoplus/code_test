package com.infosystem.demo.controller;

import com.infosystem.demo.domain.UserInfo;
import com.infosystem.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/loginController")
    public Map<String,Object> loginController(HttpServletRequest request, HttpSession session) throws Exception {
        String              loginName = request.getParameter("loginName");
        String              password  = request.getParameter("password");
        Map<String,Object> params = new HashMap<>();
        params.put("name",loginName);
        params.put("password",password);
        UserInfo user = userMapper.findUser(params);
        if (user == null){
            params.put("result","wrong");
            return params;
        }else if("admin".equals(user.getUser_type())){
            params.put("result","admin");
            session.setAttribute("user",user);
        } else if("staff".equals(user.getUser_type())){
            params.put("result","staff");
            session.setAttribute("user",user);
        } else {
            params.put("result","empty");
        }

        /*if(user != null){
            System.out.println("登录成功");
            System.out.println(user);
            return params;
        }
        System.out.println("登录失败");*/
        System.out.println("用户名:"+session.getAttribute("user"));
        return params;
    }

    @RequestMapping(value = "/getLoginname")
    public String getUserName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserInfo    user    = (UserInfo) session.getAttribute("user");

        session.setMaxInactiveInterval(24 * 60 * 60);

        String loginname = user.getName();

        return loginname;
    }


}
