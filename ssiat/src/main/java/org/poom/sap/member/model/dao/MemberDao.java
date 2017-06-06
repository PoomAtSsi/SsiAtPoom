package org.poom.sap.member.model.dao;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.poom.sap.member.model.vo.Member;

@Repository("memberDao")
public class MemberDao {
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public MemberDao(){}

	public Member selectLogin(Member loginVo) {
		return (Member) sqlSession.selectOne("loginSelect", loginVo);
	}
	
}
