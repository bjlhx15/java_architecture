package com.github.bjlhx15.architecture.common.service;

import com.github.bjlhx15.architecture.common.pageutil.Page;
import com.github.bjlhx15.architecture.common.vo.BaseModel;

import java.util.List;

public interface IBaseService<M,QM extends BaseModel> {
    void create(M record);
    void update(M record);
    void delete(Integer uuid);
    M getByUuid(int uuid);
    Page<M> getByConditionPage(QM record);
}
