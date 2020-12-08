package net.blueleo.markdowntohtml;

public class MarkdownLineParser {
    public static String markupLineToHtmlLine(String markupLine)
    {
        String outputHTMLLine = null;

        markupLine = markupLine.trim();

        if (markupLine.equals("")) {
            outputHTMLLine = "\n";
        } //else if()


        return outputHTMLLine;
    }
}
