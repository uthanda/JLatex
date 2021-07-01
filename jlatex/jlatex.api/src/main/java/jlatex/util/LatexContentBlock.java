package jlatex.util;

import java.util.ArrayList;
import java.util.List;

import jlatex.command.LatexCommandParameter;

public class LatexContentBlock<T> extends LatexBlock<T, LatexContent>
{
	private List<LatexContent> contents = new ArrayList<>();

	protected LatexContentBlock(String name, LatexCommandParameter<?>... parameters)
	{
		super(name, parameters);
	}

	@Override
	protected Iterable<LatexContent> getContents()
	{
		return contents;
	}

	@SuppressWarnings("unchecked")
	public T addContent(LatexContent content)
	{
		this.contents.add(content);
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	public T addContents(List<LatexContent> contents)
	{
		this.contents.addAll(contents);
		return (T) this;
	}
}
