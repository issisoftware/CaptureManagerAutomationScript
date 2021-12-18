package org.issi.pages.BidsAndProposals;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class CommentsPage extends BasePage {
    private CommentsPage() {
    }

    private static final By commentstab = By.xpath("//a[@id='comments-tab']");
    public static void clickOnCommentsTab(){
        clickOn(commentstab, WaitStrategy.CLICKABLE,"Comments Tab");
        waitupto(500);
    }

    private static final By commentstext = By.xpath("//textarea[@name='bidcomment-0-comments']");
    public static void enterCommentsInText(){
        enterText(commentstext,"Comment one",WaitStrategy.PRESENCE,"Comments");
        waitupto(500);
    }

    private static final By savebtn = By.xpath("//form[@id='commentsform']/div[2]/div/button[2]");
    public static void clickOnCommentsSaveBtn(){
        clickOn(savebtn,WaitStrategy.CLICKABLE,"Save button");
        waitupto(500);
    }


}
