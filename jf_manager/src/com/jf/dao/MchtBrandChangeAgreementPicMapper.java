package com.jf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jf.entity.MchtBrandChangeAgreementPic;
import com.jf.entity.MchtBrandChangeAgreementPicExample;
@Repository
public interface MchtBrandChangeAgreementPicMapper extends BaseDao<MchtBrandChangeAgreementPic, MchtBrandChangeAgreementPicExample>{
    int countByExample(MchtBrandChangeAgreementPicExample example);

    int deleteByExample(MchtBrandChangeAgreementPicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MchtBrandChangeAgreementPic record);

    int insertSelective(MchtBrandChangeAgreementPic record);

    List<MchtBrandChangeAgreementPic> selectByExample(MchtBrandChangeAgreementPicExample example);

    MchtBrandChangeAgreementPic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MchtBrandChangeAgreementPic record, @Param("example") MchtBrandChangeAgreementPicExample example);

    int updateByExample(@Param("record") MchtBrandChangeAgreementPic record, @Param("example") MchtBrandChangeAgreementPicExample example);

    int updateByPrimaryKeySelective(MchtBrandChangeAgreementPic record);

    int updateByPrimaryKey(MchtBrandChangeAgreementPic record);
}