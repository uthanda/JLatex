package jlatex.command;

import jlatex.LatexContent;

public class LatexSquareBracketCommandParameter extends LatexCommandParameter<LatexSquareBracketCommandParameter>
{
	public LatexSquareBracketCommandParameter(LatexContent content)
	{
		super('[', ']', content);
	}
}
