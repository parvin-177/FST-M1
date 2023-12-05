# Using Pandas: Write the following data into an excel file:

# Import pandas
import pandas
from pandas import ExcelWriter

# Create a dictionary that will be used to create the DataFrame
data = {
    'FirstName':["Satish", "Arun", "Kishore"],
    'LastName':["Varma", "Kumar", "Javdhav"],
    'Email':["satishvarma@example.com", "arun_kumar@example.com", "kishore.jadhav@example.com"],
    'PhoneNumber':["678291580", "802184058", "6028727830"]
}

# Create the DataFrame that will be written to the excel file
dataframe = pandas.DataFrame(data)

# Print the dataframe
print(dataframe)

# Write the dataframe to a Excel file
writer = ExcelWriter('../resources/EmpDetails.xlsx')
dataframe.to_excel(writer, 'Sheet1', index = False)

# Commit data to the Excel file
writer._save()