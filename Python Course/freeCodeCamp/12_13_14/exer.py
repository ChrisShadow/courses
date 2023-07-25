tot=0
count=0
numbers=[]
while True:
    sval= input('Enter a number:')
    if sval == 'Done' or sval == 'done':
        break
    try:
        fval= int(sval)
        numbers.append(fval)
    except:
        print("It must be only a number. Enter again")
        continue
    count+=1
    if count > 3:
        print("You can stop entering with Done")
print("List of entered data: ",numbers)
for numb in numbers:
        tot=tot+numb
print("The sum is ", tot,"and ", count," numbers entered. The average results ", float(tot/count))
