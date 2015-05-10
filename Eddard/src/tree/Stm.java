package tree;

public abstract class Stm extends Nodo{
	
	public class If extends Stm {
		private Exp cond;
		private Stm s1, s2;
		public If(Exp e, Stm s1, Stm s2){
			this.cond = e;
			this.s1 = s1;
			this.s2 = s2;
		}
	}
	public class While extends Stm{
		private Exp cond;
		private Stm s;
		public While (Exp e, Stm s){
			this.cond = e;
			this.s = s;
		}
		
	}
	public class For extends Stm{
		private Asignacion ass1;
		private Asignacion ass2;
		private Exp e;
		private Stm s;
		public For(Asignacion ass1, Asignacion ass2, Exp e, Stm s){
			this.ass1 = ass1;
			this.ass2 = ass2;
			this.e = e;
			this.s = s;
		}
	}
	public class Foreach extends Stm{
		private Id id1;
		private Id id2;
		private Stm s;
		public Foreach(Id id1, Id id2, Stm s){
			this.id1 = id1;
			this.id2 = id2;
			this.s = s;
		}
	}
	public class Repeat extends Stm{
		private Exp e;
		private Stm s;
		public Repeat(Exp e, Stm s){
			this.e = e;
			this.s = s;
		}
	}
	public class Case extends Stm{
		private Exp value;
		private Stm s;
		public Case (Exp value, Stm s){
			this.s = s;
			this.value = value;
		}
	}
	public class Default extends Stm{
		private Stm s;
		public Default( Stm s){
			this.s = s;
		}
	}
	public class Switch extends Stm{
		private Id id;
		private List<Case> cases;
		private Default def;
		public Switch(Id id, List<Case> cases, Default def){
			this.id = id;
			this.cases = cases;
			this.def = def;
		}
	}
	public class Return extends Stm{
		private Exp e;
		public Return(Exp e){
			this.e = e;
		}
	}
	public class Asignacion extends Stm{
		
	}
	
}
