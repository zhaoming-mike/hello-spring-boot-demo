package io.mike;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mike.bean.Kiko;
import io.mike.bean.Mike;
import other.system.service.BusinessService;

/**
 * @author zhaoming
 *
 * 2017年10月31日 下午2:57:53
 */
@RestController
@EnableAutoConfiguration
@ComponentScan
@ImportResource(locations="classpath:old-config-for-beans.xml")
public class Launch {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private Mike mike;
	
	@Resource
	private Kiko kiko;
	
	@Autowired
	private BusinessService businessService;
	
	@RequestMapping("/")
	String home() {
		List<Map<String,Object>> queryForList = jdbcTemplate.queryForList("select count(*) as total from user");
		
		for(Map<String,Object> each : queryForList) {
			System.out.println(each.get("total"));
		}
		Set<String> keys = stringRedisTemplate.keys("*");
		for (String each : keys) {
			System.out.println("each:" + each);
		}
		
		System.out.println(ToStringBuilder.reflectionToString(mike));
		System.out.println(ToStringBuilder.reflectionToString(kiko));
		
		System.out.println(businessService);
		
		return String.valueOf(System.currentTimeMillis() + " = " + queryForList.size() );
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Launch.class, args);
	}
	
	
}
