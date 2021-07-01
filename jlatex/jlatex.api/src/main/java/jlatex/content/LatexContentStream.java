package jlatex.content;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jlatex.util.LatexContent;

public class LatexContentStream<T extends LatexContent> implements LatexContent
{
	private List<T> contents = new ArrayList<>();

	public List<T> getContents()
	{
		return contents;
	}

	public void setContents(List<T> contents)
	{
		this.contents = contents;
	}
	
	public LatexContentStream<T> addContents(List<T> contents)
	{
		this.contents.addAll(contents);
		return this;
	}
	
	public LatexContentStream<T> addContent(T content)
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
