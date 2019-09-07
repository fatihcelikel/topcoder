# BIG O #

How the time scales with respect to some input variables

## O(1) ##

int getElement(int[] array, int index) { return array[index]; }

## O(N) ##
N:size of array 

boolean contains (int[] array, int value) { for (int i = 0; i < array.length; i++) { if (array[i] == value) { return true; } } return false; } for (int i = 0; i < array.length; i++) { for (int j =0; j < array.lenght; j++) { System.out.println(arr[x] + " : "+ arr[y]); } } }

N: length of square O(Nˆ2)

A: number of elements in square A = Nˆ2 O(A)

void moveAll(int[][] square){ for (int i = 0; i < square.length; i++) { for (int j = 0; j < square.lenght; j++){ move(square[i][j]); } } }

Different steps get added. O(A) + O(B) -> O(A+B)

Drop constants O(A) + O(A) -> 2O(A) -> O(A)

Different inputs different variables O(A) + O(B) -> O(A+B)

Drop non-dominant terms O(N) + O(Nˆ2) -> O(Nˆ2)
