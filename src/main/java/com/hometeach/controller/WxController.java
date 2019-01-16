package com.hometeach.controller;

import com.hometeach.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenguifeng on 2019/1/16.
 */
@RestController
public class WxController {

	@Autowired
	EntityService entityService;

	// 根据key查找数据
	@RequestMapping(value = "/{tableName}/findEntity", method = RequestMethod.POST)
	public List<LinkedHashMap> showService(@PathVariable("tableName") String tableName, @RequestBody Map<String, Object> map){
		return entityService.showService(tableName, map);

	}

	// 查询所有数据，目前分页在客户端做，将来可以考虑服务端做
	@RequestMapping(value = "/{tableName}/showEntitys", method = RequestMethod.POST)
	public List<LinkedHashMap> showAllService(@PathVariable("tableName") String tableName){
		return entityService.showAllService(tableName);
	}

	// 查询关联表的数据
	@RequestMapping(value = "/showSpecialService", method = RequestMethod.POST)
	public List<LinkedHashMap> showSpecialService(@RequestBody Map<String, Object> map){
		return entityService.showSpecialService(map);
	}

	// 搜索功能
	@RequestMapping(value = "/{tableName}/search", method = RequestMethod.POST)
	public List<LinkedHashMap> search(@PathVariable("tableName") String tableName, @RequestBody Map<String, Object> map){
		return entityService.search(tableName, map);
	}
}
