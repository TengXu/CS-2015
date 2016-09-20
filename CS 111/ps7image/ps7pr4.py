#
# ps7pr4.py (Problem Set 7, Problem 4)
#
# TT Securities
#
# Computer Science 111
#
# name: Teng Xu
# email: xt@bu.edu
#
# If you worked with a partner, put his or her contact info below:
# partner's name:
# partner's email:
# 

def display_menu():
    """ prints a menu of options
    """  
    print()
    print('(0) Input a new list of prices')
    print('(1) Print the current prices')
    print('(2) Find the latest price')
    print('(3) Find the average price')
    print('(4) Find the standard deviation')
    print('(5) Find the min and its day')
    print('(6) Find the max and its day')
    print('(7) Test a threshold')
    print('(8) Your TT investment plan')
    print('(9) Quit')
    print()

def get_new_prices():
    """ gets a new list of prices from the user and returns it
    """
    new_list = eval(input('Enter a new list of prices: '))
    return new_list

def print_prices(prices):
    """ prints the current list of prices
        input: prices is a list of 1 or more numbers.
    """
    print ('Day  Price')
    print('---  -----')
    for i in range(len(prices)):
        print( '%2.0f' % i, '%7.2f' % prices[i])

def latest_price(prices):
    """ returns the latest (i.e., last) price in a list of prices.
        input: prices is a list of 1 or more numbers.
    """
    return prices[-1]

## Add your helper functions for options 3-8 below.
def average_price(prices):
    """ returns the average price of a list of prices.
        input: prices is a list of 1 or more numbers.
    """
    sum1 = 0
    for i in prices:
        sum1 = sum1 + i
    return sum1 / len(prices)

def standard_deviation(prices):
    """ returns the standard_deviation(prices)of a list of prices.
        input: prices is a list of 1 or more numbers.
    """
    avg = average_price(prices)
    sum2 = 0
    for i in prices:
        sum2 = sum2 + ( i - avg ) ** 2
    return sum2 / len(prices)

def minprice(prices):
    m = 0
    for x in range(len(prices)):
        if prices[x] < prices[m]:
            m = x
    print('the min price is',prices[m],'and its day is', m)

def maxprice(prices):
    m = 0
    for x in range(len(prices)):
        if prices[x] > prices[m]:
            m = x
    print('the max price is',prices[m],'and its day is', m)

def threshold(prices):
    threshold = int(input('Enter the threshold: '))
    count = 0
    for x in prices:
        if x > threshold:
            count = count + 1
    if count == 0:
        print('There are no prices over', threshold)
    elif count == 1:
        print('There is at least', count,'price over', threshold)
    else:
        print('There are at least', count,'prices over', threshold)

def TT_investment(prices):
    maxdiff = 0
    pos1 = 0
    pos2 = 0
    for i in range(len(prices)):
        for j in range(len(prices)):
            d = prices[j] - prices[i]
            if d > maxdiff:
                if j > i:
                    maxdiff = d
                    pos1 = i
                    pos2 = j
    print(' Buy on day', pos1,'at price', prices[pos1])
    print('Sell on day', pos2,'at price', prices[pos2])
    print('Total profit:', maxdiff)

    
def tts():
    """ the main user-interaction loop
    """
    prices = []

    while True:
        display_menu()
        choice = int(input('Enter your choice: '))
        print()

        if choice == 0:
            prices = get_new_prices()
        elif choice == 9:
            break
        elif choice < 9 and len(prices) == 0:
            print('You must enter some prices first.')
        elif choice == 1:
            print_prices(prices)
        elif choice == 2:
            latest = latest_price(prices)
            print('The latest price is', latest)
        ## add code to process the other choices here
        elif choice == 3:
            average = average_price(prices)
            print('The average price is', average)
        elif choice == 4:
            standard = standard_deviation(prices)
            print('standard deviation is', standard)
        elif choice == 5:
            minprice(prices)
        elif choice == 6:      
            maxprice(prices)
        elif choice == 7:
            threshold(prices)
        elif choice == 8:
            TT_investment(prices)
        else:
            print('Invalid choice. Please try again.')

    print('See you yesterday!')
