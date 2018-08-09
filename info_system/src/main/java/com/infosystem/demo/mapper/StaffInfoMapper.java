package com.infosystem.demo.mapper;

import com.infosystem.demo.domain.StaffInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffInfoMapper {
    /**
     * 查找所有员工信息
     * @return
     * @throws Exception
     */
    public List<StaffInfo> findAllStaff() throws Exception;

    /**
     * 插入员工信息
     * @param staffInfo
     * @return
     * @throws Exception
     */
    public int addStaffInfo(StaffInfo staffInfo)throws Exception;

    /**
     * 修改员工信息
     * @param staffInfo
     * @return
     * @throws Exception
     */
    public int updateStaffInfo(StaffInfo staffInfo) throws Exception;

    /**
     * 伪删除
     * @param staff_id
     * @return
     * @throws Exception
     */
    public int deleteStaffInfo(int staff_id)throws Exception;
}
