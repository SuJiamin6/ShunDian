package com.lanou.controller;

import com.lanou.entity.All_Left;
import com.lanou.entity.Goods;
import com.lanou.entity.GoodsType;
import com.lanou.entity.Lefts;
import com.lanou.service.GalleryService;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2017/12/6.
 */
@Controller
@RequestMapping("/")
public class GalleryController {
    @Autowired
    private GalleryService galleryService;
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
        int type = galleryService.Judge(id);
        if (type == 1){
            //     找一级标题
            String OneName = galleryService.chazhao1(id);
            // ==============================================
            List<Lefts> finder = galleryService.finder();
            List<GoodsType> finder1 = galleryService.finder1(id);
            List<Goods> findgoodss = galleryService.findGoodss(6);
            for(int i=0;i<finder.size();i++){
                List findleftandright = new ArrayList();
                leftName = finder.get(i).getLeftName();
                findleftandright.add(leftName);
                if (i==0){
                    for (int j=0;j<finder1.size();j++){
                        rightName = finder1.get(j).getaName();
                        findleftandright.add(rightName);
                    }
                }
                if(i==1){
                    for (int j=0;j<galleryService.findright(21).size();j++){
                        rightName = galleryService.findright(21).get(j).getRight_name();
                        findleftandright.add(rightName);
                    }
                }
                map.put("一级"+i,findleftandright);

            }
            map.put("一级",OneName);
            map.put("goods", findgoodss);
        }
        if (type == 2){
            //找二级标题以及它的一级标题
            int  pid = galleryService.chazhao2(id);
            System.out.println(pid);
            List<GoodsType> names = galleryService.chazhao3(pid,id);
            System.out.println(names);
            // ==============================================
            List<Lefts>  findsan = galleryService.findsan();
            List<GoodsType> findsan1 = galleryService.findsan1(id);

            List<Goods> findgoodss = galleryService.findGoodss(6);
            for(int i=0;i<findsan.size();i++){
                List findleftandright = new ArrayList();
                leftName = findsan.get(i).getLeftName();
                System.out.println(findleftandright);
                if (i==0){
                    for (int j=0;j<findsan1.size();j++){
                        rightName = findsan1.get(j).getaName();
                        findleftandright.add(rightName);
                    }
                }
                if(i==1){
                    for (int j=0;j<galleryService.findright(21).size();j++){
                        rightName = galleryService.findright(21).get(j).getRight_name();
                        findleftandright.add(rightName);
                    }
                }
                map.put("二级"+i,findleftandright);
            }
            map.put("二级+一级",names);
            map.put("goods", findgoodss);
        }
        if (type == 3){
            //找三级标题以及它的一，二级标题
            int  pid = galleryService.chazhao2(id);
            int  ppid = galleryService.chazhao2(pid);
            List<GoodsType> namess = galleryService.chazhao4(ppid,pid,id);
            // ==============================================
            List<All_Left> findAllLeft = galleryService.findleft1(id);
            List findleftandright = new ArrayList();
            List<Goods> findgoodss =galleryService.findGoodss(id);
            for (int i = 0; i < findAllLeft.size(); i++) {

                leftId = findAllLeft.get(i).getLeft_id();
                leftName = galleryService.findleft2(leftId).get(0).getLeftName();
                System.out.println(leftName);
                findleftandright.add(leftName);
                for (int j = 0; j < galleryService.findright(leftId).size(); j++) {
                    rightName = galleryService.findright(leftId).get(j).getRight_name();
                    findleftandright.add(rightName);
                    System.out.println(rightName);

                }
            }
            map.put("leftandright",findleftandright);
            map.put("三级+二级+一级",namess);
            map.put("goods", findgoodss);
        }
        return map;
    }

    //    ==============================================================
//    查找价格区间
    @RequestMapping("/price")
    @ResponseBody
    public Map<String, Object> findPrice(Integer firstPrice , Integer secondPrice) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Goods> findByPrice = galleryService.findByPrice(firstPrice, secondPrice);
        map.put("ByPrice", findByPrice);
        return  map;

    }
    // ==============================================================
}
