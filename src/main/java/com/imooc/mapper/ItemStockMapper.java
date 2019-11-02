package com.imooc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.bean.ItemStock;
import org.apache.ibatis.annotations.Update;

public interface ItemStockMapper extends BaseMapper<ItemStock> {

    //    @Select("select * from item_stock where item_id = #{itemId}")
//    ItemStock selectByItemId(String itemId);
//
    @Update("update item_stock set stock = stock-#{amount} where item_id = #{itemId} and stock>=#{amount}")
    int decreaseStock(String itemId, Integer amount);

}