package com.github.bjlhx15.architecture.customermgr.service;

import com.github.bjlhx15.architecture.common.service.BaseService;
import com.github.bjlhx15.architecture.common.service.IBaseService;
import com.github.bjlhx15.architecture.customermgr.dao.CustomerDAO;
import com.github.bjlhx15.architecture.customermgr.vo.CustomerModel;
import com.github.bjlhx15.architecture.customermgr.vo.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl
        extends BaseService<CustomerModel,CustomerQueryModel>
        implements ICustomerService{
    private CustomerDAO dao;
    @Autowired
    private void setCustomerDAO(CustomerDAO dao){
        this.dao=dao;
        super.setDao(dao);

    }
}
