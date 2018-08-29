package com.infosystem.demo.controller;

import com.infosystem.demo.domain.Customer;
import com.infosystem.demo.domain.CustomerInfo;
import com.infosystem.demo.mapper.CustomerInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerInfoController {
    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    @RequestMapping("/customerInfo")
    public List<CustomerInfo> customerInfo(@RequestParam(value = "guest_room_id") int guest_room_id) {
        List<CustomerInfo> customerInfo = null;
        try {
            customerInfo = customerInfoMapper.findCustomerInfoByRoomId(guest_room_id);
            return customerInfo;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("错误");
        }
        return null;
    }

    @RequestMapping("/customer")
    public List<Customer> customers(){
        List<Customer> customers = null;
        try {
            customers = customerInfoMapper.findCustomers();
            System.out.println(customers);
            return customers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/deleteCustomer")
    public boolean deleteCustomer(@RequestParam(value = "customer_id") String customer_id) throws Exception {
        customerInfoMapper.deleteCustomerById(customer_id);
        return true;
    }

}
