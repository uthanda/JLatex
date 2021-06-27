package jlatex;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;

public class LatexDocument
{
	private LatexCommand begin = new LatexCommand("begin", new LatexCurlyBraceCommandParameter(new LatexText().content("document")));
	private LatexCommand end = new LatexCommand("end", new LatexCurlyBraceCommandParameter(new LatexText().content("document")));
	
	private LatexPreamble preamble;
	private List<LatexContent> contents = new ArrayList<>();

	public void setPreamble(LatexPreamble preamble)
	{
		this.preamble = preamble;
	}

	public LatexDocument preamble(LatexPreamble preamble)
	{
		this.preamble = preamble;
		return this;
	}
	
	public LatexDocument addContent(LatexContent cont)
	{
		contents.add(cont);
		return this;
	}

	public void toLatexFile(String filename) throws FileNotFoundException, UnsupportedEncodingException
	{
		PrintWriter writer = new PrintWriter(filename + ".tex", "UTF-8");

		preamble.write(writer);
		
		writer.println();
		
		begin.write(writer);
		
		writer.println("\\maketitle");
		
		for (LatexContent cont : contents)
		{
			cont.write(writer);
		}

		writer.println();
		
		end.write(writer);
		
		writer.close();
	}
}
