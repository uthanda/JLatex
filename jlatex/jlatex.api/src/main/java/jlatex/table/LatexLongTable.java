package jlatex.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSimpleCommand;
import jlatex.content.LatexContentStream;
import jlatex.content.LatexInteger;
import jlatex.content.LatexSimpleContentStream;
import jlatex.content.LatexText;
import jlatex.content.text.LatexTextBold;
import jlatex.layout.LatexFixedMeasurementElement;
import jlatex.layout.LatexMeasurement;
import jlatex.layout.LatexMeasurementUnit;
import jlatex.reference.LatexCaption;
import jlatex.reference.LatexLabel;
import jlatex.util.LatexBlock;
import jlatex.util.LatexComment;
import jlatex.util.LatexContent;
import jlatex.util.LatexNewline;
import jlatex.util.LatexSystemNewLine;

/**
 * Represents a long table that can be split across multiple pages.
 * 
 * @author Michael Oland
 *
 */
public class LatexLongTable extends LatexBlock<LatexLongTable, LatexContent>
{
	private LatexColumnSpecifications columnSpecifications = new LatexColumnSpecifications();

	private LatexCurlyBraceCommandParameter columnSpecificationsParameter = new LatexCurlyBraceCommandParameter(columnSpecifications);

	private List<LatexRow> rows = new ArrayList<>();

	private LatexCaption caption = new LatexCaption();

	private LatexLabel label = new LatexLabel();

	private boolean headers;

	private LatexContentStream<?,LatexContent> footer;

	public LatexLongTable()
	{
		super("longtable");
		addBeginParameter(columnSpecificationsParameter);
	}

	public List<LatexColumnSpecification> getColumnSpecifications()
	{
		return columnSpecifications.getColumnSpecifications();
	}

	public void setColumnSpecifications(List<LatexColumnSpecification> columnSpecifications)
	{
		this.columnSpecifications.setColumnSpecifications(columnSpecifications);
	}

	public LatexLongTable addColumnSpecification(LatexColumnSpecification specification)
	{
		this.columnSpecifications.addColumnSpecification(specification);
		return this;
	}

	public LatexLongTable addColumnSpecifications(List<LatexColumnSpecification> specifications)
	{
		this.columnSpecifications.addColumnSpecifications(specifications);
		return this;
	}

	public LatexLongTable addRow(LatexRow row)
	{
		this.rows.add(row);
		return this;
	}

	public LatexLongTable addRows(List<LatexRow> rows)
	{
		this.rows.addAll(rows);
		return this;
	}

	public LatexLongTable headers(boolean enable)
	{
		this.headers = enable;
		return this;
	}

	public LatexLongTable footer(LatexContentStream<?,LatexContent> content)
	{
		this.footer = content;
		return this;
	}

	@Override
	protected Iterable<LatexContent> getContents()
	{
		List<LatexContent> contents = new ArrayList<>();

		contents.add(new LatexComment().comment("Start the caption/label which must be at the top"));

		contents.add(caption);
		contents.add(new LatexSystemNewLine());
		contents.add(label);
		contents.add(new LatexText().content("\\\\").escapeCharacters(false));
		contents.add(new LatexSystemNewLine());

		if (this.headers)
		{
			contents.add(new LatexComment().comment("Create the header row"));

			LatexContentRow headerRow = new LatexContentRow();

			columnSpecifications.getColumnSpecifications()
					.forEach(s -> headerRow.addColumn(new LatexColumn().addContent(new LatexTextBold().addContent(s.getTitle()))));

			contents.add(new LatexHline());
			contents.add(headerRow);
			contents.add(new LatexHline());
			contents.add(new LatexSimpleCommand("endfirsthead"));
			contents.add(new LatexSystemNewLine());

			contents.add(new LatexComment().comment("Create the header rows for the remaining part of the table"));

			contents.add(new LatexHline());
			contents.add(headerRow);
			contents.add(new LatexHline());
			contents.add(new LatexSimpleCommand("endhead"));
			contents.add(new LatexSystemNewLine());
		}

		if (footer != null)
		{
			contents.add(new LatexComment().comment("Create the continued on next page footer"));

			LatexContentRow row = new LatexContentRow();

			LatexMultiColumn mc = new LatexMultiColumn()
					.columns(columnSpecifications.getColumnSpecifications().size())
					.addContents(footer.getContents())
					.before(LatexColumnLine.SINGLE)
					.after(LatexColumnLine.SINGLE)
					.alignment(LatexColumnAlignment.LEFT_JUSTIFIED);

			row.addColumn(mc);

			contents.add(new LatexHline());
			contents.add(row);
			contents.add(new LatexHline());
			contents.add(new LatexSimpleCommand("endfoot"));
			contents.add(new LatexSystemNewLine());

			contents.add(new LatexComment().comment("Create the end of table footer"));

			contents.add(new LatexHline());

			contents.add(new LatexSimpleCommand("endlastfoot"));
			contents.add(new LatexSystemNewLine());

		}

		contents.addAll(rows);

		return contents;
	}

	public LatexCaption getCaption()
	{
		return caption;
	}

