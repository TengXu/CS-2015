#
# ps4pr2.py - Problem Set 4, Problem 2
#
# Indexing and slicing puzzles
#
# name: Teng Xu
# email: xt@bu.edu
from ps4pr1 import *


#1 takes as inputs two strings s1 and s2 that represent binary numbers, compute

#  the sum of the numbers, and return that sum in the form of a string that

#  represents a binary number

#1

def add(s1, s2):
    sum1 = bin_to_dec(s1) + bin_to_dec(s2)
    sum2 = dec_to_bin(sum1)
    return sum2


#2 adds two binary numbers

def add_bitwise(s1, s2):
    if s1 == '' or s2 == '':
        return s1 + s2
    else:
        rest = add_bitwise(s1[:-1], s2[:-1])
        if s1[-1] + s2[-1] == '00':
            return rest + '0'
        elif s1[-1] + s2[-1] == '11':
            return add_bitwise(rest,'1') + '0'
        else:
            return rest + '1' 
    

