package jlatex.table;

import java.io.PrintWriter;
import java.util.List;

import jlatex.content.LatexContentStream;
import jlatex.util.LatexContent;

public class LatexColumnSpecification implements LatexContent
{
	private LatexColumnAlignment alignment = LatexColumnAlignment.LEFT_JUSTIFIED;

	private Integer width;
	private LatexContentStream<LatexContent> title = new LatexContentStream<>();

	private LatexColumnLine before;
	private LatexColumnLine after;

	public LatexColumnSpecification addTitleContent(LatexContent content)
	{
		title.addContent(content);
		return this;
	}

	public LatexColumnSpecification addTitleContents(List<LatexContent> contents)
	{
		title.addContents(contents);
		return this;
	}

	public LatexContentStream<LatexContent> getTitle()
	{
		return title;
	}

	public LatexColumnAlignment getAlignment()
	{
		return alignment;
	}

	public void setAlignment(LatexColumnAlignment alignment)
	{
		this.alignment = alignment;
	}

	public LatexColumnSpecification alignment(LatexColumnAlignment alignment)
	{
		this.alignment = alignment;
		return this;
	}

	public Integer getWidth()
	{
		return width;
	}

	public void setWidth(Integer width)
	{
		this.width = width;
	}

	public LatexColumnSpecification width(Integer width)
	{
		this.width = width;
		return this;
	}

	public LatexColumnLine getBefore()
	{
		return before;
	}

	public void setBefore(LatexColumnLine before)
	{
		this.before = before;
	}

	public LatexColumnSpecification before(LatexColumnLine before)
	{
		this.before = before;
		return this;
	}

	public LatexColumnLine getAfter()
	{
		return after;
	}

	public void setAfter(LatexColumnLine after)
	{
		this.after = after;
	}

	public LatexColumnSpecification after(LatexColumnLine after)
	{
		this.after = after;
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		writer.write(before == null ? "" : before.getLatexContent());

		writer.write(alignment.getLatexContent());

		switch (alignment)
		{
			case PARAGRAPH_TOP:
			case PARAGRAPH_MIDDLE:
			case PARAGRAPH_BOTTOM:
				writer.print('{');
				writer.print(width);
				writer.print('}');
				break;
			default:
				// NOOP
				break;
		}

		writer.print(after == null ? "" : after.getLatexContent());
	}
}
