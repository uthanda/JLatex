package jlatex.content;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jlatex.LatexContent;

public class LatexContentStream extends LatexContent
{
	private List<LatexContent> contents = new ArrayList<>();

	public List<LatexContent> getContents()
	{
		return contents;
	}

	public void setContents(List<LatexContent> contents)
	{
		this.contents = contents;
	}
	
	public LatexContentStream addContents(List<LatexContent> contents)
	{
		this.contents.addAll(contents);
		return this;
	}
	
	public LatexContentStream addContent(LatexContent content)
	{
		this.contents.add(content);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		contents.forEach(content -> content.write(writer));
	}
}
