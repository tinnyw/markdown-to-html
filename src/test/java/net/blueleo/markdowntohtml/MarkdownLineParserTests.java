package net.blueleo.markdowntohtml;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MarkdownLineParserTests {
    @Test
    // test the empty line scenario returns new line
    public void testEmptyLine() {
        String emptyMarkupLine = "  ";
        String expectedOutputHTML = "\n";
        assertThat(MarkdownLineParser.markupLineToHtmlLine(emptyMarkupLine)).isEqualTo(expectedOutputHTML);
    }

    @Test
    // test that header lines return appropriately
    public void testHeaderLine() {
        String markupHeaderLine = "## Heading 2";
        String expectedOutputHTML = "<h2>Heading 2</h2>";
        assertThat(MarkdownLineParser.markupLineToHtmlLine(markupHeaderLine)).isEqualTo(expectedOutputHTML);
    }

    @Test
    // test header lines with more than 6 hash only yield <h6>
    public void testHeaderLineCappedAt6() {
        String markupHeaderLine = "####### Only Heading 6";
        String expectedOutputHTML = "<h6>Only Heading 6</h6>";
        assertThat(MarkdownLineParser.markupLineToHtmlLine(markupHeaderLine)).isEqualTo(expectedOutputHTML);
    }

    @Test
    // test non header content outputs paragraphs
    public void testParagraph() {
        String markupHeaderLine = "Bob Saget 4 President";
        String expectedOutputHTML = "<p>Bob Saget 4 President</p>";
        assertThat(MarkdownLineParser.markupLineToHtmlLine(markupHeaderLine)).isEqualTo(expectedOutputHTML);
    }

    @Test
    // test against XSS injections
    public void testHTMLEscape() {
        String fishyMarkupline = "<script>alert('ahhh xss');</script>";
        String expectedOutputHTML = "<p>&lt;script&gt;alert(&#39;ahhh xss&#39;);&lt;/script&gt;</p>";
        assertThat(MarkdownLineParser.markupLineToHtmlLine(fishyMarkupline)).isEqualTo(expectedOutputHTML);
    }

    @Test
    // test link output is as expected
    public void testLink() {
        String markupHeaderLine = "[Best site ever!](https://www.zombo.com/)";
        String expectedOutputHTML = "<p><a href=\"https://www.zombo.com/\">Best site ever!</a></p>";
        assertThat(MarkdownLineParser.markupLineToHtmlLine(markupHeaderLine)).isEqualTo(expectedOutputHTML);
    }
}
