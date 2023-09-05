package com.kh.myproject.store.tour.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.kh.myproject.store.tour.model.dto.TourismDto;
import com.kh.myproject.store.tour.model.entity.Tourism;
import com.kh.myproject.store.tour.model.vo.detailCommon;
import com.kh.myproject.store.tour.model.vo.detailRestaurant;
import com.kh.myproject.store.tour.repository.TourismRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TourService {

    @Autowired
    TourismRepository tourismRepository;

    public String getApiData(String url) {

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public List<TourismDto> getTourism(String areaName) {
        List<Tourism> list = tourismRepository.findAllByAreaName(areaName);
        List<TourismDto> dtoList = new ArrayList<>();

        for (Tourism item : list) {
            dtoList.add(item.toDto());
        }
        return dtoList;
    }

    public JsonObject getDetailApiData(String url) {

        StringBuilder result = new StringBuilder();

        JsonObject object = null;

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

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result.toString());

            JsonArray item = element.getAsJsonObject().get("response").getAsJsonObject().get("body").getAsJsonObject().get("items").getAsJsonObject().get("item").getAsJsonArray();
            object = (JsonObject) item.get(0);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }

    public detailCommon getDetailCommon(String url) {


        detailCommon data = null;

        ObjectMapper mapper = new ObjectMapper();

        JsonObject object = getDetailApiData(url);

        try {
            data = mapper.readValue(object.toString(), detailCommon.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    public detailRestaurant getDetailRestaurant(String url) {

        detailRestaurant data = null;

        Gson gson = new Gson();

        JsonObject object = getDetailApiData(url);

        data = gson.fromJson(object.toString(), detailRestaurant.class);

        return data;
    }

//    public City getCityInfo(String cityName) {
//        City CityInfo = new City();
//        List<String> placeName = new ArrayList<>();
//    }

}
