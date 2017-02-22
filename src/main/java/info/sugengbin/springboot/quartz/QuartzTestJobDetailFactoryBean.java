package info.sugengbin.springboot.quartz;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import info.sugengbin.springboot.biz.QuartzTestService;
import info.sugengbin.springboot.quartz.job.QuartzTestJob;

/**
 * 
 *
 * Date: 2017年2月22日<br/>
 * 
 * @author sugengbin
 */
@Component
public class QuartzTestJobDetailFactoryBean extends JobDetailFactoryBean {

	@Autowired
	private QuartzTestService quartzTestService;

	@Override
	public void afterPropertiesSet() {
		setJobClass(QuartzTestJob.class);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("quartzTestService", quartzTestService);
		setJobDataAsMap(data);
		setDurability(true);
		super.afterPropertiesSet();
	}
}
