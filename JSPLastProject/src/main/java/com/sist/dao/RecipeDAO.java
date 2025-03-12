package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;
import com.sist.commons.*;

public class RecipeDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	public static ChefVO recipeTodayChef() {
		ChefVO vo=null;
		SqlSession session=null;
		try
		{
			session=ssf.openSession();
			vo=session.selectOne("recipeTodayChef");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return vo;
	}
	public static List<RecipeVO> recipeData7(){
		List<RecipeVO> list=null;
		SqlSession session=null;
		try
		{
			session=ssf.openSession();
			list=session.selectOne("recipeTodayChef");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	public static List<RecipeVO> recipeData(Map	map){
		List<RecipeVO> list=null;
		SqlSession session=null;
		try
		{
			session=ssf.openSession();
			list=session.selectOne("recipeData7");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public static int recipeTotalPage() {
		int total=0;
		SqlSession session=null;
		try
		{
			session=ssf.openSession();
			total=session.selectOne("recipeTotalPage");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return total;
	}
	
	public static List<RecipeVO> recipeListData(Map map){
		List<RecipeVO> list=null;
		SqlSession session=null;
		try
		{
			session=ssf.openSession();
			list=session.selectList("recipeListData", map);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static List<ChefVO> recipeChefListData(Map map){
		SqlSession session=ssf.openSession();
		List<ChefVO> list=session.selectList("recipeChefList");
		session.close();
		return list;
	}
	public static int recipeChefTotalPage() {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("recipeChefTotalPage");
		session.close();
		return total;
	}
	 public static List<RecipeVO> recipeFindData(Map map)
	  {
		  SqlSession session=ssf.openSession();
		  List<RecipeVO> list=session.selectList("recipeFindData",map);
		  session.close();
		  return list;
	  }
}
