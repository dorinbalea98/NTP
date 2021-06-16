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
			contentRepository.save(new Content("Tata", "Sef la bani", ContentType.FOLDER, null, null, null));
			contentRepository.save(new Content("Mama", "Sefa la dusmani", ContentType.FOLDER, null, null, null));
			contentRepository.save(new Content("Ana", "Mere", ContentType.ASSET, "video", "https://www.youtube.com/watch?v=bltCt00GGb0", 1L));
			contentRepository.save(new Content("Fiu1", "NEFIU", ContentType.FOLDER, null, null, 1L));
			contentRepository.save(new Content("Nepot1", "G", ContentType.FOLDER, null, null, 4L));
			contentRepository.save(new Content("Asta", "Black Clover", ContentType.ASSET, "video", "https://www.youtube.com/watch?v=8ll4gFYdkcA", 4L));
		};
	}
}
