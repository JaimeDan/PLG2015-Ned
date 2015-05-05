package alex;

import errors.GestionErroresTiny;

%%
%line
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode
%cup
%public

%{
 private ALexOperations ops;
 private GestionErroresTiny errores;
 public String lexema() {return yytext();}
 public int fila() {return yyline+1;}
 public void fijaGestionErrores(GestionErroresTiny errores) {
   this.errores = errores;
 }
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
parteEntera = ({digitoPositivo}{digito}*|0)
parteDecimal = {digito}* {digitoPositivo}

separador = [ \t\r\b\n]
comentario = #[^\n]* 
comAp = /\*
comCierre = \*/

Begin = Begin
End = End
Declare = Declare
var = var
class = class
function = function
Class = Class
public = public
private = private

if = if
then = then
else = else
endif = endif
while = while
do = do
endwhile = endwhile
for = for
endfor = endfor
foreach = foreach
in = in
endforeach = endforeach
repeat = repeat
until = until
endrepeat = endrepeat
switch = switch
case = case
Default = Default
endswitch = endswitch
return = return


int = int
float = float
char = char
string = string
bool = bool


id = {min}({min}|{may}|{digito})*
Id = {may}({min}|{may}|{digito})*

ent = [\+,\-]?{parteEntera}
real = [\+,\-]?{parteEntera}\.{parteDecimal}
boolean = (True|False)
vchar = \' (may | min |digitopositivo |0| separador) \'
vstring = \" (may | min |digitopositivo |0| separador)* \"

operadorSuma = \+
operadorResta = \-
operadorMultiplicacion = \*
operadorDivision = /
operadorDivEntera = \:
operadorModulo = \%
operadorExponencial = \u005E
operadorAnd = \&\&
operadorOr = \|\|
operadorNot = \!
parentesisApertura = \(
parentesisCierre = \)
llavesApertura = \{
llavesCierre = \}
operadorIgual = \=\=
operadorDistinto =\!\=
operadorMenor = \<
operadorMenorIgual = \<\=
operadorMayor = \>
operadorMayorIgual = \>\=
igual = \=
coma  = \,
puntoycoma = \;

%%
{separador}               {}
{comentario}              {}
{comAp}	                  {}
{comCierre}               {}

{Begin}                   {return ops.unidadBegin();}
{End}                     {return ops.unidadEnd();}
{Declare}                 {return ops.unidadDeclare();}
{var}                     {return ops.unidadVar();}
{class}                   {return ops.unidadClass();}
{function}                {return ops.unidadfunction();}
{Class}                   {return ops.unidadCClass();}
{public}                  {return ops.unidadPublic();}
{private}                  {return ops.unidadPrivate();}

{if}                  {return ops.unidadIf();}
{then}                  {return ops.unidadThen();}
{else}                  {return ops.unidadElse();}
{endif}                  {return ops.unidadEndif();}
{while}                  {return ops.unidadWhile();}
{do}                  {return ops.unidadDo();}
{endwhile}                  {return ops.unidadEndwhile();}
{for}                  {return ops.unidadFor();}
{endfor}                  {return ops.unidadEndfor();}
{foreach}                  {return ops.unidadForeach();}
{in}                  {return ops.unidadIn();}
{endforeach}                  {return ops.unidadEndforeach();}
{repeat}                  {return ops.unidadRepeat();}
{until}                  {return ops.unidadUntil();}
{endrepeat}                  {return ops.unidadEndrepeat();}
{switch}                  {return ops.unidadSwitch();}
{case}                  {return ops.unidadCase();}
{Default}                  {return ops.unidadDefault();}
{endswitch}                  {return ops.unidadEndswitch();}
{return}                  {return ops.unidadReturn();}

{int}                  {return ops.unidadInt();}
{float}                  {return ops.unidadFloat();}
{char}                  {return ops.unidadChar();}
{string}                  {return ops.unidadString();}
{bool}                    {return ops.unidadBool();}

{id}                      {return ops.unidadId();}
{Id}                      {return ops.unidadIId();}

{ent}                     {return ops.unidadEnt();}
{real}                    {return ops.unidadReal();}
{boolean}                 {return ops.unidadBoolean();}
{vchar}                    {return ops.unidadVchar();}
{vstring}                  {return ops.unidadVstring();}

{operadorSuma}            {return ops.unidadSuma();}
{operadorResta}           {return ops.unidadResta();}
{operadorMultiplicacion}  {return ops.unidadMul();}
{operadorDivision}        {return ops.unidadDiv();}
{operadorDivEntera}      {return ops.unidadDivEnt();}
{operadorModulo}          {return ops.unidadModulo();}
{operadorExponencial}     {return ops.unidadExp();}
{operadorAnd}             {return ops.unidadAnd();}
{operadorOr}              {return ops.unidadOr();}
{operadorNot}             {return ops.unidadNot();}
{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();} 
{llavesApertura}          {return ops.unidadLAp();}
{llavesCierre}            {return ops.unidadLCierre();}
{operadorIgual}           {return ops.unidadOpIgual();}
{operadorDistinto}        {return ops.unidadDistinto();}
{operadorMenor}           {return ops.unidadMenor();}
{operadorMenorIgual}      {return ops.unidadMenori();}
{operadorMayor}           {return ops.unidadMayor();}
{operadorMayorIgual}      {return ops.unidadMayori();}
{igual}                   {return ops.unidadIgual();} 
{coma}                    {return ops.unidadComa();}
{puntoycoma}              {return ops.unidadPuntocoma();}
[^]                       {errores.errorLexico(fila(),lexema());} 