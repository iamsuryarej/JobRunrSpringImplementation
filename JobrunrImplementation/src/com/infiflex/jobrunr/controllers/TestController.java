package com.infiflex.jobrunr.controllers;

import java.time.Instant;

import org.jobrunr.configuration.JobRunr;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/testing")
public class TestController {
	@Autowired
	JobScheduler jobscheduler;
	@GetMapping("/test")
	public String test()
	{
		jobscheduler.enqueue(() -> System.out.println("Hello, world!"));
		BackgroundJob.enqueue(() -> System.out.println("Hello, world! for the 2nd time"));
		BackgroundJob.schedule(Instant.now().plusMillis(5000), 
				  ()-> System.out.println("surya"));
		
		return "test successful";
	}

}
