package com.github.bjlhx15.architecture.customermgr;

import com.github.bjlhx15.architecture.common.pageutil.Page;
import com.github.bjlhx15.architecture.customermgr.dao.CustomerDAO;
import com.github.bjlhx15.architecture.customermgr.service.ICustomerService;
import com.github.bjlhx15.architecture.customermgr.vo.CustomerModel;
import com.github.bjlhx15.architecture.customermgr.vo.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Client2 {
    @Autowired
    private ICustomerService s;

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        Client2 client=(Client2)ctx.getBean("client2");
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomerId("c1");
        customerModel.setPwd("c1");
        customerModel.setRegisterTime("111");
        customerModel.setShowName("lhx");
        customerModel.setTrueName("lhx");
        customerModel.setUuid(1);
        client.s.create(customerModel);
        CustomerQueryModel queryModel = new CustomerQueryModel();
        queryModel.getPage().setNowPage(2);

        Page<CustomerModel> page = client.s.getByConditionPage(queryModel);
        System.out.println(page);
    }
}
