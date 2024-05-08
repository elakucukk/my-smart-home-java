package com.example.mysmarthomejava;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8082") // Adjust the port to match your frontend
@RestController
public class HomeController {

    private final HomeRepository repository;

    public HomeController(HomeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/addHome")
    public List<HomeData> addHomeData(@RequestParam double temperature, @RequestParam double humidity) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repository.addHomeData(new HomeData(timeStamp ,temperature, humidity));
        return repository.getAllHomeData();
    }

    @GetMapping("/home")
    public HomeData getHomeData() {
        List<HomeData> homeDataList = repository.getAllHomeData();
        return homeDataList.isEmpty() ? null : homeDataList.get(homeDataList.size() - 1);
    }

    @GetMapping("/allHome")
    public List<HomeData> getAllHomeData() {
        return repository.getAllHomeData();
    }
}
