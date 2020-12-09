package com.example.curse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ticketid")
    private long id;
    @Column(name="ticketdate")
    private Date ticketdate;
    @Column(name="penaltyid")
    private long penaltyid;
    @Column(name="inspectorid")
    private long inspectorid;
    @Column(name="personid")
    private long personid;
    @Column(name="payed")
    private Date payed;
    @Column(name="cost")
    private int cost;
}