package com.lanou.dao;


import com.lanou.entity.ShouDiZhi;

import java.util.List;

public interface ShouDiZhiMapper {

	public  List<ShouDiZhi> findShouDiZhi(Integer uId);
	public boolean addShouDiZhi(ShouDiZhi shouDiZhi);
	public  boolean deleteShouDiZhi(Integer sId,Integer user_id);


	public ShouDiZhi findShouDiZhiBysId(int sId,int user_id);
}
