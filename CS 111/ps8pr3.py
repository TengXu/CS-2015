#
# ps8pr3.py (Problem Set 8, Problem 3)
#
# Matrix operations
#
# Computer Science 111
#
# name: Teng Xu
# email: xt@bu.edu
# 

def display_menu():
    """ prints a menu of options
    """  
    print()
    print('(0) Enter a new matrix')
    print('(1) Negate the matrix')
    print('(2) Multiply a row by a constant')
    print('(3) Add one row to another')
    print('(4) Add a multiple of one row to another')
    print('(5) Transpose the matrix')
    print('(6) Quit')
    print()

def print_matrix(matrix):
    """ prints the specified matrix in rectangular form.
        input: matrix is a 2-D list numbers
    """
    for r in range(len(matrix)):
        for c in range(len(matrix[0])):
            print('%7.2f' % matrix[r][c], end=' ')
        print()
       
def get_matrix():
    """ gets a new matrix from the user and returns it
    """
    matrix = eval(input('Enter a new 2-D list of numbers: '))
    return matrix

def negate_matrix(matrix):
    """ negates all of the elements in the specified matrix
        inputs: matrix is a rectangular 2-D list of numbers
    """
    for r in range(len(matrix)):
        for c in range(len(matrix[0])):
            matrix[r][c] *= -1
    # We don't need to return the matrix!
    # All changes to the matrix will still be there when the
    # function returns, because we received a copy of the
    # *reference* to the matrix used by main().

### Add your functions for options 2-5 here. ###
    
# 2
def mult_row(matrix, r, m):
    """ multiplies row r of the specified matrix by the
        specified multiplier m
    """
    for row in range(len(matrix)):
        for c in range(len(matrix[0])):
            if row == r:
                matrix[row][c] *= m
# 3                
def add_row_into(matrix, rs, rd):
    """  takes the specified 2-D list matrix and adds each
         element of row rs (the source row) to the corresponding
         element of row rd (the destination row)
    """
    for r in range(len(matrix)):
        for c in range(len(matrix[0])):
            if r == rd:
                matrix[r][c] += matrix[rs][c]
# 4
def add_mult_row_into(matrix, m, rs, rd):
    """ takes the specified 2-D list matrix and adds each element of
        row rs (the source row), multiplied by m, to the corresponding
        element of row rd (the destination row)
    """
    for r in range(len(matrix)):
        for c in range(len(matrix[0])):
            if r == rd:
                matrix[r][c] += (matrix[rs][c] * m)
# 5
def create_grid(height, width):
    """ creates and returns a 2-D list of height rows and width
        columns in which all of the cells–i.e., all of the elements
        of the sublists–have a value of 0
    """
    grid = []
    for row_num in range(height):
        grid += [[0] * width]
    return grid
def transpose(matrix):
    """  takes the specified 2-D list matrix and creates and returns a
        new 2-D list that is the transpose of matrix
    """
    height = len(matrix[0])
    width = len(matrix)
    newmatrix = create_grid(height, width)
    for r in range(len(newmatrix)):
        for c in range(len(newmatrix[0])):
            newmatrix[r][c] = matrix[c][r]
    return newmatrix

def main():
    """ the main user-interaction loop
    """
    ## The default starting matrix.
    ## DO NOT CHANGE THESE LINES.
    matrix = [[ 1,  2,  3,  4],
              [ 5,  6,  7,  8],
              [ 9, 10, 11, 12]]

    while True:
        print()
        print_matrix(matrix)
        display_menu()
        choice = int(input('Enter your choice: '))

        if choice == 0:
            matrix = get_matrix()
        elif choice == 1:
            negate_matrix(matrix)
        elif choice == 2:
            r = int(input('Index of row: '))
            m = float(input('Multiplier: '))
            mult_row(matrix, r, m)
        elif choice == 3:
            rs = int(input('Index of source row: '))
            rd = int(input('Index of destination row: '))
            add_row_into(matrix, rs, rd)
        elif choice == 4:
            rs = int(input('Index of source row: '))
            rd = int(input('Index of destination row: '))
            m = float(input('Multiplier: '))            
            add_mult_row_into(matrix, m, rs, rd)
        elif choice == 5:
            matrix = transpose(matrix)
        elif choice == 6:
            break
        else:
            print('Invalid choice. Try again.')
