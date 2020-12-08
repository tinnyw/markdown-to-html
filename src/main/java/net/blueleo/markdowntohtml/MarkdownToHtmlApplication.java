package net.blueleo.markdowntohtml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
@RestController
//@Controller
public class MarkdownToHtmlApplication {

	public static void main(String[] args) throws IOException {
		// SpringApplication.run(MarkdownToHtmlApplication.class, args);
		convertMarkDownFileToHTML();
	}

	private static void convertMarkDownFileToHTML() throws IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream markDownFileStream = classLoader.getResourceAsStream("markdown.txt");
		InputStreamReader streamReader = new InputStreamReader(markDownFileStream, StandardCharsets.UTF_8);
		BufferedReader reader = new BufferedReader(streamReader);
		for (String line; (line = reader.readLine()) != null;) {
			System.out.println(MarkdownLineParser.markupLineToHtmlLine(line));
		}
	}

	@GetMapping("/markdown-to-html")
	public String markDownToHTML() {
		return "markdown2html.html";
	}

	@GetMapping("/LOGOS")
	public String LOGOS() {
		return "LOGOS!!!!";
	}
}
