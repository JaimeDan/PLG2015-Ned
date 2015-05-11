package tree;

import java.util.List;

import tree.Stm.Asignacion;
import tree.Val.Exp;

public class DecVar {
	private Tipo tip;
	private Id id;
	private Asignacion asig;
	private boolean ass;
	public class Tipo{
		private String tipo;
		private List<Integer> indices;
		public Tipo (String tipo, List<Integer> ind){
			this.tipo = tipo;
			this.indices = ind;
		}
	}
	public DecVar(Tipo tip, Id id1){
		this.tip = tip;
		this.id = id1;
		this.ass = false;
	}
	public DecVar(Tipo tip, Id id1, Exp e){
		this.tip = tip;
		this.asig = new Asignacion(id1, e);
		this.ass = true;
	}
}
