package com.xcy.controller;

import com.xcy.pojo.Area;
import com.xcy.service.SanjiService;
import com.xcy.utils.JedisClient;
import com.xcy.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.jsp.PageContext;
import java.util.List;


@Controller
public class sanjiManage {

    @Autowired
    SanjiService sanjiService;
    @Autowired
    JedisClient jedisClient;

    @RequestMapping("/showAllProvince")
    @ResponseBody
    public List<Area> a(){
        String allProvinceJson = jedisClient.get("areaList");
        List<Area> areaList = null;
        if(allProvinceJson == null || allProvinceJson.equals("")){
            areaList = sanjiService.showAllProvince();
            String jsonData = JsonUtils.objectToJson(areaList);
            jedisClient.set("areaList",jsonData);
            System.out.println("我是从  数据库  拿到的");
        }else{
            areaList = JsonUtils.jsonToList(allProvinceJson,Area.class);
            System.out.println("我是从  缓存中  拿到的");
        }

        return areaList;
    }

    @RequestMapping("/showAllCity")
    @ResponseBody
    public List<Area> showAllCity(int id){

        String allCityJson = jedisClient.get("cityList:"+id);
        List<Area> cityList = null;
        if(allCityJson == null || allCityJson.equals("")){
           cityList = sanjiService.showAllCity(id);
            String jsonData = JsonUtils.objectToJson(cityList);
            jedisClient.set("cityList:"+id,jsonData);
            System.out.println("我是从  数据库  取得值");
        }else{
            cityList = JsonUtils.jsonToList(allCityJson, Area.class);
            System.out.println("我是从  缓存中  取得值");
        }

        return cityList;
    }

    @RequestMapping("/showAllCountry")
    @ResponseBody
    public List<Area> showAllCountry(int id){

        String allCountryJson = jedisClient.get("countryList:"+id);
        List<Area> countryList = null;
        if(allCountryJson == null || allCountryJson.equals("")){
            countryList = sanjiService.showAllCountry(id);
            String jsonData = JsonUtils.objectToJson(countryList);
            jedisClient.set("countryList:"+id,jsonData);
            System.out.println("我是从    数据库  中拿的值");
        }else{
            countryList = JsonUtils.jsonToList(allCountryJson,Area.class);
            System.out.println("我是从   缓存中  拿的值");
        }

        return countryList;
    }

}
