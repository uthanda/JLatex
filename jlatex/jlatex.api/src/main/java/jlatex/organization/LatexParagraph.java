package jlatex.organization;

import java.io.PrintWriter;

import jlatex.command.LatexSimpleCommand;
import jlatex.content.LatexContentStream;
import jlatex.content.LatexText;
import jlatex.util.LatexContent;

/**
 * Represents a paragraph of text as a stream of LatexContent ended with a \\par command.
 * 
 * @author Michael Oland
 *
 */
public class LatexParagraph extends LatexContentStream<LatexParagraph,LatexContent>
{
	private boolean writeNewLine = true;
	
	@Override
	public void write(PrintWriter writer)
	{
		super.write(writer);
		
		new LatexSimpleCommand("par",writeNewLine).write(writer);
		
		if(!writeNewLine)
		{
			new LatexText().content(" ").write(writer);
		}
	}
	
	public LatexParagraph withNewLine()
	{
		this.writeNewLine = true;
		return this;
	}
	
	public LatexParagraph withoutNewLine()
	{
		this.writeNewLine = false;
		return this;
	}
}
