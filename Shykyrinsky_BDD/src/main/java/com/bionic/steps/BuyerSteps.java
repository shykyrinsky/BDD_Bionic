package com.bionic.steps;

import com.bionic.model.ProductItem;
import com.bionic.pages.Allo.CartPage;
import com.bionic.pages.Allo.MainPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static com.bionic.model.SessionVariables.SELECTED_ITEMS;
import static org.assertj.core.api.Assertions.assertThat;

public class BuyerSteps extends ScenarioSteps {

    MainPage mainPage;
    CartPage cartPage;
    int selected;

    @Step
    public void searches_by_keyword(String keyword) {
        mainPage.open();
        mainPage.enterSearchTerms(keyword);
        mainPage.search();
    }

    @Step
    public void chooses_item_with_number(int number) {
        mainPage.chooseItemWith(number);
        selected = number-1;
        Serenity.setSessionVariable(SELECTED_ITEMS).to(mainPage.getProductItemFromSearchList(number));

    }

    @Step
    public void add_item_to_cart() {
        mainPage.clickBuyButtonOfItemWith(selected);
        mainPage.clickBackToItemsLink();
    }

    @Step
    public void open_cart() {
        cartPage.open();
    }

    @Step
    public void should_see_item_in_cart() {
        ProductItem item = (ProductItem) Serenity.sessionVariableCalled(SELECTED_ITEMS);
        assertThat(cartPage.isItemWithNameInCart(item.getName())).isTrue();
    }



}