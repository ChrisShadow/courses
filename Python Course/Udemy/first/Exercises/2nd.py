# User Input and Errors
"""Create a infinite while loop that will loop until a valid integer is given.
When a valid integer is given, break the while loop and print the square of the integer.
Important: Do not have a prompt in your input statement."""
listData = []
while True:
    data = input("Enter a number: ")
    try:
        if data.isdigit() or (data.startswith('-') and data[1:].isdigit()):
            number = int(data)
            sqrt = number ** 2
            print("The square of ", number, "is ", sqrt)
            break
        else:
            listData.append(data)
            print(data, "is not a number, enter again")
    finally:
        pass

print("Caracteres ingresados: ", listData)
print("**Programa finalizado**")

#The bloody real one
"""
While True:
    data = input()
    try:
        if data.isdigit() or (data.startswith('-') and data[1:].isdigit()):
            number = int(data)
            sqrt = number ** 2
            print(sqrt)
            break
    finally:
        pass
"""




