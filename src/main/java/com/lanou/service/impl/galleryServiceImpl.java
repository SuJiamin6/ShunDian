package com.lanou.service.impl;

import com.lanou.dao.GalleryMapper;
import com.lanou.dao.GoodsTypeMapper;
import com.lanou.entity.*;
import com.lanou.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("galleryService")
public class galleryServiceImpl implements GalleryService{
    @Autowired
    private GalleryMapper   galleryMapper;
    public int  Judge(int all_id){
        return  galleryMapper.Judge(all_id);
    }
    public List<Lefts> finder(){
        return  galleryMapper.finder();
    }
    public List<GoodsType> finder1(Integer all_id){
        return galleryMapper.finder1(all_id);
    }
    public List<Lefts> findsan(){
        return  galleryMapper.findsan();
    }
    public List<GoodsType> findsan1(Integer all_id){
        return  galleryMapper.findsan1(all_id);
    }



    public List<All_Left> findleft1(Integer all_id){
        return galleryMapper.findleft1(all_id);
    }
    public List<Lefts> findleft2(Integer leftId){
        return galleryMapper.findleft2(leftId);
    }
    public List<Rights> findright(Integer leftId){
        return galleryMapper.findright(leftId);
    }
    public List<Goods> findGoodss(Integer all_id){
        return galleryMapper.findGoodss(all_id);
    }


    //商品分类
    public String chazhao1(Integer all_id){
        return  galleryMapper.chazhao1(all_id);
    }

    public int chazhao2(Integer all_id){
        return  galleryMapper.chazhao2(all_id);
    }

    public List<GoodsType> chazhao3(Integer pid , Integer id){
        return galleryMapper.chazhao3(pid,id);
    }

    public List<GoodsType> chazhao4(Integer pid,Integer ppid,Integer id){
        return galleryMapper.chazhao4(ppid, pid, id);
    }

    //	价格区间
    public List<Goods> findByPrice(Integer firstPrice , Integer secondPrice){
        return  galleryMapper.findByPrice(firstPrice , secondPrice);
    }

}
