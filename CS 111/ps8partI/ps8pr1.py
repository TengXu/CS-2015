#
# ps8pr1.py (Problem Set 8, Problem 1)
#
# 2-D Lists
#
# Computer Science 111
#
# name: Teng Xu
# email:xt@bu.edu
#
# If you worked with a partner, put his or her contact info below:
# partner's name:
# partner's email:
# 

# IMPORTANT: This file is for your solutions to problem 1.
# Your solutions to problem 2 should go in ps8pr2.py instead.

import random

def create_row(width):
    """ creates and returns a "row" with the specified width --
        i.e., a list containing width zeros.
        input: width is a non-negative integer
    """
    row = []
    
    for col_num in range(width):
        row += [0]    # add one 0 to the end of the row

    return row

def create_grid(height, width):
    """ creates and returns a 2-D list of height rows and width
        columns in which all of the cells–i.e., all of the elements
        of the sublists–have a value of 0
    """
    grid = []
    for row_num in range(height):
        grid += [[0] * width]
    return grid

def print_grid(grid):
    """ prints the 2-D list specified by grid in 2-D form,
        with each row on its own line, and no spaces between values.
        input: grid is a 2-D list. We assume that all of the cell 
               values are either 0 or 1.
    """
    for row in grid:
        for cell in row:
            print(cell, end='')        # don't print a newline or space at end
        print()                        # at end of row, go to next line

def diagonal_grid(height, width):
    """ creates and returns a height x width grid in which the cells
        on the diagonal are set to 1, and all other cells are 0.
        inputs: height and width are non-negative integers
    """
    grid = create_grid(height, width)   # initially all 0s

    for r in range(height):
        for c in range(width):
            if r == c:
                grid[r][c] = 1

    return grid

def inner_grid(height, width):
    """ creates and returns a 2-D list of height rows and width columns
        in which the “inner” cells are all 1 and the cells on the outer
        border are all 0
    """
    grid = create_grid(height, width) 
    for r in range(height):
        for c in range(width):
            if r > 0 and r < (height - 1):
                if c > 0 and c < (width -1):
                    grid[r][c] = 1
    return grid

def random_grid(height, width):
    """ creates and returns a 2-D list of height rows and width columns
        in which the inner cells are randomly assigned either 0 or 1, but
        the cells on the outer border are all 0
    """
    grid = create_grid(height, width) 
    for r in range(height):
        for c in range(width):
            if r != 0 and r != (height - 1):
                if c != 0 and c != (width -1):
                    grid[r][c] = random.choice([0, 1])
    return grid

def copy(grid):
    height = len(grid)
    width = len(grid[0])
    newg = create_grid(height, width)
    for r in range(height):
        for c in range(width):
            newg[r][c] = grid[r][c]
    return newg


