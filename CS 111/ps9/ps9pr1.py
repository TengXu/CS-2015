# Name: Teng Xu
# E-mail: xt@bu.edu



def count_ignore_case(s, sub):
    """ takes a string s and and substring sub, and that uses one or more
        string methods to compute and return the number of occurrences of
        sub in s, but in a way that ignores the cases of the letters involved
    """
    count = s.lower().count(sub.lower())
    return  count



def middle_name(fullname):
    """ takes a string fullname that represents a person’s full name, and
        that uses one or more string methods to extract and return a string
        representing the person’s middle name
    """
    name = fullname.split()
    if len(name) < 3:
        return ''
    else:
        return name[1]
