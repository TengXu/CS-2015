def ends_match(s):
    """  takes a string input s and returns True if the first character
         in s matches the last character in s, and False otherwise
    """
    return s[0] == s[-1]


def front3(a):
    """ Given a string, we'll say that the front is the first 3 chars of
        the string. If the string length is less than 3, the front is whatever

        is there. Return a new string which is 3 copies of the front.

    """
    if len(a) < 3:
        return a * 3
    return a[0:3] * 3


def every_other(values):   
    """ takes as input a list values and returns a list containing every
        other value from the original list
    """
    return values[0::2]



def begins_with(word, prefix):
    """ takes as inputs two string values word and prefix, and that returns
        True if the string word begins with the string prefix, and False
        otherwise
    """
    leng = len(prefix)
    return word[0:leng] == prefix





