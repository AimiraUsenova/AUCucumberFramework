Feature:adding below data to youe excel file in Sheet3
  @project
  Scenario:A
    Given Go to Database and get First name and Last name of employees who works in Europe and validate with their UI information (First name, Last Name).
    And go to Excel and update column ‘Actual # of Employees’ with number of Europe employees that you get from UI
    Then Compare ‘Actual # of Employees’ with ‘expected # of Employees’ and if they matched then update ‘Test Execution Status’ cell as PASSEDif not match then update with FAILED.

     @project2
    Scenario: B
      Given Go to Database and get Department Name and number of ‘Active’employees and validate with their UI numbers
      And  go to Excel and update column ‘Actual # of Employees’ with number of Activeemployees that you get from UI and compare that number with ‘expected # of Employees’ and if they matched then update ‘Test Execution Status’ cell as PASSEDif not match then update with Failed