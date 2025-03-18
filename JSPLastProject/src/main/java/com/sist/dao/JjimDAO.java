package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.commons.*;
import com.sist.vo.*;
public class JjimDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf=CreateSqlSessionFactory.getSsf();
	}
	/*
	 * 	 <select id="jjimCheckCount" resultType="int" parameterType="JjimVO">
	   SELECT COUNT(*) FROM all_jjim
	   WHERE id=#{id} AND rno=#{rno} AND type=#{type}
	 </select>
	 */
	public static int jjimCheckCount(JjimVO vo) {
		SqlSession session=null;
		int count=0;
		try {
			session=ssf.openSession();
			count=session.selectOne("jjimCheckCount",vo);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return count;
	}
}
