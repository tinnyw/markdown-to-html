package net.blueleo.markdowntohtml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MarkdownToHtmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarkdownToHtmlApplication.class, args);
	}

	@GetMapping("/LOGOS")
	public String LOGOS() {
		return "LOGOS!!!!";
	}
}
