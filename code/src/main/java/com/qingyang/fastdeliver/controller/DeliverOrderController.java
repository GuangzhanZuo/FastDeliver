package com.qingyang.fastdeliver.controller;

import com.qingyang.fastdeliver.entity.OrderForm;
import com.qingyang.fastdeliver.service.IOrderService;
import com.qingyang.fastdeliver.service.ex.OrderListIsNullException;
import com.qingyang.fastdeliver.util.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("deliver")
public class DeliverOrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("deliverGetOrderList")
    public JsonResult<List<OrderForm>> userGetOrderList(HttpSession session) {
        //通过session获取账号account_id
        String accountId = "1000000001";
//        String accountId = (String) session.getAttribute("accountId");

        JsonResult<List<OrderForm>> result = new JsonResult<>();
        try{
            List<OrderForm> orderList = orderService.deliverGetOrderList(accountId);
            result.setState(200);
            result.setData(orderList);
        } catch (OrderListIsNullException e){
            result.setState(4001);
            result.setMessage("未查询到该用户的订单信息");
        } catch (Exception e){
            result.setState(5001);
            result.setMessage("查询订单信息时出现未知错误");
        }
        return result;
    }

    @PostMapping("getacceptorderlist")
    public JsonResult<List<OrderForm>> getAcceptOrderList() {

        JsonResult<List<OrderForm>> result = new JsonResult<>();
        try{
            List<OrderForm> orderList = orderService.acceptOrderList();
            result.setState(200);
            result.setData(orderList);
        } catch (OrderListIsNullException e){
            System.out.println(e.getClass().getSimpleName());
            result.setState(4001);
            result.setMessage("未查询到该用户的订单信息");
        } catch (Exception e){
            result.setState(5001);
            result.setMessage("查询订单信息时出现未知错误");
        }
        return result;
    }

    @PostMapping("acceptorder")
    public JsonResult<Void> acceptOrder(String orderId) {
        //通过session获取账号account_id
        String accountId = "1000000001";
//        String accountId = (String) session.getAttribute("accountId");

        JsonResult<Void> result = new JsonResult<>();
        try {
            if (orderService.deliverAcceptOrder(orderId, accountId)){
                result.setState(200);
                result.setMessage("接单成功");
            }else{
                result.setState(4003);
                result.setMessage("接单失败");
            }
        } catch (Exception e) {
            result.setState(5003);
            result.setMessage("接单过程中出现未知错误");
        }

        return result;
    }

    @PostMapping("takepackage")
    public JsonResult<Void> takePackage(String orderId,String pictureName,HttpSession session) {
        //通过session获取账号account_id
        String accountId = "1000000001";
//        String accountId = (String) session.getAttribute("accountId");

        JsonResult<Void> result = new JsonResult<>();
        try {
            if (orderService.deliverTakePackage(orderId, pictureName)){
                result.setState(200);
                result.setMessage("提交成功");
            }else{
                result.setState(4003);
                result.setMessage("提交失败");
            }
        } catch (Exception e) {
            result.setState(5003);
            result.setMessage("提交过程中出现未知错误");
        }

        return result;
    }

    @PostMapping("finishOrder")
    public JsonResult<Void> takePackage(String orderId, HttpSession session) {
        //通过session获取账号account_id
        String accountId = "1000000001";
//        String accountId = (String) session.getAttribute("accountId");

        JsonResult<Void> result = new JsonResult<>();
        try {
            if (orderService.deliverFinishOrder(orderId)){
                result.setState(200);
                result.setMessage("提交成功");
            }else{
                result.setState(4003);
                result.setMessage("提交失败");
            }
        } catch (Exception e) {
            result.setState(5003);
            result.setMessage("提交过程中出现未知错误");
        }

        return result;
    }

}
