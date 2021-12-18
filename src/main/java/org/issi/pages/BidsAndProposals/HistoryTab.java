package org.issi.pages.BidsAndProposals;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class HistoryTab extends BasePage {
    private HistoryTab() {
    }

    private static final By historytab = By.xpath("//a[@id='history-tab']");
    public static void clickOnHistoryTab(){
        clickOn(historytab, WaitStrategy.CLICKABLE,"History tab");
        waitupto(500);
    }

    private static final By viewlink = By.xpath("//a[text()='View']");
    public static void clickOnViewLink(){
        clickOn(viewlink,WaitStrategy.CLICKABLE,"View link");
        waitupto(500);
    }

    private static final By capturename = By.xpath("//table[@id='example']/tbody/tr/td[2]");
    public static String getCaptureNameText(){
        return gettext(capturename,WaitStrategy.PRESENCE);
    }
}
