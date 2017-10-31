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
	
	@Value("${mike.name}")
	private String name;
	
	@Value("#{kiko.name}")
	private String namea;
	
	@Value("#{'${kiko.name}'}")
	private String nameb;
	
}
