package foobar;

import java.util.ArrayList;

public class HelperMatrix {

public int[] markovMatrix(int[][] m) {

		int[] solution = new int[m.length - 1];

		int counterZero = 0;
		// matrix being always symmetric, the length of rows is equals to length of
		// columns
		for (int i = 0; i < m.length; i++) {
			// Just to double check, first box is column
			// Second box is the row!
			System.out.println(m[0][i]);
			if (!(m[0][i] == 0)) {
				System.out.println( "Position in state zero different than 0 and its value: " + i + " and " + m[0][i]);
				counterZero = counterZero + m[0][i];

			}
		}
		System.out.println("\nTotal values in state zero " + counterZero);
		System.out.println();
		int[] pathZero = new int[counterZero];
		System.out.println("Size of this array: " + pathZero.length);
		int[] pathZero2 = new int[counterZero];
		int statesZeroIndex = 0;
		for (int i = 0; i < m.length; i++) {
			// Just to double check, first box is column
			// Second box is the row!
			 System.out.println(m[0][i]);
			if (!(m[0][i] == 0)) {
				pathZero[statesZeroIndex] = i;
				pathZero2[statesZeroIndex] = i; 
				System.out.println("Print array of paths, state 0: " + pathZero[statesZeroIndex]);

				statesZeroIndex++;
			}
		}
		//System.out.println();
		// Check terminal states and add size of it
		int terminalStatesSize = 0;
		for (int i = 0; i < m.length; i++) {
			int zeros = 0;
			// System.out.println();
			for (int j = 0; j < m.length; j++) {

				if (m[i][j] == 0) {
					zeros++;
					// System.out.println(zeros);
					if (zeros == m.length) {
						System.out.println("Terminal state: " + i);
						terminalStatesSize++;
					}
				}
			}
		}
		System.out.println("Total terminal states: " + terminalStatesSize);
		System.out.println();
		int[] terminalStates = new int[terminalStatesSize];
		// System.out.println(terminalStates.length);

		// Populate array of terminal states
		int terminalStatesSize2 = 0;
		for (int i = 0; i < m.length; i++) {
			int zeros = 0;
			// System.out.println();
			for (int j = 0; j < m.length; j++) {

				if (m[i][j] == 0) {
					zeros++;
					// System.out.println(zeros);
					if (zeros == m.length) {
						terminalStates[terminalStatesSize2] = i;
						System.out.println( "Store all terminal states in the array: " + terminalStates[terminalStatesSize2]);
						terminalStatesSize2++;
					}
				}
			}
		}
		//System.out.println();
		// Check if any position from pathZero array is terminal
		// this one should be a method to check all terminal states!!!
		for (int i = 0; i < pathZero.length; i++) {
			for (int j = 0; j < terminalStates.length; j++) {
				if (pathZero[i] == terminalStates[j]) {
					System.out.println("Paths that end in terminal state: " + pathZero[i]);
					 
					pathZero[i] = -1;
					// I need to record this information before I change to value equals to -1
				}
			}
		}
		// Next calculus I know only works because there is one new way!
		int firstPath = 0;
		for (int i = 0; i < pathZero.length; i++)
			if (!(pathZero[i] == -1)) {
				firstPath = pathZero[i];
			}
		System.out.println("Remaining path (non-terminal): " + firstPath + "\n");
		int[] paths;
		int pathsSize = 0;
		int terminalStatesFirstPath = 0;
		for (int i = 0; i < m.length; i++) {
			// we have to check if the indexes at this row is different than zero
			if (!(m[firstPath][i] == 0)) {
				System.out.println("States paths: " + i + " and its value " + m[firstPath][i]);
				pathsSize++;
			}
		}
		System.out.println(pathsSize);
		System.out.println(terminalStatesFirstPath);
		paths = new int[pathsSize];
		int[] pathsValues = new int[pathsSize];
		int z = 0;
		for (int i = 0; i < m.length; i++) {
			
			// we have to check if the indexes at this row is different than zero
			if (!(m[firstPath][i] == 0)) {
				System.out.println("States paths: " + i + " and its value " + m[firstPath][i]);
				paths[z] = i;
				pathsValues[z] = m[firstPath][i];
				//System.out.println(z + " " + paths[z] + " " + pathsValues[z]);
				z++;
			}
			
		}

		for (int i = 0; i < terminalStates.length; i++) {
			for(int j = 0; j < paths.length;j++) {
				if (terminalStates[i] == paths[j]) {
				    System.out.println("Terminal state and path and its value: " + terminalStates[i] + " " + paths[j] + " " + pathsValues[i]);
					terminalStatesFirstPath += pathsValues[i];
					solution[paths[i] - 2] = pathsValues[i];
					System.out.println("Values for denominator " + terminalStatesFirstPath);
					//System.out.println();
					paths[j] = - 1;
					System.out.println(j + " " + paths[j]);
				}
			}	
		}
		int finalDenominator = 0;
		for (int i = 0; i < paths.length; i++) {
			if(paths[i] >= 0) {
				//System.out.println(paths[i]);

				terminalStatesFirstPath += pathsValues[i]/counterZero;
				System.out.println("Values for denominator " + terminalStatesFirstPath);
				finalDenominator = terminalStatesFirstPath * counterZero;
				//System.out.println();
				//solution[paths[i] - 2] = finalDenominator + counterZero;
			}
		}
		
        //System.out.println(terminalStatesFirstPath);
        //System.out.println(finalDenominator);
		
        solution[m.length - 2] = finalDenominator;
        //System.out.println(solution[matrix.length-2]);
        for (int i = 0; i < pathZero2.length; i++) {
			for (int j = 0; j < terminalStates.length; j++) {
				if (pathZero2[i] == terminalStates[j]) {
					System.out.println("Paths that end in terminal state: " + i +" " + pathZero2[i]);
					solution[pathZero2[i] - 2] = finalDenominator/counterZero + counterZero;
				}
			}
		}
        for (int i = 0; i < solution.length; i++) {
        	//System.out.println("Hey");
        	System.out.println("Solution - index and value:" + i + " " + solution[i]);
        	
        }
		return solution;
        
       
		// End
	}


////////////

public static int[] markovMatrix2(int[][] m) {
	
	int[] solution = new int[m.length - 1];

	int counterZero = 0;
	int counterZero2 = 0;
	// matrix being always symmetric, the length of rows is equals to length of
	// columns
	for (int i = 0; i < m.length; i++) {
		// Just to double check, first box is column
		// Second box is the row!
	//System.out.println(m[0][i]);
		if (!(m[0][i] == 0)) {
			System.out.println( "Position in state zero different than 0 and its value: " + i + " and " + m[0][i]);
			counterZero = counterZero + m[0][i];
			counterZero2++;
		}
	}

	//System.out.println("\nTotal values in state zero " + counterZero);
	//System.out.println();
	int[] pathZero = new int[counterZero2];
	System.out.println("Size of this array: " + pathZero.length);
	int[] pathZero2 = new int[counterZero2];
	int statesZeroIndex = 0;
	for (int i = 0; i < m.length; i++) {
		// Just to double check, first box is column
		// Second box is the row!
		//System.out.println(m[0][i]);
		if (!(m[0][i] == 0)) {
			//System.out.println(statesZeroIndex);
			//System.out.println(i);
			pathZero[statesZeroIndex] = i;
			pathZero2[statesZeroIndex] = i; 
			System.out.println("Print paths from state 0: " + pathZero[statesZeroIndex]);
			statesZeroIndex++;
		}
	}
	//System.out.println();
	//Check terminal states and add size of it
	int terminalStatesSize = 0;
	for (int i = 0; i < m.length; i++) {
		int zeros = 0;
		//System.out.println();
		for (int j = 0; j < m.length; j++) {

			if (m[i][j] == 0) {
				zeros++;
				//System.out.println(zeros);
				if (zeros == m.length) {
					//System.out.println("Terminal states or with no-values rows: " + i);
					terminalStatesSize++;
				}
			}
		}
	}
	System.out.println("Number total of terminal states: " + terminalStatesSize);
	//System.out.println();
	int[] terminalStates = new int[terminalStatesSize];
	//System.out.println(terminalStates.length);

	// Populate array of terminal states
	int terminalStatesSize2 = 0;
	for (int i = 0; i < m.length; i++) {
		int zeros = 0;
		// System.out.println();
		for (int j = 0; j < m.length; j++) {

			if (m[i][j] == 0) {
				zeros++;
				// System.out.println(zeros);
				if (zeros == m.length) {
					terminalStates[terminalStatesSize2] = i;
					//System.out.println( "Store all terminal states in the array: " + terminalStates[terminalStatesSize2]);
					terminalStatesSize2++;
				}
			}
		}
	}
	//System.out.println();
	// Check if any path from pathZero array is terminal
	// this one should be a method to check all terminal states!!!
	for (int i = 0; i < pathZero.length; i++) {
		for (int j = 0; j < terminalStates.length; j++) {
			System.out.print(pathZero[i] + " ");
			//line 105 changed dramatically! i instead of pathZero[i]
			if (i == terminalStates[j]) {
				System.out.println("Paths that end in terminal state: " + pathZero[i]);
				pathZero[i] = -1;
				// I need to record this information before I change to value equals to -1
			}
		}
	}
	// Next calculus I know only works because there is one new way!
	int firstPath = 0;
	int[] pathsFromZero;
	for (int i = 0; i < pathZero.length; i++)
		if (!(pathZero[i] == -1)) {
			System.out.print( "\n" + pathZero[i]);
			//Changed line 118 as well, we need to check how many arrays are not terminal
			//old fistPath = pathZero[i];
			firstPath++;	
		}
	//We eliminate all terminal states, now we have the non-terminal states! 
	pathsFromZero = new int[firstPath];
	int ad = 0;
	for (int i = 0; i < pathZero.length; i++)
		if (!(pathZero[i] == -1)) {
			 pathsFromZero[ad] = pathZero[i];
			 System.out.println("\nAll paths, index, value for that index: " +  ad + " "+ pathsFromZero[ad]);
			 ad++;	
		}
	
	System.out.println("\nRemaining path (non-terminal): " + firstPath + "\n");
	
	int[] paths;
	int pathsSize = 0;
	int terminalStatesFirstPath = 0;
	for (int i = 0; i < m.length; i++) {
		// we have to check if the indexes at this row is different than zero
		for (int c = 0; c < pathsFromZero.length; c++) {
			if (!(m[pathsFromZero[c]][i] == 0)) {
				System.out.println("States paths: " + i + " and its value " + m[pathsFromZero[c]][i]);
				pathsSize++;
			}
		}
	}
	System.out.println("Number of paths from first state: " + pathsSize);
	//System.out.println(terminalStatesFirstPath);
	paths = new int[pathsSize];
	int[] pathsValues = new int[pathsSize];
	int z = 0;
	for (int i = 0; i < m.length; i++) {
		for (int c = 0 ; c < pathsFromZero.length; c++) {
			// we have to check if the indexes at this row is different than zero
			if (!(m[pathsFromZero[c]][i] == 0)) {
				System.out.println("States paths: " + i + " and its value " + m[pathsFromZero[c]][i]);
				paths[z] = i;
				pathsValues[z] = m[pathsFromZero[c]][i];
				//System.out.println(z + " " + paths[z] + " " + pathsValues[z]);
				z++;
			}
		}
	}

	for (int i = 0; i < terminalStates.length; i++) {
		for(int j = 0; j < paths.length;j++) {
			if (terminalStates[i] == paths[j]) {
				System.out.println("Terminal state and path and its value: " + terminalStates[i] + " " + paths[j] + " " + pathsValues[j]);
				//I do have problems with next line as well 
				terminalStatesFirstPath += pathsValues[j];
				//I have problem over here, about the position
				//Check this one! 
	
				if(paths[j] == m[0][i]) {
					solution[paths[j] - 2] = pathsValues[j] * m[0][i] ;
				}
				
				
				
				System.out.println("Values for denominator " + terminalStatesFirstPath);
				//System.out.println();
				paths[j] = - 1;
				//System.out.println(j + " " + paths[j]);
			}
		}	
	}
	//Check from here...
	int finalDenominator = 0;
	for (int i = 0; i < paths.length; i++) {
		System.out.println(paths[i]);
		if(paths[i] >= 0) {
			//System.out.println(paths[i]);
			terminalStatesFirstPath += pathsValues[i]/counterZero;
		}

	}
	finalDenominator = terminalStatesFirstPath * counterZero;
	for (int i = 0; i < paths.length; i++) {
		System.out.println(paths[i]);
		if(paths[i] >= 0) {
			solution[paths[i] - 2] = finalDenominator + counterZero;
		}

	}
	
    System.out.println(terminalStatesFirstPath);
    System.out.println(finalDenominator);
	
    solution[m.length - 2] = finalDenominator;
    //System.out.println(solution[matrix.length-2]);
    for (int i = 0; i < pathZero2.length; i++) {
		for (int j = 0; j < terminalStates.length; j++) {
			if (pathZero2[i] == terminalStates[j]) {
				System.out.println("Paths that end in terminal state: " + i +" " + pathZero2[i]);
				solution[pathZero2[i] - 2] = finalDenominator/counterZero + counterZero;
			}
		}
	}
    for (int i = 0; i < solution.length; i++) {
    	System.out.println("Hey");
    	
        System.out.println("Solution - index and value:" + i + " " + solution[i]);
    	
    }
	return solution;
    
    
	// End
}

////// PARTIAL SOLUTION 
//https://stackoverflow.com/questions/61627375/hidden-test-cases-not-passing-for-google-foobar-challenge-doomsday-fuel
public int[] markovMatrix3(int[][] m) {
	
	double[][] mDouble = toDouble(m);
    //TODO: change the double back into an int
    // GOAL ONE: find Q matrix :
    // 1:separate the input into two 2d arrays
    ArrayList<double[]> ters = new ArrayList<double[]>();
    ArrayList<double[]> nonTers = new ArrayList<double[]>();
    for(int i = 0; i < mDouble.length; i++){
        boolean isTerminal = true;
        int sum = 0;
        for(int j = 0; j < mDouble[0].length; j++){
            sum += mDouble[i][j];
            if(mDouble[i][j] != 0){
                isTerminal = false;
            }
        }

        if(isTerminal){
            ters.add(mDouble[i]);
        }else{
            for(int j = 0; j < mDouble[0].length; j++){
                mDouble[i][j] = mDouble[i][j]/sum;
            }
            nonTers.add(mDouble[i]);
        }
    }
    double[][] terminalStates = new double[ters.size()][m.length];
    double[][] nonTerminalStates = new double[nonTers.size()][m.length];

    for(int i = 0; i < ters.size(); i++){
        terminalStates[i] = ters.get(i);
    }
    for(int i = 0; i < nonTers.size(); i++){
        nonTerminalStates[i] = nonTers.get(i);
    }
    // 2: Plug into a function that will create the 2d array
    double[][] QMatrix = getQMatrix(nonTerminalStates);
    // GOAL TWO: find I matrix
    double[][] IMatrix = makeIMatrix(QMatrix.length);
    //GOAL 3: Find F matrix
    //1: subtract the q matrix from the I matrix
    double[][] AMatrix = SubtractMatrices(IMatrix, QMatrix);
    //2: find the inverse TODO WRITE FUNCTION
    double[][] FMatrix = invert(AMatrix);
    //GOAL 4: multiply by R Matrix
    //1: find r Matrx
    double[][] RMatrix = getRMatrix(nonTerminalStates, terminalStates.length);
    //2: use multiply function to get FR Matrix
    double[][] FRMatrix = multiplyMatrices(FMatrix, RMatrix);
    //GOAL 5: find answer array
    //1: get the one dimensional answer
    double[] unsimplifiedAns = FRMatrix[0];
    //2: get fractions for the answers
    int[] ans = fractionAns(unsimplifiedAns);
    return ans;
    

    
}
public static int[] fractionAns(double[] uAns){
    int[] ans = new int[uAns.length + 1];
    int[] denominators = new int[uAns.length];
    int[] numerators = new int[uAns.length];
    for(int i = 0; i < uAns.length; i++){
        denominators[i] = (int)(convertDecimalToFraction(uAns[i])[1]);
        numerators[i] = (int)(convertDecimalToFraction(uAns[i])[0]);
    }
    int lcm = (int) lcm_of_array_elements(denominators);
    for(int i = 0; i < uAns.length; i++){
        ans[i] = numerators[i]*(lcm/convertDecimalToFraction(uAns[i])[1]);
    }
    ans[ans.length-1] = lcm;
    return ans;
    
    
}

static private int[] convertDecimalToFraction(double x){
    double tolerance = 1.0E-10;
    double h1=1; double h2=0;
    double k1=0; double k2=1;
    double b = x;
    do {
        double a = Math.floor(b);
        double aux = h1; h1 = a*h1+h2; h2 = aux;
        aux = k1; k1 = a*k1+k2; k2 = aux;
        b = 1/(b-a);
    } while (Math.abs(x-h1/k1) > x*tolerance);

    return new int[]{(int)h1, (int)k1};
}   
public static long lcm_of_array_elements(int[] element_array) 
{ 
    long lcm_of_array_elements = 1; 
    int divisor = 2; 

    while (true) { 
        int counter = 0; 
        boolean divisible = false; 

        for (int i = 0; i < element_array.length; i++) { 

            // lcm_of_array_elements (n1, n2, ... 0) = 0. 
            // For negative number we convert into 
            // positive and calculate lcm_of_array_elements. 

            if (element_array[i] == 0) { 
                return 0; 
            } 
            else if (element_array[i] < 0) { 
                element_array[i] = element_array[i] * (-1); 
            } 
            if (element_array[i] == 1) { 
                counter++; 
            } 

            // Divide element_array by devisor if complete 
            // division i.e. without remainder then replace 
            // number with quotient; used for find next factor 
            if (element_array[i] % divisor == 0) { 
                divisible = true; 
                element_array[i] = element_array[i] / divisor; 
            } 
        } 

        // If divisor able to completely divide any number 
        // from array multiply with lcm_of_array_elements 
        // and store into lcm_of_array_elements and continue 
        // to same divisor for next factor finding. 
        // else increment divisor 
        if (divisible) { 
            lcm_of_array_elements = lcm_of_array_elements * divisor; 
        } 
        else { 
            divisor++; 
        } 

        // Check if all element_array is 1 indicate  
        // we found all factors and terminate while loop. 
        if (counter == element_array.length) { 
            return lcm_of_array_elements; 
        } 
    } 
} 
public static double[][] toDouble(int[][] ma){
    double[][] retArr = new double[ma.length][ma.length];
    for(int i = 0; i < retArr.length; i++){
        for(int j = 0; j < retArr[0].length; j++){
            retArr[i][j] = (ma[i][j]);
        }
    }
    return retArr;
}
public static double[][] getRMatrix(double[][] nonTerminals, int terminalLength){
    double[][] retArr = new double[nonTerminals.length][terminalLength];
    for(int i = 0; i < retArr.length; i++){
        for(int j = nonTerminals.length; j < nonTerminals[0].length; j++){
            retArr[i][j-nonTerminals.length] = (nonTerminals[i][j]);
        }
    }
    return retArr;
}

public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix){
    int r1 = firstMatrix.length;
    int c1 = firstMatrix[0].length;
    int c2 = secondMatrix[0].length;
    double[][] product = new double[r1][c2];
    for(int i = 0; i < r1; i++) {
        for (int j = 0; j < c2; j++) {
            for (int k = 0; k < c1; k++) {
                product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
            }
        }
    }

    return product;
}
public static double[][] inverseMatrix(double[][] Amatrix){
    return null;
}
public static double[][] SubtractMatrices(double[][] I, double[][] Q){
    double[][] retArr = new double[I.length][I.length];
    for(int i = 0; i < retArr.length; i++){
        for(int j = 0; j < retArr.length; j++){
            retArr[i][j] = I[i][j]-Q[i][j];
        }
    }
    return retArr;
}
public static double[][] getQMatrix(double[][] qArr){
    int size = qArr.length;
    double[][] retArr = new double[size][size];
    for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
            retArr[i][j] = qArr[i][j];
        }
    }
    return retArr;
}
public static double[][] makeIMatrix(int size){
    double[][] retArr = new double[size][size];
    for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
            if(i == j){
                retArr[i][j] = 1;
            }else{
                retArr[i][j] = 0;
            }
        }
    }
    return retArr;
}
public static double[][] invert(double a[][]) 
{
    int n = a.length;
    double x[][] = new double[n][n];
    double b[][] = new double[n][n];
    int index[] = new int[n];
    for (int i=0; i<n; ++i) 
        b[i][i] = 1;

// Transform the matrix into an upper triangle
    gaussian(a, index);

// Update the matrix b[i][j] with the ratios stored
    for (int i=0; i<n-1; ++i)
        for (int j=i+1; j<n; ++j)
            for (int k=0; k<n; ++k)
                b[index[j]][k]
                        -= a[index[j]][i]*b[index[i]][k];

// Perform backward substitutions
    for (int i=0; i<n; ++i) 
    {
        x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
        for (int j=n-2; j>=0; --j) 
        {
            x[j][i] = b[index[j]][i];
            for (int k=j+1; k<n; ++k) 
            {
                x[j][i] -= a[index[j]][k]*x[k][i];
            }
            x[j][i] /= a[index[j]][j];
        }
    }
    return x;
}

