package com.imooc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.bean.Promo;
import org.apache.ibatis.annotations.Select;

public interface PromoMapper extends BaseMapper<Promo> {
    @Select("select * from promo where item_id = #{itemId}")
    Promo selByItemId(String itemId);
}
