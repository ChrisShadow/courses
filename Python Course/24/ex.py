
fname=''
while True:
    fname= input('Enter a valid file(Enter to finish): ')
    if fname=='': 
        print("**Finishing**") 
        break
    try:
        if len(fname) < 1 : fname='escrito.txt'
        file= open(fname)

        dic=dict()
        for lin in file:
            lin=lin.rstrip()
            #print(lin)
            wds=lin.split() 
            #print(wds)
            for w in wds:
                ''' oldcount=dic.get(w,0)
                print(w,"old",oldcount)
                newcount= oldcount+1
                dic[w]=newcount
                print(w,"new",newcount) '''
                #recupera,crea y actualiza el contador
                dic[w]=dic.get(w,0)+1
        #print(dic)
        #Now the most commond word
        largest=-1
        theword=None
        for key,value in dic.items():
            print(key,value)
            if value >largest:
                largest=value
                theword=key
        print("\nAomg of all, the most common is\n", "'",theword,"' with ",largest," iteretions")
        fname=''
        continue
    except:
        print(fname," it does not exist. Enter again")
        continue
        fname=''
