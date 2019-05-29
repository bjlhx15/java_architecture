package com.github.bjlhx15.architecture.common.dao;

import java.util.List;

public interface BaseDAO<M,QM> {
    void create(M record);
    void update(M record);
    void delete(Integer uuid);
    M getByUuid(int uuid);
    List<M> getByConditionPage(QM record);
}
