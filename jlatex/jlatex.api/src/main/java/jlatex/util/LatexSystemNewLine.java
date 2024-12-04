package jlatex.util;

import java.io.PrintWriter;

/**
 * Represents a simple newline (characters 0xA, 0xB or 0xA0xB).
 * 
 * @author Michael Oland
 *
 */
public class LatexSystemNewLine implements LatexContent
{
	@Override
	public void write(PrintWriter writer)
	{
		writer.printf("%n");
	}
}
