package com.qingyang.fastdeliver.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OrderForm {

    private String orderId;

    private String accountId;

    private String deliverAccountId;

    private String adminAccountId;

    private String addressId;

    private String packageAddress;

    private String packageCode;

    private String pickupCode;

    private Integer orderAmount;

    private Date orderDate;

    private Integer orderStatus;

    private Date getPackageTime;

    private String pictureName;

    private Date orderFinishTime;

    private Date auditTime;
}
