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

	public List<Goods> find5Goods(){
		return  goodsTypeMapper.find5Goods();
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

	public List<Comments> findComments(int gId) {
		return goodsTypeMapper.findComments(gId);
	}

	public List<User_Info> findUser_Info(int uId) {
		return goodsTypeMapper.findUser_Info(uId);
	}
	//	添加历史记录
	public boolean  insert1(String userName,String goodsName,String goodsImage,Double goodsPrice){
		return  goodsTypeMapper.insert1(userName,goodsName,goodsImage,goodsPrice);
	}
//	调出历史记录
      public List<History> findHistory(String userName){
		return  goodsTypeMapper.findHistory(userName);
	  }
//    判断有无
	  public int findNull(String goodsName){
      	return  goodsTypeMapper.findNull(goodsName);
	  }

	//地址三级联动模块
	public DiZhi_Info findDiZhicityid(int cityid) {
		return goodsTypeMapper.findDiZhicityid(cityid);
	}

	public List<DiZhi_Info> selectDiZhiChildrenByParentId(int cityid) {
		return goodsTypeMapper.selectDiZhiChildrenByParentId(cityid);
	}


	public List<GoodsType> find1(Goods good1 ,Integer aId){
		return goodsTypeMapper.find1(good1,aId);
	}
	//查询aId
	public List<GoodsType> findfenlei(Integer aId){
		return  goodsTypeMapper.findfenlei(aId);
	}

	//	=====
	public List findLun(){
		return  goodsTypeMapper.findLun();
	}
	//	找到三张图
	public List findIndexSan(Integer aId){
		return  goodsTypeMapper.findIndexSan(aId);
	}


	//购物车模块
	public void updateShopCar1(int cout,Double sum,int goods_id){
		goodsTypeMapper.updateShopCar1(cout,sum,goods_id);
	}

	public ShopCar findShopCargoods_id(Integer goods_id) {
		return goodsTypeMapper.findShopCargoods_id(goods_id);
	}

	//添加商品
	public void updateShopCar(int gId, String gName, Double price, int count, Double sum,String goods_url) {
		goodsTypeMapper.updateShopCar(gId,gName,price,count,sum,goods_url);
	}

	//删除商品
	public void deleteShopCar(int id) {
		goodsTypeMapper.deleteShopCar(id);
	}

	//点击侧边栏模块
	public List<ShopCar> findShopCar(){

		return goodsTypeMapper.findShopCar();
	}

	//添加订单模块

	public void addOrders(String order_address, String order_goodsName, double order_price, int order_count, int user_id) {
		goodsTypeMapper.addOrders(order_address,order_goodsName,order_price,order_count,user_id);
	}

	public List<Orders> findOrders(int user_id) {
		return goodsTypeMapper.findOrders(user_id);
	}

	public void deleteShopCarAll(){
		goodsTypeMapper.deleteShopCarAll();
	}

	//订单管理模块

	public List<Orders> findAllOrders() {
		return goodsTypeMapper.findAllOrders();
	}
}
