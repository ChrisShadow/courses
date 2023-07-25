
shours= input("Enter an hour: ")
srate =input("Now the rate to calculate the pay: ")

try:
    fh=float(shours)
    fr=float(srate)
except:
    print("It must be only a number. Enter again")
    quit()


if fh >= 40:
    print("Time exceeded")
    #Get the pay
    reg=fr*fh
    #Calculate the bonus
    bon=(fh-40.0)*(fr*0.5)
    print("The regular pay is ",reg, " and the bonus reaches",bon)
    pay=reg+bon
else:
    print("Time is regular, okay")
    pay = fh*fr
print("So, the pay is ", pay)