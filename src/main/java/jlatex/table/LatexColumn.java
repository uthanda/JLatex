package jlatex.table;

import java.io.PrintWriter;
import java.util.List;

import jlatex.content.LatexContentStream;
import jlatex.util.LatexContent;

public class LatexColumn implements LatexContent
{
	private LatexContentStream<LatexContent> contents = new LatexContentStream<>();

	public LatexContentStream<LatexContent> getContents()
	{
		return contents;
	}

	public void setContents(LatexContentStream<LatexContent>contents)
	{
		this.contents = contents;
	}

	public LatexColumn addContent(LatexContent content)
	{
		this.contents.addContent(content);
		return this;
	}
	
	public LatexColumn addContents(List<LatexContent> contents)
	{
		this.contents.addContents(contents);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		contents.write(writer);
	}

	public LatexColumn contents(LatexContentStream<LatexContent> contents)
	{
		this.setContents(contents);
		return this;
	}
}
