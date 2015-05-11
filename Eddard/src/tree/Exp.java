package tree;

public abstract class Exp extends Val {
	//public Exp(){}
	
	public class ExpOr extends Exp{
		private ExpOr e0;
		private ExpAnd e1;
		
		public ExpOr(ExpOr e1, ExpAnd e2) {//B
			this.e0 = e1;
			this.e1 = e2;
		}
		public ExpOr(ExpAnd e) {
			this.e1 = e;
		}
		
	}
	
	
	public class ExpAnd extends Exp{ //B1
		private ExpAnd e1;
		private ExpComp e2;
		
		public ExpAnd(ExpAnd e1, ExpComp e2) {
			this.e1 = e1;
			this.e2 = e2;
		}
		public ExpAnd(ExpComp e) {
			this.e2 = e;
		}
	}
	public class ExpComp extends Exp{ //B2
		private ExpComp e2;
		private ExpNot e3;
		public ExpComp(ExpComp e2, ExpNot e3) {
			this.e2 = e2;
			this.e3 = e3;
		}
		public ExpComp(ExpNot e3) {
			this.e3 = e3;
		}
		
	}
	public class ExpNot extends Exp{ //B3
		private ExpNot e3;
		private ExpCteArit e4;
		public ExpNot(ExpNot e3) {
			this.e3 = e3;
		}
		public ExpNot(ExpCteArit e4) {
			this.e4 = e4;
		}
		
	}
	public class ExpCteArit extends Exp{ //B4
		
	}
}
