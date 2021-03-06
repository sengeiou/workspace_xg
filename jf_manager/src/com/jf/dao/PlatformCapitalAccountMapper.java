package com.jf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jf.entity.PlatformCapitalAccount;
import com.jf.entity.PlatformCapitalAccountExample;
@Repository
public interface PlatformCapitalAccountMapper extends BaseDao<PlatformCapitalAccount, PlatformCapitalAccountExample>{
    int countByExample(PlatformCapitalAccountExample example);

    int deleteByExample(PlatformCapitalAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PlatformCapitalAccount record);

    int insertSelective(PlatformCapitalAccount record);

    List<PlatformCapitalAccount> selectByExample(PlatformCapitalAccountExample example);

    PlatformCapitalAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PlatformCapitalAccount record, @Param("example") PlatformCapitalAccountExample example);

    int updateByExample(@Param("record") PlatformCapitalAccount record, @Param("example") PlatformCapitalAccountExample example);

    int updateByPrimaryKeySelective(PlatformCapitalAccount record);

    int updateByPrimaryKey(PlatformCapitalAccount record);
}