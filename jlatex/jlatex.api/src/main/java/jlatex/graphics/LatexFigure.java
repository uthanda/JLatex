package jlatex.graphics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import jlatex.content.LatexText;
import jlatex.content.text.LatexTextCenter;
import jlatex.reference.LatexCaption;
import jlatex.reference.LatexLabel;
import jlatex.util.LatexBlock;
import jlatex.util.LatexContent;

public class LatexFigure extends LatexBlock<LatexGraphicsFigure, LatexContent>
{
	private LatexContent figure;
	private LatexCaption caption;
	private LatexLabel label;
	private boolean center = false;
	private boolean labelFromCaption = false;

	public LatexFigure()
	{
		super("figure");
	}

	public LatexLabel getLabel()
	{
		return label;
	}

	public void setLabel(LatexLabel label)
	{
		this.label = label;
	}

	public LatexCaption getCaption()
	{
		return caption;
	}

	public void setCaption(LatexCaption caption)
	{
		this.caption = caption;
	}

	public LatexFigure caption(LatexCaption caption)
	{
		this.setCaption(caption);
		return  this;
	}
	
	public LatexFigure caption(String caption)
	{
		this.setCaption(new LatexCaption()
				.addLongTextContent(new LatexText().content(caption)));

		return  this;
	}

	public LatexFigure label(LatexLabel label)
	{
		setLabel(label);
		return  this;
	}

	public boolean isCenter()
	{
		return center;
	}

	public void setCenter(boolean center)
	{
		this.center = center;
	}

	public LatexFigure center(boolean center)
	{
		setCenter(center);
		return this;
	}
	
	public LatexContent getFigure()
	{
		return figure;
	}

	public void setFigure(LatexContent figure)
	{
		this.figure = figure;
	}
	
	public LatexFigure figure(LatexContent figure)
	{
		this.figure = figure;
		return this;
	}

	@Override
	protected Iterable<LatexContent> getContents()
	{
		List<LatexContent> contents = new ArrayList<>();
		
		contents.add(figure);
	
		if (caption != null)
		{
			contents.add(caption.newLine());
			
			if(labelFromCaption)
			{
				label = new LatexLabel()
						.newLine()
						.label("fig:" + caption.getLongText()
							.getContents()
							.stream()
							.map(LatexContent::write)
							.collect(Collectors.joining())
						.chars()
						.mapToObj(c -> Character.isAlphabetic(c) ? Character.toString(c) : "_")
						.collect(Collectors.joining())
						.toLowerCase());

			}
		}
		
		if (label != null)
		{
			contents.add(label);
		}
	
		return center ? Arrays.asList(new LatexTextCenter().addContents(contents)) : contents;
	}

	public LatexFigure labelFromCaption()
	{
		this.labelFromCaption  = true;
		return this;
	}
}