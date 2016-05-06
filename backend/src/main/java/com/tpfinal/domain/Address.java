package com.tpfinal.domain;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    private Long idAddress;
    private String street;
    private Long number;
    private Long postalCode;
    private Double latitude;
    private Double length;
    private District district;

    public Address(String street, Long number, Long postalCode, Double latitude, Double length, District district) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.latitude = latitude;
        this.length = length;
        this.district = district;
    }

    public Address() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "number")
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Column(name = "postal_code")
    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "latitude")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Column(name = "length")
    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_district")
    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
