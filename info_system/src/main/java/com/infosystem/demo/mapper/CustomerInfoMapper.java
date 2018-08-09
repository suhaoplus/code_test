package com.infosystem.demo.mapper;

import com.infosystem.demo.domain.Customer;
import com.infosystem.demo.domain.CustomerInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerInfoMapper {
    /**
     * 根据房间号查询客人信息
     * @param guest_room_id
     * @return
     */
    public List<CustomerInfo> findCustomerInfoByRoomId(int guest_room_id) throws Exception;

    /**
     * 客人信息
     * @return
     */
    public List<Customer> findCustomers()throws Exception;

    /**
     * 根据id删除客人信息
     * @param customer_id
     */
    void deleteCustomerById(String customer_id)throws Exception;
}
