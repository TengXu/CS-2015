def square(x):
    """  takes a number x as its input and returns the square of its input
    """
    return x * x



def interpolate(low, high, fraction):

    """ takes three numeric inputs low, high, and fraction and returns
        a number that linearly interpolates between low and high by the
        amount specified by fraction
    """

    return low + (high - low) * fraction


def convert_from_inches(inches):
    """  takes a nonnegative integer inches that represents a length
         in inches and returns a list of three integers in which that

         length has been broken up into yards, feet, and inches
    """
    yards = inches // 36                # number of yards
    inches = inches - yards * 36        # the leftover number of inches
    feet = inches // 12                     # number of feet
    inches = inches % 12                   # final number of inches
    return [yards, feet, inches]


def median(a,b,c):
    """ takes three numeric inputs a, b, and c, and that returns the

        median of the three inputs
    """
    if a <= b <= c or c <= b <= a:
        return b
    elif b <= a <= c or c <= a <= b:
        return a
    return c
