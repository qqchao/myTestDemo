package com.cf.demo.elastic.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

public class DataStorageElasticJob implements SimpleJob{

	@Override
	public void execute(ShardingContext arg0) {
		
		System.out.println(arg0);
		
	}

	
}
