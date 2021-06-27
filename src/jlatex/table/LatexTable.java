package jlatex.table;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jlatex.LatexCaption;
import jlatex.LatexContent;
import jlatex.LatexLabel;
import jlatex.LatexText;
import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSquareBracketCommandParameter;

public class LatexTable extends LatexContent
{
	private LatexText tableModifiers = new LatexText();
	
	private LatexSquareBracketCommandParameter tableModifiersParameter = new LatexSquareBracketCommandParameter(tableModifiers);
	
	private LatexCommand beginTable = new LatexCommand("table",tableModifiersParameter);
	
	private LatexCommand endTable = new LatexCommand("tabular");
	
	private LatexEnumText<LatexCellPosition> positionModifiers = new LatexEnumText<>(LatexCellPosition.class);
	
	private LatexSquareBracketCommandParameter positionParameter = new LatexSquareBracketCommandParameter(positionModifiers).optional(true);
	
	private LatexColumnSpecifications columnSpecifications = new LatexColumnSpecifications();
	
	private LatexCurlyBraceCommandParameter columnSpecificationsParameter = new LatexCurlyBraceCommandParameter(columnSpecifications);
	
	private LatexCommand beginTabular = new LatexCommand("table",positionParameter,columnSpecificationsParameter);
	
	private LatexCommand endTabular = new LatexCommand("tabular");
	
	private LatexCaption caption;
	private LatexLabel label;

	private List<LatexRow> rows = new ArrayList<>();

	public LatexCaption getCaption()
	{
		return caption;
	}

	public void setCaption(LatexCaption caption)
	{
		this.caption = caption;
	}

	public LatexCellPosition getPosition()
	{
		return positionModifiers.getEnumValue();
	}

	public void setPosition(LatexCellPosition position)
	{
		this.positionModifiers.setContent(position);
	}
	
	public LatexTable position(LatexCellPosition position)
	{
		this.positionModifiers.setContent(position);
		return this;
	}

	public List<LatexColumnSpecification> getColumnSpecifications()
	{
		return columnSpecifications.getColumnSpecifications();
	}
	
	public void setColumnSpecifications(List<LatexColumnSpecification> columnSpecifications)
	{
		this.columnSpecifications.setColumnSpecifications(columnSpecifications);
	}

	public LatexTable addColumnSpecification(LatexColumnSpecification specification)
	{
		this.columnSpecifications.addColumnSpecification(specification);
		return this;
	}
	
	public LatexTable addColumnSpecifications(List<LatexColumnSpecification> specifications)
	{
		this.columnSpecifications.addColumnSpecifications(specifications);
		return this;
	}

	public List<LatexRow> getRows()
	{
		return rows;
	}

	public void setRows(List<LatexRow> rows)
	{
		this.rows = rows;
	}
	
	public LatexTable addRow(LatexRow row)
	{
		this.rows.add(row);
		return this;
	}

	public String getTableModifiers()
	{
		return tableModifiers.getContent();
	}

	public void setTableModifiers(String tableModifiers)
	{
		this.tableModifiers.setContent(tableModifiers);
	}
	
	public LatexTable tableModifiers(String tableModifiers)
	{
		this.tableModifiers.setContent(tableModifiers);
		return this;
	}

	public LatexLabel getLabel()
	{
		return label;
	}

	public void setLabel(LatexLabel label)
	{
		this.label = label;
	}

	@Override
	public void write(PrintWriter sb)
	{
		beginTable.write(sb);

		if (caption != null)
		{
			caption.write(sb);
		}
		
		if (label != null)
		{
			label.write(sb);
		}

		beginTabular.write(sb);
		
		rows.forEach(row -> row.write(sb) );

		endTabular.write(sb);
		
		endTable.write(sb);
	}
}
