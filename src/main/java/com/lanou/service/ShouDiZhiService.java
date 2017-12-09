package com.lanou.service;


import com.lanou.entity.ShouDiZhi;

import java.util.List;

public interface ShouDiZhiService {

	public  List<ShouDiZhi> findShouDiZhi(Integer uId);
	public boolean addShouDiZhi(ShouDiZhi shouDiZhi);
	public  boolean deleteShouDiZhi(Integer sId,Integer user_id);

	//根据用户勾选的地址id查找
	public ShouDiZhi findShouDiZhiBysId(int sId,int user_id);
}
