package com.example.mysmarthomejava;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class HomeRepository {
    private final List<HomeData> HomeDataList = Collections.synchronizedList(new LinkedList<>());

    public void addHomeData(HomeData data) {
        HomeDataList.add(data);
        // Remove old data to avoid memory overflow
        if (HomeDataList.size() > 100) {
            HomeDataList.remove(0);
        }
    }

    public List<HomeData> getAllHomeData() {
        return HomeDataList;
    }
}
