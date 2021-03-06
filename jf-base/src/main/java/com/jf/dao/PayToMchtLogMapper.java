package com.jf.dao;

import com.jf.common.base.BaseDao;
import com.jf.entity.PayToMchtLog;
import com.jf.entity.PayToMchtLogExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayToMchtLogMapper extends BaseDao<PayToMchtLog, PayToMchtLogExample> {
    int countByExample(PayToMchtLogExample example);

    int deleteByExample(PayToMchtLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayToMchtLog record);

    int insertSelective(PayToMchtLog record);

    List<PayToMchtLog> selectByExample(PayToMchtLogExample example);

    PayToMchtLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayToMchtLog record, @Param("example") PayToMchtLogExample example);

    int updateByExample(@Param("record") PayToMchtLog record, @Param("example") PayToMchtLogExample example);

    int updateByPrimaryKeySelective(PayToMchtLog record);

    int updateByPrimaryKey(PayToMchtLog record);
}
