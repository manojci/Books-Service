package com.bfs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class BooksServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BooksServiceApplication.class, args);
	}

	@RequestMapping(path = "/books", method = RequestMethod.GET)
	public String getBooks() {
		return "books";
	}

}

@RefreshScope
@RestController
class MessageRestController {

    @Value("${msg:Hello world - Config Server is not working..pelase check}")
    private String msg;

    @RequestMapping("/msg")
    String getMsg() {
        return this.msg;
    }
}
