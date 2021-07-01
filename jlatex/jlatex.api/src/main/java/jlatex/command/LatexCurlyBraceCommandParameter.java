package jlatex.command;

import jlatex.util.LatexContent;

public class LatexCurlyBraceCommandParameter extends LatexCommandParameter<LatexCurlyBraceCommandParameter>
{
	public LatexCurlyBraceCommandParameter(LatexContent content)
	{
		super('{', '}', content);
	}
}
