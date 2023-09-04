package com.kh.myproject.community.accompany.dto;

import com.kh.myproject.community.accompany.entity.Accompany;
import com.kh.myproject.community.accompany.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentForm {

    private Long co_number;
    private String co_content;
    private String co_regdate;
    private Accompany ac_num;
    private int user_number;

    public Comment toEntity() {
        return Comment.builder()
                .co_number(co_number)
                .co_content(co_content)
                .co_regdate(co_regdate)
                .ac_num(ac_num)
                .user_number(user_number)
                .build();
    }

}
