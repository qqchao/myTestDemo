package com.cf.demo.elastic.job;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;

public class JobDemo {

	public static void main(String[] args) throws InterruptedException {
		
		JobScheduler js = new JobScheduler(createRegistryCenter(), createJobConfiguration());
//		new JobScheduler(createRegistryCenter(), createJobConfiguration()).init();
		js.init();
		int i = 1;
		while(true){
			
//			Thread.sleep(20000);
//			js.getSchedulerFacade().shutdownInstance();
			System.out.println("Stop>>>>>>");
			Thread.sleep(1000);
			js = null;
			System.out.println("init>>>>>>");
			System.out.println(i++);
//			System.out.println(js);
//			if(js == null){			
				js = new JobScheduler(createRegistryCenter(), createJobConfiguration());
//			}
				Thread.sleep(1000);
			js.init();
		}
	}
    
    private static CoordinatorRegistryCenter createRegistryCenter() {
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("10.10.8.63:2181", "elastic-job-demo"));
        regCenter.init();
        return regCenter;
    }
    
    private static LiteJobConfiguration createJobConfiguration() {
        // 创建作业配置
    	
    	// 定义作业核心配置
        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder("mySimpleJobqc", "0/5 * * * * ?", 1).build();
        // 定义SIMPLE类型配置
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, DataStorageElasticJob.class.getCanonicalName());
        // 定义Lite作业根配置
        
        return LiteJobConfiguration.newBuilder(simpleJobConfig).build();
    }
}
