package info.sugengbin.springboot.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import info.sugengbin.springboot.constant.QuartzConstant;

/**
 * scheduler factory <br/>
 * Date: 2016年8月23日<br/>
 * 
 * @author sugengbin
 */
@Component
public class QuartzTestSchedulerFactoryBean extends SchedulerFactoryBean {

	private final Logger logger = LoggerFactory.getLogger(QuartzTestSchedulerFactoryBean.class);

	@Autowired
	private QuartzTestJobDetailFactoryBean jobDetailFactory;

	@Autowired
	private QuartzTestCronTriggerFactoryBean triggerFactory;

	@Autowired
	private QuartzConstant quartzConstant;

	@Override
	public void afterPropertiesSet() throws Exception {
		setJobDetails(jobDetailFactory.getObject());
		if (quartzConstant.getEnableTask() == 1) {
			setTriggers(triggerFactory.getObject());
		}
		super.afterPropertiesSet();
	}

}
