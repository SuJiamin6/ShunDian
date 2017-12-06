package com.lanou.service;

import com.lanou.entity.*;

import java.util.List;

public interface GoodsTypeService {

	public List<GoodsType> find9Goods3Type();
	public List<GoodsType> findGoods1Type();
	public List<Floor> findFloor();
	public List<Goods> find8Goods();
	public List<GoodsType> findGoodsType(int aId);

	//对应楼层的id找到集合FloorImage
	public List<FloorImage> findFloorImage(int id);

	//商品详情页
	//第一部分
	public List<Goods> findGoodsById(int id);
	//第二部分
	public List<GoodsImage> findGoodsImage(int id);
	//第三部分
	public List<Goods> findGoodsByAll_id(int All_id);
	//第四部分
	public List<GoodsImage> findGoodsImage1(int id);

	//	无限级查询
	public List<GoodsType> find1(Goods good1 ,Integer aId);
	//查询aId
	public List<GoodsType> findfenlei(Integer aId);



}
