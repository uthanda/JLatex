package jlatex.graphics;

import java.util.List;
import java.util.function.Function;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSquareBracketCommandParameter;
import jlatex.util.LatexDynamicContent;
import jlatex.util.LatexDynamicKeyValueList;
import jlatex.util.LatexKeyValueList.LatexKeyValuePair;

public abstract class LatexKeyValueOptionCommand<T extends LatexKeyValueOptionCommand<T>> extends LatexCommand<T>
{
	private LatexDynamicKeyValueList<T> parameterKeyValues = new LatexDynamicKeyValueList<>();
	
	private LatexSquareBracketCommandParameter parameters = new LatexSquareBracketCommandParameter(parameterKeyValues)
			.optional(true);

	@SuppressWarnings("unchecked")
	private LatexDynamicContent<T> commandValue = new LatexDynamicContent<>((T)this);
	
	private LatexCurlyBraceCommandParameter command = new LatexCurlyBraceCommandParameter(commandValue);
	
	@SuppressWarnings("unchecked")
	protected LatexKeyValueOptionCommand(String name, List<Function<T, LatexKeyValuePair<?,?>>> parameterRenderers, Function<T,String> renderer)
	{
		super(name, true);

		addParameter(parameters);
		addParameter(command);

		parameterKeyValues
			.withRenderers(parameterRenderers)
			.withTarget((T)this);
		
		commandValue.withRenderer(renderer);
	}
}