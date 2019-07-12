package com.xcy.mapper;

import com.xcy.pojo.Area;

import java.util.List;

public interface SanjiMapper {
    List<Area> showAllProvince();

    List<Area> showAllCity(int id);

    List<Area> showAllCountry(int id);
}
