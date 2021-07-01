package jlatex.layout;

import java.io.PrintWriter;

public class LatexFixedMeasurementElement implements LatexMeasurementElement
{
	private LatexMeasurementUnit unit;
	private String value;

	@Override
	public void write(PrintWriter writer)
	{
		writer.printf("%s%s", value, unit.getLatexContent());
	}
}