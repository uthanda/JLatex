package jlatex.command;

import jlatex.util.LatexContent;

public class LatexSquareBracketCommandParameter extends LatexCommandParameter<LatexSquareBracketCommandParameter>
{
	public LatexSquareBracketCommandParameter(LatexContent content)
	{
		super('[', ']', content);
	}
}
