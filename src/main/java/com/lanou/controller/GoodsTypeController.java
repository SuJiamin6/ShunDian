package com.lanou.controller;

import com.lanou.dao.GoodsTypeMapper;
import com.lanou.entity.*;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Controller
@RequestMapping("/")
public class GoodsTypeController {
	@Autowired
	private GoodsTypeService goodsTypeService;

	@RequestMapping("/index")
	@ResponseBody
	public Map<String,Object> finds(){

		Map<String,Object> map = new HashMap<String,Object>();

		//请求首页部分数据
		List<GoodsType> goodsTypeList = goodsTypeService.find9Goods3Type();
		List<GoodsType> goodsTypeList1 = goodsTypeService.findGoods1Type();
		List<Floor> floorList = goodsTypeService.findFloor();
		List<Goods> goodsList = goodsTypeService.find8Goods();

		//map传出
        map.put("yi", goodsTypeList);//发现随机的九个三级标签
        map.put("er", goodsTypeList1);//所有的一级标签
        map.put("san", floorList);//各个楼层的文字
        map.put("si", goodsList);//推介楼层中的八个商品
        //map.put("wu",goods1);//根据你传入的aId来找出下面的二三级标题

		return map;
	}

	// ============================================================无限级查询的方法
    @RequestMapping("/index1")
    @ResponseBody
	 public List<GoodsType> find1(GoodsType good1 , Integer aId){
        List<GoodsType> goods =goodsTypeService.findfenlei(aId);
        for (GoodsType good : goods) {
           good.setGoodsTypes(find1(good1, good.getaId()));
        }
        System.out.println(goods);
        return goods;
    }
    // ==============================================================
    // gallery
     @RequestMapping("/gallery")
    @ResponseBody
    public Map<String, Object> findss(Integer id) {

        Map<String, Object> map = new HashMap<String, Object>();
        int leftId = 0;
        //请求商品分类页部分数据
        String leftName = null;
        String rightName = null;
        int type = goodsTypeService.Judge(id);
        System.out.println(type);
        if (type == 1){
            List<Lefts>  finder = goodsTypeService.finder();
            List<GoodsType> finder1 = goodsTypeService.finder1(id);
            List findleftandright1 = new ArrayList();
            List<Goods> findgoodss = goodsTypeService.findGoodss(6);
            for(int i=0;i<finder.size();i++){
                leftName = finder.get(i).getLeftName();
                findleftandright1.add(leftName);
                System.out.println(findleftandright1);
                if (i==0){
                    for (int j=0;j<finder1.size();j++){
                        rightName = finder1.get(j).getaName();
                        findleftandright1.add(rightName);
                        System.out.println("sdasadasdasd"+findleftandright1);
                    }
                }
                if(i==1){
                    for (int j=0;j<goodsTypeService.findright(2).size();j++){
                        rightName = goodsTypeService.findright(2).get(j).getRight_name();
                        findleftandright1.add(rightName);
                    }
                }

            }
            map.put("leftandright",findleftandright1);
            map.put("goods", findgoodss);
        }
        if (type == 2){
            List<Lefts>  findsan = goodsTypeService.findsan();
            List<GoodsType> findsan1 = goodsTypeService.findsan1(id);
            List findleftandright2 = new ArrayList();
            List<Goods> findgoodss = goodsTypeService.findGoodss(6);
             for(int i=0;i<findsan.size();i++){
                 leftName = findsan.get(i).getLeftName();
                 findleftandright2.add(leftName);
                 System.out.println(findleftandright2);
                 if (i==0){
                     for (int j=0;j<findsan1.size();j++){
                         rightName = findsan1.get(j).getaName();
                         findleftandright2.add(rightName);
                         System.out.println("sdasadasdasd"+findleftandright2);
                     }
                 }
                 if(i==1){
                     for (int j=0;j<goodsTypeService.findright(2).size();j++){
                         rightName = goodsTypeService.findright(2).get(j).getRight_name();
                         findleftandright2.add(rightName);
                     }
                 }

             }
            map.put("leftandright",findleftandright2);
            map.put("goods", findgoodss);
        }
        if (type == 3){
            List<All_Left> findAllLeft = goodsTypeService.findleft1(id);
            List findleftandright = new ArrayList();
            List<Goods> findgoodss = goodsTypeService.findGoodss(id);
            for (int i = 0; i < findAllLeft.size(); i++) {

                leftId = findAllLeft.get(i).getLeft_id();
                leftName = goodsTypeService.findleft2(leftId).get(0).getLeftName();
                System.out.println(leftName);
                findleftandright.add(leftName);
                for (int j = 0; j < goodsTypeService.findright(leftId).size(); j++) {
                    rightName = goodsTypeService.findright(leftId).get(j).getRight_name();
                    findleftandright.add(rightName);
                    System.out.println(rightName);

                }
            }
            map.put("leftandright",findleftandright);
            map.put("goods", findgoodss);
        }

        return map;
    }

