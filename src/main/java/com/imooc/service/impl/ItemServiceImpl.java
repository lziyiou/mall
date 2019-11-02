package com.imooc.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.imooc.bean.Item;
import com.imooc.bean.ItemStock;
import com.imooc.error.BusinessException;
import com.imooc.error.EmBusinessError;
import com.imooc.mapper.ItemMapper;
import com.imooc.mapper.ItemStockMapper;
import com.imooc.service.ItemService;
import com.imooc.service.PromoService;
import com.imooc.service.model.ItemModel;
import com.imooc.service.model.PromoModel;
import com.imooc.util.ConvertUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemMapper itemMapper;
    private final ItemStockMapper itemStockMapper;
    private final PromoService promoService;

    // 构造函数
    public ItemServiceImpl(ItemMapper itemMapper, PromoService promoService, ItemStockMapper itemStockMapper) {
        this.itemMapper = itemMapper;
        this.promoService = promoService;
        this.itemStockMapper = itemStockMapper;
    }

    /**
     * 创建商品
     *
     * @param itemModel 商品模型
     * @return ItemModel   返回从数据库中获取的存入对象
     * @throws BusinessException BusinessException
     */
    @Override
    @Transactional
    public ItemModel createItem(ItemModel itemModel) throws BusinessException {
        if (itemModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        //获取item, itemStock对象
//        Item item = convertItemFromItemModel(itemModel);
        Item item = ConvertUtil.convertTFromPojo(Item.class, itemModel);

        ItemStock itemStock = convertItemStockFromItemModel(itemModel);

        //写入数据库
        itemMapper.insert(item);
        itemStockMapper.insert(itemStock);

        return getItemById(itemModel.getId());
    }

    /**
     * 展示商品
     *
     * @return ItemModelList
     */
    @Override
    public List<ItemModel> listItem() {
        List<Item> items = itemMapper.selectList(Wrappers.<Item>query().orderByDesc("sales"));

        return items.stream().map(item -> {
            ItemStock itemStock = itemStockMapper.selectOne(Wrappers.<ItemStock>lambdaQuery().eq(ItemStock::getItemId, item.getId()));
            return convertFromDataObject(item, itemStock);
//            return ConvertUtil.convertTFromPojo(item, itemStock);
        }).collect(Collectors.toList());
    }

    @Override
    public ItemModel getItemByName(String name) {
        return null;
    }

    /**
     * 通过id查询商品
     *
     * @param id 商品的id
     * @return 返回商品模型
     */
    @Override
    public ItemModel getItemById(String id) {
        Item item = itemMapper.selectById(id);
        if (item == null) {
            return null;
        }
        //获得库存数量
        ItemStock itemStock = itemStockMapper.selectOne(Wrappers.<ItemStock>lambdaQuery().eq(ItemStock::getItemId, item.getId()));

        ItemModel itemModel = convertFromDataObject(item, itemStock);
        // 获取活动商品信息
        PromoModel promoModel = promoService.getPromoByItemId(itemModel.getId());
        if (promoModel != null && promoModel.getStatus() != 2) {
            itemModel.setPromoModel(promoModel);
        }

        return itemModel;
    }

    @Override
    @Transactional
    public boolean decreaseStock(String itemId, Integer amount) {
        int affectedRow = itemStockMapper.decreaseStock(itemId, amount);

        return affectedRow > 0;
    }

    /**
     * 把Item, ItemStock合成ItemModel对象
     *
     * @param item      Item对象
     * @param itemStock ItemStock库存对象
     * @return ItemModel对象
     */
    private ItemModel convertFromDataObject(Item item, ItemStock itemStock) {
        //用户为空，返回空
        if (item == null) {
            return null;
        }
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(item, itemModel);
        //密码为空，则不设置密码
        if (itemStock != null) {
            itemModel.setStock(itemStock.getStock());
        }
        return itemModel;
    }

    /**
     * 从ItemModel对象中获取ItemStock库存对象
     *
     * @param itemModel 商品模型对象
     * @return ItemStock库存对象
     */
    private ItemStock convertItemStockFromItemModel(ItemModel itemModel) {
        if (itemModel == null) {
            return null;
        }
        ItemStock itemStock = new ItemStock();
        itemStock.setItemId(itemModel.getId());
        itemStock.setStock(itemModel.getStock());
        return itemStock;
    }
}
