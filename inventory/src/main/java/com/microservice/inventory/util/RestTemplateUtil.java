package com.microservice.inventory.util;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.microservice.inventory.InventoryConstants;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class RestTemplateUtil {
	@Autowired
	private HttpServletRequest request;

	public <T> T postForObject(String url, Object body, Class<T> responseType) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        headers.add("Authorization", request.getHeader(InventoryConstants.TOKEN_HEADER));
        HttpEntity<String> entity = new HttpEntity(body, headers);
		return restTemplate.postForObject(url, entity, responseType);	
	}
	
}
