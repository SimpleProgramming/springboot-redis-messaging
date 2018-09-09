package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.sender.RedisSender;

@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private RedisSender sender;

	@GetMapping
	public String sendDataToRedisQueue(@RequestParam("redis") String input) {
		sender.sendDataToRedisQueue(input);
		return "successfully sent";
	}
}
