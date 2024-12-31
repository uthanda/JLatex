package jlatex.table.builders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jlatex.content.LatexSimpleContentStream;
import jlatex.content.LatexText;
import jlatex.table.LatexColumn;
import jlatex.table.LatexContentRow;
import jlatex.table.LatexRow;
import jlatex.util.LatexNewline;

public class ColumnsCollector implements Collector<String,List<LatexColumn>,LatexRow>
{
	@Override
	public Supplier<List<LatexColumn>> supplier()
	{
		return ArrayList::new;
	}

	@Override
	public BiConsumer<List<LatexColumn>, String> accumulator()
	{
		return (l,c) -> {

				LatexSimpleContentStream content = new LatexSimpleContentStream();
			
				if(c == null)
				{
					content.addContent(new LatexText());
				}
				else
				{
					Arrays.asList(c.split("\n"))
						.forEach(v -> {
							if(!content.getContents().isEmpty())
							{
								content.addContent(new LatexNewline());
							}
							
							content.addContent(new LatexText(v));
						});
				}
			
				l.add(new LatexColumn().addContent(content));
			};
	}

	@Override
	public BinaryOperator<List<LatexColumn>> combiner()
	{
		return (a,b) -> Stream.concat(a.stream(), b.stream()).collect(Collectors.toList());
	}

	@Override
	public Function<List<LatexColumn>, LatexRow> finisher()
	{
		return r -> new LatexContentRow().addColumns(r);
	}

	@Override
	public Set<Characteristics> characteristics()
	{
		return Set.of();
	}
}