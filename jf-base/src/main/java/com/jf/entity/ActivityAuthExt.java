package com.jf.entity;

import com.jf.common.constant.Constant;

public class ActivityAuthExt extends ActivityAuth {

	public boolean isDeleted(){
		return Constant.FLAG_TRUE.equals(getDelFlag());
	}


}
