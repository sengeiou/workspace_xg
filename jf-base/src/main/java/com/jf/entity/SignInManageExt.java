package com.jf.entity;

import com.jf.common.constant.Constant;

public class SignInManageExt extends SignInManage {

	public boolean isDeleted(){
		return Constant.FLAG_TRUE.equals(getDelFlag());
	}


}
