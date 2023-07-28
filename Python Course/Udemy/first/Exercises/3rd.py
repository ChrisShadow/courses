#Functions
"""Implement a function that prints each fibonacci number. Only print the fibonacci numbers up
to the number given as input to the function. Important: Only create the function, do not call it.
Name the function fibonacci  and print each fibonacci number in a new line. Fibonacci Numbers:
Each number is the sum of the two preceding ones, starting from 0 and 1."""

#The real one
def fibonacci(number):
    a, b = 0, 1
    while a <= number:
        print(a)
        a, b = b, a + b


#more complex
"""def fiboncci(number):
    list_f = [0,1]
    for i in range(2, number + 1):
        next_number = list_f[i - 1] + list_f[i - 2]
        list_f.append(next_number)
        print(next_number)"""
