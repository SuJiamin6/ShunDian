package com.lanou.service.impl;

import com.lanou.dao.CollectionMapper;
import com.lanou.dao.DiZhiMapper;
import com.lanou.entity.DiZhi;
import com.lanou.entity.Goods;
import com.lanou.entity.User;
import com.lanou.service.CollectionService;
import com.lanou.service.DiZhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
@Service("collectionService")
public class CollectionServiceImpl implements CollectionService{
    @Autowired
    private CollectionMapper collectionMapper;

    public List<Goods> findCollection(Integer user_id){
        return collectionMapper.findCollection(user_id);
    }

    public  Integer  finduser_id(Integer user_id,Integer goods_id){
        return collectionMapper.finduser_id(user_id,goods_id);
    }
    public boolean addCollGoods(Integer user_id,Integer goods_id){
        return collectionMapper.addCollGoods(user_id,goods_id);
    }
    public  boolean deleteCollection(Integer user_id,Integer goods_id){
        return collectionMapper.deleteCollection(user_id,goods_id);
    }
}
