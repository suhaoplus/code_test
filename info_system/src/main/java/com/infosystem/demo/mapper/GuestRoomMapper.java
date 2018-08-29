package com.infosystem.demo.mapper;

import com.infosystem.demo.domain.GuestRoom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRoomMapper {
    /**
     * 查找所有房间信息
     * @return
     * @throws Exception
     */
    public List<GuestRoom> findAllGuestRoom() throws Exception;

    /**
     * 根据房间类型查找
     * @param type_id
     * @return
     */
    List<GuestRoom> findGuestRoomById(int type_id);
}
