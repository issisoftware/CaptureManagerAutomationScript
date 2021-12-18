package org.issi.constants;

/**
 * Making this class as final to avoid multiple inheritance (or) not to extend this class
 */
public final class FrameworkConstants {
    /**
     *  since we have all static method we can call the methods using class name,
     *  so it is not required to create an object of this class.
     *  to avoid creating object for this class we are creating a private constructor as shown below
     */
    private FrameworkConstants() {
    }

    private static final String TESTRESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources"; //System.getProperty("user.dir") indicates current working directory

    private static final String CONFIGFILEPATH = TESTRESOURCESPATH + "/config/FrameworkConfig.properties";
    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    private static final int EXPLICITWAIT = 10;
    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }

    private static final String LOGGERPATH = TESTRESOURCESPATH + "/config/log4j.properties";
    public static String getLoggerPath() {
        return LOGGERPATH;
    }

    private static final String LOGINPAGETITLE = "Capture Plan Management System";
    public static String getLoginPageTitle() {
        return LOGINPAGETITLE;
    }

    private static final String ERRORMESSAGE = "Invalid Credentials";
    public static String getErrormessage(){
        return ERRORMESSAGE;
    }

    private static final String EXCELFILEPATH = TESTRESOURCESPATH +"/Test_Data/Testdata.xlsx";
    public static String getExcelFilePath() {
        return EXCELFILEPATH;
    }

    private static final String CAPTUREPLANSHEET = "Capture Plan";
    public static String getCapturPlanSheetName(){
        return CAPTUREPLANSHEET;
    }

    private static final String REQUIREMENTSHEET = "Requirements Tab";
    public static String getRequirementSheetName(){
        return REQUIREMENTSHEET;
    }

    private static final int ROWNUMBER = 0 ;
    public static int getRowNumberFromSheet(){
        return ROWNUMBER;
    }

    private static final String FILEPATH = "/Users/rajasekhar/Downloads/Selenium.pdf";
    public static String getFilePath(){
        return FILEPATH;
    }
}
