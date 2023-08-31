package com.kh.myproject.store.tour.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@Slf4j
public class TourService {

    public String getApiData(String url) throws Exception {

        StringBuilder result = new StringBuilder();

        try {
            URL resUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) resUrl.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;

            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            br.close();
            conn.disconnect();
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();
    }

//    public City getCityInfo(String cityName) {
//        City CityInfo = new City();
//        List<String> placeName = new ArrayList<>();
//    }

}
