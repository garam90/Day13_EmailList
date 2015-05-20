package com.sds.icto.guestbook.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.guestbook.vo.GuestBookVO;

@Repository
public class GuestBookDAO {
	
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public void insert(GuestBookVO vo){
		
		sqlMapClientTemplate.insert("guestbook.insert", vo);
		
	}

	public ArrayList<GuestBookVO> guestBookList(){
		
		ArrayList<GuestBookVO> list = new ArrayList<GuestBookVO>();
		
		list = (ArrayList<GuestBookVO>) sqlMapClientTemplate.queryForList("guestbook.getList");
		
		return list;
	}

	public void delete(int no, String password) {
		
		GuestBookVO vo = new GuestBookVO();
		vo.setNo(no);
		vo.setPassword(password);
		
		sqlMapClientTemplate.delete("guestbook.delete", vo);
		
	}
}
