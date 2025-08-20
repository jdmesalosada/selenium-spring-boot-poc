package com.mesaj.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idflights")
    private Integer idflights;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "numberOfPassengers", nullable = false)
    private Integer numberOfPassengers;

    public Flight(){}

    public Flight(int idflights, String origin, String destination, int numberOfPassengers) {
        this.idflights = idflights;
        this.origin = origin;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getIdflights() {
        return idflights;
    }

    public void setIdflights(int idflights) {
        this.idflights = idflights;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
