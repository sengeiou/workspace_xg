package com.jf.entity;

import com.jf.common.constant.Constant;

public class MchtInfoChgExt extends MchtInfoChg {

	public boolean isDeleted(){
		return Constant.FLAG_TRUE.equals(getDelFlag());
	}


}
