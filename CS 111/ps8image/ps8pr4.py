#
# ps8pr4.py (Problem Set 8, Problem 4)
#
# Images as lists
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
# PROBLEM4:
# The mystery.png is a solid yellow image. Because we change the list,
# but not the reference to the list, since the pixels is changed, every
# pixel becomes [255,0,255].

from hmcpng import *

# 1
def create_pixel_row(width, pixel):
    """ creates and returns a "row" of pixels with the specified width
        in which all of the pixels have the RGB values specified by pixel.
        input: width is a non-negative integer
               pixel is a list of RBG values of the form [R,G,B],
                     where each element is an integer between 0 and 255.
    """
    row = []
    
    for col_num in range(width):
        row += [pixel]

    return row
# 2
def create_uniform_image(height, width, pixel):
    """ creates and returns a 2-D list of pixels with height rows and width
        columns in which all of the pixels have the RGB values given by pixel
    """
    image = []
    for r in range(height):
        image += [create_pixel_row(width, pixel)]
    return image

# 3
def blank_image(height, width):
    """ creates and returns a 2-D list of pixels with height rows and width
        columns in which all of the pixels are green (i.e., have RGB values
        [0,255,0])
    """
    pixel = [0, 255, 0]
    return create_uniform_image(height, width, pixel)
# 4
def flip_vert(pixels):
    """ takes the 2-D list pixels containing pixels for an image, and that
        creates and returns a new 2-D list of pixels for an image in which
        the original image is “flipped” vertically
    """
    height = len(pixels)
    width = len(pixels[0])
    new = blank_image(height, width)
    for r in range(height):
        for c in range(width):
            new[r][c] = pixels[(height -1 -r)][c]
    return new

# 5
def transpose(pixels):
    """ takes the 2-D list pixels containing pixels for an image, and that
        creates and returns a new 2-D list that is the transpose of pixels
    """
    height = len(pixels[0])
    width = len(pixels)
    newp = blank_image(height, width)
    for r in range(len(newp)):
        for c in range(len(newp[0])):
            newp[r][c] = pixels[c][r]
    return newp

# 6
def rotate_counterclockwise(pixels):
    return transpose(pixels)
def rotate_clockwise(pixels):
    return transpose(flip_vert(pixels))
    