	public void setCaptionShortText(String caption)
	{
		this.caption.setShortText(caption);
	}

	public LatexLongTable captionShortText(String caption)
	{
		setCaptionShortText(caption);
		return this;
	}

	public LatexLongTable addCaptionLongTextContent(LatexContent content)
	{
		this.caption.addLongTextContent(content);
		return this;
	}
	
	public LatexLongTable addCaptionLongTextContent(String content)
	{
		this.caption.addLongTextContent(new LatexText().content(content));
		return this;
	}

	public String getLabel()
	{
		return label.getLabel();
	}

	public void setLabel(String label)
	{
		this.label.setLabel(label);
	}

	public LatexLongTable label(String label)
	{
		setLabel(label);
		return this;
	}
	
	public static class Builder
	{
		private List<Object> rows = new ArrayList<>();
		private List<LatexColumnSpecification> columns = new ArrayList<>();
		private String caption;
		private String label;
		private boolean labelFromCaption = false;
		
		public Builder withColumnSpecification(LatexColumnSpecification column)
		{
			columns.add(column);
			return this;
		}
		
		public Builder withColumnSpecification(LatexColumnAlignment alignment)
		{
			return withColumnSpecification(new LatexColumnSpecification()
					.alignment(alignment));
		}
		
		public Builder withColumnSpecification(LatexColumnAlignment alignment, int size, LatexMeasurementUnit unit)
		{
			return withColumnSpecification(new LatexColumnSpecification().alignment(alignment)
					.width(new LatexMeasurement()
							.addContent(new LatexFixedMeasurementElement()
									.unit(unit)
									.value(new LatexInteger().value(size))
									)));
		}
		
		public Builder withColumnSpecification(LatexColumnAlignment alignment, LatexColumnLine before, LatexColumnLine after)
		{
			return withColumnSpecification(new LatexColumnSpecification().alignment(alignment)
					.before(before)
					.after(after));
		}
		
		public Builder withColumnSpecification(LatexColumnAlignment alignment, int size, LatexMeasurementUnit unit, LatexColumnLine before, LatexColumnLine after)
		{
			return withColumnSpecification(new LatexColumnSpecification().alignment(alignment)
					.width(new LatexMeasurement()
							.addContent(new LatexFixedMeasurementElement()
									.unit(unit)
									.value(new LatexInteger().value(size))
									))
					.before(before)
					.after(after));
		}
		
		@SuppressWarnings("unchecked")
		public LatexLongTable build()
		{
			LatexLongTable table = new LatexLongTable();
			
			if(labelFromCaption)
			{
				Objects.requireNonNull(caption, "To generate label from caption, the caption must be provided");
				
				label = "tab:" + caption
						.chars()
						.mapToObj(c -> Character.isAlphabetic(c) ? Character.toString(c) : "_")
						.collect(Collectors.joining())
						.toLowerCase();
			}
			
			table.addCaptionLongTextContent(caption)
				.label(label);
			
			table.addColumnSpecifications(columns);
			
			for(int i = 0; i < rows.size(); i++)
			{
				Object rr = rows.get(i);
				
				if(rr instanceof LatexHline)
				{
					table.addRow(((LatexHline)rr));
					continue;
				}
				
				List<LatexContent> r = (List<LatexContent>) rows.get(i);
				
				if(r.size() != columns.size())
				{
					throw new IllegalStateException("Row " + i + " column count does not match requred column count");
				}
				
				List<LatexColumn> rowColumns = r.stream()
						.map(e -> new LatexColumn().addContent(e))
						.collect(Collectors.toList());
				
				LatexContentRow row = new LatexContentRow()
						.addColumns(rowColumns);
				
				table.addRow(row);
			}
			
			return table;
		}

		public Builder withRow(List<String> values)
		{
			rows.add(values.stream()
					.map(v -> {
						LatexSimpleContentStream content = new LatexSimpleContentStream();
						
						Arrays.asList(v.split("\n"))
							.forEach(l -> 
							{
								if(!content.getContents().isEmpty())
								{
									content
										.addContent(new LatexText().content(" "))
										.addContent(new LatexNewline())
										.addContent(new LatexText().content(" "));
								}
								
								content.addContent(new LatexText().content(l));
							});
						
						return content;
					})
					.collect(Collectors.toList()));
			
			return this;
		}

		public Builder addLine()
		{
			rows.add(new LatexHline());
			return this;
		}

		public Builder addRow(Object... values)
		{
			rows.add((Arrays.asList(values)
					.stream()
					.map(v -> (LatexContent)new LatexText().content(v.toString()))
					.collect(Collectors.toList())));
			
			return this;
		}

		public Builder withLabel(String label)
		{
			this.label = label;
			return this;
		}
		
		public Builder withCaption(String caption)
		{
			this.caption = caption;
			return this;
		}
		
		public Builder withLabelFromCaption()
		{
			this.labelFromCaption  = true;
			return this;
		}

		public Builder addRows(List<List<String>> rows)
		{
			rows.forEach(this::withRow);
			
			return this;
		}
	}
}
