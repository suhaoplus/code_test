package com.infosystem.demo.controller;

import com.infosystem.demo.domain.Style;
import com.infosystem.demo.mapper.StyleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomStyleController {
    @Autowired
    private StyleMapper styleMapper;

    @RequestMapping("/findAllStyle")
    public List<Style> findAllStyle() throws Exception {
        List<Style> styleList = styleMapper.findAllStyle();
        return styleList;
    }
}
