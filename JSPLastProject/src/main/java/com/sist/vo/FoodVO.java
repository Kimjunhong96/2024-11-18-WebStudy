package com.sist.vo;

import lombok.Data;

/*
 *  	이름         널?       유형             
---------- -------- -------------- 
FNO        NOT NULL NUMBER         
NAME       NOT NULL VARCHAR2(1000) 
TYPE       NOT NULL VARCHAR2(200)  
PHONE      NOT NULL VARCHAR2(100)  
ADDRESS    NOT NULL VARCHAR2(1000) 
SCORE               NUMBER(2,1)    
THEME      NOT NULL CLOB           
POSTER     NOT NULL VARCHAR2(600)  
IMAGES              VARCHAR2(4000) 
TIME                VARCHAR2(1000) 
PARKING    NOT NULL VARCHAR2(2000) 
CONTENT    NOT NULL CLOB           
HIT                 NUMBER         
PRICE               VARCHAR2(100)  
JJIMCOUNT           NUMBER         
LIKECOUNT           NUMBER         
REPLYCOUNT          NUMBER
 */
@Data
public class FoodVO {
	private int fno,hit,jjimcount,likecount,replycount;
	private double score;
	private String name,type,phone,address,theme,poster,images,time,parking,content,price;
}
