Feature: Apply Leave Orange HRM System

Background: 

Given Login to Orange HRM System

@SmokeTest
Scenario Outline: Apply Full Day Leave By Filling Mandatory Details

When click on Apply Leave then apply leave page will open

Then user will fill Valid "<LeaveTypes>" and "<Fromdate>" and "<Todate>"

And click on apply

Then It will add the Leave

Examples: 

| LeaveTypes              | Fromdate          | Todate            |
| Work From Home - US     | Mon, 24 Jan 2022  | Mon, 24 Jan 2022  |         
| Maternity Leave - US    | Wed, 12 Jan 2022  | Wed, 15 Jun 2022  |          
| Sick Leave - US         | Tue, 11 Jan 2022  | Fri, 21 Jan 2022  |     