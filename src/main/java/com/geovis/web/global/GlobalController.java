package com.geovis.web.global;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(basePath="/base-web/", value="/GlobalController",description="全局控制器")
@Controller
public class GlobalController {
	
	private static Logger logger = LoggerFactory.getLogger(GlobalController.class);
	
	
	@ApiOperation(value="/",httpMethod="GET",response=String.class,nickname="首页")
	@RequestMapping(path="/",method=RequestMethod.GET)
	public String globalIndex(){
		logger.info("globalIndex() Start | URL : /");
		return "index";
	}
	
	@RequestMapping(path="/jsp/{path1}",method=RequestMethod.GET)
	public String showJSP(@PathVariable String path1){
		logger.info("showJSP() Start | URL : /jsp/{}",path1);
		return path1;
	}
	@RequestMapping(path="/jsp/{path1}/{path2}",method=RequestMethod.GET)
	public String showJSP(@PathVariable String path1,@PathVariable String path2){
		logger.info("showJSP() Start | URL : /jsp/{}/{}",path1,path2);
		return path1+"/"+path2;
	}
	@RequestMapping(path="/jsp/{path1}/{path2}/{path3}",method=RequestMethod.GET)
	public String showJSP(@PathVariable String path1,@PathVariable String path2,@PathVariable String path3){
		logger.info("showJSP() Start | URL : /jsp/{}/{}/{}",path1,path2,path3);
		return path1+"/"+path2+"/"+path3;
	}
	@RequestMapping(path="/jsp/{path1}/{path2}/{path3}/{path4}",method=RequestMethod.GET)
	public String showJSP(@PathVariable String path1,@PathVariable String path2,@PathVariable String path3,@PathVariable String path4){
		logger.info("showJSP() Start | URL : /jsp/{}/{}/{}/{}",path1,path2,path3,path4);
		return path1+"/"+path2+"/"+path3+"/"+path4;
	}
	@RequestMapping(path="/jsp/{path1}/{path2}/{path3}/{path4}/{path5}",method=RequestMethod.GET)
	public String showJSP(@PathVariable String path1,@PathVariable String path2,@PathVariable String path3,@PathVariable String path4,@PathVariable String path5){
		logger.info("showJSP() Start | URL : /jsp/{}/{}/{}/{}/{}",path1,path2,path3,path4,path5);
		return path1+"/"+path2+"/"+path3+"/"+path4+"/"+path5;
	}

}
