package jlatex.content.text;

import java.util.List;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCommandParameter;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.content.LatexContentStream;
import jlatex.util.LatexContent;

public class LatexTextFormat<T> extends LatexCommand<LatexTextFormat<T>>
{
	private LatexContentStream<LatexContent> stream = new LatexContentStream<>();

	private LatexCurlyBraceCommandParameter contentParameter = new LatexCurlyBraceCommandParameter(stream);

	public LatexTextFormat(String name, LatexCommandParameter<?>... parameters)
	{
		super(name, parameters);
		super.addParameter(contentParameter);
	}

	@SuppressWarnings("unchecked")
	public T addContent(LatexContent content)
	{
		stream.addContent(content);
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	public T addContents(List<LatexContent> contents)
	{
		stream.addContents(contents);
		return (T) this;
	}
}