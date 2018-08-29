package com.infosystem.demo.mapper;

import com.infosystem.demo.domain.Style;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StyleMapper {
    /**
     * 显示所有房间类型
     * @return
     * @throws Exception
     */
    public List<Style> findAllStyle()throws Exception;
}
