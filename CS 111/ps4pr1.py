#1  takes a non-negative integer n and converts it from decimal to binary
def dec_to_bin(n):
    if n == 0:
        return '0'
    elif n == 1:
        return '1'
    else:
        rest = n // 2
        if n%2 == 0:
            return dec_to_bin(rest) + '0'
        else:
            return dec_to_bin(rest) + '1'



#2  takes the string representation of a binary number and converts the

#   number from binary to decimal, returning the resulting integer
def bin_to_dec(s):
    if s == '1':
        return 1
    elif s == '0':
        return 0
    else:
        rest = bin_to_dec(s[0:-1])
        if s[-1] == '1':
            return 2*rest + 1
        else:
            return 2*rest
        

#3 takes an 8-character string representation of a binary number and
#  returns the next larger binary number as an 8-character string
def increment(s):
    if s == '11111111':
        return '00000000'
    else:
        n = bin_to_dec(s)
        b = dec_to_bin(n+1)
        return '0'*(8-len(b))+ b
