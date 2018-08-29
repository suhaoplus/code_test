package com.infosystem.demo.controller;

import com.infosystem.demo.domain.StaffInfo;
import com.infosystem.demo.mapper.StaffInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaffController {
    @Autowired
    private StaffInfoMapper staffInfoMapper;

    @RequestMapping("/findAllStaff")
    public List<StaffInfo> findAllStaff() throws Exception {
        List<StaffInfo> staffInfos = staffInfoMapper.findAllStaff();
        return staffInfos;
    }

    @RequestMapping("/insertStaffInfo")
    public boolean addStaffInfo(@RequestParam(value = "staff_name")String staff_name,
                                @RequestParam(value = "sex")String sex,
                                @RequestParam(value = "birthday")String birthday,
                                @RequestParam(value = "years")String years,
                                @RequestParam(value = "tel")String tel) throws Exception {
        StaffInfo staffInfo = new StaffInfo(staff_name,sex,birthday,years,tel);
        staffInfoMapper.addStaffInfo(staffInfo);
        return true;
    }

    @RequestMapping("/updateStaffInfo")
    public boolean updateStaffInfo(
                                @RequestParam(value = "staff_id")int staff_id,
                                @RequestParam(value = "staff_name")String staff_name,
                                @RequestParam(value = "sex")String sex,
                                @RequestParam(value = "birthday")String birthday,
                                @RequestParam(value = "years")String years,
                                @RequestParam(value = "tel")String tel) throws Exception {
        StaffInfo staffInfo = new StaffInfo(staff_id,staff_name,sex,birthday,years,tel);
        staffInfoMapper.updateStaffInfo(staffInfo);
        return true;
    }

    @RequestMapping("/deleteStaffInfo")
    public boolean deleteStaffInfo(@RequestParam(value = "staff_id")int staff_id) throws Exception {
        staffInfoMapper.deleteStaffInfo(staff_id);
        return true;
    }
}
