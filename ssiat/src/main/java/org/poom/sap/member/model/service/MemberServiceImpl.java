package org.poom.sap.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.poom.sap.member.model.dao.MemberDao;
import org.poom.sap.member.model.vo.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	MemberDao memberDao;

	@Override
	public Member loginCheck(Member vo) {
		return memberDao.selectLogin(vo);
		
	}

	@Override
	public int insertMember(Member member) {
		return memberDao.insertMember(member);
	}

}
