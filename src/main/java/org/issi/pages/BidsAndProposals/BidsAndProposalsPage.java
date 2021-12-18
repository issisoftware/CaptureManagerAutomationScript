package org.issi.pages.BidsAndProposals;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class BidsAndProposalsPage extends BasePage {
    private BidsAndProposalsPage() {
    }

    private static final By bidsandproposalmenu = By.xpath("//a[contains(text(),'Bids and Proposals')]");
    public static void clickOnBidsAndProposalMenu(){
        clickOn(bidsandproposalmenu, WaitStrategy.CLICKABLE,"Bids And Proposals Menu");
        waitupto(500);
    }

    private static final By rfpandproposalsoptions = By.xpath("//a[text()='RFP and Proposals']");
    public static void clickOnRfpAndProposalOption(){
        clickOn(rfpandproposalsoptions,WaitStrategy.CLICKABLE,"Rfp And Proposals Options");
        waitupto(500);
    }
    public static String getRfpAndProposalText(){
        return gettext(rfpandproposalsoptions,WaitStrategy.CLICKABLE);
    }

    private static final By rfpheading = By.xpath("//h5[@class='cardtitle']");
    public static String getPageHeading(){
        return gettext(rfpheading,WaitStrategy.PRESENCE);
    }
    /**
     * Search functionality
     */
    private static final By solicitationid = By.xpath("//input[@id='id_solicitationid']");
    public static void enterSearchSolicitationId(String value){
        enterText(solicitationid,value,WaitStrategy.PRESENCE,"Solicitation Id");
        waitupto(500);
    }

    private static final By searchbtn = By.xpath("//button[text()='Search']");
    public static void clickOnRFPandPropSearchBtn(){
        clickOn(searchbtn,WaitStrategy.CLICKABLE,"Search Button");
        waitupto(500);
    }

    private static final By searchresult = By.xpath("//table[@id='example']/tbody/tr[1]/td[4]");
    public static String getRFPandProSearchResult(){
        return gettext(searchresult,WaitStrategy.PRESENCE);
    }

    private static final By serchediicon = By.xpath("//a[@title='Edit']");
    public static void clickOnRFPandProEditIcon(){
        clickOn(serchediicon,WaitStrategy.CLICKABLE,"Edit icon");
        waitupto(500);
    }


    /**
     * Add new Bid Functionality
     */

    private static final By addnewbidlink = By.xpath("//button[text()='Add New Bid']");
    public static void clickOnAddNewBidLink(){
        clickOn(addnewbidlink,WaitStrategy.CLICKABLE,"Add New Bid link");
    }

    private static final By pageheading = By.xpath("//h6[@class='cardtitle']");
    public static String pageHeadingForAddNewBid(){
        return gettext(pageheading,WaitStrategy.PRESENCE);
    }
}
