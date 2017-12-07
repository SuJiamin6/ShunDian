package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.*;
import com.lanou.service.GalleryService;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/")
public class GalleryController {
    @Autowired
    private GalleryService galleryService;

    // ==============================================================
    // gallery
    @RequestMapping("/gallery")
    //@ResponseBody
    public void findss(Integer id, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        int leftId = 0;
        //请求商品分类页部分数据
        String leftName = null;
        String rightName = null;
        int type = galleryService.Judge(id);
        List price = galleryService.rightPrice();
        if (type == 1) {
            //     找一级标题
            List<GoodsType> OneName = galleryService.chazhao1(id);
            // ==============================================
            List<GoodsType> allYiJi = galleryService.AllYiJi(id);
            List finder = galleryService.finder();
            List finder1 = galleryService.finder1(id);
            OneName.get(0).setGoodsTypes(allYiJi);
            List<Gallery1> findgoodss = galleryService.findGoodss(6);
            for (int i = 0; i < finder.size(); i++) {
                List findleftandright = new ArrayList();
                if (i == 0) {
                    for (int j = 0; j < finder1.size(); j++) {
                        rightName = (String) finder1.get(j);
                        findleftandright.add(rightName);
                    }
                }
                if (i == 1) {
                    for (int j = 0; j < galleryService.findright(21).size(); j++) {
                        rightName = galleryService.findright(21).get(j).getRight_name();
                        findleftandright.add(rightName);
                    }
                }
                map.put("One" + i, findleftandright);

            }
            map.put("OneBiao", OneName);
            map.put("goods", findgoodss);
            map.put("price", price);
        }
        if (type == 2) {
            //找二级标题以及它的一级标题
//            上一级的aId

            int pid = galleryService.chazhao2(id);
            List<GoodsType> AllYiJi = galleryService.AllYiJi(pid);
            List<GoodsType> AllErJi = galleryService.AllErJi(pid, id);
            List<GoodsType> names = galleryService.chazhao3(pid, id);
             List<GoodsType> list = new ArrayList<GoodsType>();
               names.get(0).setGoodsTypes(AllYiJi);
               names.get(1).setGoodsTypes(AllErJi);
            // ==============================================
            List findsan = galleryService.findsan();

            List findAllErJi = galleryService.findsan1(pid);

            List<Gallery1> findgoodss = galleryService.findGoodss(6);
            for (int i = 0; i < findsan.size(); i++) {
                List findleftandright = new ArrayList();
                if (i == 0) {
                    for (int j = 0; j < findsan.size(); j++) {
                        rightName = (String) findsan.get(j);
                        findleftandright.add(rightName);
                    }
                }
                if (i == 1) {
                    for (int j = 0; j < galleryService.findright(21).size(); j++) {
                        rightName = galleryService.findright(21).get(j).getRight_name();
                        findleftandright.add(rightName);
                    }
                }
                map.put("One" + i, findleftandright);
            }
            map.put("OneBiao", names);
            map.put("goods", findgoodss);
            map.put("price", price);

        }
        if (type == 3) {
            //找三级标题以及它的一，二级标题
            //            上一级的aId
            int pid = galleryService.chazhao2(id);
            //            上上一级的aId
            int ppid = galleryService.chazhao2(pid);
            List<GoodsType> AllYiJi = galleryService.AllYiJi(ppid);
            List<GoodsType> AllErJi = galleryService.AllErJi(ppid, pid);
            List<GoodsType> AllSanJi = galleryService.AllSanJi(pid, id);
            List<GoodsType> namess = galleryService.chazhao4(ppid, pid, id);
            namess.get(0).setGoodsTypes(AllYiJi);
            namess.get(1).setGoodsTypes(AllErJi);
            namess.get(2).setGoodsTypes(AllSanJi);
            // ==============================================
            List<Gallery1> findgoodss = galleryService.findGoodss(id);
//            for (int i = 0; i < findAllLeft.size(); i++) {
//                leftId = findAllLeft.get(i).getLeft_id();
//                for (int j = 0; j < galleryService.findright(leftId).size(); j++) {
//                    rightName = galleryService.findright(leftId).get(j).getRight_name();
//                    findleftandright.add(rightName);
//                    System.out.println(rightName);
//
//                }
//            }

            int a = (int) Math.random() + 5;
            int b = (int) Math.random() + 5;
            List random = galleryService.findFenLeiBiao(a, b);
            for (int i = 0; i < 2; i++) {
                List findleftandright = new ArrayList();
                if (i == 0) {
                    for (int j = 0; j < random.size(); j++) {
                        rightName = (String) random.get(j);
                        findleftandright.add(rightName);
                    }
                }
                if (i == 1) {
                    for (int j = 0; j < galleryService.findright(2).size(); j++) {
                        rightName = galleryService.findright(2).get(j).getRight_name();
                        findleftandright.add(rightName);
                    }
                }
                map.put("One" + i, findleftandright);

            }
            map.put("OneBiao", namess);
            map.put("goods", findgoodss);
            map.put("price", price);

        }
        FastJson_All.toJson(map,response);
        //return map;
    }

        //    ==============================================================
//    查找价格区间
        @RequestMapping("/price")
       // @ResponseBody
        public void findPrice (Integer firstPrice, Integer secondPrice,HttpServletResponse response){
            Map<String, Object> map = new HashMap<String, Object>();
            List<Goods> findByPrice = galleryService.findByPrice(firstPrice, secondPrice);
            map.put("ByPrice", findByPrice);

            FastJson_All.toJson(map,response);
            //return map;

    }
        // ==============================================================
}

