package com.jf.entity;

import com.jf.common.constant.Constant;

public class FavoritesProductTypeExt extends FavoritesProductType {

	public boolean isDeleted(){
		return Constant.FLAG_TRUE.equals(getDelFlag());
	}


}