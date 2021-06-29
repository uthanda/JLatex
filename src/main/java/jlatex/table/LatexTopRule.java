package jlatex.table;

import jlatex.command.LatexSimpleCommand;

public class LatexTopRule extends LatexCommandRow
{
	public LatexTopRule()
	{
		super(new LatexSimpleCommand("toprule",true));
	}
}
