package jlatex.table;

import java.io.PrintWriter;

import jlatex.command.LatexCommand;

public class LatexCommandRow implements LatexRow
{
	private LatexCommand<?> command;

	protected LatexCommandRow(LatexCommand<?> command)
	{
		this.command = command;
	}

	@Override
	public void write(PrintWriter writer)
	{
		command.write(writer);
		writer.println();
	}
}
