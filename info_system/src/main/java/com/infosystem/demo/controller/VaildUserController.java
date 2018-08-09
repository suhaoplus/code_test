package com.infosystem.demo.controller;

import com.infosystem.demo.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Class VaildUserController
 *
 *
 * @version        1.0, 17/09/30
 * @author         datapps
 */
@RestController
@Controller
public class VaildUserController {

    /**
     * Method vaildUser
     *
     *
     * @param session
     *
     * @return Map<String,Object>
     */
    @RequestMapping("/vaildUser")
    public Map<String, Object> vaildUser(HttpSession session) {
        Map<String, Object> map      = new HashMap<>();
        UserInfo            userInfo = (UserInfo) session.getAttribute("user");

        if (userInfo == null) {
            map.put("loginError", "true");

            return map;
        } else {
            map.put("loginError", "false");

            return map;
        }
    }


}
