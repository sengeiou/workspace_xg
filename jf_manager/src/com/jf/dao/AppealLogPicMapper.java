package com.jf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jf.entity.AppealLogPic;
import com.jf.entity.AppealLogPicExample;
@Repository
public interface AppealLogPicMapper extends BaseDao<AppealLogPic, AppealLogPicExample>{
    int countByExample(AppealLogPicExample example);

    int deleteByExample(AppealLogPicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppealLogPic record);

    int insertSelective(AppealLogPic record);

    List<AppealLogPic> selectByExample(AppealLogPicExample example);

    AppealLogPic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppealLogPic record, @Param("example") AppealLogPicExample example);

    int updateByExample(@Param("record") AppealLogPic record, @Param("example") AppealLogPicExample example);

    int updateByPrimaryKeySelective(AppealLogPic record);

    int updateByPrimaryKey(AppealLogPic record);
}