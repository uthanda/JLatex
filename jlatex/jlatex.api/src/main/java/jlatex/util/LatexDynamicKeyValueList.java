package jlatex.util;

import java.io.PrintWriter;
import java.util.List;
import java.util.function.Function;

import jlatex.graphics.LatexKeyValueOptionCommand;

public class LatexDynamicKeyValueList<T extends LatexKeyValueOptionCommand<T>> extends LatexKeyValueList
{
	private List<Function<T, LatexKeyValuePair<?,?>>> parameterRenderers;
	private T target;
	
	public LatexDynamicKeyValueList<T> withTarget(T target)
	{
		this.target = target;
		return this;
	}
	
	public LatexDynamicKeyValueList<T> withRenderers(List<Function<T, LatexKeyValuePair<?,?>>> parameterRenderers)
	{
		this.parameterRenderers = parameterRenderers;
		return this;
	}
	
	@Override
	public boolean isEmpty()
	{
		return parameterRenderers
			.stream()
			.map(f -> f.apply(target))
			.allMatch(v -> v == null);
	}
	
	@Override
	public void write(PrintWriter writer)
	{
		parameterRenderers
			.stream()
			.map(f -> f.apply(target))
			.filter(v -> v != null)
			.forEach(this::value);
		
		super.write(writer);
	}
}
