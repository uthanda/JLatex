package jlatex.organization;

import java.io.PrintWriter;

import jlatex.command.LatexSimpleCommand;
import jlatex.content.LatexContentStream;
import jlatex.util.LatexContent;

public class LatexParagraph extends LatexContentStream<LatexContent>
{
	@Override
	public void write(PrintWriter writer)
	{
		super.write(writer);
		new LatexSimpleCommand("par",false).write(writer);
	}
}
