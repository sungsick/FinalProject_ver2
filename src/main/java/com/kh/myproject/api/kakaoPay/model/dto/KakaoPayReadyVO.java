package com.kh.myproject.api.kakaoPay.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class KakaoPayReadyVO {

    //response
    private String tid;
    private String next_redirect_pc_url;
    private Date created_at;

}
