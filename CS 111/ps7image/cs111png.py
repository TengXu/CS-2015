# loosely based on the cs5png module from Harvey Mudd College

from png import Reader, Writer
from os.path import isfile

DEFAULT_PIXEL = (0, 255, 0)


class ReadOnlyMethod:
    def __init__(self, name, val):
        self.name = name
        self.val = val

    def __get__(self, obj, t):
        return lambda *x: self.val(obj, *x)

    def __set__(self, obj, val):
        raise ValueError("'" + self.name + "' is a method and should not "
                         "be redefined; did you mean to call it?")


class Image:
    def __init__(self, height, width):
        self.width = width
        self.height = height
        self.image_data = [[DEFAULT_PIXEL for col in range(width)]
                                          for row in range(height)]

    def _save(self, filename):
        if type(filename) is not str:
            raise ValueError("file name must be a string")

        with open(filename, 'wb') as f:
            rows, cols = len(self.image_data), len(self.image_data[0])
            writer = Writer(cols, rows)

            pixels = _unbox(self.image_data)
            writer.write(f, pixels)

        print(filename, "saved.")

    def _get_width(self):
        return self.width

    def _get_height(self):
        return self.height

    def _get_pixel(self, row, col):
        if not _in_bounds(self.height, self.width, row, col):
            raise ValueError("row or column is out of bounds: " + str(row),
                             ", " + str(col))

        return self.image_data[row][col]

    def _set_pixel(self, row, col, pixel):
        def valid_color(c):
            return type(c) is int and 0 <= c <= 255

        if type(pixel) != list or len(pixel) != 3 or \
           not all(map(valid_color, pixel)):

            raise ValueError("pixel is not a list of three ints "
                             ">= 0 and <= 255: " + str(pixel))

        if not _in_bounds(self.height, self.width, row, col):
            raise ValueError("row or column is out of bounds: " + str(row),
                             ", " + str(col))

        self.image_data[row][col] = pixel


Image.save = ReadOnlyMethod('save', Image._save)
Image.get_width = ReadOnlyMethod('get_width', Image._get_width)
Image.get_height = ReadOnlyMethod('get_height', Image._get_height)
Image.get_pixel = ReadOnlyMethod('get_pixel', Image._get_pixel)
Image.set_pixel = ReadOnlyMethod('set_pixel', Image._set_pixel)


def load_image(filename):
    """Given the file name of a PNG file, create and return an Image object
    representing the image.
    """
    if not isfile(filename):
        raise ValueError("file '" + filename + "' cannot be found")

    reader = Reader(filename)
    num_cols, num_rows, pixels, _ = reader.asRGBA()

    rows = []
    for row in pixels:
        # note: each 'row' from this iterator is an array, so we call
        # its tolist() method here and box it
        rows.append(_box(row.tolist(), input_type='rgba'))

    img = Image(num_rows, num_cols)
    img.image_data = rows
    return img


def _box(row, input_type='rgb', output_type='rgb'):
    """Given a row of pixels in a "flat" representation (i.e., there are
    no sublists; every three or four values constitute a 3- or 4-channel
    pixel), return a "boxed" representation of these pixels (i.e., a list
    containing sublists, each with the appropriate pixel values). This
    function assumes the input is RGB (three values in a pixel: red, green
    and blue) and outputs RGB if the types are not specified.
    """
    num_input_channels = _num_channels(input_type)
    num_output_channels = _num_channels(output_type)

    new_row = []

    for i in range(len(row) // num_input_channels):
        start = num_input_channels * i
        end = start + num_output_channels

        new_row.append(row[start:end])

    return new_row


def _unbox(boxed):
    """Given a row of pixels in a "boxed" representation (i.e., a list
    containing sublists, each with the appropriate pixel values), return
    a row of pixels in a "flat" representation.
    """
    flat = []
    for row in boxed:
        flat_row = []
        for pixel in row:
            flat_row.extend(pixel)

        flat.append(flat_row)

    return flat


def _num_channels(image_type):
    if image_type == 'rgb':
        return 3
    elif image_type == 'rgba':
        return 4
    else:
        raise ValueError("invalid image type: should be 'rgba' or 'rgb'")


def _in_bounds(num_rows, num_cols, row, col):
    return 0 <= col < num_cols and 0 <= row < num_rows
