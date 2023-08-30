package com.kh.myproject.store.flight.model.entity;

import com.kh.myproject.member.user.model.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ticket_info")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightTicket {

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


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "userNumber")
    private User user;
}
