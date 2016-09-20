def add_spaces(s):
    """ takes an arbitrary string s as input and returns the string formed by adding a space between each pair of adjacent characters in the string. If the
        string has fewer than two characters, it should be returned without any changes
    """
    if len(s) < 2:
        return s
    else:
        return s[0]+' '+ add_spaces(s[1:])


def num_diff(s1, s2):
    """ takes as inputs two strings s1 and s2 (which you can assume have the same length) and returns the number of differences between the two strings
        – i.e., the number of positions at which the two strings have different characters
    """
    if s1 == '':
        return 0
    else:
        rest = num_diff(s1[1:], s2[1:])
        if s1[0] != s2[0]:
            return 1 + rest
        else:
            return rest
        
def index(elem, seq):
    """  takes as inputs an element elem and a sequence seq and returns the index of the first occurrence of elem in seq. The sequence seq can be

         either a list or a string. If seq is a string, elem will be a single-character string; if seq is a list, elem can be any value. If elem

         is not an element of seq, the function should return the length of the sequence
    """
    if seq == '' or seq == []:
        return 0
    elif elem == seq[0]:
        return 0
    else :
            return 1 + index(elem,seq[1:])


def one_dna_to_rna(c):
    """takes as input a single-character string c representing a DNA nucleotide and

       returns the corresponding messenger-RNA nucleotide
    """

    if c == '':
       return ''
    elif c == 'A':
        return 'U'
    elif c == 'C':
        return 'G'
    elif c == 'G':
        return 'C'
    elif c == 'T':
        return 'A'
    else:
        return ''

def transcribe(s):
    """ takes as input a string s representing a piece of DNA, and returns a string representing the corresponding RNA. Any characters in
        the input that don’t correspond to a DNA nucleotide should not appear in the returned RNA string
    """
    if s == '':
        return ''
    else:
        if s[0] in 'A''C''G''T':
            return one_dna_to_rna(s[0]) + transcribe(s[1:])
        else:
            return transcribe(s[1:])
