package com.kh.myproject.store.rentcar.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CrawlingDto {
    private String img;
    private String rating;
    private String date;
    private String ratingDetail;
    private String reviewText;
}