    // ==============================================================

	@RequestMapping("/indexFloor")
	@ResponseBody
	//这里接收对应楼层的id
	public Map<String,Object> finds(int id){

		//根据id请求对应楼层的ajax
		List<FloorImage> floorImages = new ArrayList<FloorImage>();
		List<Goods> goodsList = new ArrayList<Goods>();
		Map<String,Object> map = new HashMap<String,Object>();

		if(id>=2&&id<=5){

			floorImages = goodsTypeService.findFloorImage(id);
			map.put("data",floorImages);

		} else if(id==6){
			goodsList = goodsTypeService.find8Goods();
			map.put("data",goodsList);
		}

		return map;

	}

	@RequestMapping("/product")
	@ResponseBody
	//请求点击商品跳转到商品详情页，需要接收商品的id
	public Map<String,Object> findsId(int id){

		//根据id请求找到对应的商品
		List<FloorImage> floorImages = new ArrayList<FloorImage>();
		List<Goods> goodsList = new ArrayList<Goods>();

		Map<String,Object> map = new HashMap<String,Object>();

		//第一部分是商品的主要信息，在Goods表中
//		goodsList = goodsTypeService.findGoodsById(id);
//		//第二部分是商品的多个图片

		map.put("main",goodsList.get(0));
		return map;

	}



//	//无限级查询
//	@RequestMapping("/select")
//	@ResponseBody
//	//通过查找当前传送过来的Id，查找对应的信息
//	public Map<String,Object> selectGoodsTypeAndChildren(Integer aId){
//		//定义一个map容器
//		Map<String,Object> map = new HashMap<String,Object>();
//		//先查找到对应Id的所有信息
//		GoodsType goodsType = goodsTypeService.selectByPrimaryKey(aId);
//		//如果当前查找的Id不存在，则返回一个值为空
//		if(goodsType == null){
//			return null;
//		}
//		//否则表示已经查找到当前id的信息，然后执行findChildGoodsType方法
//		//将goodsType和主键id作为形参传送过去
//		goodsType.setGoodsTypes(findChildGoodsType(goodsType,aId));
//		map.put("data",goodsType);
//		return map;
//	}
//
//	//私有方法，接收goodsType和主键id
//	private List<GoodsType> findChildGoodsType(GoodsType goodsTypeRes,Integer aId){
//		//通过主键的id，查找表中所有parent_id和Id匹配的，放入一个goodsTypeList集合中
//		List<GoodsType> goodsTypeList = goodsTypeService.selectGoodsTypeChildrenByParentId(aId);
//		//对这个集合进行遍历
//		for (GoodsType goodsTypeItem:goodsTypeList ) {
//			//这里运用到循环嵌套调用
//			//如果当前商品，根据他的主键还能查找到parent_id与之对应的话，就嵌套调用
//			//如果已经查找不到parent_id等于主键的时候，就说明集合中的参数为空，就不会再执行了
//			//最终在当前集合的goodsType中放入当前属于他子集的所有参数，完成无限极查询的功能
//			goodsTypeItem.setGoodsTypes(findChildGoodsType(goodsTypeRes,goodsTypeItem.getaId()));
//		}
//		return goodsTypeList;
//	}

}
