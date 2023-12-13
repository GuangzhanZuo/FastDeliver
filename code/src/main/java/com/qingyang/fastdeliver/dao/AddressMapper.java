package com.qingyang.fastdeliver.dao;

import com.qingyang.fastdeliver.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    //向数据库中插入地址
    Integer insertAddress(Address address);
    //通过account_id查询地址
    List<Address> findAddressById(String accountId);
}
