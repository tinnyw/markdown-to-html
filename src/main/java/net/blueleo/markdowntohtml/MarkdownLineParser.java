package net.blueleo.markdowntohtml;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkdownLineParser {
    private static final String HEADER_MATCHER_REGEX = "^#+";

    /**
     * Convert a markup line to an output HTML line
     *
     * @param markupLine
     * @return
     */
    public static String markupLineToHtmlLine(String markupLine)
    {
        // create output line
        String outputHTMLLine = "";
        //go ahead trim the prepended and appended whitespaces in case of glitches
        markupLine = markupLine != null ? markupLine.trim() : "";
        String headerGroup = findHeaderGroup(markupLine);

        if (markupLine.equals("")) {
            // if empty line then output new line
            outputHTMLLine = "\n";
        }
        else if (headerGroup != null) { // make a header line
            // if the header size is greater than 6, cap it to 6
            int headerSize = headerGroup.length();
            if (headerSize > 6) headerSize = 6;

            String markupLineContent = markupLine.replaceFirst(HEADER_MATCHER_REGEX, "").trim();
            outputHTMLLine = String.format("<h%d>%s</h%d>", headerSize, markupLineContent, headerSize);
        } else { // make a paragraph line
            outputHTMLLine = String.format("<p>%s</p>", markupLine);
        }

        return outputHTMLLine;
    }

    // match the header substring in a markup line and return it (e.g. "###" and not the contents past the header)
    private static String findHeaderGroup(String markupLine) {
        // now create the se
        Matcher patternHeaderSearch = Pattern.compile(HEADER_MATCHER_REGEX).matcher(markupLine);

        if (patternHeaderSearch.find()) {
            return patternHeaderSearch.group();
        }

        return null;
    }
}
