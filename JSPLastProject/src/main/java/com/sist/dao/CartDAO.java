package com.sist.dao;
/*
 *  <insert id="cartInsert" parameterType="CartVO">
		INSERT INTO cart VALUES(
		  cart_cno_seq.nextval,#{gno},#{id},#{account},#{price},'n',SYSDATE
		)
	</insert>
	
	<select id="cartListData" resultMap="cartMap" parameterType="string">
		SELECT cno,goods_name,goods_poster,goods_price,account,price 
		FROM cart c,goods_all g
		WHERE c.gno=g.no
		AND id=#{id} AND isbuy='n'
	</select>
	<update id="cartUpdate" parameterType="hashMap">
		UPDATE cart SET
		account=account+#{account}
		WHERE gno=#{gno} AND id=#{id}
	</update>
	<delete id="cartCancel" parameterType="int">
		DELETE FROM cart
		WHERE cno=#{cno}
	</delete>
 */
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;
import com.sist.commons.*;
public class CartDAO {
	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	public static void cartInsert(CartVO vo) {
		SqlSession session=ssf.openSession(true);
		int count=session.selectOne("cartCount",vo);
		if(count==0) {
			session.insert("cartInsert",vo);
		}
		else {
			session.update("cartUpdate",vo);
		}
		session.close();
	}
	public static List<CartVO> cartListData(String id){
		SqlSession session=ssf.openSession(true);
		List<CartVO> list=session.selectList("cartListData", id);
		session.close();
		return list;
	}
	/*
	 * <select id="buyListData" resultMap="cartMap" parameterType="string">
		SELECT cno,goods_name,goods_poster,goods_price,account,price 
		FROM cart c,goods_all g
		WHERE c.gno=g.no
		AND id=#{id} AND isbuy='y'
		ORDER BY cno DESC
	</select>
	 */
	public static List<CartVO> buyListData(String id){
		SqlSession session=ssf.openSession(true);
		List<CartVO> list=session.selectList("buyListData", id);
		session.close();
		return list;
	}
	public static void cartUpdate(Map map) {
		SqlSession session=ssf.openSession(true);
		session.update("cartUpdate",map);
		session.close();
	}
	
	public static void cartCancel(int cno) {
		SqlSession session=ssf.openSession(true);
		session.delete("cartCancel",cno);
		session.close();
	}
	/*
	 * 	<insert id="cartInsert" parameterType="CartVO">
		INSERT INTO cart VALUES(
		  cart_cno_seq.nextval,#{gno},#{id},#{account},#{price},'n',SYSDATE
		)
	</insert>
	 */
	public static void buyInsert(CartVO vo) {
		SqlSession session=ssf.openSession(true);
		session.insert("buyInsert",vo);
		session.close();
	}
}
