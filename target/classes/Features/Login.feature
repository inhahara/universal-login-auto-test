Feature: Universal Login Automative Tests


Scenario: Login to Filmstaden
Given I go to the "https://www.filmstaden.se/" login page
When I have accepted cookies by click "//button[@id='onetrust-accept-btn-handler']"
    And I have choose location by click "//span[contains(@class,'dialog-city-selection__save-btn-wrapper')]//button"
    And I have clicked "//a[contains(@class,'main-navigation__user-login-url')]"
    And I have clicked "//div[@class='anonymous-become-member__signup-wrapper']//a[@ref='urlElement'][1]"
    And I have input username "<USERNAME>" to field "//input[@id='signInName']" 
    And I have input password "<PASSWORD>" to field "//input[@id='password']"
    And I have login by click "//button[@id='next']"
Then I see my account element "//span[contains(@class,'material-icon') and contains(@class,'material-person')]"
 
Scenario: Login to Migration Sverket
Given I go to the "https://www.migrationsverket.se/" login page
When I have accepted cookies by click "//div[contains(@class,'cookie-and-error')]//button[contains(@class,'env-alert__close')]"
    And I have clicked "//i[contains(@class,'fal') and contains(@class,'fa-user')]"
    And I have accepted terms and conditions by check "//label[contains(@id,'acceptTerms_controll')]/span[1]"
    And I have clicked "//form[contains(@id,'login-form')]//input[@type='submit']" 
    And I have clicked "//div[contains(@class,'panel-group')][2]//a[@href='#']"
    And I have input username "<USERNAME>" to field "//input[@id='username']"
    And I have input password "<PASSWORD>" to field "//input[@id='password']"
    And I have login by click "//button[@name='_eventId_proceed']"
Then I see logout element "//i[contains(@class,'fal') and contains(@class,'fa-sign-out')]"
    
Scenario: Login to Facebook
Given I go to the "https://www.facebook.com/" login page
When I have accepted cookies by click "//button[@data-cookiebanner='accept_button']"
    And I have input username "<USERNAME>" to field "//input[@id='email']" 
    And I have input password "<PASSWORD>" to field "//input[@id='pass']"
    And I have login by click "//button[@name='login']"
    And I have clicked cancel on alert
Then The page "https://www.facebook.com/" is opened

Scenario: Login to Instagram
Given I go to the "https://www.instagram.com/" login page
When I have accepted cookies by click "//div[@role='dialog']//button[1]"
    And I have input username "<USERNAME>" to field "//input[@name='username']"
    And I have input password "<PASSWORD>" to field "//input[@name='password']"
    And I have login by click "//button[@type='submit']"
Then I see my account element "//a[@href='/']//svg[@aria-label='Home']"

Scenario: Login to Gmail
Given I go to the "https://www.gmail.com" login page
When I go to the "https://www.gmail.com" login page
    And I have accepted cookies by click "//a[contains(@class,'cookieBarButton') and contains(@class,'cookieBarConsentButton')]"
    And I have clicked "//a[@data-action='sign in']"
    And I have input username "<USERNAME>" to field "//input[@id='identifierId']" 
    And I have clicked "//button[@type='button']"
    And I have input password "<PASSWORD>" to field "//input[@name='password']" 
    And I have login by click "//button[@type='button']"
Then The opened page starts by "https://mail.google.com/mail/u/"
    