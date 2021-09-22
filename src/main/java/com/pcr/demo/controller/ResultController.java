package com.pcr.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pcr.demo.entity.PcrResult;
import com.pcr.demo.model.User;

@RestController
public class ResultController {
	
	private static final Logger logger = LoggerFactory.getLogger(ResultController.class);

	@Autowired
	private RedisTemplate redisTemplate;
	
	public static final String KEY = "PCR_Result";
	
	// ajax call from front.html
	@RequestMapping(method = RequestMethod.GET, path = "/resultStoredToRedis")
	public String resultStoredToRedis(@RequestParam final HashMap<String,String> param) {
		logger.info("ResultController>resultStoredToRedis");
		System.out.println(param); //HashMap is not printed by logger.info
		
		PcrResult pcrResult= new PcrResult();
		pcrResult.setResultId((int)(Math.random()*10));
		pcrResult.setSeq(param.get("seq"));
		pcrResult.setPrimerSeq(param.get("primerSeq"));
		pcrResult.setComplementarySeq(param.get("complementarySeq"));
		pcrResult.setStart_t(param.get("start_t"));
		pcrResult.setC_primerSeq(param.get("c_primerSeq"));
		pcrResult.setProduct1_1(param.get("product1_1"));
		pcrResult.setProduct1_2(param.get("product1_2"));
		pcrResult.setProduct2_1(param.get("product2_1"));
		pcrResult.setProduct2_2(param.get("product2_2"));
		pcrResult.setProduct2(param.get("product2"));	
		
		redisTemplate.opsForHash().put(KEY,"1",pcrResult);
		List<PcrResult> pcrResult1 = redisTemplate.opsForHash().values(KEY); 
		System.out.println("pcrResult.get(0)");
		System.out.println(Arrays.toString(pcrResult1.toArray()));

		return "succeed";
	}
}
