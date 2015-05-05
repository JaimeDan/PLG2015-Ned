package alex;
import errors.GestionErroresTiny;


public class AnalizadorLexicoTiny implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;

 private ALexOperations ops;
 private GestionErroresTiny errores;
 public String lexema() {return yytext();}
 public int fila() {return yyline+1;}
 public void fijaGestionErrores(GestionErroresTiny errores) {
   this.errores = errores;
 }
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public AnalizadorLexicoTiny (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public AnalizadorLexicoTiny (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private AnalizadorLexicoTiny () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;

  ops = new ALexOperations(this);
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NO_ANCHOR,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NO_ANCHOR,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NO_ANCHOR,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NO_ANCHOR,
		/* 119 */ YY_NO_ANCHOR,
		/* 120 */ YY_NO_ANCHOR,
		/* 121 */ YY_NO_ANCHOR,
		/* 122 */ YY_NO_ANCHOR,
		/* 123 */ YY_NO_ANCHOR,
		/* 124 */ YY_NO_ANCHOR,
		/* 125 */ YY_NO_ANCHOR,
		/* 126 */ YY_NO_ANCHOR,
		/* 127 */ YY_NO_ANCHOR,
		/* 128 */ YY_NO_ANCHOR,
		/* 129 */ YY_NO_ANCHOR,
		/* 130 */ YY_NO_ANCHOR,
		/* 131 */ YY_NO_ANCHOR,
		/* 132 */ YY_NO_ANCHOR,
		/* 133 */ YY_NO_ANCHOR,
		/* 134 */ YY_NO_ANCHOR,
		/* 135 */ YY_NO_ANCHOR,
		/* 136 */ YY_NO_ANCHOR,
		/* 137 */ YY_NO_ANCHOR,
		/* 138 */ YY_NO_ANCHOR,
		/* 139 */ YY_NO_ANCHOR,
		/* 140 */ YY_NO_ANCHOR,
		/* 141 */ YY_NO_ANCHOR,
		/* 142 */ YY_NO_ANCHOR,
		/* 143 */ YY_NO_ANCHOR,
		/* 144 */ YY_NO_ANCHOR,
		/* 145 */ YY_NO_ANCHOR,
		/* 146 */ YY_NO_ANCHOR,
		/* 147 */ YY_NO_ANCHOR,
		/* 148 */ YY_NO_ANCHOR,
		/* 149 */ YY_NO_ANCHOR,
		/* 150 */ YY_NO_ANCHOR,
		/* 151 */ YY_NO_ANCHOR,
		/* 152 */ YY_NO_ANCHOR,
		/* 153 */ YY_NO_ANCHOR,
		/* 154 */ YY_NO_ANCHOR,
		/* 155 */ YY_NO_ANCHOR,
		/* 156 */ YY_NO_ANCHOR,
		/* 157 */ YY_NO_ANCHOR,
		/* 158 */ YY_NO_ANCHOR,
		/* 159 */ YY_NO_ANCHOR,
		/* 160 */ YY_NO_ANCHOR,
		/* 161 */ YY_NO_ANCHOR,
		/* 162 */ YY_NO_ANCHOR,
		/* 163 */ YY_NO_ANCHOR,
		/* 164 */ YY_NO_ANCHOR,
		/* 165 */ YY_NO_ANCHOR,
		/* 166 */ YY_NO_ANCHOR,
		/* 167 */ YY_NO_ANCHOR,
		/* 168 */ YY_NO_ANCHOR,
		/* 169 */ YY_NO_ANCHOR,
		/* 170 */ YY_NO_ANCHOR,
		/* 171 */ YY_NO_ANCHOR,
		/* 172 */ YY_NO_ANCHOR,
		/* 173 */ YY_NO_ANCHOR,
		/* 174 */ YY_NO_ANCHOR,
		/* 175 */ YY_NO_ANCHOR,
		/* 176 */ YY_NO_ANCHOR,
		/* 177 */ YY_NO_ANCHOR,
		/* 178 */ YY_NO_ANCHOR,
		/* 179 */ YY_NO_ANCHOR,
		/* 180 */ YY_NO_ANCHOR,
		/* 181 */ YY_NO_ANCHOR,
		/* 182 */ YY_NO_ANCHOR,
		/* 183 */ YY_NO_ANCHOR,
		/* 184 */ YY_NO_ANCHOR,
		/* 185 */ YY_NO_ANCHOR,
		/* 186 */ YY_NO_ANCHOR,
		/* 187 */ YY_NO_ANCHOR,
		/* 188 */ YY_NO_ANCHOR,
		/* 189 */ YY_NO_ANCHOR,
		/* 190 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"3:8,4:2,1,3:2,4,3:18,4,47,37,2,3,43,45,36,48,49,40,38,32,39,33,41,31,30:9,4" +
"2,55,53,52,54,3:2,29,5,23,12,10,35,29:13,34,29:6,3:3,44,3:2,15,25,13,11,6,1" +
"9,7,26,8,28:2,14,28,9,22,24,28,16,18,21,20,17,27,28:3,50,46,51,3:65410,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,191,
"0,1:2,2,1,3,4,5,6,1:2,6:2,1:5,7,1:4,8,9,10,1,11,12:2,13,1:6,12,14,12,15,12:" +
"5,14,12:4,14,12,16,12:5,14:2,12:7,17,18,19,20,21,22,23,24,25,26,27,28,29,30" +
",31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55" +
",56,57,58,12,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79" +
",80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,10" +
"3,104,12,105,106,107,108,109,14,110,111,112,113,114,115,116,117,118,119,120" +
",121,122,123,124,125,126,127,128,129,130,131,132,133,14,134,135")[0];

	private int yy_nxt[][] = unpackFromString(136,56,
"1,2,3,4,2,5,6,157,70,157,103,74,180,164,157:2,168,104,171,106,173,175,157,1" +
"82,176,177,157,178,157,188,7,71,8,4,184,190,9,10,11,12,13,14,15,16,17,68,72" +
",18,19,20,21,22,23,24,25,26,-1:58,3:54,-1:5,188,156,163:3,188,163,188,163:1" +
"0,188,163:5,188:3,-1:2,188:2,-1:25,157:4,179,157:4,108,157:15,110:2,-1:2,15" +
"7:2,-1:50,7:2,-1,30,-1:52,7,71,-1:76,33,-1:55,34,-1:55,35,-1:55,36,-1:8,157" +
":16,37,157:8,110:2,-1:2,157:2,-1:25,157:25,110:2,-1:2,157:2,-1:50,30:2,-1:2" +
"9,188,163:4,188,163,188,163:10,188,163:5,188:3,-1:2,188:2,-1:25,157,142,157" +
":23,110:2,-1:2,157:2,-1:25,157,154,157:23,110:2,-1:2,157:2,-1:65,31,-1:15,1" +
"88,163:4,188,38,188,163:10,188,163:5,188:3,-1:2,188:2,-1:25,157:4,27,157:9," +
"28,157:10,110:2,-1:2,157:2,-1:53,30,-1:68,32,-1:14,188,163:3,46,188,163,188" +
",163:10,188,163:5,188:3,-1:2,188:2,-1:25,157:17,29,157:7,110:2,-1:2,157:2,-" +
"1:25,188,163:4,188,163,188,163:5,51,163:4,188,163:5,188:3,-1:2,188:2,-1:25," +
"157:11,39,157:13,110:2,-1:2,157:2,-1:25,188,59,163:3,188,163,188,163:10,188" +
",163:5,188:3,-1:2,188:2,-1:25,157:11,40,157:13,110:2,-1:2,157:2,-1:25,188,1" +
"63:4,188,163,188,163:8,60,163,188,163:5,188:3,-1:2,188:2,-1:25,157,41,157:2" +
"3,110:2,-1:2,157:2,-1:25,157,42,157:23,110:2,-1:2,157:2,-1:25,157:11,43,157" +
":13,110:2,-1:2,157:2,-1:25,157:4,44,157:20,110:2,-1:2,157:2,-1:25,157:9,45," +
"157:15,110:2,-1:2,157:2,-1:25,157:14,47,157:10,110:2,-1:2,157:2,-1:25,157:1" +
"3,48,157:11,110:2,-1:2,157:2,-1:25,157:16,49,157:8,110:2,-1:2,157:2,-1:25,1" +
"57:9,50,157:15,110:2,-1:2,157:2,-1:25,157,52,157:23,110:2,-1:2,157:2,-1:25," +
"157:11,53,157:13,110:2,-1:2,157:2,-1:25,157:4,54,157:20,110:2,-1:2,157:2,-1" +
":25,157:16,55,157:8,110:2,-1:2,157:2,-1:25,157:2,56,157:22,110:2,-1:2,157:2" +
",-1:25,157:21,57,157:3,110:2,-1:2,157:2,-1:25,157:8,58,157:16,110:2,-1:2,15" +
"7:2,-1:25,157:21,61,157:3,110:2,-1:2,157:2,-1:25,157,62,157:23,110:2,-1:2,1" +
"57:2,-1:25,157,63,157:23,110:2,-1:2,157:2,-1:25,157:4,64,157:20,110:2,-1:2," +
"157:2,-1:25,157:16,65,157:8,110:2,-1:2,157:2,-1:25,157:21,66,157:3,110:2,-1" +
":2,157:2,-1:25,157:21,67,157:3,110:2,-1:2,157:2,-1:25,188,163:3,69,188,163," +
"188,163:10,188,163:5,188:3,-1:2,188:2,-1:25,157:10,76,157:14,110:2,-1:2,157" +
":2,-1:25,188,163:2,73,163,188,163,188,163:10,188,163:5,188:3,-1:2,188:2,-1:" +
"25,157:9,118,157:5,119,157,78,157:7,110:2,-1:2,157:2,-1:25,188,163:4,188,16" +
"3,188,163:5,75,163:4,188,163:5,188:3,-1:2,188:2,-1:25,157:13,80,157:11,110:" +
"2,-1:2,157:2,-1:25,188,163:4,188,163,188,163:3,77,163:6,188,163:5,188:3,-1:" +
"2,188:2,-1:25,188,163:4,188,163,188,163,79,163:8,188,163:5,188:3,-1:2,188:2" +
",-1:25,157:10,125,157:14,110:2,-1:2,157:2,-1:25,157:13,81,157:11,110:2,-1:2" +
",157:2,-1:25,157:10,82,157:14,110:2,-1:2,157:2,-1:25,157:16,126,157:2,127,1" +
"57:5,110:2,-1:2,157:2,-1:25,157:11,169,157:13,110:2,-1:2,157:2,-1:25,157:3," +
"159,157:21,110:2,-1:2,157:2,-1:25,157:17,128,157:7,110:2,-1:2,157:2,-1:25,1" +
"57:4,129,157:20,110:2,-1:2,157:2,-1:25,157:16,130,157:8,110:2,-1:2,157:2,-1" +
":25,157,83,157:23,110:2,-1:2,157:2,-1:25,157:20,132,157:4,110:2,-1:2,157:2," +
"-1:25,157:17,84,157:7,110:2,-1:2,157:2,-1:25,157:3,85,157:7,160,157,134,135" +
",157:7,136,157:2,110:2,-1:2,157:2,-1:25,157:13,86,157:11,110:2,-1:2,157:2,-" +
"1:25,157:15,137,157:9,110:2,-1:2,157:2,-1:25,157,138,157:23,110:2,-1:2,157:" +
"2,-1:25,157:10,87,157:14,110:2,-1:2,157:2,-1:25,157:8,141,157:16,110:2,-1:2" +
",157:2,-1:25,157:3,88,157:21,110:2,-1:2,157:2,-1:25,157:12,161,157:12,110:2" +
",-1:2,157:2,-1:25,157:9,143,157:15,110:2,-1:2,157:2,-1:25,157:9,89,157:15,1" +
"10:2,-1:2,157:2,-1:25,157:22,145,157:2,110:2,-1:2,157:2,-1:25,157:17,90,157" +
":7,110:2,-1:2,157:2,-1:25,157:21,162,157:3,110:2,-1:2,157:2,-1:25,157:11,91" +
",157:13,110:2,-1:2,157:2,-1:25,157:10,92,157:14,110:2,-1:2,157:2,-1:25,157:" +
"4,93,157:20,110:2,-1:2,157:2,-1:25,157:8,94,157:16,110:2,-1:2,157:2,-1:25,1" +
"57:16,166,157:8,110:2,-1:2,157:2,-1:25,157:10,146,157:14,110:2,-1:2,157:2,-" +
"1:25,157:3,95,157:21,110:2,-1:2,157:2,-1:25,157:19,148,157:5,110:2,-1:2,157" +
":2,-1:25,157:3,149,157:21,110:2,-1:2,157:2,-1:25,157:8,96,157:16,110:2,-1:2" +
",157:2,-1:25,157:16,97,157:8,110:2,-1:2,157:2,-1:25,157,152,157:23,110:2,-1" +
":2,157:2,-1:25,157:16,153,157:8,110:2,-1:2,157:2,-1:25,157:9,98,157:15,110:" +
"2,-1:2,157:2,-1:25,157:17,99,157:7,110:2,-1:2,157:2,-1:25,157:10,100,157:14" +
",110:2,-1:2,157:2,-1:25,157:8,101,157:16,110:2,-1:2,157:2,-1:25,157:10,155," +
"157:14,110:2,-1:2,157:2,-1:25,157:8,102,157:16,110:2,-1:2,157:2,-1:25,188,1" +
"63,105,163:2,188,163,188,163:10,188,163:5,188:3,-1:2,188:2,-1:25,157:3,131," +
"157:21,110:2,-1:2,157:2,-1:25,157:16,140,157:8,110:2,-1:2,157:2,-1:25,157,1" +
"44,157:23,110:2,-1:2,157:2,-1:25,157:10,147,157:14,110:2,-1:2,157:2,-1:25,1" +
"57:3,150,157:21,110:2,-1:2,157:2,-1:25,157:9,112,113,157:10,114,157:3,110:2" +
",-1:2,157:2,-1:25,157:3,133,157:21,110:2,-1:2,157:2,-1:25,157:3,151,157:21," +
"110:2,-1:2,157:2,-1:25,188,163:4,188,163,188,163:2,107,163:7,188,163:5,188:" +
"3,-1:2,188:2,-1:25,157,115,157:23,110:2,-1:2,157:2,-1:25,157:3,139,157:21,1" +
"10:2,-1:2,157:2,-1:25,188:2,163:3,188,163,188,163:10,188,163:5,188:3,-1:2,1" +
"88:2,-1:25,157:16,116,157:5,117,157:2,110:2,-1:2,157:2,-1:25,188,163:4,188," +
"163,188,163:2,109,163:7,188,163:5,188:3,-1:2,188:2,-1:25,157:4,120,157:20,1" +
"10:2,-1:2,157:2,-1:25,188,163:4,188,163,188,163:7,111,163:2,188,163:5,188:3" +
",-1:2,188:2,-1:25,157:21,121,157:3,110:2,-1:2,157:2,-1:25,157:11,158,157:3," +
"122,157:9,110:2,-1:2,157:2,-1:25,157:17,123,157:7,110:2,-1:2,157:2,-1:25,15" +
"7:21,165,157:3,110:2,-1:2,157:2,-1:25,157:6,124,157:18,110:2,-1:2,157:2,-1:" +
"25,188,187,163:3,188,163,188,163:10,188,163:5,188:3,-1:2,188:2,-1:25,188,16" +
"3:4,188,163,188,163:7,170,163:2,188,163:5,188:3,-1:2,188:2,-1:25,188,163:4," +
"188,163,188,163,167,163:8,188,163:5,188:3,-1:2,188:2,-1:25,188,163:4,188,16" +
"3,188,163,172,163:8,188,163:5,188:3,-1:2,188:2,-1:25,188,163:4,188,163,188," +
"163:3,181,163:6,188,163:5,188:3,-1:2,188:2,-1:25,188,163:4,188,163,188,163:" +
"2,174,163:7,188,163:5,188:3,-1:2,188:2,-1:25,188,163:4,188,163,188,163:5,17" +
"0,163:4,188,163:5,188:3,-1:2,188:2,-1:25,188,163:4,188,163,188,183,163:5,18" +
"5,163:3,188,163:5,188:3,-1:2,188:2,-1:25,188,163:4,188,163,188,163,186,163:" +
"8,188,163:5,188:3,-1:2,188:2,-1:25,188,163:4,188,163,188,163:2,189,163:7,18" +
"8,163:5,188:3,-1:2,188:2,-1:20");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

  return ops.unidadEof();
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{}
					case -3:
						break;
					case 3:
						{}
					case -4:
						break;
					case 4:
						{errores.errorLexico(fila(),lexema());}
					case -5:
						break;
					case 5:
						{return ops.unidadIId();}
					case -6:
						break;
					case 6:
						{return ops.unidadId();}
					case -7:
						break;
					case 7:
						{return ops.unidadEnt();}
					case -8:
						break;
					case 8:
						{return ops.unidadComa();}
					case -9:
						break;
					case 9:
						{return ops.unidadVchar();}
					case -10:
						break;
					case 10:
						{return ops.unidadVstring();}
					case -11:
						break;
					case 11:
						{return ops.unidadSuma();}
					case -12:
						break;
					case 12:
						{return ops.unidadResta();}
					case -13:
						break;
					case 13:
						{return ops.unidadMul();}
					case -14:
						break;
					case 14:
						{return ops.unidadDiv();}
					case -15:
						break;
					case 15:
						{return ops.unidadDivEnt();}
					case -16:
						break;
					case 16:
						{return ops.unidadModulo();}
					case -17:
						break;
					case 17:
						{return ops.unidadExp();}
					case -18:
						break;
					case 18:
						{return ops.unidadNot();}
					case -19:
						break;
					case 19:
						{return ops.unidadPAp();}
					case -20:
						break;
					case 20:
						{return ops.unidadPCierre();}
					case -21:
						break;
					case 21:
						{return ops.unidadLAp();}
					case -22:
						break;
					case 22:
						{return ops.unidadLCierre();}
					case -23:
						break;
					case 23:
						{return ops.unidadIgual();}
					case -24:
						break;
					case 24:
						{return ops.unidadMenor();}
					case -25:
						break;
					case 25:
						{return ops.unidadMayor();}
					case -26:
						break;
					case 26:
						{return ops.unidadPuntocoma();}
					case -27:
						break;
					case 27:
						{return ops.unidadIn();}
					case -28:
						break;
					case 28:
						{return ops.unidadIf();}
					case -29:
						break;
					case 29:
						{return ops.unidadDo();}
					case -30:
						break;
					case 30:
						{return ops.unidadReal();}
					case -31:
						break;
					case 31:
						{return ops.unidadAnd();}
					case -32:
						break;
					case 32:
						{return ops.unidadOr();}
					case -33:
						break;
					case 33:
						{return ops.unidadDistinto();}
					case -34:
						break;
					case 34:
						{return ops.unidadOpIgual();}
					case -35:
						break;
					case 35:
						{return ops.unidadMenori();}
					case -36:
						break;
					case 36:
						{return ops.unidadMayori();}
					case -37:
						break;
					case 37:
						{return ops.unidadInt();}
					case -38:
						break;
					case 38:
						{return ops.unidadEnd();}
					case -39:
						break;
					case 39:
						{return ops.unidadVar();}
					case -40:
						break;
					case 40:
						{return ops.unidadFor();}
					case -41:
						break;
					case 41:
						{return ops.unidadElse();}
					case -42:
						break;
					case 42:
						{return ops.unidadCase();}
					case -43:
						break;
					case 43:
						{return ops.unidadChar();}
					case -44:
						break;
					case 44:
						{return ops.unidadThen();}
					case -45:
						break;
					case 45:
						{return ops.unidadBool();}
					case -46:
						break;
					case 46:
						{return ops.unidadBegin();}
					case -47:
						break;
					case 47:
						{return ops.unidadEndif();}
					case -48:
						break;
					case 48:
						{return ops.unidadClass();}
					case -49:
						break;
					case 49:
						{return ops.unidadFloat();}
					case -50:
						break;
					case 50:
						{return ops.unidadUntil();}
					case -51:
						break;
					case 51:
						{return ops.unidadCClass();}
					case -52:
						break;
					case 52:
						{return ops.unidadWhile();}
					case -53:
						break;
					case 53:
						{return ops.unidadEndfor();}
					case -54:
						break;
					case 54:
						{return ops.unidadReturn();}
					case -55:
						break;
					case 55:
						{return ops.unidadRepeat();}
					case -56:
						break;
					case 56:
						{return ops.unidadString();}
					case -57:
						break;
					case 57:
						{return ops.unidadSwitch();}
					case -58:
						break;
					case 58:
						{return ops.unidadPublic();}
					case -59:
						break;
					case 59:
						{return ops.unidadDeclare();}
					case -60:
						break;
					case 60:
						{return ops.unidadDefault();}
					case -61:
						break;
					case 61:
						{return ops.unidadForeach();}
					case -62:
						break;
					case 62:
						{return ops.unidadPrivate();}
					case -63:
						break;
					case 63:
						{return ops.unidadEndwhile();}
					case -64:
						break;
					case 64:
						{return ops.unidadfunction();}
					case -65:
						break;
					case 65:
						{return ops.unidadEndrepeat();}
					case -66:
						break;
					case 66:
						{return ops.unidadEndswitch();}
					case -67:
						break;
					case 67:
						{return ops.unidadEndforeach();}
					case -68:
						break;
					case 68:
						{errores.errorLexico(fila(),lexema());}
					case -69:
						break;
					case 69:
						{return ops.unidadIId();}
					case -70:
						break;
					case 70:
						{return ops.unidadId();}
					case -71:
						break;
					case 71:
						{return ops.unidadEnt();}
					case -72:
						break;
					case 72:
						{errores.errorLexico(fila(),lexema());}
					case -73:
						break;
					case 73:
						{return ops.unidadIId();}
					case -74:
						break;
					case 74:
						{return ops.unidadId();}
					case -75:
						break;
					case 75:
						{return ops.unidadIId();}
					case -76:
						break;
					case 76:
						{return ops.unidadId();}
					case -77:
						break;
					case 77:
						{return ops.unidadIId();}
					case -78:
						break;
					case 78:
						{return ops.unidadId();}
					case -79:
						break;
					case 79:
						{return ops.unidadIId();}
					case -80:
						break;
					case 80:
						{return ops.unidadId();}
					case -81:
						break;
					case 81:
						{return ops.unidadId();}
					case -82:
						break;
					case 82:
						{return ops.unidadId();}
					case -83:
						break;
					case 83:
						{return ops.unidadId();}
					case -84:
						break;
					case 84:
						{return ops.unidadId();}
					case -85:
						break;
					case 85:
						{return ops.unidadId();}
					case -86:
						break;
					case 86:
						{return ops.unidadId();}
					case -87:
						break;
					case 87:
						{return ops.unidadId();}
					case -88:
						break;
					case 88:
						{return ops.unidadId();}
					case -89:
						break;
					case 89:
						{return ops.unidadId();}
					case -90:
						break;
					case 90:
						{return ops.unidadId();}
					case -91:
						break;
					case 91:
						{return ops.unidadId();}
					case -92:
						break;
					case 92:
						{return ops.unidadId();}
					case -93:
						break;
					case 93:
						{return ops.unidadId();}
					case -94:
						break;
					case 94:
						{return ops.unidadId();}
					case -95:
						break;
					case 95:
						{return ops.unidadId();}
					case -96:
						break;
					case 96:
						{return ops.unidadId();}
					case -97:
						break;
					case 97:
						{return ops.unidadId();}
					case -98:
						break;
					case 98:
						{return ops.unidadId();}
					case -99:
						break;
					case 99:
						{return ops.unidadId();}
					case -100:
						break;
					case 100:
						{return ops.unidadId();}
					case -101:
						break;
					case 101:
						{return ops.unidadId();}
					case -102:
						break;
					case 102:
						{return ops.unidadId();}
					case -103:
						break;
					case 103:
						{return ops.unidadIId();}
					case -104:
						break;
					case 104:
						{return ops.unidadId();}
					case -105:
						break;
					case 105:
						{return ops.unidadIId();}
					case -106:
						break;
					case 106:
						{return ops.unidadId();}
					case -107:
						break;
					case 107:
						{return ops.unidadIId();}
					case -108:
						break;
					case 108:
						{return ops.unidadId();}
					case -109:
						break;
					case 109:
						{return ops.unidadIId();}
					case -110:
						break;
					case 110:
						{return ops.unidadId();}
					case -111:
						break;
					case 111:
						{return ops.unidadIId();}
					case -112:
						break;
					case 112:
						{return ops.unidadId();}
					case -113:
						break;
					case 113:
						{return ops.unidadId();}
					case -114:
						break;
					case 114:
						{return ops.unidadId();}
					case -115:
						break;
					case 115:
						{return ops.unidadId();}
					case -116:
						break;
					case 116:
						{return ops.unidadId();}
					case -117:
						break;
					case 117:
						{return ops.unidadId();}
					case -118:
						break;
					case 118:
						{return ops.unidadId();}
					case -119:
						break;
					case 119:
						{return ops.unidadId();}
					case -120:
						break;
					case 120:
						{return ops.unidadId();}
					case -121:
						break;
					case 121:
						{return ops.unidadId();}
					case -122:
						break;
					case 122:
						{return ops.unidadId();}
					case -123:
						break;
					case 123:
						{return ops.unidadId();}
					case -124:
						break;
					case 124:
						{return ops.unidadId();}
					case -125:
						break;
					case 125:
						{return ops.unidadId();}
					case -126:
						break;
					case 126:
						{return ops.unidadId();}
					case -127:
						break;
					case 127:
						{return ops.unidadId();}
					case -128:
						break;
					case 128:
						{return ops.unidadId();}
					case -129:
						break;
					case 129:
						{return ops.unidadId();}
					case -130:
						break;
					case 130:
						{return ops.unidadId();}
					case -131:
						break;
					case 131:
						{return ops.unidadId();}
					case -132:
						break;
					case 132:
						{return ops.unidadId();}
					case -133:
						break;
					case 133:
						{return ops.unidadId();}
					case -134:
						break;
					case 134:
						{return ops.unidadId();}
					case -135:
						break;
					case 135:
						{return ops.unidadId();}
					case -136:
						break;
					case 136:
						{return ops.unidadId();}
					case -137:
						break;
					case 137:
						{return ops.unidadId();}
					case -138:
						break;
					case 138:
						{return ops.unidadId();}
					case -139:
						break;
					case 139:
						{return ops.unidadId();}
					case -140:
						break;
					case 140:
						{return ops.unidadId();}
					case -141:
						break;
					case 141:
						{return ops.unidadId();}
					case -142:
						break;
					case 142:
						{return ops.unidadId();}
					case -143:
						break;
					case 143:
						{return ops.unidadId();}
					case -144:
						break;
					case 144:
						{return ops.unidadId();}
					case -145:
						break;
					case 145:
						{return ops.unidadId();}
					case -146:
						break;
					case 146:
						{return ops.unidadId();}
					case -147:
						break;
					case 147:
						{return ops.unidadId();}
					case -148:
						break;
					case 148:
						{return ops.unidadId();}
					case -149:
						break;
					case 149:
						{return ops.unidadId();}
					case -150:
						break;
					case 150:
						{return ops.unidadId();}
					case -151:
						break;
					case 151:
						{return ops.unidadId();}
					case -152:
						break;
					case 152:
						{return ops.unidadId();}
					case -153:
						break;
					case 153:
						{return ops.unidadId();}
					case -154:
						break;
					case 154:
						{return ops.unidadId();}
					case -155:
						break;
					case 155:
						{return ops.unidadId();}
					case -156:
						break;
					case 156:
						{return ops.unidadIId();}
					case -157:
						break;
					case 157:
						{return ops.unidadId();}
					case -158:
						break;
					case 158:
						{return ops.unidadId();}
					case -159:
						break;
					case 159:
						{return ops.unidadId();}
					case -160:
						break;
					case 160:
						{return ops.unidadId();}
					case -161:
						break;
					case 161:
						{return ops.unidadId();}
					case -162:
						break;
					case 162:
						{return ops.unidadId();}
					case -163:
						break;
					case 163:
						{return ops.unidadIId();}
					case -164:
						break;
					case 164:
						{return ops.unidadId();}
					case -165:
						break;
					case 165:
						{return ops.unidadId();}
					case -166:
						break;
					case 166:
						{return ops.unidadId();}
					case -167:
						break;
					case 167:
						{return ops.unidadIId();}
					case -168:
						break;
					case 168:
						{return ops.unidadId();}
					case -169:
						break;
					case 169:
						{return ops.unidadId();}
					case -170:
						break;
					case 170:
						{return ops.unidadIId();}
					case -171:
						break;
					case 171:
						{return ops.unidadId();}
					case -172:
						break;
					case 172:
						{return ops.unidadIId();}
					case -173:
						break;
					case 173:
						{return ops.unidadId();}
					case -174:
						break;
					case 174:
						{return ops.unidadIId();}
					case -175:
						break;
					case 175:
						{return ops.unidadId();}
					case -176:
						break;
					case 176:
						{return ops.unidadId();}
					case -177:
						break;
					case 177:
						{return ops.unidadId();}
					case -178:
						break;
					case 178:
						{return ops.unidadId();}
					case -179:
						break;
					case 179:
						{return ops.unidadId();}
					case -180:
						break;
					case 180:
						{return ops.unidadIId();}
					case -181:
						break;
					case 181:
						{return ops.unidadIId();}
					case -182:
						break;
					case 182:
						{return ops.unidadIId();}
					case -183:
						break;
					case 183:
						{return ops.unidadIId();}
					case -184:
						break;
					case 184:
						{return ops.unidadIId();}
					case -185:
						break;
					case 185:
						{return ops.unidadIId();}
					case -186:
						break;
					case 186:
						{return ops.unidadIId();}
					case -187:
						break;
					case 187:
						{return ops.unidadIId();}
					case -188:
						break;
					case 188:
						{return ops.unidadIId();}
					case -189:
						break;
					case 189:
						{return ops.unidadIId();}
					case -190:
						break;
					case 190:
						{return ops.unidadIId();}
					case -191:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
