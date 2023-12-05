#Activity7 sum of the items in elements
# creating an empty list
intList = []
# number of elements as input
intnumofElements = int(input("Enter number of elements : "))
sum = 0
# iterating till the range
for i in range(0, intnumofElements):
    intElements = int(input())
    # adding the element
    intList.append(intElements)
print('Elements in Lists are:',intList)
for number in intList:
    sum += int(number)
print('The sum of Elements in List are :', sum)

