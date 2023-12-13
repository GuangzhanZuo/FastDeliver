package com.qingyang.fastdeliver;

import com.qingyang.fastdeliver.dao.AddressMapper;
import com.qingyang.fastdeliver.entity.Address;
import com.qingyang.fastdeliver.service.IAddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FastDeliverApplicationTests {

    @Autowired(required = false)
    private AddressMapper addressMapper;

    @Test
    void contextLoads() {
    }


    @Test
    void insertAddress(){
        Address address = new Address();
        address.setAddressId("1000000002");
        address.setAccountId("1000000001");
        address.setName("qingyang");
        address.setAddress("集友三");
        address.setPhone("15039017223");

        Integer rows = addressMapper.insertAddress(address);
        System.out.println(rows);
    }

    @Test
    void findById(){
        String accountId = "1000000001";
        List<Address> addressList = addressMapper.findAddressById(accountId);
        for (Address address:addressList){
            System.out.println(address);
        }
    }

    @Autowired(required = false)
    private IAddressService addressService;

    @Test
    void addNewAdd(){
        Address address = new Address();
        address.setAddressId("1000000003");
        address.setAccountId("1000000001");
        address.setName("qingyang");
        address.setAddress("集友三");
        address.setPhone("15039017223");



    } 

    @Test
    void getAddressList(){
        String accountId = "1000000001";
        List<Address> addList = addressService.getAddressList(accountId);
        for (Address address:addList){
            System.out.println(address.toString());
        }
    }

}
