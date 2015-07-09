package com.bionic.pages.Allo;

import com.bionic.model.ProductItem;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Illya
 */
@DefaultUrl("http://allo.ua")
public class MainPage extends PageObject {

    @FindBy(id = "search")
    private WebElement searchInput;

    @FindBy(id = "search_mini_form")
    private WebElement searchMiniForm;

    @FindBy(xpath = "//ul[@class='products-grid']/li[@class='item']")
    private List<WebElement> searchResultList;

    @FindBy(id = "controls credit")
    private WebElement checkoutBtn;

    @FindBy(id = "cartResponseClose")
    private WebElement backToItemsLink;

    @FindBy(id = "topCartTitle")
    private WebElement cartTopLink;

    public void enterSearchTerms(String keywords) {
        searchInput.clear();
        searchInput.sendKeys(keywords);
    }

    public void search() {
        searchMiniForm.submit();
    }

    public void clickBuyButtonOfItemWith(int number)
    {
        searchResultList.get(number).findElement(By.xpath(".//button[contains(@name,'buy')]")).click();
    }

    public void clickCheckoutBtn() {
        checkoutBtn.click();
    }

    public void clickBackToItemsLink() {
        backToItemsLink.click();
    }

    public void clickCartTopLink() {
        cartTopLink.click();
    }

    public void chooseItemWith(int number) {
        withAction().moveToElement(searchResultList.get(number-1));
    }

    public String getNameOfSearchItem(int number) {
        return searchResultList.get(number).findElement(By.xpath(".//a[@class='product-name']"))
                                           .getAttribute("title");
    }

    public ProductItem getProductItemFromSearchList(int number) {
        WebElement item = searchResultList.get(number-1); //cause List begins with index=0;
        String name = item.findElement(By.xpath(".//a[@class='product-name']")).getAttribute("title");
        String price = (item.findElement(By.xpath(".//span[@class='sum']")).getText()).replaceAll(" ","");
        return new ProductItem(name, Double.parseDouble(price));
    }
}
