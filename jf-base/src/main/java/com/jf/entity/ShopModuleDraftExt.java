package com.jf.entity;

import com.jf.common.constant.Constant;

public class ShopModuleDraftExt extends ShopModuleDraft {

	public boolean isDeleted(){
		return Constant.FLAG_TRUE.equals(getDelFlag());
	}


}
