package org.issi.utilities;

/**
 * Constructs a dynamic xpath at run time.
 */
public final class DynamicXpathUtils {
    /**
     * Private constructor to avoid external instantiation
     */
    private DynamicXpathUtils() {
    }

    /**
     * Receives a wildcard string, replace the wildcard with the value and return to the caller
     *
     * @param xpath Xpath with wildcard string
     * @param value value to be replaced in place of wildcard
     * @return dynamic xpath string
     *
     */
     public static String getXpath(String xpath,String value){
        return String.format(xpath,value);
     }

    /**
     * Receives a wildcard string, replace the wildcard with the value and return to the caller
     *
     * @param xpath Xpath with wildcard string
     * @param value1 value to be replaced in place of wildcard
     * @param value2 value to be replaced in place of wildcard
     * @return dynamic xpath string
     */
    public static String getXpath(String xpath, String value1, String value2) {
        return String.format(xpath, value1,value2);
    }

    // Example to under stand
    //
    // private static final String  HOUSEHOLDXPATH ="//label[contains(text(),'%s')]"; //%s discribes that can be any string will come to this place
    // public static void selectHouseHoldMemValue(String numOfHouseHolds){
    //     String newXpath = DynamicXpathUtils.getXpath(HOUSEHOLDXPATH,numOfHouseHolds);
    //    clickOn(By.xpath(newXpath), WaitStrategy.CLICKABLE,numOfHouseHolds);
    //    waitupto(500);
    // }
    //
}
