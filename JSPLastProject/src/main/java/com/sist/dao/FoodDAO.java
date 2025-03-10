package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;
import com.sist.commons.*;
public class FoodDAO {
	private static SqlSessionFactory ssf;
	  static
	  {
		  ssf=CreateSqlSessionFactory.getSsf();
	  }
	


	  public static FoodVO foodMainHouseData()
	  {
		  SqlSession session=ssf.openSession();
		  FoodVO vo=session.selectOne("foodMainHouseData");
		  session.close();
		  return vo;
	  }
	  
	  public static List<FoodVO> foodMainHouseData8()
	  {
		  SqlSession session=ssf.openSession();
		  List<FoodVO> list=session.selectList("foodMainHouseData8");
		  session.close();
		  return list;
	  }
	
/*
 * <select id="foodListData" resultType="FoodVO" parameterType="hashMap">
   SELECT fno,name,poster,score,type,content,theme,phone,address,num
   FROM (SELECT fno,name,poster,score,type,content,theme,phone,address,rownum as num
   FROM SELECT /*+ INDEX_ASC(project_food pf_fno_pk)fno,name,poster,score,type,content,theme,phone,address
   FROM project_food))
   WHERE num BETWEEN #{start} AND #{end}
  </select>
  <select id="foodTotalPage" resultType="int">
   SELECT CEIL(COUNT(*)/20.0) FROM project_food
  </select>
 */
	public static List<FoodVO> foodListData(Map map){
		SqlSession session=ssf.openSession();
		List<FoodVO> list=session.selectList("foodListData",map);
		session.close();
		return list;
	}
	public static int foodTotalPage() {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("foodTotalPage");
		session.close();
		return total;
	}
	
	public static FoodVO foodDetailData(int fno) {
		SqlSession session=ssf.openSession(true);
		session.update("foodHitIncrement",fno);
		//session.commit();
		FoodVO vo=session.selectOne("foodDetailData",fno);
		session.close();
		return vo;
	}
	
	public static FoodVO foodCookieData(int fno) {
		SqlSession session=ssf.openSession(true);
		FoodVO vo=session.selectOne("foodDetailData",fno);
		session.close();
		return vo;
	}
	
	/*
	 * <!-- 맛집검색 -->
  <select id="foodFindData" resultType="FoodVO" parameterType="hashMap">
   SELECT fno,name,poster,score,type,content,theme,phone,address,num
   FROM (SELECT fno,name,poster,score,type,content,theme,phone,address,rownum as num
   FROM (SELECT /*+ INDEX_ASC(project_food pf_fno_pk)fno,name,poster,score,type,content,theme,phone,address
   FROM project_food WHERE ${fd} LIKE '%'||#{ss}||'%'))
   WHERE num BETWEEN #{start} AND #{end}
  </select>
  <select id="foodFindTotalPage" resultType="int" parameterType="hashMap">
   SELECT CEIL(COUNT(*)/12.0)
   FROM project_food
   WHERE ${fd} LIKE '%'||#{ss}||'%'
  </select>
	 *  
	 */
	
	
	
	public static List<FoodVO> foodFindData(Map map){
		SqlSession session=ssf.openSession();
		List<FoodVO> list=session.selectList("foodFindData",map);
		session.close();
		return list;
	}
	// SQL 
	public static int foodFindTotalPage(Map map) {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("foodFindTotalPage",map);
		session.close();
		return total;
	}
}
