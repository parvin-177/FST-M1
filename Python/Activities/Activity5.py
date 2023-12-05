# Activity5 Multiplication table of 1 to 100
intNum=int (input('Enter the number:\n'))
for i in range(1,intNum):
    print("\n\nMULTIPLICATION TABLE FOR %d\n" %(i))
    for j in range(1,11):
        print("%-2d X %2d = %2d" % (i, j, i*j))