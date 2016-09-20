#Name: Teng Xu
#E-mail: xt@bu.edu

class Board:
    """ a data type for a Connect Four board with
        arbitrary dimensions
    """
    def __init__(self, height, width):
         """ a constructor for Board objects """
         self.height = height
         self.width = width
         self.slots = [[' '] * width for row in range(self.height)]
         
    def __repr__(self):
        """ Returns a string representation for a Board object.
        """
        s = ''         # begin with an empty string

        # add one row of slots at a time
        for row in range(self.height):
            s += '|'   # one vertical bar at the start of the row

            for col in range(self.width):
                s += self.slots[row][col] + '|'
            s += '\n'  # newline at the end of the row
        s += '-' * (self.width * 2 + 1)
        s += '\n'
        for n in range(self.width):
            if n > 9:
                n = n - 10
            s += ' '
            s += str(n)
        return s
    
    def add_checker(self, checker, col):
        """ adds the specified checker to column col
            of the called Board object
        """
        assert(checker == 'X' or checker == 'O')
        assert(col >= 0 and col < self.width)
        row = 0
        while self.slots[row][col] == ' ' and row < (self.height-1):
            row += 1
        if row == (self.height -1) and self.slots[self.height-1][col] == ' ':
            row += 1
        self.slots[row-1][col] = checker
        
    def clear(self):
        """ clear the Board object on which it is called by setting
            all slots to contain a space character
        """
        for r in range(self.height):
            for c in range(self.width):
                self.slots[r][c] = ' '
                
    def add_checkers(self, colnums):
        """ takes in a string of column numbers and places alternating
            checkers in those columns of the called Board object, 
            starting with 'X'.
        """
        checker = 'X'   # start by playing 'X'
        for col_str in colnums:
            col = int(col_str)
            if 0 <= col < self.width:
                self.add_checker(checker, col)
            # switch to the other checker
            if checker == 'X':
                checker = 'O'
            else:
                checker = 'X'
                
    def can_add_to(self, col):
        """  returns True if it is valid to place a checker in the
             column col on the calling Board object. Otherwise, it
             should return False
        """
        if col >= 0 and col < self.width:
            if self.slots[0][col] == ' ':
                    return True
        return False

    def is_full(self):
        """ returns True if the called Board object is completely
            full of checkers, and returns False otherwise
        """
        for c in range(self.width):
            if self.can_add_to(c):
                return False
        return True

    def remove_checker(self, col):
        """ removes the top checker from column col of the called
            Board object. If the column is empty, then the method
            should do nothing
        """
        for r in range(self.height):
            if self.slots[r][col] != ' ':
                self.slots[r][col] = ' '
                return self
            
    def is_win_for(self, checker):
        """ accepts a parameter checker that is either 'X' or 'O',
            and returns True if there are four consecutive slots
            containing checker on the board. Otherwise, it should
            return False
        """
        assert(checker == 'X' or checker == 'O')
        if self.is_horizontal_win(checker) or self.is_vertical_win(checker) or\
           self.is_ldiagonal_win(checker) or self.is_rdiagonal_win(checker):
            return True
        return False
    def is_horizontal_win(self, checker):
        """ Checks for a horizontal win for the specified checker.
        """
        for row in range(self.height):
            for col in range(self.width - 3):
                if self.slots[row][col] == checker and \
                   self.slots[row][col + 1] == checker and \
                   self.slots[row][col + 2] == checker and \
                   self.slots[row][col + 3] == checker:
                    return True
        return False
    def is_vertical_win(self, checker):
        """ Checks for a horizontal win for the specified checker.
        """
        for row in range(self.height - 3):
            for col in range(self.width):
                if self.slots[row][col] == checker and \
                   self.slots[row + 1][col] == checker and \
                   self.slots[row + 2][col] == checker and \
                   self.slots[row + 3][col] == checker:
                    return True
        return False
    def is_ldiagonal_win(self, checker):
        """ Checks for a horizontal win for the specified checker.
        """
        for row in range(self.height - 3):
            for col in range(self.width - 3):
                if self.slots[row][col] == checker and \
                   self.slots[row + 1][col + 1] == checker and \
                   self.slots[row + 2][col + 2] == checker and \
                   self.slots[row + 3][col + 3] == checker:
                    return True
        return False
    def is_rdiagonal_win(self, checker):
        """ Checks for a horizontal win for the specified checker.
        """
        for row in range(3, self.height):
            for col in range(self.width - 3):
                if self.slots[row][col] == checker and \
                   self.slots[row - 1][col + 1] == checker and \
                   self.slots[row - 2][col + 2] == checker and \
                   self.slots[row - 3][col + 3] == checker:
                    return True
        return False        

