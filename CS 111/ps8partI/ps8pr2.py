#
# ps8pr2.py (Problem Set 8, Problem 2)
#
# Conway's Game of Life
#
# Computer Science 111
#
# name:  Teng Xu
# email: xt@bu.edu
#
# If you worked with a partner, put his or her contact info below:
# partner's name:
# partner's email:
# 

# IMPORTANT: This file is for your solutions to problem 2.
# Your solutions to problem 1 should go in ps8pr1.py instead.

from ps8pr1 import *
from gol_graphics import *

def inner_reverse(grid):
    """  takes an existing generation of cells (the 2-D list grid),
         and that creates and returns a new generation with the same
         dimensions as grid, but in which the inner cells are the
         reverse of the inner cells in grid
    """
    new_grid = copy(grid)
    height = len(grid)
    width = len(grid[0])
    for r in range(height):
        for c in range(width):
            if r > 0 and r < (height - 1):
                if c > 0 and c < (width -1):
                    if grid[r][c] == 1:
                        new_grid[r][c] = 0
                    else:
                        new_grid[r][c] = 1
    return new_grid

def count_neighbors(cellr, cellc, grid):
    """ returns the number of alive neighbors of the cell at position
        [cellr][cellc] in the specified grid. You may assume that the
        indices cellr and cellc will always represent one of the inner
        cells of grid, and thus the cell will always have eight neighbors
    """
    count = 0
    for r in range(cellr-1 , cellr+2):
        for c in range(cellc-1 , cellc+2):
            if grid[r][c] == 1:
                count += 1
    if grid[cellr][cellc] == 1:
                count = count -1
    return count

def next_gen(grid):
    new_grid = copy(grid)
    height = len(grid)
    width = len(grid[0])
    for r in range( 1 ,(height - 1)):
        for c in range( 1 , (width - 1)):
            count = count_neighbors(r, c, grid)
            if count < 2:
                new_grid[r][c] = 0
            if count > 3:
                new_grid[r][c] = 0
            if count == 3:
                new_grid[r][c] = 1
    return new_grid
