package jlatex.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

public interface LatexContent
{
	public abstract void write(PrintWriter writer);

	public default boolean isEmpty()
	{
		return false;
	}

	public default List<LatexPackage> getRequiredPackages()
	{
		return Arrays.asList();
	}

	public default String write()
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		write(pw);
		return sw.toString();
	}
}
