@Test
Feature: For this feature you have to have an existing account


Background:
Given User is on Retail website 
And User click  on MyAccount
When User click on Login 
And User enter username "saad@test.com" and password "test1234"
And User click on Login button
Then User should be logged in to MyAccount dashboard


Scenario Outline: Register as an Affiliate user with Cheque Payment Method
When User click on Register for an Affiliate Account link 
And User fill affiliate form with below information '<company>' '<website>' '<taxID>' '<paymentMethod>'
And User fill check detail
And User check on About us check box 
And User click on Continue button 
Then User should see a success message 

Examples:
|company|website|taxID|paymentMethod|
|Amazon|www.amazon.com|00022223333|check|

@smokeTest
Scenario Outline: Edit your affiliate information from Cheque payment method to Bank Transfer
When User click on Edit your affiliate informationlink 
And user click on Bank Transfer radio button
And User fill Bank information with below information '<bankName>' '<abaNumber>' '<swiftCode>' '<accountName>' '<accountNumber>'
And User click on Continue button for Edit
Then User should see a success message Continue 

Examples:
|bankName|abaNumber|swiftCode|accountName|accountNumber|
|BOFA|88886666|swiftCode|accountName|accountNumber|

@smokeTest
Scenario Outline: Edit your account Information 
When User click on Edit your account information link 
And User modify below information '<firstname>' '<lastName>' '<email>' '<telephone>'
And User click on continue button Edit Button
Then User should see a message Success: Your account has been successfully updated


Examples:
|firstname|lastName|email|telephone|
|saad|jabir|saad@test.com |1231456789|


