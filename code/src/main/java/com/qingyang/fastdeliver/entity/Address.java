package com.qingyang.fastdeliver.entity;


public class Address {
    private String addressId;
    private String accountId;
    private String address;
    private String name;
    private String phone;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
