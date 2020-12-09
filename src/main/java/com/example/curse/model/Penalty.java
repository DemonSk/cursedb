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
@Table(name="Penalty")
public class Penalty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="penaltyid")
    private long PenaltyID;
    @Column(name="penaltytype")
    private String penaltytype;
    @Column(name="penaltycost")
    private int penaltycost;

}