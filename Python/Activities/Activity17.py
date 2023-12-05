# Using Pandas: Writing CSV Files Activity 17 : Write the following data into a CSV file.

import pandas

# Create a Dictionary that will hold our data
data = {
    "Usernames": ["admin", "Charles", "Deku","user"],
    "Passwords": ["password", "Charl13", "AllMight","superuser"]
}

# Create a DataFrame using that data
dataframe = pandas.DataFrame(data)

# Print the DataFrame
print(dataframe)

"""
 Write the DataFrame to a CSV file
 To avoid writing the index numbers to the file as well
 the index property is set to false
"""
dataframe.to_csv("../resources/userDetails.csv", index=False)