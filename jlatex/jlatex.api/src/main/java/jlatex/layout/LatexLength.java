package jlatex.layout;

import java.io.PrintWriter;

import jlatex.util.LatexContent;

public class LatexLength implements LatexContent
{
	private LatexMeasurementUnit unit;
	private Double value;
	private String relative;

	@Override
	public void write(PrintWriter writer)
	{
		if(value != null)
		{
			writer.append(value.toString());
		}
		
		if(relative != null)
		{
			writer.append(relative);
		}
		else if(unit != null)
		{
			writer.append(unit.toString());
		}
	}

	public LatexLength value(Double value)
	{
		this.value = value;
		return this;
	}
	
	public LatexLength point()
	{
		unit = LatexMeasurementUnit.POINT;
		return this;
	}

	public LatexLength pica()
	{
		unit = LatexMeasurementUnit.PICA;
		relative = null;
		return this;
	}

	public LatexLength inch()
	{
		unit = LatexMeasurementUnit.INCH;
		relative = null;
		return this;
	}

	public LatexLength bigPoint()
	{
		unit = LatexMeasurementUnit.BIG_POINT;
		relative = null;
		return this;
	}

	public LatexLength centimeter()
	{
		unit = LatexMeasurementUnit.CENTIMETER;
		relative = null;
		return this;
	}

	public LatexLength milimeter()
	{
		unit = LatexMeasurementUnit.MILLIMETER;
		relative = null;
		return this;
	}

	public LatexLength didotPoint()
	{
		unit = LatexMeasurementUnit.DIDOT_POINT;
		relative = null;
		return this;
	}

	public LatexLength ciceroPoint()
	{
		unit = LatexMeasurementUnit.CICERO_POINT;
		relative = null;
		return this;
	}

	public LatexLength scaledPoint()
	{
		unit = LatexMeasurementUnit.SCALED_POINT;
		relative = null;
		return this;
	}

	public LatexLength xHeight()
	{
		unit = LatexMeasurementUnit.X_HEIGHT;
		relative = null;
		return this;
	}

	public LatexLength mathUnit()
	{
		unit = LatexMeasurementUnit.MATH_UNIT;
		relative = null;
		return this;
	}

	public LatexLength em()
	{
		unit = LatexMeasurementUnit.EM;
		relative = null;
		return this;
	}

	public LatexLength baselineskip()
	{
		relative = "\\baselineskip";
		unit = null;
		return this;
	}

	public LatexLength columnsep()
	{
		relative = "\\columnsep";
		unit = null;
		return this;
	}

	public LatexLength columnwidth()
	{
		relative = "\\columnwidth";
		unit = null;
		return this;
	}

	public LatexLength evensidemargin()
	{
		relative = "\\evensidemargin";
		unit = null;
		return this;
	}

	public LatexLength linewidth()
	{
		relative = "\\linewidth";
		unit = null;
		return this;
	}

	public LatexLength oddsidemargin()
	{
		relative = "\\oddsidemargin";
		unit = null;
		return this;
	}

	public LatexLength paperwidth()
	{
		relative = "\\paperwidth";
		unit = null;
		return this;
	}

	public LatexLength paperheight()
	{
		relative = "\\paperheight";
		unit = null;
		return this;
	}

	public LatexLength parindent()
	{
		relative = "\\parindent";
		unit = null;
		return this;
	}

	public LatexLength parskip()
	{
		relative = "\\parskip";
		unit = null;
		return this;
	}

	public LatexLength tabcolsep()
	{
		relative = "\\tabcolsep";
		unit = null;
		return this;
	}

	public LatexLength textheight()
	{
		relative = "\\textheight";
		unit = null;
		return this;
	}

	public LatexLength textwidth()
	{
		relative = "\\textwidth";
		unit = null;
		return this;
	}

	public LatexLength topmargin()
	{
		relative = "\\topmargin";
		unit = null;
		return this;
	}
}
