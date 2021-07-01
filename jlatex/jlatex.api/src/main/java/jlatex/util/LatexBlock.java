package jlatex.util;

import java.io.PrintWriter;
import java.util.Arrays;

import jlatex.command.LatexCommandParameter;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSimpleCommand;
import jlatex.content.LatexText;

public abstract class LatexBlock<T, C extends LatexContent> implements LatexContent
{
	private LatexSimpleCommand beginBlock;
	private LatexSimpleCommand endBlock;

	protected LatexBlock(String name, LatexCommandParameter<?>... parameters)
	{
		LatexCurlyBraceCommandParameter nameParam = new LatexCurlyBraceCommandParameter(new LatexText().content(name));

		beginBlock = new LatexSimpleCommand("begin", true, nameParam);
		beginBlock.addParameters(Arrays.asList(parameters == null ? new LatexCommandParameter[0] : parameters));

		endBlock = new LatexSimpleCommand("end", true, nameParam);
	}

	@SuppressWarnings("unchecked")
	protected T addBeginParameter(LatexCommandParameter<?> parameter)
	{
		beginBlock.addParameter(parameter);
		return (T) this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		beginBlock.write(writer);
		writer.println();

		getContents().forEach(content -> {
			content.write(writer);
		});

		endBlock.write(writer);
		writer.println();
	}

	protected abstract Iterable<C> getContents();
}
