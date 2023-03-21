package pages;

import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends CommonActionsWithElements{
    protected String base_url;

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    abstract String getRelativeURL();


}
