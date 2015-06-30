//package module6.week1.steps;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import module6.week1.driverFactory.AndroidDriverCreator;
//import module6.week1.driverFactory.DriverCreator;
//import module6.week1.driverSingleton.AndroidDriverSingleton;
//import module6.week1.interfaces.CalcPageInterfaceDecorator;
//import module6.week1.pageObject.CalcPage;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//
///**
// * Created by Ihar_Chekan on 6/25/2015.
// */
//public class Steps {
//
//    private CalcPage calcPage;
//
//    // Use this init class if you want to get driver via driverFactory
//
////    public void init () throws Exception {
////        DriverCreator creator = new AndroidDriverCreator();
////        AppiumDriver driver = creator.factoryMethod();
////
////        calcPage = new CalcPage(driver);
////        PageFactory.initElements(new AppiumFieldDecorator(driver), calcPage);
////    }
//
//    // Use this init class if you want to get driver via Singleton
//    public void init () throws Exception {
//        AppiumDriver driver = AndroidDriverSingleton.getAndroidDriverInstance();
//
//        calcPage = new CalcPage(driver);
//        PageFactory.initElements(new AppiumFieldDecorator(driver), calcPage);
//    }
//
//
//    public void doMath () throws Exception{
//        calcPage.doSomething();
//    }
//
//    public void erase () throws Exception{
//    calcPage.clickBtnErase();
//    }
//
//    public void eraseDecorator () throws Exception{
//        CalcPageInterfaceDecorator calcPageInterfaceDecorator = new CalcPageInterfaceDecorator();
//        calcPageInterfaceDecorator.clickBtnErase();
//    }
//
//    public void doAssert (String result) {
//        Assert.assertEquals(calcPage.outputField.getText(), result);
//    }
//
//}
