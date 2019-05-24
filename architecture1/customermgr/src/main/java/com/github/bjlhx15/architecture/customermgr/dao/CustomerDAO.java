package com.github.bjlhx15.architecture.customermgr.dao;

import com.github.bjlhx15.architecture.customermgr.vo.CustomerModel;
import com.github.bjlhx15.architecture.customermgr.vo.CustomerQueryModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO {
    void create(CustomerModel record);
    void update(CustomerModel record);
    void delete(Integer uuid);
    CustomerModel getByUuid(int uuid);
    List<CustomerModel> getByConditionPage(CustomerQueryModel record);
}
