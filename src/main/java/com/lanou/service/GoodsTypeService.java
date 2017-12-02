package com.lanou.service;

import com.lanou.entity.Floor;
import com.lanou.entity.Goods;
import com.lanou.entity.GoodsType;

import java.util.List;

public interface GoodsTypeService {

	public List<GoodsType> find9Goods3Type();
	public List<GoodsType> findGoods1Type();
	public List<Floor> findFloor();
	public List<Goods> find8Goods();
}
