package com.imooc.service;

import com.imooc.error.BusinessException;
import com.imooc.service.model.ItemModel;

import java.util.List;

public interface ItemService {
    //创建商品
    ItemModel createItem(ItemModel itemModel) throws BusinessException;
    //商品列表浏览
    List<ItemModel> listItem();
    //商品详情
    ItemModel getItemByName(String name);
    ItemModel getItemById(String id);

    //库存扣减
    boolean decreaseStock(String itemId, Integer amount);
}
