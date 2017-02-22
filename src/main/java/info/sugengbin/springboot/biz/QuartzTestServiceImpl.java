package info.sugengbin.springboot.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * Date: 2017年2月22日<br/>
 * 
 * @author sugengbin
 */
@Service
public class QuartzTestServiceImpl implements QuartzTestService {

	private final static Logger logger = LoggerFactory.getLogger(QuartzTestServiceImpl.class);

	@Override
	public void run() {
		// TODO biz code
		logger.info("do something , date:{}", System.currentTimeMillis());
	}

}
