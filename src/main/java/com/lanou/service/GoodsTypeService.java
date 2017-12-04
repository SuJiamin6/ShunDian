package com.lanou.service;

import com.lanou.entity.Floor;
import com.lanou.entity.FloorImage;
import com.lanou.entity.Goods;
import com.lanou.entity.GoodsType;

import java.util.List;

public interface GoodsTypeService {

	public List<GoodsType> find9Goods3Type();
	public List<GoodsType> findGoods1Type();
	public List<Floor> findFloor();
	public List<Goods> find8Goods();

	//对应楼层的id找到集合FloorImage
	public List<FloorImage> findFloorImage(int id);

}
