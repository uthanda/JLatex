import java.util.ArrayList;

public class LatexPackage extends LatexContent{
	String name;
	ArrayList<String> options;
	public LatexPackage(String pName){
		this.name = pName;
		this.options = null;
	}
	public LatexPackage(String pName, ArrayList<String> pOptions){
		this.name = pName;
		this.options = pOptions;
	}
	@Override
	String toLatexCode() {
		String out = "";
		
		out += "\\usepackage";
		if(this.options != null){
			out += "[";
			for(String o : options){
				out += o;
				if(options.indexOf(o) != options.size() - 1) out += ",";
			}
			out += "]";
		}
		out += "{" + this.name + "}\n";
		
		return out;
	}

}
