#
# ps3pr2.py (Problem Set 3, Problem 2)
#
# Caesar cipher/decipher
#
# name: Teng Xu
# email: xt@bu.edu
#
# If you worked with a partner, put his or her contact info below:
# partner's name:
# partner's email:
#

# a helper function that could be useful when assessing
# the "Englishness" of a phrase
def letter_prob(c):
    """ if c is the space character (' ') or an alphabetic character,
        returns c's monogram probability (for English);
        returns 1.0 for any other character.
        adapted from:
        http://www.cs.chalmers.se/Cs/Grundutb/Kurser/krypto/en_stat.html
    """
    if c == ' ': return 0.1904
    if c == 'e' or c == 'E': return 0.1017
    if c == 't' or c == 'T': return 0.0737
    if c == 'a' or c == 'A': return 0.0661
    if c == 'o' or c == 'O': return 0.0610
    if c == 'i' or c == 'I': return 0.0562
    if c == 'n' or c == 'N': return 0.0557
    if c == 'h' or c == 'H': return 0.0542
    if c == 's' or c == 'S': return 0.0508
    if c == 'r' or c == 'R': return 0.0458
    if c == 'd' or c == 'D': return 0.0369
    if c == 'l' or c == 'L': return 0.0325
    if c == 'u' or c == 'U': return 0.0228
    if c == 'm' or c == 'M': return 0.0205
    if c == 'c' or c == 'C': return 0.0192
    if c == 'w' or c == 'W': return 0.0190
    if c == 'f' or c == 'F': return 0.0175
    if c == 'y' or c == 'Y': return 0.0165
    if c == 'g' or c == 'G': return 0.0161
    if c == 'p' or c == 'P': return 0.0131
    if c == 'b' or c == 'B': return 0.0115
    if c == 'v' or c == 'V': return 0.0088
    if c == 'k' or c == 'K': return 0.0066
    if c == 'x' or c == 'X': return 0.0014
    if c == 'j' or c == 'J': return 0.0008
    if c == 'q' or c == 'Q': return 0.0008
    if c == 'z' or c == 'Z': return 0.0005
    return 1.0

#### Put your code for problem 2 below. ####

#1
def rot(c,n):
    """ rotate c forward by n characters,
    wrapping as needed; only letters change
    """
    if 'a' <= c <= 'z': 
        new_ord = ord(c) + n
        if new_ord > ord('z'):
            new_ord = new_ord - 26
    elif 'A' <= c <= 'Z': 
        new_ord = ord(c) + n
        if new_ord > ord('Z'):
            new_ord = new_ord - 26
    else: 
        new_ord = ord(c)
    return chr(new_ord)

def encipher(s,n):
    if s == '':
        return ''
    else:
        return rot(s[0],n)+ encipher(s[1:],n)




#2
def num_vowels(s):
    lc = [1 for c in s if c in 'aeiou']
    return sum(lc)

def decipher(s):
    options = [encipher(s,n) for n in range(26)]
    scored_options = [[num_vowels(x),x] for x in options]
    return max(scored_options)[1]




