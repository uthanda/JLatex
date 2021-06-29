package jlatex.layout;

import java.io.PrintWriter;

public class LatexAddMeasurementElement implements LatexMeasurementElement
{
	@Override
	public void write(PrintWriter writer)
	{
		writer.write('+');
	}
}
