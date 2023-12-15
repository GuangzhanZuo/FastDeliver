package com.qingyang.fastdeliver.dao;

import com.qingyang.fastdeliver.entity.OrderForm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.Order;

import java.util.List;

@Mapper
public interface OrderListMapper {

    /**
     * 以下与插入相关
     */

    /**
     * 插入新订单表
     * @param order OrderForm对象
     * @return 影响行数
     */
    Integer insertOrderForm(OrderForm order);



    /**
     * 以下与删除相关
     */

    /**
     * 删除订单
     * @param orderId 订单号
     * @param accountId 账号
     * @return 影响行数
     */
    Integer deleteOrderForm(String orderId, String accountId);



    /**
     * 以下与查询有关
     */

    /**
     * 通过账号查找订单（普通用户的全部订单/送货员送过的订单/后台管理审核过的订单）
     * @param id 账号(普通用户/送货员/后台管理员)
     * @return List<OrderForm>对象
     */
    List<OrderForm> findOrderById(String id);

    /**
     * 通过状态查询订单（送货员接单/送货员订单更新/管理待审核订单）
     * @param orderStatus
     * @return
     */
    List<OrderForm> findOrderByStatus(int orderStatus);

    /**
     * 通过状态查询未完成的订单（管理员订单监控）。
     * @return
     */
    List<OrderForm> findOrderUnfinished();

    /**
     * 以下与修改有关
     */

    /**
     * 修改订单信息(用户修改订单信息)
     * @param order OrderForm对象
     * @return 影响行数
     */
    Integer userUpdate(OrderForm order);

    /**
     * 修改订单信息（送货员接受订单）
     * @param deliverAccountId 送货员账号
     * @return 影响行数
     */
    Integer deliverUpdateAccept(String orderId, String deliverAccountId);

    /**
     *修改订单信息（送货员取货）
     * @param orderId 订单号
     * @param
     * @return 影响行数
     */
    Integer deliverUpdateTake(String orderId, String pictureName);

    /**
     *修改订单信息（送货员送达）
     * @param orderId 订单号
     * @return 影响行数
     */
    Integer deliverUpdateFinish(String orderId);

    /**
     *修改订单信息（管理员审核）
     * @param accountId 管理员账号
     * @return 影响行数
     */
    Integer adminUpdateAudit(String accountId);



}
