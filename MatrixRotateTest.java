
public class MatrixRotateTest {
    	
    static int[][] A;
    static int left = 1;
    static int right = 2;
    
	public static void main(String[] args) {
		int matrix_size = 5;
		
		// fill matrix
		A = fillMatrix(matrix_size);
        
        // print
		displayMatrix(A);

        System.out.print("\nrotated ");
        
        // rotate
        rotateMatrix(A, 2);
        
        // print
        displayMatrix(A);
        
        
        // rotate
        rotateMatrix(A, 1);
        
        // print
        displayMatrix(A);
	}
	
	// fill matrix
	public static int[][] fillMatrix(int size) {
		
		int matrix[][] = new int[size][size];
		
		for (int i=0; i<size; i++)
        {
            for (int j=0; j<size; j++)
            {
            	matrix[i][j] = size * i + j + 1;
            }
        }
		
		return matrix;		
	}
	
	public static void displayMatrix(int[][] matrix) {
		
		for (int i=0; i<matrix.length; i++)
        {
            for (int j=0; j<matrix.length; j++)
            {
                System.out.printf("%2d ", A[i][j]);
            }
            System.out.print("\n");
        }		
		System.out.println();
	}

	
	public static void rotateMatrix(int[][] matrix, int direction) {
		int size = matrix.length;
		
		if (direction == right) System.out.println("clockwise\n");
		else {System.out.println("counter-clockwise\n"); }
		
		// ��� �������� �� ����� ����� (��������) ������� ������� ������ �����, ����� ����������, ����� ��� ����� ������,
		// � ������������ 4 ���� (�� ������� ��� ������ ������� �������).

		// ������ for - ������ - �������� �� size - �.�. �� ������� �������, � ����������������� ����, � �.�. � ���������������
		// ������ for - ������ - j = i � j < size i - 1 - ����� ������� ������ ��������, ���� �������� ������������, 
		// � ��� ������ ����� �������� i (���) � ��� ������� ����������� (j = i) - ���������� ������ ������ �������� - ���������,
		// j < size - i - 1 - ���������� �������� ������ �������� - �.�. �� ������ ���� - ��� ������ � �� �����.
		// 
		// ��� �������� �� ������� ������� ������� ��������� :
		// [0][0] -> [0][m] -> [m][m] -> [m][0] -> [0][0]
		// [i][j] -> [j][m] -> [m][m] -> [m][i] -> [i][j]
		
		// ��� �������� ������ ������� ������� ������� ��������� :
		// [0][0] -> [m][0] -> [m][m] -> [0][m] -> [0][0]
		// [i][j] -> [m][i] -> [m][m] -> [j][m] -> [i][j]
		
		for (int i = 0; i < size/2; i++)		
			for (int j = i; j < size-i-1; j++) {
				int temp = matrix[i][j];
				
				if (direction == right) {	// clockwise  
										
					matrix[i][j] = matrix[size-j-1][i];
					matrix[size-j-1][i] = matrix[size-i-1][size-j-1];
					matrix[size-i-1][size-j-1] = matrix[j][size-i-1];
					matrix[j][size-i-1] = temp;
				}
				else if (direction == left) {	// counter-clockwise  
					
					matrix[i][j] = matrix[j][size-i-1];
					matrix[j][size-i-1] = matrix[size-i-1][size-j-1];
					matrix[size-i-1][size-j-1] = matrix[size-j-1][i];
					matrix[size-j-1][i] = temp;
				}				
			}			
	}	
}
