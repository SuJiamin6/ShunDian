package com.lanou.dao;

import com.lanou.entity.*;

import java.util.List;

public interface GalleryMapper {

    //	==========================================
//	 判断是几级标题
    public int  Judge(int all_id);
    //	 查询一级标题获得信息
    public  List<GoodsType> AllYiJi(Integer id);
    public List finder();
    public List<GoodsType> finder1(Integer all_id);
    public List<GoodsType> finder2(Integer all_id);
    //	 查询二级标题获得信息
    public  List<GoodsType> AllErJi(Integer id,Integer pid);
    public List findsan();
    public List findsan1(Integer all_id);
    //	查询三级标题获得信息
    public List<GoodsType> AllSanJi(Integer pid,Integer id);
    public List findFenLeiBiao (Integer a ,Integer b);
    public List<All_Left> findleft1(Integer all_id);
    public List<Lefts> findleft2(Integer leftId);
    public List<Rights> findright(Integer leftId);
    public List<Gallery1> findGoodss(Integer all_id);


//    获取小图片
    public List<GoodSmallImage> SmallImage(Integer gs_id);


    //商品分类
    public List<GoodsType> chazhao1(Integer all_id);
    public int chazhao2(Integer all_id);
    public List<GoodsType> chazhao3(Integer pid,Integer id);
    public List<GoodsType> chazhao4(Integer ppid,Integer pid,Integer id);

    //	价格区间
    public List rightPrice();
    public List<Gallery1> findByPrice(Integer firstPrice , Integer secondPrice);
//    综合分类*（随机）
    public  List<Gallery1> ByZonHe();
//    价格排序
    public  List<Gallery1> ByJiaGeJiang();
    //    价格排序
    public  List<Gallery1> ByJiaGeSheng();
    //    销量查询
    public  List<Gallery1> ByXiaoLiang();
    //    新品查询
    public  List<Gallery1> ByXinPin();
}
