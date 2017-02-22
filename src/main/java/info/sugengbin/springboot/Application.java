package info.sugengbin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import info.sugengbin.springboot.constant.QuartzConstant;

/**
 *
 * Date: 2017年2月22日<br/>
 * 
 * @author sugengbin
 */
@Configuration
@SpringBootApplication
@EnableConfigurationProperties({ QuartzConstant.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
	}

}
