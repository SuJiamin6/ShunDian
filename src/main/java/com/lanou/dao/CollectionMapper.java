package com.lanou.dao;

import com.lanou.entity.DiZhi;
import com.lanou.entity.Goods;

import java.util.List;

public interface CollectionMapper {

	public List<Goods> findCollection(Integer user_id);
	public  Integer finduser_id(Integer goods_id,Integer user_id);
	public  boolean addCollGoods(Integer goods_id,Integer user_id);
	public  boolean deleteCollection(Integer goods_id,Integer user_id);
}
