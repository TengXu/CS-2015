import random
import math
# Name: Teng Xu
# E-mail: xt@bu.edu

# 1
# simulates the act of throwing one dart in the square region,
# If the dart hits the circle of radius 1 inscribed in the square,
# the function should return True. If the dart falls outside the circle,
# the function should return False.
def throw_dart():
    x = random.uniform(-1.0, 1.0)
    y = random.uniform(-1.0, 1.0)
    if x**2 + y**2 <= 1.0 :
        return True
    else:
        return False
    
# 2
# takes a positive integer n and returns an estimate of π that is based
# on n randomly thrown darts
def for_pi(n):
    counter = 0
    for i in range(n):
        if throw_dart() == 1:
            counter = counter + 1
        result = counter / (i+1) * 4
        print( counter ,'hits out of' ,i+1, 'throws so that pi is' ,result)
    return counter / n * 4
    
# 3
# that takes a positive floating-point input error and returns the
# number of dart throws needed to produce an estimate of π that is less
# than error away from the “actual” value of π
def while_pi(error):
    counter = 0
    counter1 = 0
    while True:
        counter1 = counter1 + 1
        if throw_dart() == 1:
           counter = counter + 1
        result = counter / counter1 * 4
        print( counter ,'hits out of' ,counter1, 'throws so that pi is' ,result)
        if abs (result - math.pi) < error:
            return counter1
