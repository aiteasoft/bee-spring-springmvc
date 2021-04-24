/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(aiteasoft@163.com)
 * The license,see the LICENSE file.
 */

package com.automvc.enet.order.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.teasoft.bee.osql.BeeSQLException;
import org.teasoft.bee.osql.service.ObjSQLRichService;
import org.teasoft.bee.osql.service.ObjSQLService;
import org.teasoft.beex.util.CnNum;

import com.automvc.common.jquery.Result;
import com.automvc.enet.order.entity.Beeorders;

/**
 * @author AiTeaSoft.com
 * @since  1.0
 * Create on 2019-04-16 11:48:24
 */
@RestController
@RequestMapping("/beeorders")
public class BeeordersRest {
	@Autowired
	ObjSQLService objSQLService;
	
	@Autowired
	ObjSQLRichService objSQLRichService;
	
	@RequestMapping("/list")
	public Result list(Beeorders beeorders,
	     @RequestParam(value = "page", defaultValue = "1", required = false) int page, 
		 @RequestParam(value = "rows", defaultValue = "20", required = false) int rows) {	
	  Result  result =new Result();
	  try{
		  
		  System.err.println(CnNum.tranToUpper(12345678L));
		  int total=20;//test
		  List<Beeorders> list=objSQLRichService.select(beeorders, (page-1)*rows, rows);
		  result.setRows(list);
		  result.setTotal(total);
	  } catch (BeeSQLException e) {
	      System.err.println(e.getMessage());
		  result.setErrorMsg(e.getMessage());
	  }
		
	   return result;
	}
	
}
