package jlatex.content.text;

import java.util.List;

import jlatex.LatexContent;
import jlatex.command.LatexCommand;
import jlatex.command.LatexCommandParameter;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.content.LatexContentStream;

public class LatexTextFormat<T> extends LatexCommand
{
	private LatexContentStream stream = new LatexContentStream();

	private LatexCurlyBraceCommandParameter contentParameter = new LatexCurlyBraceCommandParameter(stream);

	public LatexTextFormat(String name, LatexCommandParameter<?>... parameters)
	{
		super(name, parameters);
		super.addParameter(contentParameter);
	}
	
	@SuppressWarnings("unchecked")
	public T addContent(LatexContent content) {
		stream.addContent(content);
		return (T)this;
	}
	
	@SuppressWarnings("unchecked")
	public T addContents(List<LatexContent> contents) {
		stream.addContents(contents);
		return (T)this;
	}
}