package com.github.bjlhx15.architecture.customermgr.dao;

import com.github.bjlhx15.architecture.common.dao.BaseDAO;
import com.github.bjlhx15.architecture.customermgr.vo.CustomerModel;
import com.github.bjlhx15.architecture.customermgr.vo.CustomerQueryModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends BaseDAO<CustomerModel,CustomerQueryModel> {
}
