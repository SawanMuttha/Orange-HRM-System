Feature: Login in Orange HRM System

Background: 

Given Open the Login Page of Orange HRM

@SmokeTest
Scenario: Login in Orange HRM With Valid Credentials

When Enter Valid UserName and Password

And Click on Login Button

Then It Will Display the DashBoard of Orange HRM System

@ValidationTesting
Scenario: Verify the Username Validation by Clicking on Login Button Directly

When User Click on Login Button

Then UserName Field will Show the Validation Message

@ValidationTesting
Scenario: Verify the Password Validation by Clicking on Login Button Directly

When User Click on Login Button

Then Password Field will Show the Validation Message

@SocialMediaIconTesting
Scenario: Verify the LinkedIn of OrangeHRM by Clicking on LinkedIn

When User Click on LinkedIn Icon

Then OrangeHRM LinkedIn Page Will be Open

@SocialMediaIconTesting
Scenario: Verify the Facebook of OrangeHRM by Clicking on Facebook

When User Click on Facebook Icon

Then OrangeHRM Facebook Page Will be Open

@SocialMediaIconTesting
Scenario: Verify the Twitter of OrangeHRM by Clicking on Twitter

When User Click on Twitter Icon

Then OrangeHRM Twitter Page Will be Open

@SocialMediaIconTesting
Scenario: Verify the Youtube of OrangeHRM by Clicking on Twitter

When User Click on Youtube Icon

Then OrangeHRM Youtube Page Will be Open

