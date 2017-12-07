package com.lanou.dao;

import com.lanou.entity.*;

import java.util.List;

public interface GoodsTypeMapper {
	public List<GoodsType> find9Goods3Type();
	public List<GoodsType> findGoods1Type();
	public List<Floor> findFloor();
	public List<Goods> find8Goods();
	public List<GoodsType> findGoodsType(int aId);

	//楼层数据
	public List<FloorImage> findFloorImage();

	//商品详情页
	public List<Goods> findGoodsById(int id);
	public List<GoodsImage> findGoodsImage(int id);
	public List<Goods> findGoodsByAll_id(int All_id);
	public List<GoodsImage> findGoodsImage1(int id);
	public List<Comments> findComments(int gId);
	public List<User_Info> findUser_Info(int uId);
	//三级联动模块
	public DiZhi_Info findDiZhicityid(int cityid);
	public List<DiZhi_Info> selectDiZhiChildrenByParentId(int cityid);

	//	==========================================
	// 无限极查询
	public List<GoodsType> find1(Goods good1 ,Integer aId);
	//查询aId
	public List<GoodsType> findfenlei(Integer aId);
	//	==========================================
	//找到轮播图
	public List findLun();
	//	找到三张图
	public List findIndexSan(Integer aId);


	//购物车模块
	//跟新功能
	public void updateShopCar1(int cout,Double sum,int Goods_id);

	public ShopCar findShopCargoods_id(Integer goods_id);

	//添加功能
	public void updateShopCar(Integer gId,String gName,Double price,Integer count,Double sum);
	//删除功能
	public void deleteShopCar(int id);

	//点击购物车侧边栏
	public List<ShopCar> findShopCar();

}
