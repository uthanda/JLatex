package jlatex.graphics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import jlatex.layout.LatexLength;
import jlatex.util.LatexKeyValueList.LatexContentKeyValuePair;
import jlatex.util.LatexKeyValueList.LatexKeyValuePair;

public abstract class LatexGraphic<T extends LatexGraphic<T>> extends LatexKeyValueOptionCommand<T>
{	
	private LatexLength width;
	private LatexLength height;
	
	private String filename;

	@SuppressWarnings("squid:S1604")
	protected LatexGraphic(String name, List<Function<T, LatexKeyValuePair<?,?>>> parameterRenderers)
	{
		super(name,Arrays.asList(
					parameterRenderers,
					Arrays.asList(new Function<T, LatexKeyValuePair<?,?>>()
					{
						@Override
						public LatexKeyValuePair<?, ?> apply(T t)
						{
							return renderWidth(t);
						}
					},new Function<T, LatexKeyValuePair<?,?>>()
					{
						@Override
						public LatexKeyValuePair<?, ?> apply(T t)
						{
							return renderHeight(t);
						}
					})
				)
				.stream()
				.flatMap(List::stream)
				.collect(Collectors.toList()), l -> ((LatexGraphic<?>)l).filename);
	}

	private static LatexKeyValuePair<?,?> renderWidth(LatexGraphic<?> g)
	{
		return g.width == null ? null : new LatexContentKeyValuePair("width")
				.value(g.width);
	}
	
	private static LatexKeyValuePair<?,?> renderHeight(LatexGraphic<?> g)
	{
		return g.height == null ? null : new LatexContentKeyValuePair("height")
				.value(g.height);
	}
	
	@SuppressWarnings("unchecked")
	public T withWidth(LatexLength width)
	{
		this.width = width;
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	public T withHeight(LatexLength height)
	{
		this.height = height;
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	public T withFilename(String filename)
	{
		this.filename = filename;
		return (T) this;
	}

}