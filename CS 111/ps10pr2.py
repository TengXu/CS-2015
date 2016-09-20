#
# ps10pr2.py (Problem Set 10, Problem 2)
#
# A Connect Four Player class 
#
# name: Teng Xu
# email: xt@bu.edu
#
# If you worked with a partner, put his or her contact info below:
# partner's name:
# partner's email:
#

from ps10pr1 import Board

# Write your Player class below.

class Player:
    def __init__(self, checker):
        """ constructs a new Player object """
        assert(checker == 'X' or checker == 'O')
        self.checker = checker
        self.num_moves = 0
    def __repr__(self) :
        """ returns a string representing a Player object """
        return 'Player  ' + self.checker
    def opponent_checker(self):
        """ returns a one-character string representing the checker
            of the Player object’s opponent
        """
        if self.checker == 'O':
            return 'X'
        return 'O'
    def next_move(self, board):
        """ accepts a Board object as a parameter and returns the column
            where the player wants to make the next move. To do this, the
            method should ask the user to enter a column number that
            represents where the user wants to place a checker on the board
        """
        self.num_moves += 1
        col = int(input('Enter a column: '))
        if board.can_add_to(col):
            return col
        return('Try again!')
