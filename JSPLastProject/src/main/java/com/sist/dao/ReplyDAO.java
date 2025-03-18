package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;
import com.sist.commons.*;
public class ReplyDAO {
	private static SqlSessionFactory ssf;
	  static
	  {
		  ssf=CreateSqlSessionFactory.getSsf();
	  }
	  /*
	   * 
	   */
	  public static List<ReplyVO> replyListData(ReplyVO vo){
		  SqlSession session=ssf.openSession();
		  List<ReplyVO> list=session.selectList("replyListData", vo);
		  session.close();
		  return list;
	  }
	  public static void replyInsert(ReplyVO vo) {
		  SqlSession session=ssf.openSession(true);
		  session.insert("replyInsert",vo);
		  session.close();
	  }
	  public static int replyCount(ReplyVO vo){
		  SqlSession session=ssf.openSession();
		  int count=session.selectOne("replyCount", vo);
		  session.close();
		  return count;
	  }
	  public static void replyDelete(int cno){
		  SqlSession session=ssf.openSession();
		  session.delete("replyDelete", cno);
		  session.close();
	  }
	  /*
	   *  UPDATE all_comment SET
	  msg=#{msg}
	  WHERE cno=#{cno}
	   */
	  public static void replyUpdate(ReplyVO vo) {
		  
	  }
}
