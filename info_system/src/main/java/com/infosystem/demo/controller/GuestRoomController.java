package com.infosystem.demo.controller;

import com.infosystem.demo.domain.GuestRoom;
import com.infosystem.demo.mapper.GuestRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuestRoomController {
    @Autowired
    private GuestRoomMapper guestRoomMapper;

    @RequestMapping("/findAllGuestRoom")
    public List<GuestRoom> findAllGuestRoom() throws Exception {
        List<GuestRoom> guestRoomList = guestRoomMapper.findAllGuestRoom();
        return guestRoomList;
    }

    @RequestMapping("/findGuestRoomById")
    public List<GuestRoom> findGuestRoomById(@RequestParam(value = "type_id") int type_id){
        List<GuestRoom> guestRoomList = guestRoomMapper.findGuestRoomById(type_id);
        return guestRoomList;
    }
}
