#
# ps6pr3.py (Problem Set 6, Problem 3, Tasks 3 and 4)
#
# testing for uniqueness
#
# name: 
# email:
#
# If you worked with a partner, put his or her contact info below:
# partner's name:
# partner's email:
#

# IMPORTANT: This file is for tasks 3 and 4 of problem 3.
# For tasks 1 and 2, use ps6pr3.txt instead.

### Replace the numbers in the following string with the numbers
### produced by your LCG using your choices of a and c.
NUMBERS = """
45
48
11
34
17
60
63
26
49
32
75
78
41
64
47
90
93
56
79
62
5
8
71
94
77
20
23
86
9
92
35
38
1
24
7
50
53
16
39
22
65
68
31
54
37
80
83
46
69
52
95
98
61
84
67
10
13
76
99
82
25
28
91
14
97
40
43
6
29
12
55
58
21
44
27
70
73
36
59
42
85
88
51
74
57
0
3
66
89
72
15
18
81
4
87
30
33
96
19
2
"""

def test():
    """ turns the string of integers NUMBERS into a list of integers and
        runs your unique() function on that list of integers, returning
        whatever it returns.

        NOTE: The commented-out print statements are there in case you'd
        like to gain more insight into what test() is doing.
        If you uncomment them, please re-comment them before you submit.
    """    
    list_of_strings = NUMBERS.strip().split()
    # print('list_of_strings is:', list_of_strings)

    list_of_ints = [int(s) for s in list_of_strings]
    # print('list_of_ints is:', list_of_ints)

    return unique(list_of_ints)

### Put your definition of the unique() function below.

def unique(lst):
    if lst == []:
        return True
    elif lst[0] in lst[1:]:
        return False
    else:
        return unique(lst[1:])
