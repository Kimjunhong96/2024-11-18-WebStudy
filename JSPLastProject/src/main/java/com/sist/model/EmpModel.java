package com.sist.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.EmpDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.sist.vo.*;
@Controller
public class EmpModel {
	@RequestMapping("mybais/emp_info.do")
	public String emp_info(HttpServletRequest request,HttpServletResponse response) {
		List<EmpVO> list=EmpDAO.empGetEnameData();
		request.setAttribute("list", list);
		return "../mybatis/emp_info.jsp";
	}
	@RequestMapping("mybatis/emp_result.do")
	public String emp_result(HttpServletRequest request,HttpServletResponse response) {
		String[] empnos=request.getParameterValues("empno");
		Map map=new HashMap();
		map.put("empnos", empnos);
		List<EmpVO> list=EmpDAO.empFindData(map);
		request.setAttribute("list", list);
		return "../mybatis/emp_result.jsp";
	}
}
