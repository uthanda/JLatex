package jlatex.table.builders;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jlatex.table.LatexHline;
import jlatex.table.LatexRow;

public class RowsCollector<T> implements Collector<T,List<LatexRow>,List<LatexRow>>
{
	private Function<T,LatexRow> converter;

	private boolean firstLine;
	private boolean lastLine;
	private boolean between;

	private RowsCollector(Builder<T> builder)
	{
		this.converter = builder.converter;
		this.firstLine = builder.firstLine;
		this.lastLine = builder.lastLine;
		this.between = builder.between;
	}
	
	@Override
	public Supplier<List<LatexRow>> supplier()
	{
		return ArrayList::new;
	}

	@Override
	public BiConsumer<List<LatexRow>, T> accumulator()
	{
		return (l, c) -> {
			
			if(between && !l.isEmpty())
			{
				l.add(new LatexHline());
			}
			
			l.add(converter.apply(c));
		};
	}

	@Override
	public BinaryOperator<List<LatexRow>> combiner()
	{
		return (a,b) -> Stream.concat(a.stream(), b.stream()).collect(Collectors.toList());
	}

	@Override
	public Function<List<LatexRow>, List<LatexRow>> finisher()
	{
		return r -> {

			if(firstLine)
			{
				r.add(0, new LatexHline());
			}
			
			if(lastLine)
			{
				r.add(new LatexHline());
			}
			
			return r;
		};
	}

	@Override
	public Set<Characteristics> characteristics()
	{
		return Set.of();
	}

	public static Builder<List<String>> stringArrayBuilder()
	{
		return new Builder<List<String>>()
				.withConverter(r -> r.stream().collect(new ColumnsCollector()));
	}
	
	public static class Builder<T>
	{
		private Function<T, LatexRow> converter;
		private boolean firstLine;
		private boolean lastLine;
		private boolean between;

		public Builder<T> withConverter(Function<T, LatexRow> converter)
		{
			this.converter = converter;
			return this;
		}

		public Builder<T> withFirstLine(boolean firstLine)
		{
			this.firstLine = firstLine;
			return this;
		}

		public Builder<T> withLastLine(boolean lastLine)
		{
			this.lastLine = lastLine;
			return this;
		}

		public Builder<T> withBetween(boolean between)
		{
			this.between = between;
			return this;
		}

		public RowsCollector<T> build()
		{
			return new RowsCollector<>(this);
		}
	}
}