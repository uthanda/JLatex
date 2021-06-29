package jlatex.list;

import jlatex.util.LatexContentBlock;

public abstract class LatexList<T> extends LatexContentBlock<T>
{
	protected LatexList(String type)
	{
		super(type);
	}
}
