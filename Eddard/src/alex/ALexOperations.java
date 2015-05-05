package alex;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  
  public UnidadLexica unidadBegin() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.BEGIN, "Begin"); 
	  }
  public UnidadLexica unidadEnd() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.END, "End"); 
	  } 
  public UnidadLexica unidadDeclare() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.DECLARE, "Declare"); 
	  } 
  public UnidadLexica unidadVar() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.VAR, "var"); 
	  } 
  public UnidadLexica unidadClass() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.CLASS, "class"); 
	  } 
  public UnidadLexica unidadfunction() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.FUNCTION, "function"); 
	  } 
  public UnidadLexica unidadCClass() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.CCLASS, "Class"); 
	  } 
  public UnidadLexica unidadPublic() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.PUBLIC, "public"); 
	  } 
  public UnidadLexica unidadPrivate() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.PRIVATE, "private"); 
	  } 
  
  
  public UnidadLexica unidadIf() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.IF, "if"); 
	  } 
  public UnidadLexica unidadThen() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.THEN, "then"); 
	  } 
  public UnidadLexica unidadElse() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.ELSE, "else"); 
	  } 
  public UnidadLexica unidadEndif() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.ENDIF, "endif"); 
	  } 
  public UnidadLexica unidadWhile() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.WHILE, "while"); 
	  } 
  public UnidadLexica unidadDo() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.DO, "do"); 
	  } 
  
  public UnidadLexica unidadEndwhile() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.ENDWHILE, "endwhile"); 
	  } 
  public UnidadLexica unidadFor() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.FOR, "for"); 
	  } 
  
  public UnidadLexica unidadEndfor() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.ENDFOR, "endfor"); 
	  } 
  public UnidadLexica unidadForeach() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.FOREACH, "foreach"); 
	  } 
  public UnidadLexica unidadIn() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.IN, "in"); 
	  } 
  public UnidadLexica unidadEndforeach() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.ENDFOREACH, "endforeach"); 
	  } 
  public UnidadLexica unidadRepeat() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.REPEAT, "repeat"); 
	  } 
  public UnidadLexica unidadUntil() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.UNTIL, "until"); 
	  } 
  public UnidadLexica unidadEndrepeat() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.ENDREPEAT, "endrepeat"); 
	  } 
  public UnidadLexica unidadSwitch() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.SWITCH, "switch"); 
	  } 
  public UnidadLexica unidadCase() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.CASE, "case"); 
	  } 
  public UnidadLexica unidadDefault() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.DEFAULT, "Default"); 
	  } 
  public UnidadLexica unidadEndswitch() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.ENDSWITCH, "endswitch"); 
	  } 
  public UnidadLexica unidadReturn() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.RETURN, "return"); 
	  } 
  
  
  public UnidadLexica unidadInt() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.INT, "int"); 
	  } 
  public UnidadLexica unidadFloat() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.FLOAT, "float"); 
	  } 
  public UnidadLexica unidadChar() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.CHAR, "char"); 
	  } 
  public UnidadLexica unidadString() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.STRING, "string"); 
	  } 
  public UnidadLexica unidadBool() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.BOOL, "bool"); 
	  } 
  
  
  
  public UnidadLexica unidadId() {
     return new UnidadLexica(alex.fila(),ClaseLexica.ID,
                                         alex.lexema()); 
  } 
  public UnidadLexica unidadIId() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.IID,
	                                         alex.lexema()); 
	  } 
  public UnidadLexica unidadEnt() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.ENT,
	                                         alex.lexema()); 
	  } 
  public UnidadLexica unidadReal() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.REAL,
	                                         alex.lexema()); 
	  } 
  public UnidadLexica unidadBoolean() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.BOOLEAN,
	                                         alex.lexema()); 
	  } 
  public UnidadLexica unidadVchar() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.VCHAR,
	                                         alex.lexema()); 
	  } 
  public UnidadLexica unidadVstring() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.VSTRING,
	                                         alex.lexema()); 
	  } 
  
  
  public UnidadLexica unidadSuma() {
     return new UnidadLexica(alex.fila(),ClaseLexica.SUMA, "+"); 
  } 
  public UnidadLexica unidadResta() {
     return new UnidadLexica(alex.fila(),ClaseLexica.RESTA, "-"); 
  } 
  public UnidadLexica unidadMul() {
     return new UnidadLexica(alex.fila(),ClaseLexica.MULT, "*"); 
  } 
  public UnidadLexica unidadDiv() {
     return new UnidadLexica(alex.fila(),ClaseLexica.DIV,"/"); 
  } 
  public UnidadLexica unidadDivEnt() {
     return new UnidadLexica(alex.fila(),ClaseLexica.DIVENT,":"); 
  } 
  public UnidadLexica unidadModulo() {
     return new UnidadLexica(alex.fila(),ClaseLexica.MOD,"%"); 
  } 
  public UnidadLexica unidadExp() {
     return new UnidadLexica(alex.fila(),ClaseLexica.EXP,"^"); 
  } 
  public UnidadLexica unidadAnd() {
     return new UnidadLexica(alex.fila(),ClaseLexica.AND,"&&"); 
  }
  public UnidadLexica unidadOr() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.OR, "||"); 
	  } 
  public UnidadLexica unidadNot() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.NOT, "!"); 
	  } 
  public UnidadLexica unidadPAp() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.PAP, "("); 
	  } 
  public UnidadLexica unidadPCierre() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.PCIERRE, ")"); 
	  }
  public UnidadLexica unidadLAp() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.LAP, "{"); 
	  }
  public UnidadLexica unidadLCierre() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.LCIERRE, "}"); 
	  }
  public UnidadLexica unidadOpIgual() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.OPIGUAL, "=="); 
	  } 
  public UnidadLexica unidadDistinto() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.OPDISTINTO, "!="); 
	  } 
  public UnidadLexica unidadMenor() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.MENOR, "<"); 
	  } 
  public UnidadLexica unidadMenori() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.MENORIG, "<="); 
	  } 
  public UnidadLexica unidadMayor() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.MAYOR, ">"); 
	  } 
  public UnidadLexica unidadMayori() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.MAYORIG, ">="); 
	  }  
  public UnidadLexica unidadIgual() {
     return new UnidadLexica(alex.fila(),ClaseLexica.IGUAL, "="); 
  } 
  public UnidadLexica unidadComa() {
     return new UnidadLexica(alex.fila(),ClaseLexica.COMA, ","); 
  } 
  public UnidadLexica unidadPuntocoma() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.PUNTOCOMA, ";"); 
	  } 
  public UnidadLexica unidadEof() {
     return new UnidadLexica(alex.fila(),ClaseLexica.EOF, "<EOF"); 
  }
  public void error() {
    System.err.println("***"+alex.fila()+" Caracter inexperado: "+alex.lexema());
  }
}
