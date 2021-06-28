package jlatex.table;

import java.util.ArrayList;
import java.util.List;

import jlatex.LatexBlock;
import jlatex.LatexCaption;
import jlatex.LatexContent;
import jlatex.LatexLabel;
import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.content.LatexContentStream;
import jlatex.content.LatexNewLine;
import jlatex.content.LatexText;
import jlatex.content.text.LatexTextBold;
import jlatex.util.LatexComment;

public class LatexLongTable extends LatexBlock<LatexLongTable, LatexContent>
{
	private LatexColumnSpecifications columnSpecifications = new LatexColumnSpecifications();
	
	private LatexCurlyBraceCommandParameter columnSpecificationsParameter = new LatexCurlyBraceCommandParameter(columnSpecifications);
	
	private List<LatexRow> rows = new ArrayList<>();

	private boolean captionTop = false;

	private LatexCaption caption = new LatexCaption();

	private LatexLabel label = new LatexLabel();

	private boolean headers;

	private LatexContentStream footer;
	
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

	public LatexLongTable addRow(LatexRow row) {
		this.rows.add(row);
		return this;
	}
	
	public LatexLongTable addRows(List<LatexRow> rows) {
		this.rows.addAll(rows);
		return this;
	}
	
	public LatexLongTable headers(boolean enable) {
		this.headers = enable;
		return this;
	}
	
	public LatexLongTable footer(LatexContentStream content) {
		this.footer = content;
		return this;
	}
	
	@Override
	protected Iterable<LatexContent> getContents()
	{
		List<LatexContent> contents = new ArrayList<>();
		
		contents.add(new LatexComment().comment("Start the caption/label which must be at the top"));
		
		contents.add(caption);
		contents.add(label);
		contents.add(new LatexText().content("\\\\").escapeCharacters(false));
		contents.add(new LatexNewLine());

		if (this.headers)
		{
			contents.add(new LatexComment().comment("Create the header row"));
			
			LatexContentRow headerRow = new LatexContentRow();
			
			columnSpecifications.getColumnSpecifications().forEach(s -> {
				headerRow.addColumn(new LatexColumn().addContent(new LatexTextBold().addContent(s.getTitle())));
			});
			
			contents.add(new LatexHline());
			contents.add(headerRow);
			contents.add(new LatexHline());
			contents.add(new LatexCommand("endfirsthead"));
			contents.add(new LatexNewLine());

			contents.add(new LatexComment().comment("Create the header rows for the remaining part of the table"));

			contents.add(new LatexHline());
			contents.add(headerRow);
			contents.add(new LatexHline());
			contents.add(new LatexCommand("endhead"));
			contents.add(new LatexNewLine());
		}
		
		if(footer != null) {
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
			contents.add(new LatexCommand("endfoot"));
			contents.add(new LatexNewLine());
			
			contents.add(new LatexComment().comment("Create the end of table footer"));
			
			contents.add(new LatexHline());
			
			contents.add(new LatexCommand("endlastfoot"));
			contents.add(new LatexNewLine());

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
}
