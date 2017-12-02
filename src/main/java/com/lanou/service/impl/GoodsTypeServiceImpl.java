package com.lanou.service.impl;

import com.lanou.dao.GoodsTypeMapper;
import com.lanou.entity.Floor;
import com.lanou.entity.Goods;
import com.lanou.entity.GoodsType;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsTypeService")
public class GoodsTypeServiceImpl implements GoodsTypeService{

	@Autowired
	private GoodsTypeMapper goodsTypeMapper;

	public List<GoodsType> find9Goods3Type() {
		return goodsTypeMapper.find9Goods3Type();
	}

	public List<GoodsType> findGoods1Type() {
		return goodsTypeMapper.findGoods1Type();
	}

	public List<Floor> findFloor() {
		return goodsTypeMapper.findFloor();
	}

	public List<Goods> find8Goods() {
		return goodsTypeMapper.find8Goods();
	}
}
