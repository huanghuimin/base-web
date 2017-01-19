package com.geovis.web.global;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class ControllerResult {
	private static Logger logger = LoggerFactory.getLogger(ControllerResult.class);
	
	/**
	 * 打印输出字符串,支持跨域处理
	 * @param response
	 * @param request
	 * @param msg
	 */
	public static void print(HttpServletResponse response, HttpServletRequest request, String msg) {
		try {
			//处理跨域请求
			String jsonpcallback = request.getParameter("jsoncallback");
			if (jsonpcallback != null) {
				msg = jsonpcallback + "(" + msg + ")";
			}

			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter writer = response.getWriter();
			
			logger.debug(msg);
			
			writer.print(msg);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			logger.error("打印输出异常："+e.getMessage());
		}
	}
	
	/**
	 * 打印json输出object对象，输出形式外层包裹JsonResult对象
	 * @param response
	 * @param request
	 * @param obj
	 */
	public static void printJson(HttpServletResponse response, HttpServletRequest request, Object obj) {
		String msg = JSON.toJSONString(outputJsonObject(obj));
		print(response, request, msg);
	}

	/**
	 * 打印json输出数组对象，输出形式外层包裹JsonResult对象
	 * @param response
	 * @param request
	 * @param coll
	 */
	public static void printJson(HttpServletResponse response, HttpServletRequest request, Collection<?> coll) {
		String msg = JSON.toJSONString(outputJsonArray(coll));
		print(response, request, msg);
	}

	public static JsonResult outputJsonObject(Object obj) {
		int count = 0;
		if (obj != null) {
			count = 1;
		}
		return new JsonResult(JsonResult.SUCCESS_TRUE, obj, count);
	}

	public static JsonResult outputJsonArray(Collection<?> coll) {
		int count = 0;
		if (coll != null) {
			count = coll.size();
		}
		
		return new JsonResult(JsonResult.SUCCESS_TRUE, coll, count);
	}

	public static JsonResult outputError(String msg) {
		return new JsonResult(JsonResult.SUCCESS_FALSE, msg, 0);
	}
	
	public static JsonResult outputSting(String msg) {
		return new JsonResult(JsonResult.SUCCESS_TRUE, msg, 0);
	}

	/**
	 * 返回标准格式json对象结果
	 * @author hhm
	 *
	 */
	public static class JsonResult {
		public static String SUCCESS_TRUE = "true";
		public static String SUCCESS_FALSE = "false";

		//结果是否正确标志：true或false
		public String success;

		//结果内容，可为单个对象或多个对象数组
		public Object results;

		//结果内容个数
		public Integer count;

		public JsonResult(String success, Object results, Integer count) {
			super();
			this.success = success;
			this.results = results;
			this.count = count;
		}

	}
}
