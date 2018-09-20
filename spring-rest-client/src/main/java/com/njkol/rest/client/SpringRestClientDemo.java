package com.njkol.rest.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.njkol.rest.client.model.User;

/**
 * 
 * @author Nilanjan Sarkar
 *
 */
public class SpringRestClientDemo {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		// testPost(restTemplate);
		// testGet(restTemplate);
		//testDelete(restTemplate);
	}

	public static void testPost(RestTemplate restTemplate) {

		String resourceUrl = "http://localhost:8181/user/create";

		User user = new User();
		user.setCity("Dubai");
		user.setFirstName("Faizi");
		user.setLastName("Mohammad");
		HttpEntity<User> request = new HttpEntity<>(user);

		// Approach 1 : Using postForObject
		// User foo = restTemplate.postForObject(resourceUrl, request, User.class);
		// System.out.println(foo);

		// Approach 2 : Using postForLocation
		// URI location = restTemplate.postForLocation(resourceUrl, request);
		// System.out.println(location);

		// Approach 3 : Using the generic exchange API
		ResponseEntity<User> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request, User.class);
		System.out.println(response);
	}

	public static void testDelete(RestTemplate restTemplate) {

		String entityUrl = "http://localhost:8181/user/delete/8";
		restTemplate.delete(entityUrl);
	}

	public static void testGet(RestTemplate restTemplate) {
		String resourceUrl = "http://localhost:8181/user/getbyid/1";
		// Approach 1 : Getting back a JSON
		// ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl +
		// "/1", String.class);
		// System.out.println(response.getBody());
		// Approach 2 : Getting back a POJO
		User response = restTemplate.getForObject(resourceUrl, User.class);
		System.out.println(response);
	}
}
