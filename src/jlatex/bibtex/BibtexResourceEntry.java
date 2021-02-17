package jlatex.bibtex;

import jlatex.LatexContent;

public class BibtexResourceEntry extends LatexContent
{
	private String resource;
	
	public BibtexResourceEntry(String resource)
	{
		this.resource = resource;
	}
	
	@Override
	public String toLatexCode()
	{
		return String.format("\\addbibresource{%s}", resource);
	}
}
