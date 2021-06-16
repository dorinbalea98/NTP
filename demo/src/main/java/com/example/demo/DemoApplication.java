package com.example.demo;

import com.example.demo.domain.Content;
import com.example.demo.domain.ContentType;
import com.example.demo.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContentRepository contentRepository) {
		return args -> {
			contentRepository.save(new Content("Lecu", "Zeu", ContentType.FOLDER, null, null, null));
			contentRepository.save(new Content("Ana", "Plm", ContentType.ASSET, "video", "https://youtube.com", 1L));
		};
	}
}
