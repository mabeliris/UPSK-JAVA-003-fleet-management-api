package com.Fleet.Management.demo.model;

import jakarta.persistence.*;


import java.time.OffsetDateTime;

@Entity
@Table(name = "trajectories")

public class Trajectories {


    //Atributos de la entidad o clase
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "taxi_id")
    private int taxi_id;

    @Column (name= "date")
    private OffsetDateTime date;

    @Column (name="latitude")
    private double latitude;

    @Column (name="longitude")
    private double longitude;


     //constructor vacío jpa
     public Trajectories() {}

    //constructor con parámetros
    public Trajectories(long id, int taxi_id, OffsetDateTime date, double latitude, double longitude) {
         this.id = id;
         this.date=date;
         this.latitude= latitude;
         this.longitude=longitude;
         this.taxi_id= taxi_id;
    }

    //Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getTaxi_id() { return taxi_id;}
    public void setTaxi_id(int taxi_id) {
        this.taxi_id = taxi_id;
    }

    public OffsetDateTime getDate() { return date;}

    public void setDate(OffsetDateTime date) {this.date = date;}

    public double getLatitude() {return latitude;}

    public void setLatitude(double latitude) {this.latitude = latitude;}

    public double getLongitude() {return longitude;}

    public void setLongitude(double longitude) {this.longitude = longitude;}
}
