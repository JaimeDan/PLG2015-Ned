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
		/* 190 */ YY_NO_ANCHOR,
		/* 191 */ YY_NO_ANCHOR,
		/* 192 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"3:8,4:2,1,3:2,4,3:18,4,47,39,2,3,43,45,38,48,49,6,40,34,41,35,5,33,32:9,42," +
"55,53,52,54,3:2,31,7,25,14,12,37,31:13,36,31:6,3:3,44,3:2,17,27,15,13,8,21," +
"9,28,10,30:2,16,30,11,24,26,30,18,20,23,22,19,29,30:3,50,46,51,3:65410,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,193,
"0,1:2,2,1,3,4,5,6,7,8,1:2,8:2,1:3,9,1:4,10,11,12,1:3,13,14:2,15,1:6,14,16,1" +
"4,17,14:5,16,14:4,16,14,18,14:5,16:2,14:7,19,20,21,22,23,24,25,26,27,28,29," +
"30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54," +
"55,56,57,58,59,60,14,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78," +
"79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102," +
"103,104,105,106,14,107,108,109,110,111,16,112,113,114,115,116,117,118,119,1" +
"20,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,16,136,137")[0];

	private int yy_nxt[][] = unpackFromString(138,56,
"1,2,3,4,2,5,6,7,8,159,72,159,105,76,182,166,159:2,170,106,173,108,175,177,1" +
"59,184,178,179,159,180,159,190,9,73,10,4,186,192,11,12,13,14,15,16,17,70,74" +
",18,19,20,21,22,23,24,25,26,-1:58,3:54,-1:6,27,-1:54,28,-1:57,190,158,165:3" +
",190,165,190,165:10,190,165:5,190:3,-1:2,190:2,-1:25,159:4,181,159:4,110,15" +
"9:15,112:2,-1:2,159:2,-1:50,9:2,-1,32,-1:52,9,73,-1:74,35,-1:55,36,-1:55,37" +
",-1:55,38,-1:10,159:16,39,159:8,112:2,-1:2,159:2,-1:25,159:25,112:2,-1:2,15" +
"9:2,-1:50,32:2,-1:29,190,165:4,190,165,190,165:10,190,165:5,190:3,-1:2,190:" +
"2,-1:25,159,144,159:23,112:2,-1:2,159:2,-1:25,159,156,159:23,112:2,-1:2,159" +
":2,-1:63,33,-1:17,190,165:4,190,40,190,165:10,190,165:5,190:3,-1:2,190:2,-1" +
":25,159:4,29,159:9,30,159:10,112:2,-1:2,159:2,-1:53,32,-1:66,34,-1:16,190,1" +
"65:3,48,190,165,190,165:10,190,165:5,190:3,-1:2,190:2,-1:25,159:17,31,159:7" +
",112:2,-1:2,159:2,-1:25,190,165:4,190,165,190,165:5,53,165:4,190,165:5,190:" +
"3,-1:2,190:2,-1:25,159:11,41,159:13,112:2,-1:2,159:2,-1:25,190,61,165:3,190" +
",165,190,165:10,190,165:5,190:3,-1:2,190:2,-1:25,159:11,42,159:13,112:2,-1:" +
"2,159:2,-1:25,190,165:4,190,165,190,165:8,62,165,190,165:5,190:3,-1:2,190:2" +
",-1:25,159,43,159:23,112:2,-1:2,159:2,-1:25,159,44,159:23,112:2,-1:2,159:2," +
"-1:25,159:11,45,159:13,112:2,-1:2,159:2,-1:25,159:4,46,159:20,112:2,-1:2,15" +
"9:2,-1:25,159:9,47,159:15,112:2,-1:2,159:2,-1:25,159:14,49,159:10,112:2,-1:" +
"2,159:2,-1:25,159:13,50,159:11,112:2,-1:2,159:2,-1:25,159:16,51,159:8,112:2" +
",-1:2,159:2,-1:25,159:9,52,159:15,112:2,-1:2,159:2,-1:25,159,54,159:23,112:" +
"2,-1:2,159:2,-1:25,159:11,55,159:13,112:2,-1:2,159:2,-1:25,159:4,56,159:20," +
"112:2,-1:2,159:2,-1:25,159:16,57,159:8,112:2,-1:2,159:2,-1:25,159:2,58,159:" +
"22,112:2,-1:2,159:2,-1:25,159:21,59,159:3,112:2,-1:2,159:2,-1:25,159:8,60,1" +
"59:16,112:2,-1:2,159:2,-1:25,159:21,63,159:3,112:2,-1:2,159:2,-1:25,159,64," +
"159:23,112:2,-1:2,159:2,-1:25,159,65,159:23,112:2,-1:2,159:2,-1:25,159:4,66" +
",159:20,112:2,-1:2,159:2,-1:25,159:16,67,159:8,112:2,-1:2,159:2,-1:25,159:2" +
"1,68,159:3,112:2,-1:2,159:2,-1:25,159:21,69,159:3,112:2,-1:2,159:2,-1:25,19" +
"0,165:3,71,190,165,190,165:10,190,165:5,190:3,-1:2,190:2,-1:25,159:10,78,15" +
"9:14,112:2,-1:2,159:2,-1:25,190,165:2,75,165,190,165,190,165:10,190,165:5,1" +
"90:3,-1:2,190:2,-1:25,159:9,120,159:5,121,159,80,159:7,112:2,-1:2,159:2,-1:" +
"25,190,165:4,190,165,190,165:5,77,165:4,190,165:5,190:3,-1:2,190:2,-1:25,15" +
"9:13,82,159:11,112:2,-1:2,159:2,-1:25,190,165:4,190,165,190,165:3,79,165:6," +
"190,165:5,190:3,-1:2,190:2,-1:25,190,165:4,190,165,190,165,81,165:8,190,165" +
":5,190:3,-1:2,190:2,-1:25,159:10,127,159:14,112:2,-1:2,159:2,-1:25,159:13,8" +
"3,159:11,112:2,-1:2,159:2,-1:25,159:10,84,159:14,112:2,-1:2,159:2,-1:25,159" +
":16,128,159:2,129,159:5,112:2,-1:2,159:2,-1:25,159:11,171,159:13,112:2,-1:2" +
",159:2,-1:25,159:3,161,159:21,112:2,-1:2,159:2,-1:25,159:17,130,159:7,112:2" +
",-1:2,159:2,-1:25,159:4,131,159:20,112:2,-1:2,159:2,-1:25,159:16,132,159:8," +
"112:2,-1:2,159:2,-1:25,159,85,159:23,112:2,-1:2,159:2,-1:25,159:20,134,159:" +
"4,112:2,-1:2,159:2,-1:25,159:17,86,159:7,112:2,-1:2,159:2,-1:25,159:3,87,15" +
"9:7,162,159,136,137,159:7,138,159:2,112:2,-1:2,159:2,-1:25,159:13,88,159:11" +
",112:2,-1:2,159:2,-1:25,159:15,139,159:9,112:2,-1:2,159:2,-1:25,159,140,159" +
":23,112:2,-1:2,159:2,-1:25,159:10,89,159:14,112:2,-1:2,159:2,-1:25,159:8,14" +
"3,159:16,112:2,-1:2,159:2,-1:25,159:3,90,159:21,112:2,-1:2,159:2,-1:25,159:" +
"12,163,159:12,112:2,-1:2,159:2,-1:25,159:9,145,159:15,112:2,-1:2,159:2,-1:2" +
"5,159:9,91,159:15,112:2,-1:2,159:2,-1:25,159:22,147,159:2,112:2,-1:2,159:2," +
"-1:25,159:17,92,159:7,112:2,-1:2,159:2,-1:25,159:21,164,159:3,112:2,-1:2,15" +
"9:2,-1:25,159:11,93,159:13,112:2,-1:2,159:2,-1:25,159:10,94,159:14,112:2,-1" +
":2,159:2,-1:25,159:4,95,159:20,112:2,-1:2,159:2,-1:25,159:8,96,159:16,112:2" +
",-1:2,159:2,-1:25,159:16,168,159:8,112:2,-1:2,159:2,-1:25,159:10,148,159:14" +
",112:2,-1:2,159:2,-1:25,159:3,97,159:21,112:2,-1:2,159:2,-1:25,159:19,150,1" +
"59:5,112:2,-1:2,159:2,-1:25,159:3,151,159:21,112:2,-1:2,159:2,-1:25,159:8,9" +
"8,159:16,112:2,-1:2,159:2,-1:25,159:16,99,159:8,112:2,-1:2,159:2,-1:25,159," +
"154,159:23,112:2,-1:2,159:2,-1:25,159:16,155,159:8,112:2,-1:2,159:2,-1:25,1" +
"59:9,100,159:15,112:2,-1:2,159:2,-1:25,159:17,101,159:7,112:2,-1:2,159:2,-1" +
":25,159:10,102,159:14,112:2,-1:2,159:2,-1:25,159:8,103,159:16,112:2,-1:2,15" +
"9:2,-1:25,159:10,157,159:14,112:2,-1:2,159:2,-1:25,159:8,104,159:16,112:2,-" +
"1:2,159:2,-1:25,190,165,107,165:2,190,165,190,165:10,190,165:5,190:3,-1:2,1" +
"90:2,-1:25,159:3,133,159:21,112:2,-1:2,159:2,-1:25,159:16,142,159:8,112:2,-" +
"1:2,159:2,-1:25,159,146,159:23,112:2,-1:2,159:2,-1:25,159:10,149,159:14,112" +
":2,-1:2,159:2,-1:25,159:3,152,159:21,112:2,-1:2,159:2,-1:25,159:9,114,115,1" +
"59:10,116,159:3,112:2,-1:2,159:2,-1:25,159:3,135,159:21,112:2,-1:2,159:2,-1" +
":25,159:3,153,159:21,112:2,-1:2,159:2,-1:25,190,165:4,190,165,190,165:2,109" +
",165:7,190,165:5,190:3,-1:2,190:2,-1:25,159,117,159:23,112:2,-1:2,159:2,-1:" +
"25,159:3,141,159:21,112:2,-1:2,159:2,-1:25,190:2,165:3,190,165,190,165:10,1" +
"90,165:5,190:3,-1:2,190:2,-1:25,159:16,118,159:5,119,159:2,112:2,-1:2,159:2" +
",-1:25,190,165:4,190,165,190,165:2,111,165:7,190,165:5,190:3,-1:2,190:2,-1:" +
"25,159:4,122,159:20,112:2,-1:2,159:2,-1:25,190,165:4,190,165,190,165:7,113," +
"165:2,190,165:5,190:3,-1:2,190:2,-1:25,159:21,123,159:3,112:2,-1:2,159:2,-1" +
":25,159:11,160,159:3,124,159:9,112:2,-1:2,159:2,-1:25,159:17,125,159:7,112:" +
"2,-1:2,159:2,-1:25,159:21,167,159:3,112:2,-1:2,159:2,-1:25,159:6,126,159:18" +
",112:2,-1:2,159:2,-1:25,190,189,165:3,190,165,190,165:10,190,165:5,190:3,-1" +
":2,190:2,-1:25,190,165:4,190,165,190,165:7,172,165:2,190,165:5,190:3,-1:2,1" +
"90:2,-1:25,190,165:4,190,165,190,165,169,165:8,190,165:5,190:3,-1:2,190:2,-" +
"1:25,190,165:4,190,165,190,165,174,165:8,190,165:5,190:3,-1:2,190:2,-1:25,1" +
"90,165:4,190,165,190,165:3,183,165:6,190,165:5,190:3,-1:2,190:2,-1:25,190,1" +
"65:4,190,165,190,165:2,176,165:7,190,165:5,190:3,-1:2,190:2,-1:25,190,165:4" +
",190,165,190,165:5,172,165:4,190,165:5,190:3,-1:2,190:2,-1:25,190,165:4,190" +
",165,190,185,165:5,187,165:3,190,165:5,190:3,-1:2,190:2,-1:25,190,165:4,190" +
",165,190,165,188,165:8,190,165:5,190:3,-1:2,190:2,-1:25,190,165:4,190,165,1" +
"90,165:2,191,165:7,190,165:5,190:3,-1:2,190:2,-1:18");

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
						{return ops.unidadDiv();}
					case -6:
						break;
					case 6:
						{return ops.unidadMul();}
					case -7:
						break;
					case 7:
						{return ops.unidadIId();}
					case -8:
						break;
					case 8:
						{return ops.unidadId();}
					case -9:
						break;
					case 9:
						{return ops.unidadEnt();}
					case -10:
						break;
					case 10:
						{return ops.unidadComa();}
					case -11:
						break;
					case 11:
						{return ops.unidadVchar();}
					case -12:
						break;
					case 12:
						{return ops.unidadVstring();}
					case -13:
						break;
					case 13:
						{return ops.unidadSuma();}
					case -14:
						break;
					case 14:
						{return ops.unidadResta();}
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
						{}
					case -28:
						break;
					case 28:
						{}
					case -29:
						break;
					case 29:
						{return ops.unidadIn();}
					case -30:
						break;
					case 30:
						{return ops.unidadIf();}
					case -31:
						break;
					case 31:
						{return ops.unidadDo();}
					case -32:
						break;
					case 32:
						{return ops.unidadReal();}
					case -33:
						break;
					case 33:
						{return ops.unidadAnd();}
					case -34:
						break;
					case 34:
						{return ops.unidadOr();}
					case -35:
						break;
					case 35:
						{return ops.unidadDistinto();}
					case -36:
						break;
					case 36:
						{return ops.unidadOpIgual();}
					case -37:
						break;
					case 37:
						{return ops.unidadMenori();}
					case -38:
						break;
					case 38:
						{return ops.unidadMayori();}
					case -39:
						break;
					case 39:
						{return ops.unidadInt();}
					case -40:
						break;
					case 40:
						{return ops.unidadEnd();}
					case -41:
						break;
					case 41:
						{return ops.unidadVar();}
					case -42:
						break;
					case 42:
						{return ops.unidadFor();}
					case -43:
						break;
					case 43:
						{return ops.unidadElse();}
					case -44:
						break;
					case 44:
						{return ops.unidadCase();}
					case -45:
						break;
					case 45:
						{return ops.unidadChar();}
					case -46:
						break;
					case 46:
						{return ops.unidadThen();}
					case -47:
						break;
					case 47:
						{return ops.unidadBool();}
					case -48:
						break;
					case 48:
						{return ops.unidadBegin();}
					case -49:
						break;
					case 49:
						{return ops.unidadEndif();}
					case -50:
						break;
					case 50:
						{return ops.unidadClass();}
					case -51:
						break;
					case 51:
						{return ops.unidadFloat();}
					case -52:
						break;
					case 52:
						{return ops.unidadUntil();}
					case -53:
						break;
					case 53:
						{return ops.unidadCClass();}
					case -54:
						break;
					case 54:
						{return ops.unidadWhile();}
					case -55:
						break;
					case 55:
						{return ops.unidadEndfor();}
					case -56:
						break;
					case 56:
						{return ops.unidadReturn();}
					case -57:
						break;
					case 57:
						{return ops.unidadRepeat();}
					case -58:
						break;
					case 58:
						{return ops.unidadString();}
					case -59:
						break;
					case 59:
						{return ops.unidadSwitch();}
					case -60:
						break;
					case 60:
						{return ops.unidadPublic();}
					case -61:
						break;
					case 61:
						{return ops.unidadDeclare();}
					case -62:
						break;
					case 62:
						{return ops.unidadDefault();}
					case -63:
						break;
					case 63:
						{return ops.unidadForeach();}
					case -64:
						break;
					case 64:
						{return ops.unidadPrivate();}
					case -65:
						break;
					case 65:
						{return ops.unidadEndwhile();}
					case -66:
						break;
					case 66:
						{return ops.unidadfunction();}
					case -67:
						break;
					case 67:
						{return ops.unidadEndrepeat();}
					case -68:
						break;
					case 68:
						{return ops.unidadEndswitch();}
					case -69:
						break;
					case 69:
						{return ops.unidadEndforeach();}
					case -70:
						break;
					case 70:
						{errores.errorLexico(fila(),lexema());}
					case -71:
						break;
					case 71:
						{return ops.unidadIId();}
					case -72:
						break;
					case 72:
						{return ops.unidadId();}
					case -73:
						break;
					case 73:
						{return ops.unidadEnt();}
					case -74:
						break;
					case 74:
						{errores.errorLexico(fila(),lexema());}
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
						{return ops.unidadIId();}
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
						{return ops.unidadId();}
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
						{return ops.unidadIId();}
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
						{return ops.unidadId();}
					case -157:
						break;
					case 157:
						{return ops.unidadId();}
					case -158:
						break;
					case 158:
						{return ops.unidadIId();}
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
						{return ops.unidadId();}
					case -164:
						break;
					case 164:
						{return ops.unidadId();}
					case -165:
						break;
					case 165:
						{return ops.unidadIId();}
					case -166:
						break;
					case 166:
						{return ops.unidadId();}
					case -167:
						break;
					case 167:
						{return ops.unidadId();}
					case -168:
						break;
					case 168:
						{return ops.unidadId();}
					case -169:
						break;
					case 169:
						{return ops.unidadIId();}
					case -170:
						break;
					case 170:
						{return ops.unidadId();}
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
						{return ops.unidadIId();}
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
						{return ops.unidadId();}
					case -181:
						break;
					case 181:
						{return ops.unidadId();}
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
					case 191:
						{return ops.unidadIId();}
					case -192:
						break;
					case 192:
						{return ops.unidadIId();}
					case -193:
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
