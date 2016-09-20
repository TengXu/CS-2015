def reverse(s):
    return s[-1::-1]



def outer_vals(values):
    return values[0:1] + values[-1:]




def flipside(s):
    leng = len(s)//2
    return s[leng:] + s[0:leng]




def adjust(s, length):
    if len(s) < length:
        return ' '*(length - len(s)) + s
    return s[0:length]
