#Conditions and Loops

"""Implement a for loop that will iterate over the given names list and print out each name until it
reaches the name John. You should also not print any names starting with the letter M. Hint: To get a
specific character of a string you can use the same operator as we used in a list. Ex: name[0] gets the
first letter of the name string."""

names = ["Adam", "Maria", "Kevin", "Madison", "John", "Bailey"]
for value in names:
    if value[0] == "M":
        continue
    if value == "John":
        break
    print(value)
