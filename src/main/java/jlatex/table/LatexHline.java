package jlatex.table;

import jlatex.command.LatexCommand;

public class LatexHline extends LatexCommandRow
{
	protected LatexHline()
	{
		super(new LatexCommand("hline"));
	}
}
