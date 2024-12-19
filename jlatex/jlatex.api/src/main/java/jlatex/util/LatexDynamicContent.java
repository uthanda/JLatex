package jlatex.util;

import java.io.PrintWriter;
import java.util.function.Function;

public class LatexDynamicContent<T> implements LatexContent
{
	private Function<T,String> renderer;
	private T target;
	
	public LatexDynamicContent(T target)
	{
		this.target = target;
	}
	
	public LatexDynamicContent<T> withRenderer(Function<T,String> renderer)
	{
		this.renderer = renderer;
		return this;
	}
	
	@Override
	public void write(PrintWriter writer)
	{
		writer.append(renderer.apply(target));
	}
}
