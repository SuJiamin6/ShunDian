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
	public void finds(HttpServletResponse response){

		Map<String, Object> map = new HashMap();

		List<GoodsType> goodsTypeList = this.goodsTypeService.find9Goods3Type();
		List<GoodsType> goodsTypeList1 = this.goodsTypeService.findGoods1Type();
		List<Floor> floorList = this.goodsTypeService.findFloor();
		List<Goods> goodsList = this.goodsTypeService.find8Goods();

		List<FloorImage> floorImages = this.goodsTypeService.findFloorImage();
		List<Goods> goodsList1 = this.goodsTypeService.find8Goods();

		map.put("yi", goodsTypeList);
		map.put("er", goodsTypeList1);
		map.put("san", floorList);

		map.put("si", goodsList);
		map.put("wu", floorImages);
		map.put("liu", goodsList1);

		FastJson_All.toJson(map, response);
	}


}
