package com.lanou.dao;

import com.lanou.entity.*;

import java.util.List;

/**
 * Created by lanou on 2017/12/6.
 */
public interface GalleryMapper {

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


    //商品分类
    public String chazhao1(Integer all_id);
    public int chazhao2(Integer all_id);
    public List<GoodsType> chazhao3(Integer pid,Integer id);
    public List<GoodsType> chazhao4(Integer ppid,Integer pid,Integer id);

    //	价格区间
    public List<Goods> findByPrice(Integer firstPrice , Integer secondPrice);
}
