package com.lanou.service.impl;

import com.lanou.dao.GoodsMapper;
import com.lanou.dao.GoodsTypeMapper;
import com.lanou.entity.Goods;
import com.lanou.entity.GoodsType;
import com.lanou.service.GoodsService;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsMapper goodsMapper;

	public List<Goods> find9Goods() {
		return goodsMapper.find9Goods();
	}
}
