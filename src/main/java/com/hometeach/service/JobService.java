package com.hometeach.service;

import com.hometeach.dto.Job;
import com.hometeach.util.Utils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class JobService extends AbstractWeixinService {

	@Override
	protected String getAppId(){
		return "wxa90560cdcea0cef6";
	}
	
	@Override
	protected String getSecret(){
		return "7af9730c561558e02926e6122f1ef374";
	}
	
	// 发布工作
	@Transactional
	@RequestMapping(value="/job/addJob", method=RequestMethod.POST)
	private int addJob(@RequestBody Job job){
		try{
			String openid = getOpenId(job.getOpenId());
			
			job.setOpenId(openid);
			job.setNickName(Utils.emoji2Utf8(job.getNickName()));
			weixinDao.addJob(job);
			System.out.println(job);
			int jobId = job.getJobId();
			return jobId;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	// 获取所有工作
	@RequestMapping(value="/job/getAllJobs", method=RequestMethod.GET)
	private List<LinkedHashMap> getAllJobs(){
		return Utils.refreshNickName( weixinDao.getAllJobs());
	}
}
