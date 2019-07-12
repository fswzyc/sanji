package com.xcy.service.impl;


import com.xcy.mapper.SanjiMapper;
import com.xcy.pojo.Area;
import com.xcy.service.SanjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SanjiServiceImpl implements SanjiService {

    @Autowired
    SanjiMapper sanjiMapper;

    public List<Area> showAllProvince() {
        List<Area> areaList = sanjiMapper.showAllProvince();
        return areaList;
    }

    @Override
    public List<Area> showAllCity(int id) {
        List<Area> cityList = sanjiMapper.showAllCity(id);
        return cityList;
    }

    @Override
    public List<Area> showAllCountry(int id) {
        List<Area> conuntryList = sanjiMapper.showAllCountry(id);
        return conuntryList;
    }
}
