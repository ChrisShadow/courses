def is_palindrome(phrase):
    # Remove spaces and convert to lowercase
    cleaned_phrase = phrase.replace(" ", "").lower()
    # Check if the phrase is the same forward and backward
    return cleaned_phrase == cleaned_phrase[::-1]

# Ask the user to input a phrase
phrase = input("Enter a phrase: ")

# Check if the phrase is a palindrome
if is_palindrome(phrase):
    print(f'"{phrase}" is a palindrome.')
else:
    print(f'"{phrase}" is not a palindrome.')
