package io.mike.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author zhaoming
 *
 * 2017年10月31日 下午5:00:33
 */
@Service
public class Kiko {

	@Value("${kiko.name}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
