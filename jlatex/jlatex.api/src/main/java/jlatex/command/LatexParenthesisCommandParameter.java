package jlatex.command;

import jlatex.util.LatexContent;

public abstract class LatexParenthesisCommandParameter<T> extends LatexCommandParameter<T>
{
	public LatexParenthesisCommandParameter(LatexContent content)
	{
		super('(', ')', content);
	}
}
