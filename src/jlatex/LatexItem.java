package jlatex;

import java.io.PrintWriter;

import jlatex.command.LatexCommand;

public class LatexItem extends LatexParagraph
{
	private LatexCommand item = new LatexCommand("item");
	
	@Override
	public void write(PrintWriter writer)
	{
		item.write(writer);
		super.write(writer);
	}
}
