# -*- coding: utf-8 -*-
#1
def rem_first(elem, s):
    """ returns a version of values in which *only the first* occurrence
        of elem (if any) has been removed.
        inputs: elem is an arbitrary value
                s is an arbitrary string
    """
    if s == '':
        return ''
    elif s[0] == elem:
        return s[1:]
    else:
        rest = rem_first(elem, s[1:])
        return s[0] + rest

#2
#takes two strings s1 and s2 as inputs and returns the Jotto score of s1
#compared with s2 – i.e., the number of characters in s1 that are shared by
#s2. The positions and the order of the shared characters within each string
#do not matter. Repeated letters are counted multiple times, as long as
#they appear multiple times in both strings

def jscore(s1, s2):
    if s1 == '' or s2 == '':
        return 0
    else:
        if s1[0] in s2:
            return 1 + jscore(s1[1:], rem_first(s1[0], s2))
        else:
            return jscore(s1[1:], s2)


#3
#takes two strings s1 and s2 and returns the longest common subsequence
#(LCS) that they share. The LCS is a string whose letters appear in both
#s1 and s2; these letters must appear in the same order in both s1 and s2,
#but not necessarily consecutively

def lcs(s1, s2):
    if s1 == '' or s2 == '':
        return ''
    elif s1[0] == s2[0]:
        return s1[0] + lcs(s1[1:],s2[1:])
    else:
        result1 = lcs( s1[1:] , s2 )
        result2 = lcs( s1 , s2[1:] )
        if len(result1) > len(result2):
            return result1
        else:
            return result2
