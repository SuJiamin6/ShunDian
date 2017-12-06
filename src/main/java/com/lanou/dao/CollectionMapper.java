package com.lanou.dao;

import com.lanou.entity.Goods;
import com.lanou.entity.User;

import java.util.List;

/**
 * Created by lanou on 2017/12/6.
 */
public interface CollectionMapper {
    public List<Goods> findCollection(Integer user_id);
    public  Integer  finduser_id(Integer user_id,Integer goods_id);
    public boolean addCollGoods(Integer user_id,Integer goods_id);
}
