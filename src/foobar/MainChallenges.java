package foobar;

import java.util.ArrayList;

public class MainChallenges {

	public static void main(String[] args) {
		// int[] b = {7,3,5,1};
		// SolutionTree t1 = new SolutionTree();
		// System.out.println(t1.trees(3, b));
		
		int[][] matrix = { { 0, 2, 1, 0, 0 }, { 0, 0, 0, 3, 4 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		int[][] matrix2 = { { 0, 1, 0, 0, 0, 1 }, { 4, 0, 0, 3, 2, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
		int[][] matrix3 = {{0,0,2,0,0}, {0,0,0,0,0}, {2,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}};
		//int[] a = markovMatrix(matrix).clone();
		//for (int i = 0; i < a.length; i++) {
		//	System.out.println(i + " " + a[i]);
		//}

		markovMatrix(matrix);
		//HelperMatrix x = new HelperMatrix();
		//int[] a2 = x.markovMatrix(matrix).clone();
		//for (int i = 0; i < a2.length; i++) {
			//System.out.println(i + " " + a2[i]);
		//}
		//System.out.println(x.markovMatrix3(matrix2));

	}

	public static int[] markovMatrix(int[][] m) {

		//First, check if each state if there are non-terminal states going to non-terminal states (loops generator) 
		
		
		// matrix being always symmetric, the length of rows is equals to length of
		// columns
		
		//-- Class --//
		class Terminal {
			//int m[][];
			
			public int states(int b, int[][] m) {
				int counterStates = 0;	
				for (int i = 0; i < m.length; i++) {
					// Just to double check, first box is row, second box is the column
					if (!(m[b][i] == 0)) {
						//System.out.println("Position in state x different than 0 and its value: "+ b + " " + i + " and " + m[b][i]);
						counterStates = counterStates + m[b][i];
					}
				}
				//System.out.println(counterStates);
				return counterStates;
			}
			int a = 0;
			int b = 0;
			int bb = 0;
			int[] itself;
			//this method checks if the array of non-terminal states are connected to another non-terminal states
			//if so, we return an integer, where 1 is not linked whatsoever which another terminal 
			
			public int nonlinkedTerminals(int[] array) {
				for (int i = 0; i < array.length; i++) {
					for (int j = 0; j < array.length; j++) {
						//first [] is row, second [] is column
						int b =0;
						b = m[array[i]][array[j]];
						//System.out.println(m[nonTerminalStates[i]][nonTerminalStates[j]]);
						if ((b > 0) && !(array[i] == array[j])) {
							a++;	
						}	
					}
				}
				return a;
			}
			int zSize = 0;
			int[] z;
			public int[] nonlinkedTerminals2(int[] array) {
			    
				z = new int[array.length];
			    
				for (int i = 0; i < array.length; i++) {
					for (int j = 0; j < array.length; j++) {
						//first [] is row, second [] is column
						int b = 0;
						b = m[array[i]][array[j]];
						//System.out.println(m[nonTerminalStates[i]][nonTerminalStates[j]]);
						if ((b > 0) && (!(i == j))) {
							
							if(!(m[array[j]][array[i]] == 0)) {
								
								z[zSize] = m[array[i]][array[j]];
								zSize++;
								System.out.println(m[array[j]][array[i]]);
							}
						}	
					}
				}
				return z;
				
			}
			
			//This method check if the non-terminal will link to itself
			public int[] linkedTerminalsInner(int[] array) {
				
				if (linkedTerminalsInnerSize(array) > 0) {
					itself = new int[linkedTerminalsInnerSize(array)];
					//System.out.println(itself.length);
				
				}
				
				for (int i = 0; i < array.length; i++) {
					
					for (int j = 0; j < array.length; j++) {
						//first [] is column, second [] is row
						
						int c = 0;
						c = m[array[i]][array[j]];
						//System.out.println(m[nonTerminalStates[i]][nonTerminalStates[j]]);
			
						if ((c > 0) && array[i] == array[j]) {
							itself[b] = array[i];
							b++;
						}
					}
				}
				return itself;
			}
			int bbb = 0;
			public int linkedTerminalsInnerSize(int[] array) {

	
					for (int i = 0; i < array.length; i++) {
						//System.out.println("Hey");
						for (int j = 0; j < array.length; j++) {
							//first [] is column, second [] is row
		
							int c = m[array[i]][array[j]];
							
							//System.out.println(m[array[i]][array[j]]);
							
							if ((c > 0) && array[i] == array[j]) {
								System.out.println(" " + bbb);

								bbb++;
								
							}		
						}
					}
					
				if (bbb == 0) {
					bbb = -1;
				}	
		
				//System.out.println(" Hey Hey");
				return bbb;
			} 
			
			
		}
		class Values {
			
			int counter = 0;
			
			public int denominatorNonLinked(int[][] m, int x) {
				int denominator = 0;
				for (int i = 0; i < m.length; i++) {
						denominator = denominator + m[x][i];
				}
				System.out.println(denominator);
				return denominator;
			}
			
			public int[] valuesPerRow(int[][] m, int x) {
			int[] values = new int[m.length];
			
				for (int i = 0; i < m.length; i++) {
					values[i] = m[x][i];
					System.out.println(values[i]);
			    }
				return values;
			}
		}
		//------//
		Terminal x = new Terminal();
		Values v = new Values();
		
		int indexTerminalStatesSize = 0;
		int indexNonTerminalStatesSize = 0;
		//Integers to check the size of non-terminal states and terminal states
		for (int i = 0; i < m.length; i++) {
			if(x.states(i, m) == 0) {
				indexTerminalStatesSize++;
			}
			if(!(x.states(i, m) == 0)) {
				indexNonTerminalStatesSize++;
			}
			
		}
		//System.out.println(indexTerminalStatesSize + " " + indexNonTerminalStatesSize);
		//populate arrays of terminal states and non-terminal states 
		int[] terminalStates = new int [indexTerminalStatesSize];
		int indexIncrementation = 0;
		
		int[] nonTerminalStates = new int [indexNonTerminalStatesSize];
		int indexNTIncrementation = 0;
		
		for (int i = 0; i < m.length; i++) {
			
			if(x.states(i, m) == 0) {
				terminalStates[indexIncrementation] = i; 
				System.out.println("Terminals " + terminalStates[indexIncrementation]);
				indexIncrementation++;
			}
			if(!(x.states(i, m) == 0)) {
				nonTerminalStates[indexNTIncrementation] = i; 
				//System.out.println("Non terminals " + nonTerminalStates[indexNTIncrementation]);
				indexNTIncrementation++;
			}
	
		}
		System.out.println("--------Non-terminal link to Non-Terminal-------");
		int[] solution = new int [terminalStates.length];
		//System.out.println(terminalStates.length);
		//System.out.println("Size of solution: " + solution.length);
		
		int finalDenominator = 1;
		//FIST CASE - NO BOND WITH OTHER TERMINALS STATES 
		int a = x.nonlinkedTerminals(nonTerminalStates);
		if (a == 1) {
			
			System.out.println("Not linked");
			for (int i = 0; i < m.length; i++) {
				if(!(v.denominatorNonLinked(m, i) == 0)) {
					finalDenominator = finalDenominator * v.denominatorNonLinked(m, i);	
				}	
			}
			System.out.println(finalDenominator);
			solution[terminalStates.length - 1] = finalDenominator;
			
	        
			for (int ii = 0; ii < nonTerminalStates.length; ii++) {
				System.out.println("Row " + ii);
				if(ii == 0) {
				 
				}
				System.out.println(v.valuesPerRow(m, ii));	
			}
			//The terminals, even though there are non-terminals, they have none connection with others
		}
		
		//SECOND CASE - NON-TERMINAL CASES LINKED TO ITSELF 
		//This will check for all terminals that link to itself
		//Some issues with this method!! Big bug! 
		if (!(x.linkedTerminalsInner(nonTerminalStates) == null)) {
			int[] outside = x.linkedTerminalsInner(nonTerminalStates).clone();
			if (!(outside == null)) {
				for (int i = 0; i < outside.length; i++) {
					System.out.println("Index: " + i + ", state linked itself: " + outside[i]);
					System.out.println("Non-terminal itself linked");
				};
			}
		}
		
		//THIRD CASE - NON-TERMINALS CASE LINKED TO NON-TERMINAL CASES 
		//We have to check for non-terminals that links to another non-terminal
		int[] outside2 = x.nonlinkedTerminals2(nonTerminalStates).clone();
		for (int i = 0; i < outside2.length; i++) {
			if(!(outside2[i] == 0)) {
				System.out.println("non-Terminal linked to non-Terminal");
				System.out.println("index: " + i + ", state linked itself: " + outside2[i]);
			}
		}
		
		
		
		return null;

	}

}