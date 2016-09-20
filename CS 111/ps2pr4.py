#
# ps2pr4.py - Problem Set 2, Problem 4
#
# List comprehensions
#
# name: 
# email:
#
# If you worked with a partner, put his or her contact info below:
# partner's name:
# partner's email:
#

# Problem 4-1: LC puzzles!
# This code won't work until you complete the list comprehensions!
# If you can't figure out how to complete one of them, please
# comment out the corresponding lines by putting a # at the start
# of the appropriate lines.

# part a
lc1 = [ x+5 for x in range(5)]
print(lc1)

# part b
lc2 = [ word+'ing' for word in ['go', 'eat', 'read']]
print(lc2)

# part c
words = ['hello', 'world', 'how', 'goes', 'it?']
lc3 = [  w[-1]  for w in words]
print(lc3)

# part d
lc4 = [ c == 'a'  for c in 'aardvark']
print(lc4)

# part e
lc5 = [ x for x in range(1, 21) if x%5 == 0 ]
print(lc5)


# Problem 4-2: Put your definition of the powers_of() function below.
# takes as inputs a number n and a positive integer count, and that uses a list comprehension to construct and re
# turn a list containing the first count powers of n, beginning with the 0th power
def powers_of(n, count):
    return [n**count for count in range(count)]

# Problem 4-3: Put your definition of the starts_with() function below.
# takes as inputs a string prefix and a list of strings wordlist, and that uses a list comprehension to return
# a list consisting of all words from wordlist that begin with prefix
def starts_with(prefix, wordlist):
    return [x for x in wordlist if x[:len(prefix)] == prefix]
