package com.geovis.web.global;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wordnik.swagger.annotations.Api;

@Api(hidden=false, value = "")
@Controller
@RequestMapping("/error")
public class GlobalControllerException {
	
	private Logger logger = LoggerFactory.getLogger(GlobalControllerException.class);

	@RequestMapping("/500")
	public void error500(HttpServletResponse response, HttpServletRequest request){
		Exception ex = (Exception)request.getAttribute("exception");
		logger.error("程序异常500",ex);
		ControllerResult.print(response,request,"500,系统出错，请稍后在试！");
	}
	
	@RequestMapping("/404")
	public void error404(HttpServletResponse response, HttpServletRequest request){
		
		ControllerResult.print(response,request,"404,您访问的页面不存在！");
	}
	@RequestMapping("/400")
	public void error400(HttpServletResponse response, HttpServletRequest request){
		
		ControllerResult.print(response,request,"400,请求参数异常！");
	}
}
