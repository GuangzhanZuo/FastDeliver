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
@RequestMapping("admin")
public class AdminOrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("admingetorderlist")
    public JsonResult<List<OrderForm>> userGetOrderList(HttpSession session) {
        //通过session获取账号account_id
        String accountId = "1000000001";
//        String accountId = (String) session.getAttribute("accountId");

        JsonResult<List<OrderForm>> result = new JsonResult<>();
        try{
            List<OrderForm> orderList = orderService.adminGetOrderList(accountId);
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

    @PostMapping("getfinishorderlist")
    public JsonResult<List<OrderForm>> getFinishOrderList() {

        JsonResult<List<OrderForm>> result = new JsonResult<>();
        try{
            List<OrderForm> orderList = orderService.finishOrderList();
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

    @PostMapping("getallnotendorderlist")
    public JsonResult<List<OrderForm>> getAllNotEndOrderList() {
        JsonResult<List<OrderForm>> result = new JsonResult<>();
        try{
            List<OrderForm> orderList = orderService.allNOtEndOrderList();
            result.setState(200);
            result.setData(orderList);
        } catch (OrderListIsNullException e){
            result.setState(4001);
            result.setMessage("未查询到正在进行的订单信息");
        } catch (Exception e){
            result.setState(5001);
            result.setMessage("查询订单信息时出现未知错误");
        }
        return result;
    }

    @PostMapping("auditupdate")
    public JsonResult<Void> auditUpdate(OrderForm order){
        //通过session获取账号account_id
        String accountId = "1000000001";
//        String accountId = (String) session.getAttribute("accountId");

        JsonResult<Void> result = new JsonResult<>();
        try {
            if (orderService.auditUpdate(accountId)){
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
