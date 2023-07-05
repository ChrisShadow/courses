def payment( hours,rate):
    print("Data: ", hours , rate)
    if hours >= 40:
        print("Time exceeded")
        #Get the pay
        reg=rate*hours
        #Calculate the bonus
        bon=(hours-40.0)*(rate*0.5)
        print("The regular pay is ",reg, " and the bonus reaches",bon)
        xp=reg+bon
    else:
        print("Time is regular, okay")
        xp = hours*rate  
    print("Returning ", xp)
    return xp


shours= input("Enter an hour: ")
srate =input("Now the rate to calculate the pay: ")

try:
    fh=float(shours)
    fr=float(srate)
except:
    print("It must be only a number. Enter again")
    quit()

pay= payment(fh, fr)

print("So, the pay is ", pay)