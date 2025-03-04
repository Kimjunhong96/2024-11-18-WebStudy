<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	1) 데이터베이스 => 테이블 => 크롤링
	2) GIT => Repository (조별) => Full (템플릿)
	3) => mainpage / join / login
	
	1. 라이브러리 로드 
	   <script src="http://code.jquery.com/jquery.js">
	   => 라이브러리 충돌
	   => main.jsp에 추가
	2. jquery는 자바스크립트 라이브러리
	   1) 변수설정 => var / let / const: 서버에서 데이터 읽기
	   2) 데이터형 : number / string / date / boolean / object:{},[]
	   3) 연산자 : 자바스크립트 이용
	     => 형변환
	   4) 제어문    
	      if / if~else
	      for => 일반 for
	      for-each => map / forEach
	   5) 서버에서 데이터 전송을 받는 경우 => Ajax
	      => 검색 : List =>[]
	      => VO : 
	      
	   6) 객체모델 / 문서 모델 =>
	   
	   
	 jquery
	 ------
	 
	 1) selector
	    태그명 : $('태그명') = 멀티
	    아이디명 : $('#아이디명') = 싱글
	    클래스명 : $('.클래스명') = 멀티
	           -------------------- 해당 태그 $(this)
	   => CSS
	      후손 / 자손 => $('태그명>태그명') $('태그명 태그명')
	      속성 => $('태그명[속성=값]')
	      가상선택자 => 목록 (table , dl , ul)
	                $('li:eq(0)')
	                $('li:nth-child(1)')
	                
	 2) 태그 제어
	    = 감추기 / 보여주기 
	      display: '' / display:none
	       show           hide
	    = 태그와 태그 사이 값 읽기 / 쓰기
	      <td>aaa</td> =>
	   
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
let httpRequest=null
function getXMLHttpRequest(){
	// 브라우저에서 HttpXMLRequest객체 읽기 
	// 브라우저마다 객체명이 다르다 
	if(window.XMLHttpRequest) // null이 아니면
	{
		// 크롬 / FF
		return new XMLHttpRequest()
		// XMLHttpRequest : 서버에 요청 => 결과값을 읽어오는 역할
		// $.ajax({})
	}
	else
	{
		return null
	}
}
// 전송 => 수신
function sendRequest(url,params,callback,method){
	// callback => 시스템에 의해 자동 호출되는 함수 => 결과값을 받아서 출력 
	/*
		$.ajax({
			url: ,
			type : ,
			data : {},
			success : function(){
				// 데이터 받아서 출력
			}
		})
		
		// => Vue / React
		axios.get(url,{params}).then(function(){})
		axios.post(url,{params}).then(function(){})
	*/
	// 1. 객체 생성 
	httpRequest=getXMLHttpRequest()
	
	// 2. method방식 지정
	let httpMethod=method?method:'GET'
	if(httpMethod!='GET' && httpMethod!='POST'){
		httpMethod='GET'
	}
	// Param 처리 => ?id=admin
	let httpParams=(params==null||params=="")?null:params
	// URL 처리
	let httpUrl=url
	// GET방식이고 전송할 데이터가 있는 경우 
	if(httpMethod==='GET' && httpParams!=null)
	{
		httpUrl=httpUrl+"?"+httpParams		
	}
	// 서버연결 => open함수는 이미 제작됨 
	httpRequest.open(httpMethod,httpUrl,true)
	// true => 비동기 , false => 동기 
	// 한글 처리 
	httpRequest.setRequestHeader('Content-Type','application/x--www-form-urlencoded')
	// 자동호출되는 함수 지정
	httpRequest.onreadystatechange=callback
	// 데이터 전송
	httpRequest.send(httpMethod==='POST'?httpParams:null)
	// 데이터 읽기 : responseText / responseXML(JSON)
}
function send()
{
	sendRequest('sub.jsp',null,ok,'POST') // 요청
	
}
function ok(){
	/*
		0 => 서버 연결 준비
		1 => 서버 연결 => open
		2 => 서버 연결 완료
		3 => 데이터 전송 준비 => send()
		4 => 데이터 전송 완료 
	*/
	if(httpRequest.readyState===4){
		if(httpRequest.status===200){
			// status => 정상 수행 (200) , 404,403,500...
			let div=document.querySelector("#print")
			div.innerHTML=httpRequest.responseText
		}
	}
}

</script>
</head>
<body>
  <button onclick="send()">전송</button>
  <div id="print"></div>
</body>
</html>