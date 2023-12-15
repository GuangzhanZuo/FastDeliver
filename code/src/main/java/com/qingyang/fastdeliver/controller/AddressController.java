package com.qingyang.fastdeliver.controller;

import com.qingyang.fastdeliver.entity.Address;
import com.qingyang.fastdeliver.service.IAddressService;
import com.qingyang.fastdeliver.service.ex.AddressIsNullException;
import com.qingyang.fastdeliver.util.IdGenerator;
import com.qingyang.fastdeliver.util.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping("newaddress")
    public JsonResult<Void> addNewAdd(Address address, HttpSession session){
        //通过session获取账号account_id
//        String accountId = (String) session.getAttribute("accountId");
//        address.setAccountId(accountId);
        address.setAccountId("1000000001");

        //获取地址号
        String addressId = IdGenerator.generateOrderNumber();
        address.setAddressId(addressId);

        JsonResult<Void> result = new JsonResult<>();
        try{
            addressService.addNewAdd(address);
            result.setState(200);
            result.setMessage("地址添加成功");
        } catch (Exception e) {
            result.setState(4000);
            result.setMessage("注册时产生未知异常");
        }
        return result;
    }

    @GetMapping("getaddress")
    public JsonResult<List<Address>> getAddress(HttpSession session){
        //通过session获取账号account_id
        String accountId = "1000000001";
//        String accountId = (String) session.getAttribute("accountId");

        JsonResult<List<Address>> result = new JsonResult<>();
        try{
            List<Address> addressList = addressService.getAddressList(accountId);
            result.setState(200);
            result.setData(addressList);
        } catch (AddressIsNullException e){
            result.setState(4001);
            result.setMessage("未查询到该用户的地址信息");
        } catch (Exception e){
            result.setState(5001);
            result.setMessage("查询地址信息时出现未知错误");
        }
        return result;
    }

    @PostMapping("deleteaddlist")
    public JsonResult<Void> deleteAddList(List<String> addressList, HttpSession session){
//        String accountId = (String) session.getAttribute("accountId");
        String accountId = "1000000001";

        JsonResult<Void> result = new JsonResult<>();
        try {
            Integer deletedRows = addressService.deleteAddress(addressList, accountId);
            result.setState(200);
            result.setMessage("成功删除" + deletedRows + "条地址");
        } catch (Exception e) {
            result.setState(5002);
            result.setMessage("删除过程中出现未知错误");
        }
        return result;
    }

    @PostMapping("updateaddress")
    public JsonResult<Void> updateAddress(Address address, HttpSession session){
        //通过session获取账号account_id
//        String accountId = (String) session.getAttribute("accountId");
//        address.setAccountId(accountId);
        address.setAccountId("1000000001");

        JsonResult<Void> result = new JsonResult<>();
        try {
            if (addressService.updateAddress(address)){
                result.setState(200);
                result.setMessage("地址修改成功");
            }else{
                result.setState(4003);
                result.setMessage("地址修改失败");
            }
        } catch (Exception e) {
            result.setState(5003);
            result.setMessage("地址修改过程中出现未知错误");
        }

        return result;
    }
}
