package com.qingyang.fastdeliver.service;

import com.qingyang.fastdeliver.entity.Address;

import java.util.List;

public interface IAddressService {


    /**
     * 添加新地址
     * @param address
     */
    void addNewAdd(Address address);

    List<Address> getAddressList(String accountId);

}
