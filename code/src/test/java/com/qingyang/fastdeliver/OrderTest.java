package com.qingyang.fastdeliver;

import com.qingyang.fastdeliver.dao.OrderListMapper;
import com.qingyang.fastdeliver.entity.OrderForm;
import com.qingyang.fastdeliver.util.IdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderTest {

    @Autowired(required = false)
    private OrderListMapper orderListMapper;


    @Test
    void insertOrderForm(){
        OrderForm order = new OrderForm();
        order.setOrderId(IdGenerator.generateOrderNumber());
        order.setAddressId("1000000001");
        order.setAccountId("1000000001");
        order.setPackageAddress("小高厂房");
        order.setPackageCode("98456123456");
        order.setPickupCode("90-50-1");
        order.setOrderAmount(3);
        order.setOrderStatus(1);

        Integer affRows = orderListMapper.insertOrderForm(order);
        System.out.println(affRows);
    }

    @Test
    void findOrderById(){
        String id = "1000000001";
        List<OrderForm> orderList = orderListMapper.findOrderById(id);

        for (OrderForm order:orderList){
            System.out.println(order.toString());
        }
    }

    @Test
    void deleteOrderForm(){
        String orderId = "1000000001";
        String accountId = "1000000001";

        Integer affRows = orderListMapper.deleteOrderForm(orderId, accountId);
        System.out.println(affRows);
    }

    @Test
    void userUpdate(){
        OrderForm order = new OrderForm();
        order.setAddressId("1000000001");
        order.setPackageAddress("庄重文");
        order.setPackageCode("84956123");
        order.setPickupCode("90-1-2");
        order.setOrderId("2312141900");
        order.setAccountId("1000000001");
        Integer affRows = orderListMapper.userUpdate(order);
        System.out.println(affRows);
    }

    @Test
    void selectTest(){
        int orderStatus = 1;
        List<OrderForm> orderS = orderListMapper.findOrderByStatus(orderStatus);
        for (OrderForm order : orderS){
            System.out.println(order.toString());
        }
        List<OrderForm> orderU = orderListMapper.findOrderUnfinished();
        System.out.println(orderU.toString());
    }

    @Test
    void updateTest(){
        OrderForm order = new OrderForm();
        order.setOrderId("2312142100");
//        order.setOrderStatus(2);
//        order.setOrderStatus(3);
//        order.setOrderStatus(4);
        order.setOrderStatus(5);
        order.setDeliverAccountId("1000000002");
        order.setAdminAccountId("1000000003");
//        Integer affRows = orderListMapper.deliverUpdateAccept(order);
//        Integer affRows = orderListMapper.deliverUpdateTake(order);
//        Integer affRows = orderListMapper.deliverUpdateFinish(order);
//        Integer affRows = orderListMapper.adminUpdateAudit(accountId);

//        System.out.println(affRows);


    }

}
