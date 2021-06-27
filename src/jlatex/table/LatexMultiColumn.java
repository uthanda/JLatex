package jlatex.table;

import jlatex.LatexInteger;
import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;

public class LatexMultiColumn extends LatexCommand
{
	private LatexInteger columns = new LatexInteger();
	
	private LatexCurlyBraceCommandParameter columnsParameter = new LatexCurlyBraceCommandParameter(columns);
	
	private LatexEnumText<LatexColumnAlignment> alignment = new LatexEnumText<>(LatexColumnAlignment.class);
	
	private LatexCurlyBraceCommandParameter alignmentParameter = new LatexCurlyBraceCommandParameter(alignment);
	
	public LatexMultiColumn()
	{
		super("multicolumn");
		addParameter(columnsParameter);
		addParameter(alignmentParameter);
	}

	public Integer getColumns() {
		return columns.getValue();
	}
	
	public void setColumns(Integer columns) {
		this.setColumns(columns);
	}
	
	public LatexMultiColumn columns(Integer columns) {
		this.setColumns(columns);
		return this;
	}

	public LatexColumnAlignment getAlignment() {
		return alignment.getEnumValue();
	}
	
	public void setAlignment(LatexColumnAlignment alignment) {
		this.setAlignment(alignment);
	}
	
	public LatexMultiColumn columns(LatexColumnAlignment alignment) {
		this.setAlignment(alignment);
		return this;
	}
}
