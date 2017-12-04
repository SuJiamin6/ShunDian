package com.lanou.controller;

import com.lanou.entity.Floor;
import com.lanou.entity.FloorImage;
import com.lanou.entity.Goods;
import com.lanou.entity.GoodsType;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public Map<String,Object> finds(){

		Map<String,Object> map = new HashMap<String,Object>();

		//请求首页部分数据
		List<GoodsType> goodsTypeList = goodsTypeService.find9Goods3Type();
		List<GoodsType> goodsTypeList1 = goodsTypeService.findGoods1Type();
		List<Floor> floorList = goodsTypeService.findFloor();
		List<Goods> goodsList = goodsTypeService.find8Goods();

		map.put("yi",goodsTypeList);
		map.put("er",goodsTypeList1);
		map.put("san",floorList);
		map.put("si",goodsList);

		return map;
	}

	@RequestMapping("/indexFloor")
	@ResponseBody
	//这里接收对应楼层的id
	public Map<String,Object> finds(int id){

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

		return map;

	}

//	public List<GoodsType> finds() {
//		List<GoodsType> goodsTypeList = goodsTypeService.find9Goods3Type();
//		return goodsTypeList;
//	}
	
}
