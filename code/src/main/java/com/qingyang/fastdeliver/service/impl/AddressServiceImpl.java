package com.qingyang.fastdeliver.service.impl;

import com.qingyang.fastdeliver.dao.AddressMapper;
import com.qingyang.fastdeliver.entity.Address;
import com.qingyang.fastdeliver.service.IAddressService;
import com.qingyang.fastdeliver.service.ex.AddressIsNullException;
import com.qingyang.fastdeliver.service.ex.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public void addNewAdd(Address address) {
        try {
            Integer affRows = addressMapper.insertAddress(address);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Address> getAddressList(String accountId) {
        List<Address> addressList = addressMapper.findAddressById(accountId);
        if (addressList.isEmpty()){
            throw new AddressIsNullException("未查询到该用户的地址");
        }
        return addressList;
    }
}
