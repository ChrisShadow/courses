# There are 3 types of way to manipulate a file: read, write, append
"""Append the content of the file data.txt to itself, on a new line. Important:
Make sure to not have any extra new lines. Hint: Open the file in read mode and store the content.
Open it again in append mode and write the content you stored on a new line."""

with open("data.txt", "r") as first_version:
    content = first_version.read()

with open("data.txt", "a") as second_version:
    second_version.write(content.rstrip())  #not required indeed
    second_version.write("\n")
    second_version.write(content)
