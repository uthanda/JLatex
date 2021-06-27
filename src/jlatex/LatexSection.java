package jlatex;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;

public class LatexSection extends LatexContent
{
	private LatexText name = new LatexText();
	private LatexCurlyBraceCommandParameter nameParameter = new LatexCurlyBraceCommandParameter(name);
	private LatexCommand section = new LatexCommand("section",nameParameter);
	
	private List<LatexContent> contents = new ArrayList<>();

	public LatexSection addContent(LatexContent cont)
	{
		contents.add(cont);
		return this;
	}

	public String getName()
	{
		return name.getContent();
	}
	
	public void setName(String name) {
		this.name.setContent(name);
	}
	
	public LatexSection name(String name) {
		this.name.setContent(name);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		section.write(writer);
		
		for (LatexContent s : contents)
		{
			s.write(writer);
			writer.println();
		}
	}
}
