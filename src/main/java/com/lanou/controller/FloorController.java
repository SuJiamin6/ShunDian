package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.Floor;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2017/12/13.
 */
@Controller
@RequestMapping({"/"})
public class FloorController {
    @Autowired
    private GoodsTypeService goodsTypeService;

    public FloorController() {
    }

    @RequestMapping({"/selectfloor.do"})
    public void selectfloor(HttpServletResponse response) {
        HashMap map = new HashMap();
        List floorList = this.goodsTypeService.findFloor();
        map.put("floor", floorList);
        FastJson_All.toJson(map, response);
    }

    @RequestMapping({"/updatefloor.do"})
    public void updatefloor(HttpServletResponse response, Integer id, String fName) {
        HashMap map = new HashMap();
        this.goodsTypeService.updatefloor(fName, id);
        map.put("result", Boolean.valueOf(true));
        FastJson_All.toJson(map, response);
    }

    @RequestMapping({"/deletefloor.do"})
    public void updatefloor(HttpServletResponse response, Integer id) {
        HashMap map = new HashMap();
        this.goodsTypeService.deletefloor(id);
        map.put("result", Boolean.valueOf(true));
        FastJson_All.toJson(map, response);
    }

    @RequestMapping({"/insertfloor.do"})
    public void insertfloor(HttpServletResponse response, String fName) {
        HashMap map = new HashMap();
        this.goodsTypeService.insertFloor(fName);
        map.put("result", Boolean.valueOf(true));
        FastJson_All.toJson(map, response);
    }
}