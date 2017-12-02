package com.lanou.controller;

import com.lanou.entity.GoodsType;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class GoodsTypeController {
	@Autowired
	private GoodsTypeService goodsTypeService;

	@RequestMapping("/index")
	public String finds(Model model) {
		List<GoodsType> goodsTypeList = goodsTypeService.findGoodsType();
		model.addAttribute("teachers",goodsTypeList);
		return "index";
	}
	
}
