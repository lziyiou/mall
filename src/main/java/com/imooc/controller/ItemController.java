package com.imooc.controller;

import com.imooc.controller.viewObject.ItemVo;
import com.imooc.error.BusinessException;
import com.imooc.response.CommonReturnType;
import com.imooc.service.ItemService;
import com.imooc.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/item")
public class ItemController extends BaseController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * 创建商品
     * @param itemModel 接收商品信息
     * @return  返回一个itemVo
     * @throws BusinessException 添加商品引发可能引发异常
     */
    @RequestMapping("citem")
    public CommonReturnType createItem(ItemModel itemModel) throws BusinessException {
        ItemModel itemModelForReturn = itemService.createItem(itemModel);
        ItemVo itemVo = convertItemVoFromItemModel(itemModelForReturn);
        return new CommonReturnType(itemVo);
    }

    /**
     * 商品展示
     * @return CommonReturnType
     */
    @RequestMapping("item_list")
    public CommonReturnType showItems(){
        List<ItemModel> itemModels = itemService.listItem();
        List<ItemVo> itemVoList = itemModels.stream().map(this::convertItemVoFromItemModel).collect(Collectors.toList());
        return new CommonReturnType(itemVoList);
    }

    @RequestMapping("getItem")
    public CommonReturnType getItem(@RequestParam("id")String id){
        ItemModel ItemModel = itemService.getItemById(id);

        return new CommonReturnType(convertItemVoFromItemModel(ItemModel));
    }

    /**
     * 把ItemModel转为ItemVo对象，返回给前端
     * @param itemModel 数据来源
     * @return ItemVo
     */
    private ItemVo convertItemVoFromItemModel(ItemModel itemModel) {
        if (itemModel == null) {
            return null;
        }
        ItemVo itemVo = new ItemVo();
        BeanUtils.copyProperties(itemModel, itemVo);
        return itemVo;
    }
}
