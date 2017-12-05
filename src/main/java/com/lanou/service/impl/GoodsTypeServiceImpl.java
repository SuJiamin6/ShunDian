package com.lanou.service.impl;

import com.lanou.dao.GoodsTypeMapper;
import com.lanou.entity.*;
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

	//对应楼层的实现方法
	public List<FloorImage> findFloorImage(int id) {
		return goodsTypeMapper.findFloorImage(id);
	}

	//商品详情页

//	public List<Goods> findGoodsById(int id) {
//		return goodsTypeMapper.findGoodsById(id);
//	}

	public List<GoodsType> find1(Goods good1 ,Integer aId){
		return goodsTypeMapper.find1(good1,aId);
	}
	//查询aId
	public List<GoodsType> findfenlei(Integer aId){
		return  goodsTypeMapper.findfenlei(aId);
	}



	public int  Judge(int all_id){
		return  goodsTypeMapper.Judge(all_id);
	}
	public List<Lefts> finder(){
		return  goodsTypeMapper.finder();
	}
	public List<GoodsType> finder1(Integer all_id){
		return goodsTypeMapper.finder1(all_id);
	}
	public List<Lefts> findsan(){
		return  goodsTypeMapper.findsan();
	}
	public List<GoodsType> findsan1(Integer all_id){
		return  goodsTypeMapper.findsan1(all_id);
	}



	public List<All_Left> findleft1(Integer all_id){
		return goodsTypeMapper.findleft1(all_id);
	}
	public List<Lefts> findleft2(Integer leftId){
		return goodsTypeMapper.findleft2(leftId);
	}
	public List<Rights> findright(Integer leftId){
		return goodsTypeMapper.findright(leftId);
	}
	public List<Goods> findGoodss(Integer all_id){
		return goodsTypeMapper.findGoodss(all_id);
	}



}
