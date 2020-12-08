package net.blueleo.markdowntohtml;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MarkdownLineParserTests {
    @Test
    public void testEmptyLine() {
        String emptyMarkupLine = "  ";
        String expectedOutputHTML = "\n";
        assertThat(MarkdownLineParser.markupLineToHtmlLine(emptyMarkupLine)).isEqualTo(expectedOutputHTML);
    }

    @Test
    public void testHeaderLine() {
        String markupHeaderLine = "## Heading 2";
        String expectedOutputHTML = "<h2>Heading 2</h2>";
        assertThat(MarkdownLineParser.markupLineToHtmlLine(markupHeaderLine)).isEqualTo(expectedOutputHTML);
    }
}
