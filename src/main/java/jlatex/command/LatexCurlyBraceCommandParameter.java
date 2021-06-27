package jlatex.command;

import jlatex.LatexContent;

public class LatexCurlyBraceCommandParameter extends LatexCommandParameter<LatexCurlyBraceCommandParameter>
{
	public LatexCurlyBraceCommandParameter(LatexContent content)
	{
		super('{', '}', content);
	}
}
