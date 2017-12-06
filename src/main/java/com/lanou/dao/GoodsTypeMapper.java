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
	public List<FloorImage> findFloorImage(int id);

	//商品详情页
	public List<Goods> findGoodsById(int id);
	public List<GoodsImage> findGoodsImage(int id);
	public List<Goods> findGoodsByAll_id(int All_id);
	public List<GoodsImage> findGoodsImage1(int id);

//	==========================================
//	无限极查询
	public List<GoodsType> find1(Goods good1 ,Integer aId);
//查询aId
	public List<GoodsType> findfenlei(Integer aId);
//	==========================================
//	 判断是几级标题
	 public int  Judge(int all_id);
//	 查询一级标题获得信息
    public List<Lefts> finder();
	public List<GoodsType> finder1(Integer all_id);
//	 查询二级标题获得信息
	public List<Lefts> findsan();
	public List<GoodsType> findsan1(Integer all_id);
//	查询三级标题获得信息
	public List<All_Left> findleft1(Integer all_id);
	public List<Lefts> findleft2(Integer leftId);
	public List<Rights> findright(Integer leftId);
	public List<Goods> findGoodss(Integer all_id);


}
