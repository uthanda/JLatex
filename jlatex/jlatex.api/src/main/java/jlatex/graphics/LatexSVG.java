package jlatex.graphics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import jlatex.command.LatexCommand;
import jlatex.util.LatexKeyValueList.LatexContentKeyValuePair;
import jlatex.util.LatexKeyValueList.LatexIntegerKeyValuePair;
import jlatex.util.LatexKeyValueList.LatexKeyValuePair;
import jlatex.util.LatexKeyValueList.LatexStringKeyValuePair;
import jlatex.util.LatexPackage;

public class LatexSVG extends LatexGraphic<LatexSVG>
{
	private static List<Function<LatexSVG,LatexKeyValuePair<?,?>>> parameterRenderers = new ArrayList<>();
	
	static
	{
		parameterRenderers.add(l -> renderParameter("inkscape",  l.inkscape));
		parameterRenderers.add(l -> renderParameter("inkscapeformat", l.inkscapeFormat));
		parameterRenderers.add(l -> renderParameter("inkscapelatex", l.inkscapeLatex));
		parameterRenderers.add(l -> renderParameter("inkscapearea", l.inkscapeArea));
		parameterRenderers.add(l -> l.inkscapeDPI);
	}
	
	private String inkscape;
	private String inkscapeFormat;
	private String inkscapeLatex;
	private String inkscapeArea;
	private LatexKeyValuePair<?,?> inkscapeDPI;
	String filename;
	
	public LatexSVG()
	{
		super("includesvg", parameterRenderers);
	}
	
	public LatexSVG withInkscapeLatex()
	{
		this.inkscapeLatex = "true";
		return this;
	}
	
	private static LatexKeyValuePair<?,?> renderParameter(String key, Object value)
	{
		if(value instanceof Integer)
		{
			return new LatexIntegerKeyValuePair(key).value((Integer)value);
		}
		else if(value instanceof String)
		{
			return new LatexStringKeyValuePair(key).value((String)value);
		}
		else
		{
			return null;
		}
	}
	
	public LatexSVG withRelax()
	{
		this.inkscapeDPI = new LatexContentKeyValuePair("inkscapedpi").value(new LatexSVGRelax());
		return this;
	}
	
	public LatexSVG withDPI(Integer dpi)
	{
		this.inkscapeDPI = new LatexIntegerKeyValuePair("inkscapedpi").value(dpi);
		return this;
	}
	
	public LatexSVG withAreaDrawing()
	{
		this.inkscapeArea = "drawing";
		return this;
	}
	
	public LatexSVG withAreaPage()
	{
		this.inkscapeArea = "page";
		return this;
	}
	
	public LatexSVG noLatex()
	{
		this.inkscapeLatex = "false";
		return this;
	}
	
	public LatexSVG noExport()
	{
		this.inkscape = "false";
		return this;
	}
	
	public LatexSVG exportIfNewer()
	{
		this.inkscape = "true";
		return this;
	}
	
	public LatexSVG forceExport()
	{
		this.inkscape = "forced";
		return this;
	}
	
	public LatexSVG asPDF()
	{
		this.inkscapeFormat = "pdf";
		return this;
	}
	
	public LatexSVG asEPS()
	{
		this.inkscapeFormat = "eps";
		return this;
	}
	
	public LatexSVG asPNG()
	{
		this.inkscapeFormat = "png";
		return this;
	}
	
	public LatexSVG formatPS()
	{
		this.inkscapeFormat = "ps";
		return this;
	}

	@Override
	public List<LatexPackage> getRequiredPackages()
	{
		return Arrays.asList(new LatexPackage().name("graphicsx"));
	}
	
	public static class LatexSVGRelax extends LatexCommand<LatexSVGRelax>
	{
		public LatexSVGRelax()
		{
			super("relax", false);
		}
	}
}
