package jlatex.graphics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

import jlatex.layout.LatexLength;

class LatexSVGTest
{
	@Test
	void testSimple()
	{
		String rendered = new LatexSVG()
				.withFilename("image.svg")
				.write();
		
		assertEquals("\\includesvg{image.svg}", rendered.trim());
	}

	@Test
	void testWidth()
	{
		StringWriter sq = new StringWriter();
		PrintWriter writer = new PrintWriter(sq);
		
		new LatexSVG()
				.withFilename("image.svg")
				.withWidth(new LatexLength()
						.linewidth()
						.value(0.7)
						)
				.write(writer);
		
		assertEquals("\\includesvg[width=0.7\\linewidth]{image.svg}", sq.toString().trim());
	}
}
