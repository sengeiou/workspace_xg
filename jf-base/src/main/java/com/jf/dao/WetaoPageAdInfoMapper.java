package com.jf.dao;

import com.jf.common.base.BaseDao;
import com.jf.entity.WetaoPageAdInfo;
import com.jf.entity.WetaoPageAdInfoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WetaoPageAdInfoMapper extends BaseDao<WetaoPageAdInfo, WetaoPageAdInfoExample> {
    int countByExample(WetaoPageAdInfoExample example);

    int deleteByExample(WetaoPageAdInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WetaoPageAdInfo record);

    int insertSelective(WetaoPageAdInfo record);

    List<WetaoPageAdInfo> selectByExample(WetaoPageAdInfoExample example);

    WetaoPageAdInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WetaoPageAdInfo record, @Param("example") WetaoPageAdInfoExample example);

    int updateByExample(@Param("record") WetaoPageAdInfo record, @Param("example") WetaoPageAdInfoExample example);

    int updateByPrimaryKeySelective(WetaoPageAdInfo record);

    int updateByPrimaryKey(WetaoPageAdInfo record);
}
