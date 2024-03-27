Feature: To test the functionality of Homepage functionality of Access Science

Background:  
           Given user lands on MHE Access Science homepage

Scenario Outline: Verification of Homepage
                  
           Then verify access science homepage with page title "<pagetitle>"
            
           Then verify text for content button "<contenttext>"
           Then verify the drop down menu in content section  
           Then verify the link in dropdown menu "<articlestext>""<articletextid>"
           Then verify the link in dropdown menu "<biographiestext>""<biographiestextid>"
           Then verify the link in dropdown menu "<bookstext>""<bookstextid>"
           Then verify the link in dropdown menu "<newstext>""<newstextid>"
           Then verify the link in dropdown menu "<videostext>""<videostextid>"
           
           Then verify text for topics button "<topicstext>" 
           
           Then verify text for information for button "<informationfortext>"
           Then verify the drop down menu in Information For section
           Then verify the link in dropdown menu "<educatorstext>""<educatorstextid>"
           Then verify the link in dropdown menu "<librarianstext>""<librarianstextid>"
           Then verify the link in dropdown menu "<studentstext>""<studentstextid>"
           
           Then verify text for my account button "<myaccounttext>"
           Then print the list of content in the container
         
           Then verify the footer links"<contenttype>""<articlestext>""<footerarticleid>"
           Then verify the footer links"<contenttype>""<biographiestext>""<footerbiographiesid>"
           Then verify the footer links"<contenttype>""<bookstext>""<footerbooksid>"
           Then verify the footer links"<contenttype>""<newstext>""<footernewsid>"
           Then verify the footer links"<contenttype>""<videostext>""<footervideosid>"
           
           Then verify the footer links"<informationfortype>""<educatorstext>""<footereducatorsid>"
           Then verify the footer links"<informationfortype>""<librarianstext>""<footerlibrariansid>"
           Then verify the footer links"<informationfortype>""<studentstext>""<footerstudentsid>"
             
           Then verify the footer links"<resources>""<abouttext>""<abouttextid>"
           Then verify the footer links"<resources>""<contacttext>""<contacttextid>"
           Then verify the footer links"<resources>""<helpfaqtext>""<helpfaqid>"
           Then verify the footer links"<resources>""<new&noteworthytext>""<new&noteworthyid>"
           Then verify the footer links"<resources>""<remoteaccesstext>""<remoteaccessid>"
           Then verify the footer links"<resources>""<subscribetext>""<subscribeid>"
           
           Then verify social media icons "<facebook>""<facebookid>"
           Then verify social media icons "<twitter>""<twitterid>"
           Then verify social media icons "<youtube>""<youtubeid>"
           
           Then verify the user IP Address "<ipaddress>"
           
           Then verify Privacy Notice Link with title "<privacytitle>"
           Then verify Terms of use Link with title "<termsofusetitle>"
           Then verify Additional Credits and copyrights Link with title "<copyrighttitle>"
           Then verify Accessibility Policy link with title "<accessibilitypolicytitle>"
                 
Examples:                  
|pagetitle|contenttext|topicstext|informationfortext|myaccounttext|articlestext|articletextid|footerarticleid|biographiestext|biographiestextid|footerbiographiesid|bookstext|bookstextid|footerbooksid|newstext|newstextid|footernewsid|videostext|videostextid|footervideosid|educatorstext|educatorstextid|footereducatorsid|librarianstext|librarianstextid|footerlibrariansid|studentstext|studentstextid|footerstudentsid|contenttype|informationfortype|resources|abouttext|abouttextid|contacttext|contacttextid|helpfaqtext|helpfaqid|new&noteworthytext|new&noteworthyid|remoteaccesstext|remoteaccessid|subscribetext|subscribeid|facebook|facebookid|twitter|twitterid|youtube|youtubeid|ipaddress|privacytitle|termsofusetitle|copyrighttitle|accessibilitypolicytitle|      
|McGraw Hill's AccessScience|Content|Topics|Information for|My account|Articles|448413|448424|Biographies|448414|448425|Books|448415|448426|News|448416|448427|Videos|448417|448428|Educators|448420|448429|Librarians|448421|448430|Students|448422|448431|content|informationfor|resources|About|448432|Contact|448433|Help/FAQ|448434|New & Noteworthy|448435|Remote Access|448436|Subscribe|448437|Follow McGraw Hill on Facebook|448438|Follow AccessScience on Twitter|448439|Follow McGraw Hill Professional on YouTube|448440|Your IP information is|Privacy Center|Terms of Use|Additional Credits and Copyrights|Accessible Learning|