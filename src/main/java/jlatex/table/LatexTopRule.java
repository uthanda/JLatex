package jlatex.table;

import jlatex.command.LatexCommand;

public class LatexTopRule extends LatexCommandRow
{
	public LatexTopRule()
	{
		super(new LatexCommand("toprule"));
	}
}