//Method to carry out the partial-pivoting Gaussian
//elimination.  Here index[] stores pivoting order.

public static void gaussian(double a[][], int index[]) 
{
    int n = index.length;
    double c[] = new double[n];

// Initialize the index
    for (int i=0; i<n; ++i) 
        index[i] = i;

// Find the rescaling factors, one from each row
    for (int i=0; i<n; ++i) 
    {
        double c1 = 0;
        for (int j=0; j<n; ++j) 
        {
            double c0 = Math.abs(a[i][j]);
            if (c0 > c1) c1 = c0;
        }
        c[i] = c1;
    }

// Search the pivoting element from each column
    int k = 0;
    for (int j=0; j<n-1; ++j) 
    {
        double pi1 = 0;
        for (int i=j; i<n; ++i) 
        {
            double pi0 = Math.abs(a[index[i]][j]);
            pi0 /= c[index[i]];
            if (pi0 > pi1) 
            {
                pi1 = pi0;
                k = i;
            }
        }

// Interchange rows according to the pivoting order
        int itmp = index[j];
        index[j] = index[k];
        index[k] = itmp;
        for (int i=j+1; i<n; ++i)   
        {
            double pj = a[index[i]][j]/a[index[j]][j];

// Record pivoting ratios below the diagonal
            a[index[i]][j] = pj;

// Modify other elements accordingly
            for (int l=j+1; l<n; ++l)
                a[index[i]][l] -= pj*a[index[j]][l];
        }
    }
}

 //FinalSubmission

