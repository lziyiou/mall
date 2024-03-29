package com.imooc.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.imooc.bean.Promo;
import com.imooc.mapper.PromoMapper;
import com.imooc.service.PromoService;
import com.imooc.service.model.PromoModel;
import com.imooc.util.ConvertUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

@Service
public class PromoServiceImpl implements PromoService {

    private final PromoMapper promoMapper;

    public PromoServiceImpl(PromoMapper promoMapper) {
        this.promoMapper = promoMapper;
    }

    @Override
    public PromoModel getPromoByItemId(String itemId) {

        Promo promo = promoMapper.selectOne(Wrappers.<Promo>lambdaQuery().eq(Promo::getItemId, itemId));
        PromoModel promoModel = convertFromPromo(promo);

        // 判断活动状态
        if (promoModel.getStart().isAfterNow()) {
            promoModel.setStatus(0);
        } else if (promoModel.getEnd().isBeforeNow()) {
            promoModel.setStatus(2);
        } else {
            promoModel.setStatus(1);
        }

        return promoModel;
    }

    private PromoModel convertFromPromo(Promo promo) {
        PromoModel mod = ConvertUtil.convertTFromPojo(PromoModel.class, promo);
        mod.setStart(new DateTime(promo.getStart()));
        mod.setEnd(new DateTime(promo.getEnd()));
        return mod;
    }
}
