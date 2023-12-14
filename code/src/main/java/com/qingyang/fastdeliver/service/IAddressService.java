package com.qingyang.fastdeliver.service;

import com.qingyang.fastdeliver.entity.Address;

import java.util.List;

public interface IAddressService {


    /**
     * 添加新地址
     * @param address address对象
     */
    void addNewAdd(Address address);

    /**
     * 查询地址表
     * @param accountId 账号
     * @return List<Address>对象
     */
    List<Address> getAddressList(String accountId);

    /**
     * 删除地址
     * @param addressIdList 地址列表
     * @param accountId 账号
     * @return 影响行数
     */
    Integer deleteAddress(List<String> addressIdList, String accountId);

    /**
     * 修改地址
     * @param address address对象
     * @return 影响行数
     */
    Boolean updateAddress(Address address);

}
