# Name: Teng Xu
# E-mail: xt@bu.edu
from ps9pr2 import Date

def get_age_on(birthday, other):
    """ accepts two Date objects as parameters: one to represent a person’s
        birthday, and one to represent an arbitrary date. The function should
        then return the person’s age on that date as an integer
    """
    new_date = Date(birthday.month, birthday.day, other.year)
    age = other.year - birthday.year - 1
    if other.is_after(new_date):
        age += 1
    return age
    
def print_birthdays(filename):
    """ accepts a string filename as a parameter. The function should then
        open the file that corresponds to that filename, read through the
        file, and print some information derived from that file
    """
    file = open(filename, 'r')
    for line in file:
        fields = line.split(',')
        mon = int(fields[1])
        day = int(fields[2])
        year = int(fields[3])
        d = Date( mon, day, year)
        print (fields[0],'(' + str(d) + ')','(' + d.day_of_week() + ')')
