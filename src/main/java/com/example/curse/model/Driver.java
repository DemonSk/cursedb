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
@Table(name="Drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Driverid")
    private long DriverID;
    @Column(name="fullname")
    private String fullname;
    @Column(name="passport")
    private String passport;
    @Column(name="platenum")
    private String platenum;
    @Column(name="drivinglicence")
    private String drivinglicence;
    @Column(name="dltime")
    private Date dltime;
    @Column(name="licence")
    boolean licence;
    @Column(name="confis_date")
    private Date confis_date;
}

