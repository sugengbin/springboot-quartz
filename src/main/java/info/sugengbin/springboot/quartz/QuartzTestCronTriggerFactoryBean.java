package info.sugengbin.springboot.quartz;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.stereotype.Component;

import info.sugengbin.springboot.constant.QuartzConstant;

/**
 * job register <br/>
 * Date: 2016年8月23日<br/>
 * 
 * @author sugengbin
 */
@Component
public class QuartzTestCronTriggerFactoryBean extends CronTriggerFactoryBean {

	private final Logger logger = LoggerFactory.getLogger(QuartzTestCronTriggerFactoryBean.class);
	
	@Autowired
	private QuartzTestJobDetailFactoryBean jobDetailFactory;

	@Autowired
	private QuartzConstant quartzConstant;

	@Override
	public void afterPropertiesSet() throws ParseException {
		setCronExpression(quartzConstant.getCron());
		setJobDetail(jobDetailFactory.getObject());
		super.afterPropertiesSet();
	}

}
