package com.qingyang.fastdeliver.controller;

import com.qingyang.fastdeliver.entity.OrderForm;
import com.qingyang.fastdeliver.service.IOrderService;
import com.qingyang.fastdeliver.service.ex.OrderListIsNullException;
import com.qingyang.fastdeliver.util.IdGenerator;
import com.qingyang.fastdeliver.util.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("normal")
public class NormalOrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("neworder")
    public JsonResult<Void> newOrder(OrderForm order, HttpSession session){
        //通过session获取账号account_id
//        String accountId = (String) session.getAttribute("accountId");
//        order.setAccountId(accountId);
        order.setAccountId("1000000001");

        //获取订单号
        String orderId = IdGenerator.generateOrderNumber();
        order.setOrderId(orderId);

        JsonResult<Void> result = new JsonResult<>();

        try {
            orderService.newOrder(order);
            result.setState(200);
            result.setMessage("订单提交成功");
        } catch (Exception e) {
            result.setState(4000);
            result.setMessage("注册时产生未知异常");
        }

        return result;
    }

    @PostMapping("deleteOrder")
    public JsonResult<Void> deleteAddList(String orderId, HttpSession session){
//        String accountId = (String) session.getAttribute("accountId");
        String accountId = "1000000001";

        JsonResult<Void> result = new JsonResult<>();
        try {
            if (orderService.deleteOrder(orderId,accountId))
                result.setMessage("删除成功");
            else
                result.setMessage("删除失败");
            result.setState(200);
        } catch (Exception e) {
            result.setState(5002);
            result.setMessage("删除过程中出现未知错误");
        }
        return result;
    }

    @GetMapping("usergetorderlist")
    public JsonResult<List<OrderForm>> userGetOrderList(HttpSession session) {
        //通过session获取账号account_id
        String accountId = "1000000001";
//        String accountId = (String) session.getAttribute("accountId");

        JsonResult<List<OrderForm>> result = new JsonResult<>();
        try{
            List<OrderForm> orderList = orderService.userGetOrderList(accountId);
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

    @PostMapping("modifyorder")
    public JsonResult<Void> modifyOrder(OrderForm order){
        //通过session获取账号account_id
//        String accountId = (String) session.getAttribute("accountId");
//        address.setAccountId(accountId);
        order.setAccountId("1000000001");

        JsonResult<Void> result = new JsonResult<>();
        try {
            if (orderService.modifyOrder(order)){
                result.setState(200);
                result.setMessage("订单修改成功");
            }else{
                result.setState(4003);
                result.setMessage("订单修改失败");
            }
        } catch (Exception e) {
            result.setState(5003);
            result.setMessage("订单修改过程中出现未知错误");
        }

        return result;
    }
}
