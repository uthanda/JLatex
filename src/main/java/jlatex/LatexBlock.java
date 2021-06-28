package jlatex;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCommandParameter;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.content.LatexText;

public abstract class LatexBlock<T,C extends LatexContent> extends LatexContent
{
	private LatexCommand beginBlock;
	private LatexCommand endBlock;
	
	protected LatexBlock(String name, LatexCommandParameter<?>... parameters) {
		
		LatexCurlyBraceCommandParameter nameParam = new LatexCurlyBraceCommandParameter(new LatexText().content(name));
		
		beginBlock = new LatexCommand("begin",nameParam);
		beginBlock.addParameters(Arrays.asList(parameters == null ? new LatexCommandParameter[0] : parameters));
		
		endBlock = new LatexCommand("end", nameParam);
	}
	
	@SuppressWarnings("unchecked")
	protected T addBeginParameter(LatexCommandParameter<?> parameter) {
		beginBlock.addParameter(parameter);
		return (T)this;
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
