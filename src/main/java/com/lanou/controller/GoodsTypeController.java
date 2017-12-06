package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.dao.GoodsTypeMapper;
import com.lanou.entity.*;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Controller
@RequestMapping("/")
public class GoodsTypeController {
	@Autowired
	private GoodsTypeService goodsTypeService;

	@RequestMapping("/index")
	@ResponseBody
	public void finds(HttpServletResponse response,GoodsType good1 , Integer aId){

		Map<String,Object> map = new HashMap<String,Object>();

		//请求首页部分数据
		List<GoodsType> goodsTypeList = goodsTypeService.find9Goods3Type();
		List<GoodsType> goodsTypeList1 = goodsTypeService.findGoods1Type();
		List<Floor> floorList = goodsTypeService.findFloor();
		List<Goods> goodsList = goodsTypeService.find8Goods();
		List<GoodsType> goods = find1(good1,aId);
		System.out.println(goods);

		//map传出
        map.put("yi", goodsTypeList);//发现随机的九个三级标签
        map.put("er", goodsTypeList1);//所有的一级标签
        map.put("san", floorList);//各个楼层的文字
        map.put("si", goodsList);//推荐楼层中的八个商品
		map.put("wu",goods);//无限极查询

		//return map;
        FastJson_All.toJson(map,response);
	}

	// ============================================================无限级查询的方法
	 public List<GoodsType> find1(GoodsType good1 , Integer aId){
        List<GoodsType> goods =goodsTypeService.findfenlei(aId);
        for (GoodsType good : goods) {
           good.setGoodsTypes(find1(good1, good.getaId()));
        }
        System.out.println(goods);
        return goods;
    }
//    ===========================================================
	@RequestMapping("/indexFloor")
	@ResponseBody
	//这里接收对应楼层的id
	public void finds(int id,HttpServletResponse response){

		//根据id请求对应楼层的ajax
		List<FloorImage> floorImages = new ArrayList<FloorImage>();
		List<Goods> goodsList = new ArrayList<Goods>();
		Map<String,Object> map = new HashMap<String,Object>();

		if(id>=2&&id<=5){

			floorImages = goodsTypeService.findFloorImage(id);
			map.put("data",floorImages);

		} else if(id==6){
			goodsList = goodsTypeService.find8Goods();
			map.put("data",goodsList);
		}
        FastJson_All.toJson(map,response);
		//return map;

	}


}
