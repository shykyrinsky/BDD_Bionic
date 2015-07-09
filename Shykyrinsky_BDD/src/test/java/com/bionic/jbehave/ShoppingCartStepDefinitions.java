package com.bionic.jbehave;

import com.bionic.steps.BuyerSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
/**
 * Created by Illya on 06.07.2015.
 */
public class ShoppingCartStepDefinitions {

    @Steps
    BuyerSteps buyer;

    @Given("I have searched for '$product'")
    public void givenIHaveSearchedFor(String product) {
       buyer.searches_by_keyword(product);
    }

    @Given("I have selected item $number from search result list")
    public void givenIHaveSelectedItemFromSearchResultList(int number) {
        buyer.chooses_item_with_number(number);
    }

    @When("I add it to the cart")
    public void whenIAddItToTheCart() {
        buyer.add_item_to_cart();
    }

    @Then("the item should appeared in the cart")
    public void thenTheItemShouldAppearedInTheCart() {
        buyer.open_cart();
        buyer.should_see_item_in_cart();
    }
}