public static int[] solution(int[][] m) {
    //First approach, would check if the states are terminal
    //After check which ones are terminals and which one are non-terminals 
    //I would check each non-terminal states to 3 scenarios:
    //First scenario: non-terminal state zero would be link to only one state
    //Second scenario: non-terminal states would link to itselfs
    //Third scenario: non-terminal states bond to non-terminal states 
    //Every scenario leads to a different logic to solve the states! 
    
    //However, after hours trying the code above, I could not finish the attempt
    int[] solution = new int[m.length - 1];

	int counterZero = 0;
	// matrix being always symmetric, the length of rows is equals to length of
	// columns
	for (int i = 0; i < m.length; i++) {
		
		if (!(m[0][i] == 0)) {
			counterZero = counterZero + m[0][i];
		}
	}

	int[] pathZero = new int[counterZero];
	int[] pathZero2 = new int[counterZero];
	int statesZeroIndex = 0;
	for (int i = 0; i < m.length; i++) {
		if (!(m[0][i] == 0)) {
			pathZero[statesZeroIndex] = i;
			pathZero2[statesZeroIndex] = i; 
			statesZeroIndex++;
		}
	}

	// Check terminal states and add size of it
	int terminalStatesSize = 0;
	for (int i = 0; i < m.length; i++) {
		int zeros = 0;
		for (int j = 0; j < m.length; j++) {

			if (m[i][j] == 0) {
				zeros++;
				if (zeros == m.length) {
					terminalStatesSize++;
				}
			}
		}
	}

	int[] terminalStates = new int[terminalStatesSize];


	// Populate array of terminal states
	int terminalStatesSize2 = 0;
	for (int i = 0; i < m.length; i++) {
		int zeros = 0;
		for (int j = 0; j < m.length; j++) {

			if (m[i][j] == 0) {
				zeros++;
				if (zeros == m.length) {
					terminalStates[terminalStatesSize2] = i;
					terminalStatesSize2++;
				}
			}
		}
	}
	// Check if any position from pathZero array is terminal
	// this one should be a method to check all terminal states!!!
	for (int i = 0; i < pathZero.length; i++) {
		for (int j = 0; j < terminalStates.length; j++) {
			if (pathZero[i] == terminalStates[j]) {
				pathZero[i] = -1;
				// I need to record this information before I change to value equals to -1
			}
		}
	}
	// Next calculus I know only works because there is one new way!
	int firstPath = 0;
	for (int i = 0; i < pathZero.length; i++)
		if (!(pathZero[i] == -1)) {
			firstPath = pathZero[i];
		}
	//Remaining path (non-terminal)
	int[] paths;
	int pathsSize = 0;
	int terminalStatesFirstPath = 0;
	for (int i = 0; i < m.length; i++) {
		// we have to check if the indexes at this row is different than zero
		if (!(m[firstPath][i] == 0)) {
			pathsSize++;
		}
	}

	paths = new int[pathsSize];
	int[] pathsValues = new int[pathsSize];
	int z = 0;
	for (int i = 0; i < m.length; i++) {
		
		// we have to check if the indexes at this row is different than zero
		if (!(m[firstPath][i] == 0)) {
			paths[z] = i;
			pathsValues[z] = m[firstPath][i];
			z++;
		}
		
	}

	for (int i = 0; i < terminalStates.length; i++) {
		for(int j = 0; j < paths.length;j++) {
			if (terminalStates[i] == paths[j]) {
				terminalStatesFirstPath += pathsValues[i];
				solution[paths[i] - 2] = pathsValues[i];
				paths[j] = - 1;
			}
		}	
	}
	int finalDenominator = 0;
	for (int i = 0; i < paths.length; i++) {
		if(paths[i] >= 0) {
	
			terminalStatesFirstPath += pathsValues[i]/counterZero;
			finalDenominator = terminalStatesFirstPath * counterZero;
		}
	}

    solution[m.length - 2] = finalDenominator;
    for (int i = 0; i < pathZero2.length; i++) {
		for (int j = 0; j < terminalStates.length; j++) {
			if (pathZero2[i] == terminalStates[j]) {
				solution[pathZero2[i] - 2] = finalDenominator/counterZero + counterZero;
			}
		}
	}
	return solution;
	
	//Alternative code, described above
}

}


