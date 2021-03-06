package com.jf.service;

import com.jf.common.base.BaseService;
import com.jf.dao.MemberSupplementarySignInMapper;
import com.jf.entity.MemberSupplementarySignIn;
import com.jf.entity.MemberSupplementarySignInExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberSupplementarySignInService extends BaseService<MemberSupplementarySignIn, MemberSupplementarySignInExample> {
	@Autowired
	private MemberSupplementarySignInMapper memberSupplementarySignInMapper;
	@Autowired
	public void setMemberSupplementarySignInMapper(MemberSupplementarySignInMapper memberSupplementarySignInMapper) {
		this.setDao(memberSupplementarySignInMapper);
		this.memberSupplementarySignInMapper = memberSupplementarySignInMapper;
	}
	
}
