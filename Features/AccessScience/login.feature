Feature: To test the functionality of Login and Registration Page

Background:  
           Given user lands on MHE Access Science homepage

Scenario Outline: Verification of Login Functionality

#//////////////////////---Check login with valid credentials---/////////////////////////////////////

                   Then user click on my account button
                   Then user enters Username "<username>"
                   Then enter Password "<password>"
                   Then click on login button
                   Then verification of user info for successfull login verification by username "<text>"
                   Then user click on logout button
                   
#//////////////////////---Check login with invalid credentials---///////////////////////////////////// 
                  
                  Then user click on my account button
                  Then user enters Username "<invalidusername>" 
                  Then enter Password "<password>"
                  Then click on login button
                  Then validate error message display with invalid credentials "<errormessage>"
                  
#//////////////////////---Check the functionality of Forgot Password---////////////////////////////////

                  Then click forgot password link
                  Then enter email address to recovery of the password "<username>"
                  Then click on submit button on forgot password page
                  Then enter reset password code "<code>"
                  Then enter new password "<resetpassword>"
                  Then enter confirm password "<confirmpassword>"
                  Then click on submit button on forgot password page
                  Then click on return to the website link
                  
#//////////////////////---Check the functionality of User Registration---////////////////////////////////
                 
                 Then user click on my account button
                 Then user click on register link 
                 Then user enters full name "<fullname>"
                 #NOTE : User needs to enter a new email whenever the script is executed, otherwise script will throw error due to existing email 
                 Then user enters email address "<email>" 
                 Then user select date of birth
                 Then user select country
                 Then user enter password for registration"<password>"
                 Then user enter confirm password for registration"<confirmpassword>"
                 Then user clicks on registeration button
                 Then verify the text on verify your email page
                 Then click on return to the website link
                 
#//////////////////////---Check the functionality of Login via Library card---////////////////////////////

                 Then user click on my account button
                 Then user click on login via library card link
                 Then select you library "<library>"
                 Then enter library card number  "<cardnumber>"
                 Then user click on login button on login via library card page
                 Then verify branding logo text "<brandingtext>"
                 Then user click on my account button
                 Then user click on profile logout button
                 
#//////////////////////---Redeem a voucher functionality---////////////////////////////////////////////////

                 Then user click on my account button
                 Then user click on redeem voucher link
                 And verify the text message "<textmsg>"
                 Then user enters Username "<username>"
                 Then enter Password "<password>"
                 Then click on login button
                 Then enter voucher code "<vouchercode>"
                 Then user click on redeem voucher button
                 Then verify redeem voucher alert message "<textalertmsg>"
                 Then click on return to the website link
                 Then user click on my account drop down button
                 Then user click on logout button
                 
                 
#//////////////////////---Login via Institution---////////////////////////////////////////////////////////

                 #Then user click on my account button
                 #Then click on login via your institution link
                 #Then verify the text on SAMS SIGMA page "<pagetext>"
                 #Then select your organization "<organization>"
                 Then close the browser
                 
                 
  
Examples: 
|username|password|text|invalidusername|errormessage|code|resetpassword|confirmpassword|fullname|email|library|cardnumber|brandingtext|textmsg|vouchercode|textalertmsg|pagetext|organization|
|rashmi.verma@mpslimited.com|Mpst@1234|Hi Rashmi Verma|ashish.tanwar@mpslimited.com|We were unable to log you in, please try again. There was a problem with your email / username and password combination.|12345|Mpst@1234|Mpst@1234|Ashish Tanwar|ashishtanwarmps20@gmail.com|HighWire Press Library|HW-123-123-990|Access via|To redeem a voucher code, please log in or register first|SELV2WUSPNV|You have already redeemed this voucher code|SAMS Sigma Shibboleth Discovery Service|UK federation test IdP|                                                                                                                                                