package com.imooc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.bean.Item;
import org.springframework.stereotype.Component;

@Component
public interface ItemMapper extends BaseMapper<Item> {

//    @Select("select * from item order by sales desc")
//    List<Item> selAll();

}