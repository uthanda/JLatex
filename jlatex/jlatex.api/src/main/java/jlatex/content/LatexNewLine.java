package jlatex.content;

import java.io.PrintWriter;

import jlatex.util.LatexContent;

public class LatexNewLine implements LatexContent
{
	@Override
	public void write(PrintWriter writer)
	{
		writer.printf("%n");
	}
}
