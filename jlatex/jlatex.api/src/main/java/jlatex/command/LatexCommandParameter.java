package jlatex.command;

import java.io.PrintWriter;

import jlatex.util.LatexContent;

public abstract class LatexCommandParameter<T> implements LatexContent
{
	private final char start, end;
	private final LatexContent content;

	private boolean optional = false;

	public LatexCommandParameter(char start, char end, LatexContent content)
	{
		this.start = start;
		this.end = end;
		this.content = content;
	}

	@Override
	public void write(PrintWriter writer)
	{
		// Allow for not rendering if this parameter is optional
		if (optional && ((content != null && content.isEmpty()) || content == null))
		{
			return;
		}

		writer.write(start);

		if (content != null)
		{
			content.write(writer);
		}

		writer.write(end);
	}

	public void setOptional(boolean optional)
	{
		this.optional = optional;
	}

	@SuppressWarnings("unchecked")
	public T optional(boolean optional)
	{
		this.optional = optional;
		return (T) this;
	}
}
