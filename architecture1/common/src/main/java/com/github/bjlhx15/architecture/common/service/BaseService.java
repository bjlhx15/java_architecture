package com.github.bjlhx15.architecture.common.service;

import com.github.bjlhx15.architecture.common.dao.BaseDAO;
import com.github.bjlhx15.architecture.common.pageutil.Page;
import com.github.bjlhx15.architecture.common.vo.BaseModel;

import java.util.List;

public class BaseService<M, QM  extends BaseModel >implements IBaseService<M, QM> {
    private BaseDAO dao = null;

    public void setDao(BaseDAO dao) {
        this.dao = dao;
    }

    public void create(M record) {
        dao.create(record);
    }

    public void update(M record) {
        dao.update(record);
    }

    public void delete(Integer uuid) {
        dao.delete(uuid);
    }

    public M getByUuid(int uuid) {
        return (M)dao.getByUuid(uuid);
    }

    public Page<M> getByConditionPage(QM record) {
        List<M> byConditionPage = dao.getByConditionPage(record);
        record.getPage().setResult(byConditionPage);
        return record.getPage();
    }
}
