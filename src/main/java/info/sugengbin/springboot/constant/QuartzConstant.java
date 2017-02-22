package info.sugengbin.springboot.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * Date: 2017年2月22日<br/>
 * 
 * @author sugengbin
 */
@ConfigurationProperties(prefix = "quartz")
public class QuartzConstant {

	private Integer enableTask;
	private String cron;

	public Integer getEnableTask() {
		return enableTask;
	}

	public void setEnableTask(Integer enableTask) {
		this.enableTask = enableTask;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

}
