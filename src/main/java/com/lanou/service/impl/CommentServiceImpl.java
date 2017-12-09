package com.lanou.service.impl;

import com.lanou.dao.CommentMapper;
import com.lanou.dao.DiZhiMapper;
import com.lanou.entity.Comments;
import com.lanou.entity.DiZhi;
import com.lanou.service.CommentService;
import com.lanou.service.DiZhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService{
    @Autowired
   private CommentMapper commentMapper;

    public void addComment(Comments comments){
        commentMapper.addComment(comments);
    }
}
