package com.jf.entity;

import com.jf.common.constant.Constant;

public class PlatformCapitalAccountExt extends PlatformCapitalAccount {

	public boolean isDeleted(){
		return Constant.FLAG_TRUE.equals(getDelFlag());
	}


}
