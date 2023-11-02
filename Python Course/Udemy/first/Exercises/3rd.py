#Functions
"""Implement a function that prints each fibonacci number. Only print the fibonacci numbers up
to the number given as input to the function. Important: Only create the function, do not call it.
Name the function fibonacci  and print each fibonacci number in a new line. Fibonacci Numbers:
Each number is the sum of the two preceding ones, starting from 0 and 1."""

#The real one
def fibonacciOne(number):
    a, b = 1, 1
    item=0
    print(f"Starting the first {number} fibonnaci numbers without a list")
    while a <= number:
        item+=1
        print(f"{item}){a:,}")
        a, b = b, a + b
    print(f"This is the end of the first {number} fibonnaci numbers without a list\n")

#more complex
def fiboncciComplex(number):
    list_f = [0,1]
    item=0
    print(f"Starting the first {number} fibonnaci numbers using a list")
    for i in range(2, number + 2):
        item+=1
        next_number = list_f[i - 1] + list_f[i - 2]
        list_f.append(next_number)
        print(f"{item}){next_number:,}")
    print(f"This is the end of the first {number} fibonnaci numbers using a list")

fibonacciOne(10)
fiboncciComplex(20)


