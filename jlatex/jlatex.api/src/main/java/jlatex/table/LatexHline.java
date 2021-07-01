package jlatex.table;

import jlatex.command.LatexSimpleCommand;

public class LatexHline extends LatexCommandRow
{
	public LatexHline()
	{
		super(new LatexSimpleCommand("hline",false));
	}
}
