package jlatex.util;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import jlatex.content.LatexSimpleContentStream;
import jlatex.content.LatexText;

public class LatexCollectors
{
	private LatexCollectors() {}
	
	public static Collector<LatexContent,LatexSimpleContentStream,LatexContent> toList(LatexText joiner)
	{
		return new Collector<LatexContent, LatexSimpleContentStream, LatexContent>()
		{
			@Override
			public Supplier<LatexSimpleContentStream> supplier()
			{
				return LatexSimpleContentStream::new;
			}

			@Override
			public BiConsumer<LatexSimpleContentStream, LatexContent> accumulator()
			{
				return (t,e) -> 
				{
					if(!t.getContents().isEmpty())
					{
						t.addContent(joiner);
					}
					
					t.addContent(e);
				};
			}

			@Override
			public BinaryOperator<LatexSimpleContentStream> combiner()
			{
				return (a,b) -> a.addContent(joiner).addContent(b);
			}

			@Override
			public Function<LatexSimpleContentStream, LatexContent> finisher()
			{
				return a -> a;
			}

			@Override
			public Set<Characteristics> characteristics()
			{
				return Collections.emptySet();
			}};
	}

}
