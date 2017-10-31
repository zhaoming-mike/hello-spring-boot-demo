package io.mike.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhaoming
 *
 * 2017年10月31日 下午4:22:08
 */
@Component
public class Mike {

	@Value("a")
	private String name;
}
