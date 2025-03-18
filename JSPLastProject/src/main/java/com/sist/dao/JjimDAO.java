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
/*
 *  	<insert id="jjimInsert" parameterType="JjimVO">
	 	INSERT INTO all_jjim VALUeS(
	 		aj_jno_seq.nextval,#{rno},#{type},#{id},SYSDATE
	 	)
	 </insert>
 */
	public static void jjimInsert(JjimVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession();
			session.insert("jjimInsert",vo);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	/*
	 * 
	 */
	public static List<JjimVO> jjimFoodListData(String id){
		SqlSession session=null;
		List<JjimVO>lsit=new ArrayList<JjimVO>();
		try {
			session=ssf.openSession();
			list=session.selectOne("jjimFoodListData",id);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	/*
	 *  <delete id="jjimDelete" parameterType="int">
		DELETE FROM all_jjim
		WHERE jno=#{jno}
	</delete>
	 */
	public static int jjimDelete(int jno) {
		SqlSession session=null;
		try {
			session=ssf.openSession();
			session=session.selectOne("jjimDelete",jno);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return session;
	}
}
