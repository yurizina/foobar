package foobar;

public class SolutionKnight {
	public static int solution(int src, int dest) {
	       int cols = 0, rows = 0, colTarget = 0, rowTarget = 0, solution = 0;

	        //Approaces taken:
	        //First, I tried to reach the minimum number of steps to reach destination 
	        //using an algorithm that check all possibles paths, by Dijkstra's algorithm
	        //Unfortunately, once applying the code the complexity to find the steps were too high
	        //and I had difficulties to deployment of 
	        
	        //Second, mathematical approach, where I formula calculate shortest path 
	        //based upon online sources, the formulas weren't precise
	        
	        //Last approach, use the trend of shortest path to every position possible 
	        //regardelss the starting point, the knight will move always:
	        //{ {2,1}, {2, -1}, {1,2}, {-1, +2}, {-2, 1}, {-2, -1}, {1, -2}, {-1, -2} }
	        //So the destination is a trend as well! 
	        
	        //creating the chessboard and all positions
			int[][] chessboard = { 
					{ 0, 1, 2, 3, 4, 5, 6, 7 },
					{ 8, 9, 10, 11, 12, 13, 14, 15 },
					{ 16, 17, 18, 19, 20, 21, 22, 23 },
					{ 24, 25, 26, 27, 28, 29, 30, 31 },
					{ 32, 33, 34, 35, 36, 37, 38, 39 }, 
					{ 40, 41, 42, 43, 44, 45, 46, 47 },
					{ 48, 49, 50, 51, 52, 53, 54, 55 }, 
					{ 56, 57, 58, 59, 60, 61, 62, 63 } };

	        //Array 2D, where we using a for-loop to find the starting point in coordinates 
	        //axis x is rows and axis y is cols
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (chessboard[i][j] == src) {
						//System.out.println("Position initial in the board: " + i + " " + j);
						rows = i;
						cols = j;
					}
				}
			}
			//Destination coordinates 
			for (int c = 0; c < 8; c++) {
				for (int d = 0; d < 8; d++) {
					if (chessboard[c][d] == dest) {
						//System.out.println("Position target in the board: " + c + " " + d);
						rowTarget = c;
						colTarget = d;
					}
				}
			}
		
			int e, f;
			e = rows - rowTarget; // dif (x - destination x)
			if (e < 0) {
				e = e * (-1);// only positive int 
			}
			
			f = cols - colTarget; // dif (y -  destination y)
			if (f < 0) {
				f = f * (-1); // only positive int
			}
			

			if (e == 0 && f == 0) {
			    //if knight destination is the same of initial position 
				solution = 0;

			}
			if ((cols == 0 && rows == 0) || (cols == 0 && rows == 7) || (cols == 7 && rows == 0)
					|| (cols == 7 && rows == 7)) {
				//only exception of the trend is knight starting in the corners 
				//if destination is one square in the diagonal from initial point 
				//it will take 4 steps to reach the destination square
				if (e == f && e == 1) {
					solution = 4;
				};
			}
			//Now we have all shorts possibilites to reach a point regardeless the initial position 
			if ((e == 1 && f == 2) || (e == 2 && f == 1)) {
			    //chessboard can be divide in 4 blocks of 16 squares
			    //if the initial position is 0,0 there are only two squares where the knight can reach
			    // n = 2
				solution = 1;
			} else if ((e == 0 && f == 1) || (e == 0 && f == 3) || (e == 0 && f == 5) || (e == 1 && f == 0)
					|| (e == 1 && f == 4) || (e == 1 && f == 6) || (e == 2 && f == 3) || (e == 2 && f == 5)
					|| (e == 3 && f == 0) || (e == 3 && f == 2) || (e == 3 && f == 4) || (e == 3 && f == 6)
					|| (e == 4 && f == 1) || (e == 4 && f == 3) || (e == 4 && f == 5) || (e == 5 && f == 0)
					|| (e == 5 && f == 2) || (e == 5 && f == 4) || (e == 6 && f == 1) || (e == 6 && f == 3)) {
					//infinite chessboard would be n x 64 (8 x 8)    
				solution = 3;
			} else if ((e == 0 && f == 2) || (e == 0 && f == 4) || (e == 1 && f == 1) || (e == 1 && f == 3)
					|| (e == 2 && f == 0) || (e == 2 && f == 4) || (e == 3 && f == 1) || (e == 3 && f == 3)
					|| (e == 4 && f == 0) || (e == 4 && f == 2)) {
				//from 2 initial positions, the knight will be able to move to 10 squares
				//if a infinite board, would be n x 8 (movements of knight)
				solution = 2;
			} else if ((e == 0 && f == 6) || (e == 1 && f == 5) || (e == 1 && f == 7) || (e == 2 && f == 2)
					|| (e == 2 && f == 6) || (e == 3 && f == 5) || (e == 3 && f == 7) || (e == 4 && f == 4)
					|| (e == 4 && f == 6) || (e == 5 && f == 1) || (e == 5 && f == 3) || (e == 5 && f == 5)
					|| (e == 5 && f == 7) || (e == 6 && f == 0) || (e == 6 && f == 2) || (e == 6 && f == 4)
					|| (e == 6 && f == 6) || (e == 7 && f == 1) || (e == 7 && f == 3) || (e == 7 && f == 5)) {
				//max movements - infinite chessboard - n x 512 ( 8 x 8 x 8)
				solution = 4;
			} else if ((e == 0 && f == 7) || (e == 2 && f == 7) || (e == 4 && f == 7) || (e == 5 && f == 6)
					|| (e == 6 && f == 5) || (e == 6 && f == 7) || (e == 7 && f == 0) || (e == 7 && f == 2)
					|| (e == 7 && f == 4) || (e == 7 && f == 6)) {
				// max movements - infinite chessboard - n x 4096 ( 8 x 8 x 8 x 8)
				solution = 5;
			} else if (e == 7 && f == 7) {
			    // max movements - infinite chessboard - n x 32768 ( 8 x 8 x 8 x 8 x 8
				solution = 6;
			}

			return solution;
	    }
}
