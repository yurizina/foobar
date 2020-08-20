package foobar;

public class HelperKnight {

	
	public static void chessboard(int a, int b) {

		int cols = 0, rows = 0;
		int colTarget = 0, rowTarget = 0;
		int solution = 0;

		int[][] chessboard2 = { { 0, 1, 2, 3, 4, 5, 6, 7 }, { 8, 9, 10, 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20, 21, 22, 23 }, { 24, 25, 26, 27, 28, 29, 30, 31 },
				{ 32, 33, 34, 35, 36, 37, 38, 39 }, { 40, 41, 42, 43, 44, 45, 46, 47 },
				{ 48, 49, 50, 51, 52, 53, 54, 55 }, { 56, 57, 58, 59, 60, 61, 62, 63 } };

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (chessboard2[i][j] == a) {
					System.out.println("Position initial in the board: " + i + " " + j);
					cols = i;
					rows = j;
				}
			}
		}
		for (int c = 0; c < 8; c++) {
			for (int d = 0; d < 8; d++) {
				if (chessboard2[c][d] == b) {
					System.out.println("Position target in the board: " + c + " " + d);
					colTarget = c;
					rowTarget = d;
				}
			}
		}

		if (cols == colTarget && rows == rowTarget) {
			solution = 0;
		
			
		} else {
			
			// check if the position will be valid or not
			positions(cols, rows, colTarget, rowTarget);
				
			}

		//int [][] movements = { {2,1}, {2, -1}, {1,2}, {-1, +2}, {-2, 1}, {-2, -1}, {1, -2}, {-1, -2} };
		
			System.out.println("The smallest number of movement(s) is/are: " + solution);
			// simulate a knight move now
			// A knight move always go two positions and turn left or right
			// so first, always front 2 spaces, any horizontal or vertical direction
			// Lets print all options to knight move 2 spaces
			//
			if (cols + 2 < 8 && rows < 8) {
				// System.out.println(chessboard2[cols+2][rows]);

				if (rows + 1 < 8) {
					System.out.println(chessboard2[cols + 2][rows + 1]);
				}
				if (rows - 1 > 0) {
					System.out.println(chessboard2[cols + 2][rows - 1]);
				}
			}

			if (cols < 8 && rows + 2 < 8) {
				// System.out.println(chessboard2[cols][rows+2]);

				if (cols + 1 < 8) {
					System.out.println(chessboard2[cols + 1][rows + 2]);
				}
				if (cols - 1 > 0) {
					System.out.println(chessboard2[cols - 1][rows + 2]);
				}
			}
			if (cols - 2 > 0 && rows < 8) {
				// System.out.println(chessboard2[cols-2][rows]);

				if (rows + 1 < 8) {
					System.out.println(chessboard2[cols - 2][rows + 1]);
				}
				if (rows - 1 > 0) {
					System.out.println(chessboard2[cols - 2][rows - 1]);
				}
			}
			if (cols < 8 && rows - 2 > 0) {
				// System.out.println(chessboard2[cols][rows-2]);

				if (cols + 1 < 8) {
					System.out.println(chessboard2[cols + 1][rows - 2]);
				}
				if (cols - 1 > 0) {
					System.out.println(chessboard2[cols - 1][rows - 2]);
				}
			}
		}

	private static int positions(int a, int b, int c, int d) {
		int e = 0, f = 0, g = 0, h = 0, i = 0, j = 0, k = 0, l = 0;
		int[] moves = {0,0,0,0,0,0,0,0};
		boolean flag = false;
		int cols = a;
		int rows = b;
		int colTarget = c;
		int rowTarget = d;

		int movedCol1 = cols + 2;
		int movedRow1 = rows + 1;
		if (movedCol1 < 8 && movedRow1 < 8) {
			while (flag == false) {
				if (movedCol1 == colTarget && movedRow1 == rowTarget) {
					e++;
					flag = true;
					moves[0] = e;
					System.out.println("true");
				} else if (e < 6) {
					flag = true;
				} else {
					flag = false;
					e++;
					System.out.println("false");
					e = positions(movedCol1, movedRow1, colTarget, rowTarget);
				}
			}

		}
		// case 2
		int movedCol2 = cols + 2;
		int movedRow2 = rows - 1;
		if (movedCol2 < 8 && movedRow2 >= 0) {
			while (flag == false) {
				if (movedCol2 == colTarget && movedRow2 == rowTarget) {
					f++;
					flag = true;
					moves[1] = f;
				} else if (f < 6) {
					flag = true;
				} else {
					flag = false;
					f++;
					f = positions(movedCol2, movedRow2, colTarget, rowTarget);
				}
			}

		}

		// case 3
		int movedCol3 = cols + 1;
		int movedRow3 = rows + 2;
		if (movedCol3 < 8 && movedRow3 < 8) {
			while (flag == false) {
				if (movedCol3 == colTarget && movedRow3 == rowTarget) {
					g++;
					flag = true;
					moves[2] = g;
				} else if (g < 6) {
					flag = true;
				} else {
					g++;
					flag = false;
					g = positions(movedCol3, movedRow3, colTarget, rowTarget);
				}
			}
		}
		// case 4
		int movedCol4 = cols - 1;
		int movedRow4 = rows + 2;
		if (movedCol4 >= 0 && movedRow4 < 8) {
			while (flag = false) {
				if (movedCol4 == colTarget && movedRow4 == rowTarget) {
					h++;
					flag = true;
					moves[3] = h;
				} else if (h < 6) {
					flag = true;
				} else {
					h++;
					flag = false;
					h = positions(movedCol4, movedRow4, colTarget, rowTarget);
				}
			}

		}

		// case 5
		int movedCol5 = cols - 2;
		int movedRow5 = rows + 1;
		if (movedCol5 >= 0 && movedRow5 < 8) {
			while (flag == false) {
				if (movedCol5 == colTarget && movedRow5 == rowTarget) {
					i++;
					flag = true;
					moves[4] = i;
				} else if (i < 6) {
					flag = true;
				} else {
					i++;
					flag = false;
					 i = positions(movedCol5, movedRow5, colTarget, rowTarget);
				}
			}
		}

		// case 6
		int movedCol6 = cols - 1;
		int movedRow6 = rows - 2;
		if (movedCol6 >= 0 && movedRow6 >= 0) {
			while (flag == false) {
				if (movedCol6 == colTarget && movedRow6 == rowTarget) {
					j++;
					flag = true;
					moves[5] = j;
				} else if (j < 6) {
					flag = true;
				}else {
					j++;
					flag = false;
					j = positions(movedCol6, movedRow6, colTarget, rowTarget);
				}
			}
		}

		// case 7
		int movedCol7 = cols + 1;
		int movedRow7 = rows - 2;
		if (movedCol7 < 8 && movedRow7 >= 0) {
			while (flag == false) {
				if (movedCol7 == colTarget && movedRow7 == rowTarget) {
					k++;
					flag = true;
					moves[6] = k;
				} else if (k < 6) {
					flag = true;
				} else {
					k++;
					flag = false;
					k = positions(movedCol7, movedRow7, colTarget, rowTarget);
				}
			}

		}

		// case 8
		int movedCol8 = cols - 1;
		int movedRow8 = rows - 2;
		if (movedCol8 >= 0 && movedRow8 >= 0) {
			while (flag == false || l < 6) {
				if (movedCol8 == colTarget && movedRow8 == rowTarget) {
					l++;
					flag = true;
					moves[7] = l;
				} else if (l < 6) {
					flag = true;
				} else {
					l++;
					flag = false;
					l = positions(movedCol8, movedRow8, colTarget, rowTarget);
				}
			}

		}
		int min = moves[0];
		for (int z = 0; z < moves.length; z++) {
			if (moves[z] < min) {
				min = moves[z];
			}
		}

		return min;
	}
	public int mathSolution(){
		int e, f, g, h = 0, j, i, m = 0, n;
		int cols = 0, rows = 0;
		int colTarget = 0, rowTarget = 0;
		int solution = 0;
		e = cols - colTarget; // dif (x - tx)
		if (e < 0) {
			e = e * (-1);
		}
		// only positive e
		//System.out.println("Difference of x is " + e);
		if ( e > 3) {
			g = (e + 1) / 2; // max x
		} else {
			g = e / 2; // max x
		}
		
		//System.out.println("Max distance between x and tx: " + g);

		f = rows - rowTarget; // dif (y - ty)
		if (f < 0) {
			f = f * (-1);
		}
		// only positive f
		//System.out.println("Difference of y is " + f);
		if(f > 3) {
			h = (f + 1)/ 2; // max y
		} else {
			h = f / 2;
		}
		
		//System.out.println("Max distance between y and ty: " + h);

		i = (e + f) / 3; // max x-y
		//System.out.println("max x-y is " + i);
		// compute max values among g, h, and i
		if (g >= h && g >= i) {
			m = g;
		}
		if (h >= g && h >= i) {
			m = h;
		}
		if (i >= g && i >= h) {
			m = i;
		}
		//System.out.println("Print max among x, y, x-y: " + m);
		// module
		j = (m + g + h) % 2;
		//System.out.println("Print module: " + j);
		// solution open space
		n = m + j;
		//System.out.println("solution " + n);

		if (cols == colTarget && rows == rowTarget) {
			solution = 0;
		} else if ((cols == 1 && rows == 1) || (cols == 1 && rows == 8) || (cols == 8 && rows == 1)
				|| (cols == 8 && rows == 8)) {
			if (e == f && e == 1) {
				solution = 4;
			} else if (e == f && e == 2) {
				solution = 4;
			} else if (e + f == 1) {
				solution = 3;
			}
		} else if ((cols == 1 && rows == 2) || (cols == 1 && rows == 3) || (cols == 1 && rows == 4) ||
				   (cols == 1 && rows == 5) || (cols == 1 && rows == 6) || (cols == 1 && rows == 7) ||
				   (cols == 8 && rows == 2) || (cols == 8 && rows == 3) || (cols == 8 && rows == 4) ||
				   (cols == 8 && rows == 5) || (cols == 8 && rows == 6) || (cols == 8 && rows == 7) ||
				   (cols == 2 && rows == 1) || (cols == 3 && rows == 1) || (cols == 4 && rows == 1) ||
				   (cols == 5 && rows == 1) || (cols == 6 && rows == 1) || (cols == 7 && rows == 1) ||
				   (cols == 2 && rows == 8) || (cols == 3 && rows == 8) || (cols == 4 && rows == 8) ||
				   (cols == 5 && rows == 8) || (cols == 6 && rows == 8) || (cols == 7 && rows == 8)) {
			if (e == f && e == 1) {
				solution = 4;
			} else if (e == f && e == 2) {
				solution = 4;
			} else if (e + f == 1) {
				solution = 3;
			}
		} else {
			if (e == f && e == 2) {
				solution = 4;
			} else if (e + f == 1) {
				solution = 3;
			} else {
				solution = n;
			}
		}
		return solution;
	}
	}

