Feature: NoBroker Post Property Flow
@rent
Scenario Outline: Navigation of Homepage to Property Details Page

When the user clicks on Post Free Property Ad
Then the user should be redirected to the property Page
And clicks the Post Now
Then the user should be redirected to the Post your property page
And the user select city "<City>"
And the user select property type
And the user select property Ad Type
When the user clicks on start posting Your Ad for FREE
Then the user clicks Yes
Then the user should be redirected to the Room details page
Then the user Select the type of rooms available
When the user clicks Save & Continue
When the user should be redirected to the Locality Details



Examples:
| City |
| Chennai  |

  
 




    