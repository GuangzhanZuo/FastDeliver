package com.qingyang.fastdeliver.service;

import com.qingyang.fastdeliver.entity.Address;
import com.qingyang.fastdeliver.entity.OrderForm;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IOrderService {

    /**
     * 提交新订单
     * @param order OrderForm对象
     */
    void newOrder(OrderForm order);

    /**
     * 删除订单
     * @param orderId 订单号
     * @param accountId 账号
     * @return 是否删除成功
     */
    Boolean deleteOrder(String orderId, String accountId);

    /**
     * 普通用户的订单列表
     * @param accountId 账号account_id
     * @return List<OrderForm>订单列表
     */
    List<OrderForm> userGetOrderList(String accountId);

    /**
     * 普通用户修改订单
     * @param order OrderForm对象
     * @return 是否修改成功
     */
    Boolean modifyOrder(OrderForm order);

    /**
     * 送货员送货历史订单
     * @param accountId 账号account_id
     * @return List<OrderForm>订单列表
     */
    List<OrderForm> deliverGetOrderList(String accountId);

    /**
     * 送货员的接单列表
     * @return List<OrderForm>订单列表
     */
    List<OrderForm> acceptOrderList();

    /**
     * 送货员接受订单
     * @param orderId 订单号
     * @param deliverAccountId 送货员账号
     * @return
     */
    Boolean deliverAcceptOrder(String orderId, String deliverAccountId);

    /**
     * 送货员取货更改订单状态
     * @param orderId 订单号
     * @return 是否修改成功
     */
    Boolean deliverTakePackage(String orderId, String pictureName);

    /**
     * 送货员送达快递更改订单信息
     * @param orderId 订单号
     * @return 是否修改成功
     */
    Boolean deliverFinishOrder(String orderId);

    /**
     * 管理员审核历史订单
     * @param accountId 账号account_id
     * @return List<OrderForm>订单列表
     */
    List<OrderForm> adminGetOrderList(String accountId);

    /**
     * 管理员待审核订单列表
     * @return List<OrderForm>订单列表
     */
    List<OrderForm> finishOrderList();

    /**
     * 管理员订单监控
     @return List<OrderForm>订单列表
     */
    List<OrderForm> allNOtEndOrderList();

    /**
     * 管理员审核
     * @param accountId 管理员账号
     * @return
     */
    Boolean auditUpdate(String accountId);

}
