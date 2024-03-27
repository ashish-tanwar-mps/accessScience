Feature: To test the functionality of Biography Content page

Background:  
           Given user lands on MHE Access Science homepage

Scenario Outline: Verification of Text Biography content page with successful login

           Then user click on my account button
           Then user enters Username "<username>"
           Then enter Password "<password>"
           Then click on login button
                   
           Then user click on search input box
           Then user enter search term "<searchterm>"
           Then user click on search button
           Then verify search result title with search term "<searchterm>"
           Then user click on searched article "<searchterm>"
           Then verify article content title with search term "<searchterm>"
           
           Then verify Cite section "<searchterm>"
           
           Then verify Bookmark section "<searchterm>"
           Then verify remove bookmark section "<searchterm>"
           #Then verify Label dialogue box section
           #Then verify add label functionality with "<labelname>"
           #Then verify manage label functionality with "<labelname>"
           #Then click and verify annotate section "<annotatetitle>"
           #Then close annotate modal
           #Then user click and verify share button "<sharemodaltitle>"
           #Then user click and verify share modal link
           #Then user verify share link
         #
           #Then verify share social icon "<email>""<emailid>"
           #Then verify share social icon "<gmail>""<gmailid>"
           #Then close share modal
         
         

Examples: 
|username|password|searchterm|labelname|sharemodaltitle|annotatetitle|
|rashmi.verma@mpslimited.com|Mpst@1234|Tesla, Nikola (1856–1943)|testLabel|Share this content|Annotate with Hypothesis|
           