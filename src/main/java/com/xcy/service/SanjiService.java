package com.xcy.service;

import com.xcy.pojo.Area;

import java.util.List;

public interface SanjiService {
    List<Area> showAllProvince();

    List<Area> showAllCity(int id);

    List<Area> showAllCountry(int id);
}
