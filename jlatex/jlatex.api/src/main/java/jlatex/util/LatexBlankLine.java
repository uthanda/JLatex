package jlatex.util;

import java.io.PrintWriter;

public class LatexBlankLine implements LatexContent
{
	@Override
	public void write(PrintWriter writer)
	{
		writer.println();
	}
}
