package com.lanou.service;

import com.lanou.entity.Comments;


public interface CommentService {

	public void addComment(Integer good_id,Integer user_id,String content);
	public Integer findGoods_id(Integer goods_id,Integer user_id);
}
