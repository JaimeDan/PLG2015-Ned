package tree;

import java.util.List;

public class Declaraciones {

	public Declaraciones ( List<DecVar> dvs,  List<DecFP> dfs){
		this.dfs = dfs;
		this.dvs = dvs;
		
	}
	public List<DecVar> dvs;
	public List<DecFP> dfs;
}
