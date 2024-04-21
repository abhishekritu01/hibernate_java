package com.spring;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;


@Entity
@Table(name = "student_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @Column(length = 50, name = "STREET")
    private String Street;
    @Column(length = 100, name = "CITY")
    private String City;
    @Column(name = "is_open")
    private boolean isOpen;

    @Transient            // when use transient no column be created in database
    private double x;

    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)    //temporal is used to store date in database
    private Date addedDate;

    @Lob
    private byte[] image;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Address(int addressId, String street, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
        this.addressId = addressId;
        Street = street;
        City = city;
        this.isOpen = isOpen;
        this.x = x;
        this.addedDate = addedDate;
        this.image = image;
    }



    public Address() {
        super();
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", Street='" + Street + '\'' +
                ", City='" + City + '\'' +
                ", isOpen=" + isOpen +
                ", x=" + x +
                ", addedDate=" + addedDate +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
