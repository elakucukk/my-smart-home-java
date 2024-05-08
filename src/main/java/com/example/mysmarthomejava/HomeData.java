package com.example.mysmarthomejava;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class HomeData {
    private String date;
    private double temperature;
    private double humidity;
}
