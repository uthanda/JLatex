package jlatex;

import java.util.ArrayList;
import java.util.List;

public class LatexList extends LatexContent
{
	private final List<LatexContent> elements = new ArrayList<>();
	private final String type;
	
	public LatexList(String type)
	{
		this.type = type;
	}

	public List<LatexContent> getElements()
	{
		return elements;
	}
	
	public void addElement(LatexContent content)
	{
		this.elements.add(content);
	}

	@Override
	public String toLatexCode()
	{
		StringBuilder sb = new StringBuilder();		
		
		sb.append("\\begin{");
		sb.append(type);
		sb.append("}\n");
		
		elements.forEach(element -> {
			sb.append("\t\\item ");
			sb.append(element.toLatexCode());
			sb.append("\n");
		});
		
		sb.append("\\end{");
		sb.append(type);
		sb.append("}\n");
		
		return sb.toString();
	}
}
