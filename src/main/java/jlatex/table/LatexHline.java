package jlatex.table;

import jlatex.command.LatexCommand;

public class LatexHline extends LatexCommandRow
{
	public LatexHline()
	{
		super(new LatexCommand("hline"));
	}
}
