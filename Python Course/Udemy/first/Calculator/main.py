

print("Multiplication table on function of the entered number")
listN = []
while True:
    sentinel=input("\nEnter any number from the set of integers, Enter to exit: ")
    if sentinel=='':
        print("Finishing")
        break
    try:
        number=int(sentinel)
        listN.append(number)
        print(f"Number entered correctly: ",{number},". Its multiple are: ")
        if number > 0:

            for i in range(1,number+1):
                    acc=listN[-1]*i #accumulator
                    print(acc," ,")
            print("\n")
        elif number < 0:
            for i in range(1,abs(number)+1):
                    acc = listN[-1] * i  # accumulator
                    print(acc," ,")
            print("\n")
        else:
            print(" 0")
        continue
    except ValueError:
        print("It must be only number. Enter again")
        continue
