package tree;

import java.util.List;

public class Program {

	public Program(Declaraciones ds, List<Stm> stms){
		this.ds = ds;
		this.stms = stms;
	}
	
	public List<Stm> stms;
	public Declaraciones ds;
	
	
}
