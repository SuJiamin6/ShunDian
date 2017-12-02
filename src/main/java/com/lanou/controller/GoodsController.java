package com.lanou.controller;

import com.lanou.entity.Good_small;
import com.lanou.entity.Goods;
import com.lanou.entity.GoodsType;
import com.lanou.service.GoodsService;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/index")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/find.do")
	public String finds(Model model) {
		List<Goods> goodsList = goodsService.find9Goods();
		List<Good_small> good_smalls = new ArrayList<Good_small>();
		for(int i=0;i<goodsList.size();i++){

			Good_small good_small = new Good_small();
			good_small.setgId(goodsList.get(i).getgId());
			good_small.setgName(goodsList.get(i).getgName());
			good_smalls.add(good_small);

		}
		model.addAttribute("teachers",good_smalls);
		return "index";
	}
	
}
