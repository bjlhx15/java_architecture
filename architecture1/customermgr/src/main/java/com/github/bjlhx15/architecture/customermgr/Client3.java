package com.github.bjlhx15.architecture.customermgr;

import com.github.bjlhx15.architecture.common.pageutil.Page;
import com.github.bjlhx15.architecture.customermgr.service.ICustomerService;
import com.github.bjlhx15.architecture.customermgr.vo.CustomerModel;
import com.github.bjlhx15.architecture.customermgr.vo.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Client3 {
    @Autowired
    private ICustomerService s;

    //有事务的时候代理出错，使用一下
    public ICustomerService getS() {
        return s;
    }

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        Client3 client=(Client3)ctx.getBean("client3");
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

        Page<CustomerModel> page = client.getS().getByConditionPage(queryModel);
        System.out.println(page);
    }
}
