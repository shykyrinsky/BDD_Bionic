Narrative:
In order to make the most appropriate purchase decisions
As a buyer
I want to be able to place items which want to buy in a virtual cart before placing my order

Scenario: Add item to cart
Given I have searched for 'Imac'
And I have selected item 1 from search result list
When I add it to the cart
Then the item should appeared in the cart
