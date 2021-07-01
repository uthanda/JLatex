package jlatex.util;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jlatex.layout.LatexMeasurement;

public class LatexKeyValueList implements LatexContent
{
	private Map<String, LatexKeyValuePair<?, ?>> values = new HashMap<>();

	public LatexKeyValuePair<?, ?> getValue(String key)
	{
		return values.get(key);
	}

	public void setValue(LatexKeyValuePair<?, ?> pair)
	{
		values.put(pair.key, pair);
	}

	public LatexKeyValueList value(LatexKeyValuePair<?, ?> pair)
	{
		this.setValue(pair);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		boolean first = true;

		for (LatexKeyValuePair<?, ?> e : values.values())
		{
			if (first)
			{
				first = false;
			}
			else
			{
				writer.write(',');
			}

			e.write(writer);
		}
	}

	public static class LatexStringKeyValuePair extends LatexKeyValuePair<LatexStringKeyValuePair, String>
	{
		public LatexStringKeyValuePair(String key)
		{
			super(key);
		}

		@Override
		protected String formatValue(String value)
		{
			return value;
		}
	}

	public static class LatexMeasurementKeyValuePair extends LatexKeyValuePair<LatexStringKeyValuePair, LatexMeasurement>
	{
		private String units;

		public LatexMeasurementKeyValuePair(String key)
		{
			super(key);
		}

		public String getUnits()
		{
			return units;
		}

		public void setMeasurementSystem(String units)
		{
			this.units = units;
		}

		public LatexMeasurementKeyValuePair measurementSystem(String units)
		{
			this.setMeasurementSystem(units);
			return this;
		}

		@Override
		protected String formatValue(LatexMeasurement value)
		{
			return value.write();
		}
	}

	public static class LatexIntegerKeyValuePair extends LatexKeyValuePair<LatexStringKeyValuePair, Integer>
	{
		public LatexIntegerKeyValuePair(String key)
		{
			super(key);
		}

		@Override
		protected String formatValue(Integer value)
		{
			return value.toString();
		}
	}

	public static class LatexBooleanKeyValuePair extends LatexKeyValuePair<LatexStringKeyValuePair, Boolean>
	{
		public LatexBooleanKeyValuePair(String key)
		{
			super(key);
		}

		@Override
		protected String formatValue(Boolean value)
		{
			return value.toString();
		}
	}

	public static class LatexKeyOnlyPair extends LatexKeyValuePair<LatexKeyOnlyPair, Void>
	{
		public LatexKeyOnlyPair(String key)
		{
			super(key);
		}

		@Override
		public void setValue(Void value)
		{
			throw new UnsupportedOperationException("setValue is not supported on LatexKeyOnlyPair");
		}

		@Override
		protected String formatValue(Void value)
		{
			return "";
		}
	}

	public static abstract class LatexKeyValuePair<T, V> implements LatexContent
	{
		private final String key;
		private V value;

		protected LatexKeyValuePair(String key)
		{
			this.key = key;
		}

		public V getValue()
		{
			return value;
		}

		public void setValue(V value)
		{
			this.value = value;
		}

		@SuppressWarnings("unchecked")
		public T value(V value)
		{
			this.setValue(value);
			return (T) this;
		}

		public String getKey()
		{
			return key;
		}

		@Override
		public void write(PrintWriter writer)
		{
			if (this instanceof LatexKeyOnlyPair)
			{
				writer.print(key);
				return;
			}

			if (value == null)
			{
				return;
			}

			writer.format("%s=%s", key, formatValue(value));
		}

		protected abstract String formatValue(V value);
	}
}
