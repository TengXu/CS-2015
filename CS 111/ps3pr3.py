#
# ps3pr3.py (Problem Set 3, Problem 3)
#
# sorting
#
# name: 
# email:
#

# two possible helper functions for use in your gensort function
def insert_sorted(elem, values):
    """ takes a sorted list, and creates and returns a new sorted
          list containing the elements from the original list, along
          with elem in its appropriate place.
        inputs: elem is an an arbitrary value.
                values is a *sorted* list.
                elem should be of a type that allows it to be compared
                to the existing elements in values.
    """
    if values == []:
        return [elem]
    elif elem < values[0]:
        return [elem] + values
    else:
        rest = insert_sorted(elem, values[1:])
        return [values[0]] + rest

def rem_first(elem, value):
    """ returns a version of values in which *only the first* occurrence
        of elem (if any) has been removed.
        inputs: elem is an arbitrary value
                values is an arbitrary list
    """
    if value == []:
        return []
    elif value[0] == elem:
        return value[1:]
    else:
        rest = rem_first(elem, value[1:])
        return [value[0]] + rest
    
#1
def binsort(digits):
    """takes as input a list of binary digits, and that creates and
       returns a new list with the same elements as the original list,
       
but sorted in ascending order.
    """
    return [x for x in digits if x == 0] + [y for y in digits if y == 1]

#2
def gensort(values):
    """  takes as input a list of values, and that creates and returns
         a new list with the same elements as the original list, but
         in ascending order
    """
    if values == []:
        return []
    else:
        min1 = min(values)
        rest = rem_first(min1,values)
        return [min1] + gensort(rest)
