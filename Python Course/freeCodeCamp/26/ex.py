fname=''
while True:
    fname= input('Enter a valid file(Enter to finish): ')
    if fname=='': 
        print("**Finishing**") 
        break
    try:
        if len(fname) < 1 : fname='pass.txt'
        file= open(fname)

        dic=dict()
        for lin in file:
            lin=lin.rstrip()
            wds=lin.split() 
            for w in wds:
                #recupera,crea y actualiza el contador
                dic[w]=dic.get(w,0)+1
        #print("The Dictionary is: \n",dic)

        ''' s=sorted(dic.items())
        print("But now in order is: \n", s[:5]) '''

        nwt= list()
        #print("\nNow on a list: \n")
        for k,v in dic.items():
            #print(k,v)
            new=(v,k)
            nwt.append(new)
        #print("\nFlipped: \n", nwt)

        nwt= sorted(nwt, reverse=True)
        #print("\nSorted: \n", nwt[:5])

        #Nicer
        print("\nSorted\n")
        for v,k in nwt[:5]:
            print(k,v)

        fname=''
        continue
    except:
        print(fname," it does not exist. Enter again")
        continue