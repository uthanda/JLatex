package jlatex.content;

import java.io.PrintWriter;

import jlatex.LatexContent;

public class LatexNewLine extends LatexContent
{
	@Override
	public void write(PrintWriter writer)
	{
		writer.printf("%n");
	}
}
