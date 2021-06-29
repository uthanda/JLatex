package jlatex.command;

public class LatexSimpleCommand extends LatexCommand<LatexSimpleCommand>
{
	public LatexSimpleCommand(String name, boolean addNewLine, LatexCommandParameter<?>... parameters)
	{
		super(name, addNewLine, parameters);
	}
	
	public LatexSimpleCommand(String name)
	{
		super(name, true);
	}
}
