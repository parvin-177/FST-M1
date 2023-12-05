# Given a two list of numbers create a new list such that new list should contain only odd numbers from the first list and even numbers from the second list.

# Given lists
intnumList1 = [10, 20, 23, 11, 17]
intnumList2 = [13, 43, 24, 36, 12]

# Print the lists
print("First List ", intnumList1)
print("Second List ", intnumList2)

# Declare a third list that will contain the result
intnumList3 = []

# Iterate through first list to get odd elements
for num in intnumList1:
    if (num % 2 != 0):
        intnumList3.append(num)

# Iterate through first list to get even elements
for num in intnumList2:
    if (num % 2 == 0):
        intnumList3.append(num)

# Print result
print("The Odd elements of List1 and Even elements of List2 combined in List3 are:")
print(intnumList3)