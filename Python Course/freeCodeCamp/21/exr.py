file = open("not.txt", encoding="utf-8")

for line in file:
    line = line.rstrip()
    parts=line.split()
    print("Palabra: ", parts)
    #Double check--> Guardian in a compound statement
    if len(parts)<3 or parts[0] != 'From' : 
        continue
    print(parts[2])
