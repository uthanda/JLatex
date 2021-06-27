package jlatex.command;

import jlatex.LatexContent;

public abstract class LatexParenthesisCommandParameter<T> extends LatexCommandParameter<T>
{
	public LatexParenthesisCommandParameter(LatexContent content)
	{
		super('(', ')', content);
	}
}
