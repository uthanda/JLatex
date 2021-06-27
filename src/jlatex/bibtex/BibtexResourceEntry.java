package jlatex.bibtex;

import java.io.PrintWriter;

import jlatex.LatexContent;

public class BibtexResourceEntry extends LatexContent
{
	private String resource;
	
	public BibtexResourceEntry(String resource)
	{
		this.resource = resource;
	}
	
	@Override
	public void write(PrintWriter writer)
	{
		writer.printf("\\addbibresource{%s}%s", resource);
	}
}
