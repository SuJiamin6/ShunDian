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

	public List<GoodsType> findGoodsType(int aId) {
		return goodsTypeMapper.findGoodsType(aId);
	}

	//对应楼层的实现方法
	public List<FloorImage> findFloorImage() {
		return goodsTypeMapper.findFloorImage();
	}

	//商品详情页

	public List<Goods> findGoodsById(int id) {
		return goodsTypeMapper.findGoodsById(id);
	}

	public List<GoodsImage> findGoodsImage(int id) {
		return goodsTypeMapper.findGoodsImage(id);
	}

	public List<Goods> findGoodsByAll_id(int All_id) {
		return goodsTypeMapper.findGoodsByAll_id(All_id);
	}

	public List<GoodsImage> findGoodsImage1(int id) {
		return goodsTypeMapper.findGoodsImage1(id);
	}

	public List<GoodsType> find1(Goods good1 , Integer aId){
		return goodsTypeMapper.find1(good1,aId);
	}

	public List<Comments> findComments(int gId) {
		return goodsTypeMapper.findComments(gId);
	}

	public List<User_Info> findUser_Info(int uId) {
		return goodsTypeMapper.findUser_Info(uId);
	}

	//地址三级联动模块
	public DiZhi_Info findDiZhicityid(int cityid) {
		return goodsTypeMapper.findDiZhicityid(cityid);
	}

	public List<DiZhi_Info> selectDiZhiChildrenByParentId(int cityid) {
		return goodsTypeMapper.selectDiZhiChildrenByParentId(cityid);
	}

	//查询aId
	public List<GoodsType> findfenlei(Integer aId){
		return  goodsTypeMapper.findfenlei(aId);
	}







}
