package alex;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  
  public UnidadLexica unidadBegin() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.BEGIN); 
	  }
  public UnidadLexica unidadEnd() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.END); 
	  } 
  public UnidadLexica unidadDeclare() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.DECLARE); 
	  } 
  public UnidadLexica unidadVar() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.VAR); 
	  } 
  public UnidadLexica unidadClass() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.CLASS); 
	  } 
  public UnidadLexica unidadfunction() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.FUNCTION); 
	  } 
  public UnidadLexica unidadCClass() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.CCLASS); 
	  } 
  public UnidadLexica unidadPublic() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.PUBLIC); 
	  } 
  public UnidadLexica unidadPrivate() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.PRIVATE); 
	  } 
  
  
  public UnidadLexica unidadIf() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.IF); 
	  } 
  public UnidadLexica unidadThen() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.THEN); 
	  } 
  public UnidadLexica unidadElse() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.ELSE); 
	  } 
  public UnidadLexica unidadEndif() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.ENDIF); 
	  } 
  public UnidadLexica unidadWhile() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.WHILE); 
	  } 
  public UnidadLexica unidadDo() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.DO); 
	  } 
  
  public UnidadLexica unidadEndwhile() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.ENDWHILE); 
	  } 
  public UnidadLexica unidadFor() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.FOR); 
	  } 
  
  public UnidadLexica unidadEndfor() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.ENDFOR); 
	  } 
  public UnidadLexica unidadForeach() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.FOREACH); 
	  } 
  public UnidadLexica unidadIn() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.IN); 
	  } 
  public UnidadLexica unidadEndforeach() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.ENDFOREACH); 
	  } 
  public UnidadLexica unidadRepeat() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.REPEAT); 
	  } 
  public UnidadLexica unidadUntil() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.UNTIL); 
	  } 
  public UnidadLexica unidadEndrepeat() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.ENDREPEAT); 
	  } 
  public UnidadLexica unidadSwitch() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.SWITCH); 
	  } 
  public UnidadLexica unidadCase() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.CASE); 
	  } 
  public UnidadLexica unidadDefault() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.DEFAULT); 
	  } 
  public UnidadLexica unidadEndswitch() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.ENDSWITCH); 
	  } 
  public UnidadLexica unidadReturn() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.RETURN); 
	  } 
  
  
  public UnidadLexica unidadInt() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.INT); 
	  } 
  public UnidadLexica unidadFloat() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.FLOAT); 
	  } 
  public UnidadLexica unidadChar() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.CHAR); 
	  } 
  public UnidadLexica unidadString() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.STRING); 
	  } 
  public UnidadLexica unidadBool() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.BOOL); 
	  } 
  
  
  
  public UnidadLexica unidadId() {
     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.ID,
                                         alex.lexema()); 
  } 
  public UnidadLexica unidadIId() {
	     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.IID,
	                                         alex.lexema()); 
	  } 
  public UnidadLexica unidadEnt() {
	     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.ENT,
	                                         alex.lexema()); 
	  } 
  public UnidadLexica unidadReal() {
	     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.REAL,
	                                         alex.lexema()); 
	  } 
  public UnidadLexica unidadBoolean() {
	     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.BOOLEAN,
	                                         alex.lexema()); 
	  } 
  
  
  
  public UnidadLexica unidadSuma() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.SUMA); 
  } 
  public UnidadLexica unidadResta() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.RESTA); 
  } 
  public UnidadLexica unidadMul() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.MULT); 
  } 
  public UnidadLexica unidadDiv() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.DIV); 
  } 
  public UnidadLexica unidadDivEnt() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.DIVENT); 
  } 
  public UnidadLexica unidadModulo() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.MOD); 
  } 
  public UnidadLexica unidadExp() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.EXP); 
  } 
  public UnidadLexica unidadAnd() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.AND); 
  }
  public UnidadLexica unidadOr() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.OR); 
	  } 
  public UnidadLexica unidadNot() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.NOT); 
	  } 
  public UnidadLexica unidadPAp() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.PAP); 
	  } 
  public UnidadLexica unidadPCierre() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.PCIERRE); 
	  }
  public UnidadLexica unidadLAp() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.LAP); 
	  }
  public UnidadLexica unidadLCierre() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.LCIERRE); 
	  }
  public UnidadLexica unidadOpIgual() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.OPIGUAL); 
	  } 
  public UnidadLexica unidadDistinto() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.OPDISTINTO); 
	  } 
  public UnidadLexica unidadMenor() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.MENOR); 
	  } 
  public UnidadLexica unidadMenori() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.MENORIG); 
	  } 
  public UnidadLexica unidadMayor() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.MAYOR); 
	  } 
  public UnidadLexica unidadMayori() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.MAYORIG); 
	  }  
  public UnidadLexica unidadIgual() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.IGUAL); 
  } 
  public UnidadLexica unidadComa() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.COMA); 
  } 
  public UnidadLexica unidadPuntocoma() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.PUNTOCOMA); 
	  } 
  public UnidadLexica unidadEof() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.EOF); 
  }
  public void error() {
    System.err.println("***"+alex.fila()+" Caracter inexperado: "+alex.lexema());
  }
}
