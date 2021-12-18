package org.issi.pages.MasterPage;

import org.issi.enums.WaitStrategy;
import org.issi.pages.BasePage;
import org.openqa.selenium.By;

public final class EvaluationCriteria extends BasePage {
    private EvaluationCriteria() {
    }

    private static final By evaluationcriteriaoption = By.xpath("//div[@id='collapsibleNavbar']/ul/li[3]/div/a[12]");
    public static void clickOnEvalutationCriteriaOption(){
        clickOn(evaluationcriteriaoption, WaitStrategy.CLICKABLE,"Evaluation Criteria Option");
        waitupto(500);
    }

    private static final By addevaluatincriterialink = By.xpath("//a[text()='Add Evaluation Criteria']");
    public static void clickOnAddEvaluationCriteriaLink(){
        clickOn(addevaluatincriterialink,WaitStrategy.CLICKABLE,"Add Evaluation cirteria Link");
        waitupto(500);
    }

    private static final By evalutationcriteriasubmtbtn = By.xpath("//input[@class='btn btn-success']");
    public static void clickOnEvaluationCriteriaSubBtn(){
        clickOn(evalutationcriteriasubmtbtn,WaitStrategy.CLICKABLE,"Evaluation criteria Submit button");
        waitupto(500);
    }


    private static final By evalutaioncriteriatext = By.xpath("//input[@name='evaluationcriteria']");
    public static void enterEvaluationCriteriaText(String depart){
        enterText(evalutaioncriteriatext,depart,WaitStrategy.PRESENCE,"Evalutaion Criteria");
        waitupto(500);
    }

    private static final By evalutaioncriteriasearchtext = By.xpath("//input[@id='id_evaluation_criteria']");
    public static void enterEvaluationCriteriaSearchInfo(String comp){
        enterText(evalutaioncriteriasearchtext,comp,WaitStrategy.PRESENCE,"Evaluation Criteria search information");
        waitupto(500);
    }
    public static void clearEvaluationCriteriaSearchText(){
        clearText(evalutaioncriteriasearchtext,WaitStrategy.PRESENCE,"Evaluation Criteria text");
        waitupto(500);
    }
    private static final By evaluationcriteriasearchresult = By.xpath("//table[@id='example']/tbody//td[3]");
    public static String evaluationCriteriaSearchResult(){
        return gettext(evaluationcriteriasearchresult,WaitStrategy.VISIBLE);
    }

}
