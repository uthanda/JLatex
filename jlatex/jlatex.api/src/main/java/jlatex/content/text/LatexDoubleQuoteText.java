package jlatex.content.text;

import java.io.PrintWriter;

import jlatex.content.LatexContentStream;
import jlatex.util.LatexContent;

public class LatexDoubleQuoteText extends LatexContentStream<LatexContent>
{
	public void write(PrintWriter writer)
	{
		writer.append("``");
		super.write(writer);
		writer.append("''");
	}
}
