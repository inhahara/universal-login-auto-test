Feature: Mailchimp Sign Up
Sign Up as User At https://login.mailchimp.com/signup/ 

Scenario Outline: Tests
Given I have entered "<emailLocalPart>" into the sign up page
Given I have also entered "<username>" into the sign up page
Given I have entered "<password>" into the sign up page too
Given I press Accept All Cookies
When I press Sign Up
Then The result of Sign Up should be "<result>"

Examples:
|emailLocalPart|username|password|result|
|inhahara|inhahara|Inhahara123!|Success|
|inhahara2|inhaharainhaharainhaharainhaharainhaharainhaharainhaharainhaharainhaharainhaharainhaharainhaharainhahara|Inhahara123!|Failure|
|inhahara3|haragote@gmail.com|Inhahara123!|Failure|
||inhahara4|Inhahara123!|Failure|