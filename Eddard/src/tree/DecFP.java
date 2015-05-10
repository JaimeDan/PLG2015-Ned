package tree;

public abstract class DecFP {
	private List<Argumento> args;
	private Id name;
	private List<Stm> sents;
	
	public DecFP(List<Argumento> args, Id name, List<Stm> sents, Tipo tipo){
		this.args = args;
		this.name = name;
		this.sents = sents;
	}
	public class DecF extends DecFP{
		private Tipo tipo;
		public DecF(List<Argumento> args, Id name, List<Stm> sents, Tipo tipo){
			super(args, name, sents);
			this.tipo = tipo;
		}
		
	}
	public class DecP extends DecFP{
		public DecF(List<Argumento> args, Id name, List<Stm> sents, Tipo tipo){
			super(args, name, sents);
		}
		
	}
	
}
