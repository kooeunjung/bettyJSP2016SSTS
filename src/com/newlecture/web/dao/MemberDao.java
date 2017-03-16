package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Member;

/**
 * Member Controller
 */
public interface MemberDao {
   List<Member> getList();
   List<Member> getList(String query);
   int add(Member member);
}