#
# ps2pr3.py - Problem Set 2, Problem 3
#
# Indexing and slicing puzzles
#
# name: teng xu
# email: xt@bu.edu

# 1
def mult(n, m):
    """ takes two integers n and m as inputs and returns the product
        of those integers
    """
    if  n == 0:
        return 0
    elif n < 0:
        return -mult(-n, m)
    else :
         rest = mult(n-1,m)
         return m + rest


# 2
def dot(l1, l2):
    """ takes as inputs two lists of numbers, l1 andl2, and returns
        the dot product of those lists
    """
    if  len(l1) != len(l2):
        return 0.0
    elif l1 == [] or l2 == []:
        return 0.0
    else:
        rest = dot(l1[1:],l2[1:])
        return l1[0]*l2[0] + rest


# 3
def letter_score(letter):
    """  takes a lowercase letter as input and returns the value of
         that letter as a scrabble tile.
    """
    if letter in ['a','b','c','d','e','f','g','h','i','j','k','l','m',
                  'n','o','p','q','r','s','t','u','v','w','x','y','z',]:
        if   letter in ['a','n','o','i','e','l','r','s','t','u']:
            return 1
        elif letter in ['d','g']:
            return 2
        elif letter in ['b','c','m','p']:
            return 3
        elif letter in ['f','v','w','y','h']:
            return 4
        elif letter in ['k']:
            return 5
        elif letter in ['j','x',]:
            return 8
        elif letter in ['q','z']:
            return 10
    else:
        return 0


# 4
def scrabble_score(word):
    """ takes as input a string word containing only lowercase letters and

        returns the scrabble score of that string
    """
    if  word == '':
        return 0
    else:
        rest = scrabble_score(word[1:])
        return letter_score(word[0]) + rest
        
