package info.sugengbin.springboot.quartz;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import info.sugengbin.springboot.biz.QuartzTestService;
import info.sugengbin.springboot.constant.QuartzConstant;
import info.sugengbin.springboot.quartz.job.QuartzTestJob;

/**
 *
 * Date: 2017年2月22日<br/>
 * 
 * @author sugengbin
 */
@Configuration
public class QuartzTestConfig {

	@Autowired
	private QuartzConstant quartzConstant;

	@Autowired
	private QuartzTestService quartzTestService;

	// JobDetail Factory
	@Bean(name = "quartzTestJobDetailFactoryBean")
	public JobDetailFactoryBean quartzTestJobDetailFactoryBean() {
		JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
		jobDetailFactory.setJobClass(QuartzTestJob.class);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("quartzTestService", quartzTestService);
		jobDetailFactory.setJobDataAsMap(data);
		jobDetailFactory.setDurability(true);
		return jobDetailFactory;
	}

	// cron trigger factory
	@Bean(name = "quartzTestCronTriggerFactoryBean")
	public CronTriggerFactoryBean quartzTestCronTriggerFactoryBean(
			JobDetailFactoryBean jobDetailFactory) {
		CronTriggerFactoryBean cronTriggerFactory = new CronTriggerFactoryBean();
		cronTriggerFactory.setCronExpression(quartzConstant.getCron());
		cronTriggerFactory.setJobDetail(jobDetailFactory.getObject());
		return cronTriggerFactory;
	}

	// scheduler factory
	@Bean(name = "quartzTestSchedulerFactoryBean")
	public SchedulerFactoryBean quartzTestSchedulerFactoryBean(
			 JobDetailFactoryBean jobDetailFactory,
			CronTriggerFactoryBean triggerFactory) {
		SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
		scheduler.setJobDetails(jobDetailFactory.getObject());
		if (quartzConstant.getEnableTask() == 1) {
			scheduler.setTriggers(triggerFactory.getObject());
		}
		return scheduler;
	}

}
