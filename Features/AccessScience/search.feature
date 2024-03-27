Feature: To test the functionality of Search in Access Science

Background:  
           Given user lands on MHE Access Science homepage

Scenario Outline: Verification of Search
           
           Then user click on search input box
           Then user enter search term "<searchterm>"
           Then user click on search button
           Then verify search result title with search term "<searchterm>"

Examples: 
|searchterm|
|Global climate change |

