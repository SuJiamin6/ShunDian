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
	public List<Comments> findComments(int gId);
	public List<User_Info> findUser_Info(int uId);
	//三级联动模块
	public DiZhi_Info findDiZhicityid(int cityid);
	public List<DiZhi_Info> selectDiZhiChildrenByParentId(int cityid);

//	==========================================
//	无限极查询
	public List<GoodsType> find1(Goods good1 ,Integer aId);
//查询aId
	public List<GoodsType> findfenlei(Integer aId);
//	==========================================
}
