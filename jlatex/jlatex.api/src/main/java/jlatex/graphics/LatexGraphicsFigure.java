package jlatex.graphics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import jlatex.content.LatexText;
import jlatex.util.LatexKeyValueList;
import jlatex.util.LatexKeyValueList.LatexKeyValuePair;
import jlatex.util.LatexPackage;

public class LatexGraphicsFigure extends LatexGraphic<LatexGraphicsFigure>
{
	private static List<Function<LatexGraphicsFigure, LatexKeyValuePair<?, ?>>> renderers = new ArrayList<>();

	private LatexKeyValueList options = new LatexKeyValueList();

	private LatexText size = new LatexText();

	private String imageName;

	private boolean clipImage = false;

	public LatexGraphicsFigure()
	{
		super("includegraphics", renderers);
	}

	public String getImageName()
	{
		return imageName;
	}

	public void setImageName(String name)
	{
		imageName = name;
	}

	public LatexGraphicsFigure imageName(String name)
	{
		setImageName(name);
		return this;
	}

	public String getSize()
	{
		return this.size.getContent();
	}

	public void setSize(String size)
	{
		this.size.setContent(size);
	}

	public LatexGraphicsFigure size(String size)
	{
		this.size.setContent(size);
		return this;
	}

	public LatexKeyValuePair<?, ?> getOption(String key)
	{
		return this.options.getValue(key);
	}

	public void setOption(LatexKeyValuePair<?, ?> option)
	{
		this.options.setValue(option);
	}

	public LatexGraphicsFigure option(LatexKeyValuePair<?, ?> option)
	{
		this.setOption(option);
		return this;
	}

	public boolean isClipImage()
	{
		return clipImage;
	}

	public void setClipImage(boolean clipImage)
	{
		this.clipImage = clipImage;
	}

	public LatexGraphicsFigure clipImage(boolean clipImage)
	{
		this.setClipImage(clipImage);
		return this;
	}

	@Override
	public List<LatexPackage> getRequiredPackages()
	{
		return Arrays.asList(new LatexPackage().name("graphicsx"));
	}
}
