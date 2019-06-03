package com.github.bjlhx15.architecture.customermgr.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.bjlhx15.architecture.common.pageutil.Page;
import com.github.bjlhx15.architecture.customermgr.service.ICustomerService;
import com.github.bjlhx15.architecture.customermgr.vo.CustomerModel;
import com.github.bjlhx15.architecture.customermgr.vo.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @RequestMapping(value = "toAdd", method = RequestMethod.GET)
    public String toAdd() {
        System.out.println("sss");
        return "customer/add";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("cm") CustomerModel record) {
        record.setRegisterTime(new SimpleDateFormat().format(new Date()));
        iCustomerService.create(record);
        return "customer/success";
    }

    @RequestMapping(value = "toUpdate/{customerUuid}", method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("customerUuid") int customerUuid) {
        CustomerModel customerModel = iCustomerService.getByUuid(customerUuid);
        model.addAttribute("cm",customerModel);
        return "customer/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("cm") CustomerModel record) {
        iCustomerService.update(record);
        return "customer/success";
    }
    @RequestMapping(value = "toDelete/{customerUuid}", method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("customerUuid") int customerUuid) {
        CustomerModel customerModel = iCustomerService.getByUuid(customerUuid);
        model.addAttribute("cm",customerModel);
        return "customer/delete";
    }

    @RequestMapping(value = "delete/", method = RequestMethod.POST)
    public String update(@RequestParam("uuid") int customerUuid) {
        iCustomerService.delete(customerUuid);
        return "customer/success";
    }

    @RequestMapping(value = "toList", method = RequestMethod.GET)
    public String toList(@ModelAttribute("wm")CustomerWebModel wm,Model model){
        System.out.println("=============="+JSON.toJSONString(wm));
        CustomerQueryModel cqm = null;
        if(wm==null||wm.getQueryJsonStr()==null || wm.getQueryJsonStr().trim().length()==0){
            cqm =  new CustomerQueryModel();
        }else{
            cqm = JSON.parseObject(wm.getQueryJsonStr(),CustomerQueryModel.class);
        }

        cqm.getPage().setNowPage(wm.getNowPage());
        if(wm.getPageShow() > 0){
            cqm.getPage().setPageShow(wm.getPageShow());
        }

        Page dbPage = iCustomerService.getByConditionPage(cqm);


        System.out.println("=============="+JSON.toJSONString(dbPage));
        model.addAttribute("wm", wm);
        model.addAttribute("page", dbPage);

        return "customer/list";
    }
    @RequestMapping(value = "toList2", method = RequestMethod.GET)
    public String toList2(@RequestBody CustomerQueryModel customerQueryModel,Model model) {

        Page<CustomerModel> modelPage = iCustomerService.getByConditionPage(customerQueryModel);

        //
        model.addAttribute("wm", modelPage.getResult());
        model.addAttribute("page", modelPage);
        return "customer/list";
    }

    @RequestMapping(value="toQuery",method=RequestMethod.GET)
    public String toQuery(){
        return "customer/query";
    }
}
