package com.lanou.service;

import com.lanou.entity.*;

import java.util.List;

public interface GoodsTypeService {

	public List<GoodsType> find9Goods3Type();
	public List<GoodsType> findGoods1Type();
	public List<Floor> findFloor();
	public List<Goods> find8Goods();

	//对应楼层的id找到集合FloorImage
	public List<FloorImage> findFloorImage(int id);

	//商品详情页
//	public List<Goods> findGoodsById(int id);

//	无限级查询
public List<GoodsType> find1(Goods good1 ,Integer aId);
//查询aId
public List<GoodsType> findfenlei(Integer aId);

    //判断
	public int  Judge(int all_id);
	//	 查询一级标题获得信息
	public List<Lefts> finder();
	public List<GoodsType> finder1(Integer all_id);
	//	查询二级标题
	public List<Lefts> findsan();
	public List<GoodsType> findsan1(Integer all_id);
    //查询三级标题
	public List<All_Left> findleft1(Integer all_id);
	public List<Lefts> findleft2(Integer leftId);
	public List<Rights> findright(Integer leftId);
	public List<Goods> findGoodss(Integer all_id);


}
