package com.qingyang.fastdeliver.service.impl;

import com.qingyang.fastdeliver.dao.OrderListMapper;
import com.qingyang.fastdeliver.entity.OrderForm;
import com.qingyang.fastdeliver.service.IOrderService;
import com.qingyang.fastdeliver.service.ex.OrderListIsNullException;
import com.qingyang.fastdeliver.service.ex.ServiceException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderListMapper orderListMapper;

    @Override
    public void newOrder(OrderForm order) {
        try {
            Integer affRows = orderListMapper.insertOrderForm(order);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Boolean deleteOrder(String orderId, String accountId) {
        Integer affRows = orderListMapper.deleteOrderForm(orderId, accountId);
        if (affRows==1)
            return true;
        else
            return false;
    }

    @Override
    public List<OrderForm> userGetOrderList(String accountId) {
        List<OrderForm> orderList = orderListMapper.findOrderById(accountId);
        if (orderList.isEmpty()){
            throw new OrderListIsNullException("未查询到该用户的订单信息");
        }
        return orderList;
    }

    @Override
    public Boolean modifyOrder(OrderForm order) {
        Integer affRows = orderListMapper.userUpdate(order);
        return affRows == 1;
    }

    @Override
    public List<OrderForm> deliverGetOrderList(String accountId) {
        List<OrderForm> orderList = orderListMapper.findOrderById(accountId);
        if (orderList.isEmpty()){
            throw new OrderListIsNullException("未查询到该用户的订单信息");
        }
        return orderList;
    }

    @Override
    public List<OrderForm> acceptOrderList() {
        int status = 1;
        List<OrderForm> orderList = orderListMapper.findOrderByStatus(status);
        if (orderList.isEmpty()){
            throw new OrderListIsNullException("未查询到该用户的订单信息");
        }
        return orderList;
    }

    @Override
    public Boolean deliverAcceptOrder(String orderId, String deliverAccountId) {
        Integer affRows = orderListMapper.deliverUpdateAccept(orderId, deliverAccountId);
        return affRows == 1;
    }

    @Override
    public Boolean deliverTakePackage(String orderId, String pictureName) {
        Integer affRows = orderListMapper.deliverUpdateTake(orderId, pictureName);
        return affRows == 1;
    }

    @Override
    public Boolean deliverFinishOrder(String orderId) {
        Integer affRows = orderListMapper.deliverUpdateFinish(orderId);
        return affRows == 1;
    }

    @Override
    public List<OrderForm> adminGetOrderList(String accountId) {
        List<OrderForm> orderList = orderListMapper.findOrderById(accountId);
        if (orderList.isEmpty()){
            throw new OrderListIsNullException("未查询到该用户的订单信息");
        }
        return orderList;
    }

    @Override
    public List<OrderForm> finishOrderList() {
        int status = 4;
        List<OrderForm> orderList = orderListMapper.findOrderByStatus(status);
        if (orderList.isEmpty()){
            throw new OrderListIsNullException("未查询到该用户的订单信息");
        }
        return orderList;
    }

    @Override
    public List<OrderForm> allNOtEndOrderList() {
        List<OrderForm> orderList = orderListMapper.findOrderUnfinished();
        if (orderList.isEmpty()){
            throw new OrderListIsNullException("未查询到任何正在进行的订单信息");
        }
        return orderList;
    }

    @Override
    public Boolean auditUpdate(String accountId) {
        Integer affRows = orderListMapper.adminUpdateAudit(accountId);
        return affRows == 1;
    }
}
