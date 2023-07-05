str = 'X-DSPAM-Confidence: 0.8475 '

whatPosi = str.find(':')
print("The position" , whatPosi)
piece=str[whatPosi+1:]
print (piece)
value = float(piece)
print("Value converted to float,",value+1)