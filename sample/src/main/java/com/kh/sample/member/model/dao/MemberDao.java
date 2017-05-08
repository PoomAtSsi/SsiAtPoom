package com.kh.sample.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sample.member.model.vo.Member;

@Repository("memberDao")
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public MemberDao(){}

	public Member selectLogin(Member loginVo) {
		 System.out.println("dao : selectLogin run...");
		return (Member) sqlSession.selectOne("loginSelect", loginVo);
	}
	
}
