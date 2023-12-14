package com.qingyang.fastdeliver.dao;

import com.qingyang.fastdeliver.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    /**
     * 向数据库中插入地址
     * @param address 地址对象
     * @return 影响行数
     */
    Integer insertAddress(Address address);

    /**
     * 通过account_id查询地址
     * @param accountId 账号account_id
     * @return List<Address>对象
     */
    List<Address> findAddressById(String accountId);

    /**
     * 删除地址
     * @param addressId 地址号
     * @param accountId 账号
     * @return 影响行数
     */
    Integer deleteAddress(String addressId, String accountId);

    Integer updateAddress(Address address);


}
