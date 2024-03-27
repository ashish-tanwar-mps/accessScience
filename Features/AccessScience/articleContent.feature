Feature: To test the functionality of Artcile Content page

Background:  
           Given user lands on MHE Access Science homepage

Scenario Outline: Verification of Article content page with successful login

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
           Then verify author "<authorname1>"
           Then verify the last review date with text "<lastreview>"
           Then verify article DOI link "<doilink>"
           Then verify show previous version link
           
           Then verify Cite section "<searchterm>"
           Then verify Bookmark section "<searchterm>"
           Then verify remove bookmark section "<searchterm>"
           Then verify Label dialogue box section
           Then verify add label functionality with "<labelname>"
           Then verify manage label functionality with "<labelname>"
           Then click and verify annotate section "<annotatetitle>"
           Then close annotate modal
           Then user click and verify share button "<sharemodaltitle>"
           Then user click and verify share modal link
           Then user verify share link
         
           Then verify share social icon "<email>""<emailid>"
           #Then verify share social icon "<gmail>""<gmailid>"
           Then close share modal
           
           Then user click and verify downlaod PDF functionality with "<pdftitle>"
           Then verify readspeaker button
           
           Then verify focus view functionality "<searchterm>"
           Then click and verify table of content
           Then click and verify table of content element
           Then click and verify open in new tab link
           Then click and verify share element in content
           
           Then verify related articles "<keyra1>""<keyra2>""<keyra3>""<keyra4>""<keyra5>"
           Then verify related news "<keyrn1>""<keyrn2>""<keyrn3>""<keyrn4>""<keyrn5>"
           Then verify related videos "<keyrv1>""<keyrv2>""<keyrv3>""<keyrv4>""<keyrv5>"
           Then verify related book chapters "<keyrbc1>""<keyrbc2>""<keyrbc3>""<keyrbc4>""<keyrbc5>"
           Then verify content in Topic section "<keyt1>""<keyt2>""<keyt3>""<keyt4>"
           #################### Use only two keywords for Global Climate Change Article while verifying Topic Section #############
           
           Then verify figures and tables label
           Then verify primary literature label
           Then verify self test section
           
           
Examples: 
|searchterm|authorname1|lastreview|doilink|username|password|labelname|sharemodaltitle|annotatetitle|pdftitle|keyra1|keyra2|keyra3|keyra4|keyra5|email|emailid|gmail|gmailid|keyrn1|keyrn2|keyrn3|keyrn4|keyrn5|keyrv1|keyrv2|keyrv3|keyrv4|keyrv5|keyrbc1|keyrbc2|keyrbc3|keyrbc4|keyrbc5|keyt1|keyt2|keyt3|keyt4|
#|Global climate change|Rachel Licker|Last reviewed:|https://doi.org/10.1036/1097-8542.757541|rashmi.verma@mpslimited.com|Mpst@1234|testLabel|Share this content|Annotate with Hypothesis|McGraw Hill's AccessScience - global-climate-change.pdf|Sea-level rise|Hydrological consequences of global warming |Climatology|Greenhouse effect|Climate modeling|email|448572|gmail|448573|Peatland carbon storage affects global climate|Human-driven climate change sent Pacific Northwest temperatures soaring|Wildlife diseases rise as a result of climate change|The last 12 months were the hottest on record|The Arctic is warming even faster than scientists realized|Innovative Ways to Fight Climate Change|Burning Ice from the Ocean Floor|Cow Burps Are Warming the Planet|How is Climate Change Affecting Hibernation?|Should We Desalinate Ocean Water to Get Drinking Water?|Emerging and Reemerging Infectious Diseases: Emergence and Global Spread of Infection|Circadian Rhythms & Sleep|Risk Assessment|The Title|Toxic Effects of Calories|Earth Science|Meteorology & climatology|                                    
|Human biological variation|Barry Allan Bogin|Last reviewed:|https://doi.org/10.1036/1097-8542.757576|rashmi.verma@mpslimited.com|Mpst@1234|testLabel|Share this content|Annotate with Hypothesis|McGraw Hill's AccessScience - human-biological-variation.pdf|Homo erectus|Bioarcheology|Salmon|Mitochondrial DNA|Environment|email|448572|gmail|448573|Lucy’s species heralded the rise of long childhoods in hominids|DNA reveals ancient Siberians who set the stage for the first Americans|Connection between Neandertal DNA and COVID-19|Komodo dragon genome provides clues to evolution and physiology|We’ve lost 3 billion birds since 1970 in North America|Telomerase Function|Processing of Gene Information: Prokaryotes vs. Eukaryotes|The Biochemistry of Redheads|Exon Shuffling|Transcription (mRNA Synthesis)|Air Pollution|Linear Equations in One Variable|Radicals|Fundamental Operations with Numbers|Thyroid & Antithyroid Drugs|Anthropology & Archeology|Anthropology|Biology|Genetics|                                                                        
