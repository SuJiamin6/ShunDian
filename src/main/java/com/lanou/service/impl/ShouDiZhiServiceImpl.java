package com.lanou.service.impl;

import com.lanou.dao.DiZhiMapper;
import com.lanou.dao.ShouDiZhiMapper;
import com.lanou.entity.DiZhi;
import com.lanou.entity.ShouDiZhi;
import com.lanou.service.DiZhiService;
import com.lanou.service.ShouDiZhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
@Service("shouDiZhiService")
public class ShouDiZhiServiceImpl implements ShouDiZhiService{
    @Autowired
    private ShouDiZhiMapper shouDiZhiMapper;
    public  List<ShouDiZhi> findShouDiZhi(Integer uId){
       return shouDiZhiMapper.findShouDiZhi(uId);
    }

    public boolean addShouDiZhi(ShouDiZhi shouDiZhi){
        return shouDiZhiMapper.addShouDiZhi(shouDiZhi);
    }
    public  boolean deleteShouDiZhi(Integer sId,Integer user_id){
        return shouDiZhiMapper.deleteShouDiZhi(sId,user_id);
    }

    public ShouDiZhi findShouDiZhiBysId(int sId,int user_id) {
        return shouDiZhiMapper.findShouDiZhiBysId(sId,user_id);
    }
}
