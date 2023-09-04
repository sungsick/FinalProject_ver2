package com.kh.myproject.store.flight.model.entity;

import com.kh.myproject.member.user.model.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ticket_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FlightTicketInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticTicketId;

    @Column
    private String ticFlightDepartureDate;
    @Column
    private String ticFlightArrivalDate;
    @Column
    private String ticSeatGrade;
    @Column
    private String ticAirlineName;
    @Column
    private String ticFee;
    @Column
    private String ticFromLocation;
    @Column
    private String ticToLocation;
    @Column
    private String ticVihicleId;
    @Column
    private String tid;


    @ManyToOne()
    @JoinColumn(name = "userNumber")
    private User user;
}
