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

import javax.servlet.http.HttpServletRequest;
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
	public void finds(HttpServletResponse response, HttpServletRequest request){

		Map<String, Object> map = new HashMap();

		List<GoodsType> goodsTypeList = this.goodsTypeService.find9Goods3Type();
		List<GoodsType> goodsTypeList1 = this.goodsTypeService.findGoods1Type();
		List<Floor> floorList = this.goodsTypeService.findFloor();
		List<Goods> goodsList = this.goodsTypeService.find8Goods();

		List<FloorImage> floorImages = this.goodsTypeService.findFloorImage();
		List<Goods> goodsList1 = this.goodsTypeService.find8Goods();

		GoodsType goodsType = new GoodsType();
		for (int i= 0;i<goodsTypeList1.size();i++){
			List<GoodsType> list =new ArrayList<GoodsType>();
			List list2 =new ArrayList();
			int aId = (Integer) goodsTypeList1.get(i).getaId();
			System.out.println(aId);
			list = find1(goodsType,aId);
			list.add(goodsTypeList1.get(i));
			list2 = goodsTypeService.findIndexSan(aId);
			map.put("biaoqian"+i,list);
			map.put("sanzhangtu"+i,list2);
		}
		//历史记录
		User user  = (User) request.getSession().getAttribute("users");
		if(user != null){
			List<History> history = (ArrayList < History> )request.getSession().getAttribute("History");
			System.out.println(history);
			map.put("history",history);
		}
//		====
//		轮播图
		List lunbotu = goodsTypeService.findLun();

//		随机取出五个商品====
		List<Goods> find5Goods = this.goodsTypeService.find5Goods();

		map.put("yi", goodsTypeList);
		map.put("san", floorList);
		map.put("si", goodsList);
		map.put("youlike",find5Goods);
		map.put("wu", floorImages);
		map.put("liu", goodsList1);
		map.put("lunbotu",lunbotu);//轮播图

		FastJson_All.toJson(map, response);
	}


	// ============================================================无限级查询的方法
	public List<GoodsType> find1(GoodsType good1 , Integer aId){
		List<GoodsType> goods =goodsTypeService.findfenlei(aId);
		for (GoodsType good : goods) {
			good.setGoodsTypes(find1(good1, good.getaId()));
		}
		return goods;
	}

	// =============================================================猜你喜欢


}
