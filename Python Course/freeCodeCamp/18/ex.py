fmb = open("t.txt",encoding="utf-8")
print(fmb)

for ls in fmb:
    lp=ls.rstrip() #to ignore each new line break
    print(lp.upper())