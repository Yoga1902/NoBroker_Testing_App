Feature: NoBroker Posting Property Flow
@rent
Scenario Outline: Navigation of Homepage to Posting the Property and verifying

When the owner clicks on Post Free Property Ad
Then the owner should be redirected to the property Page
And clicks the Post Now
Then the owner should be redirected to the Post your property page
And the owner select city "<PropertyCity>"
And the owner select property type
And the owner select property Ad Type
When the owner clicks on start posting Your Ad for FREE
Then the owner clicks Yes
Then the owner should be redirected to the Room details page
Then the owner Select the type of rooms available
When the owner clicks Save & Continue
Then the owner enters expected rent "<Rent>"
And the owner enters expected deposit "<Deposit>"
And the owner selects the amenities
And the owner clicks on Save & Continue
Then the owner should be redirected to the Locality Details page
And the owner enter Landmark "<Landmark>"
And the owner enter the Locality "<Locality>"
And the owner clicks on Save & Continue
Then the owner should be redirected to the PG Details page
And the owner fills the Pg Details
And the owner select the prefered guests "<Guest>"
And the owner enter the available date
And the owner clicks on Save & Continue
Then the owner should be redirected to the Amenities Details page
And the owner clicks on Save & Continue
And the owner clicks on Save & Continue
When the owner clicks on Finish posting
Then the owner should be redirected to the final page
When the owner clicks the preview property
Then the owner should be redirected to the posted property page



Examples:
| PropertyCity    | Rent  | Deposit | Landmark       | Locality |Guest                  | 
| Chennai         | 6500  | 3000    | Sholinganallur | OMR      |Working Professional   |
  
 




    