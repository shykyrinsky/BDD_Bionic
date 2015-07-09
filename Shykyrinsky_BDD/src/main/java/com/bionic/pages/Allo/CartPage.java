package com.bionic.pages.Allo;

import com.bionic.model.ProductItem;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Illya on 06.07.2015.
 */
@At(urls={"#HOST/checkout/cart"})
@DefaultUrl("http://allo.ua/checkout/cart")
public class CartPage extends PageObject {

    private List<ProductItem> itemsList = new ArrayList<ProductItem>();

    @FindBy(xpath = "//*[@id='cartListTable']//tr[count(td)>4]")
    List<WebElement> allItemsInCartList;


    public boolean isItemWithNameInCart(String name) {
        if (!itemsList.isEmpty()) {
            for(ProductItem item: itemsList) {
               if(item.getName().equalsIgnoreCase(name))
                   return true;
            }
        } return false;
    }

    @WhenPageOpens
    private void fillItemsList() {
        for(WebElement item: allItemsInCartList) {
            String name = item.findElement(By.xpath("./td[@class='cart_product_name']//a")).getText();
            String price = item.findElement(By.xpath(".//*[@class='sum']")).getText().replaceAll(" ","");
            itemsList.add(new ProductItem(name, Double.parseDouble(price)));
        }
    }
}
