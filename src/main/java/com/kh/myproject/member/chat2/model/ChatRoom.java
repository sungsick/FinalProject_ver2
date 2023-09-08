package com.kh.myproject.member.chat2.model;


import com.kh.myproject.member.user.model.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class ChatRoom {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;


    @ManyToOne
    @JoinColumn( name = "userNumber1")
    private User user1;

    @ManyToOne
    @JoinColumn( name = "userNumber2")
    private User user2;



}
