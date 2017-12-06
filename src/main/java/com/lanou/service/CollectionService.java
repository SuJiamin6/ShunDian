package com.lanou.service;

import com.lanou.entity.Goods;
import com.lanou.entity.User;

import java.util.List;

public interface CollectionService {

	public List<Goods> findCollection(Integer user_id);
	public  Integer  finduser_id(Integer user_id,Integer goods_id);
	public boolean addCollGoods(Integer user_id,Integer goods_id);
	public  boolean deleteCollection(Integer user_id,Integer goods_id);
}
