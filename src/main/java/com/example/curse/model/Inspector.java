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
@Table(name="Inspector")
public class Inspector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inspectorid")
    private long InspectorID;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "rank")
    private String rank;

}
