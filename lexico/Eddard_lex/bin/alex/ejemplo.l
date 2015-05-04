package alex;

%%
%line
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode

%{
  private ALexOperations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

may  = [A-Z]
min  = [a-z]
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = {digitoPositivo}{digito}*
parteDecimal = {digito}* {digitoPositivo}
separador = [ \t\r\b\n]
comentario = #[^\n]* 
evalua = evalua

Begin
End
Declare
var
class
function
Class
public
private

if
then
else
endif
while
do
endwhile
for
endfor
foreach
in
endforeach
repeat
until
endrepeat
switch
case
Default
endswitch
return

int
float
char
string
bool


identificador = {letra}({letra}|{digito})*
int = [\+,\-]?{parteEntera}
float = [\+,\-]?{parteEntera}\.{parteDecimal}
bool = (True|False)


operadorSuma = \+
operadorResta = \-
operadorMultiplicacion = \*
operadorDivision = /
operadorDivEnetera = \:
operadorModulo = \%
operadorExponencial = \^
operadorAnd = \&&
operadorOr = \||
operadorNot = \!
parentesisApertura = \(
parentesisCierre = \)
operadorIgual = \==
operadorDistinto =\!=
operadorMenor = \<
operadorMenorIgual = \<=
operadorMayor = \>
operadorMayorIgual = \>=
igual = \=
coma  = \,
puntoycoma = \;


%%
{separador}               {}
{comentario}              {}
{evalua}                  {return ops.unidadEvalua();}
{donde}                   {return ops.unidadDonde();}
{identificador}           {return ops.unidadId();}
{numeroEntero}            {return ops.unidadEnt();}
{numeroReal}              {return ops.unidadReal();}
{operadorSuma}            {return ops.unidadSuma();}
{operadorResta}           {return ops.unidadResta();}
{operadorMultiplicacion}  {return ops.unidadMul();}
{operadorDivision}        {return ops.unidadDiv();}
{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();} 
{igual}                   {return ops.unidadIgual();} 
{coma}                    {return ops.unidadComa();}
[^]                       {ops.error();}  