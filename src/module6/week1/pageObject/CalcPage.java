//package module6.week1.pageObject;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.pagefactory.AndroidFindBy;
//
//
///**
// * Created by Ihar_Chekan on 6/24/2015.
// */
//public class CalcPage extends AbstractPage{
//
//
//    @AndroidFindBy(id = "module6.calc.mobile:id/btn1")
//    public MobileElement btn1;
//    @AndroidFindBy(id = "module6.calc.mobile:id/btn2")
//    public MobileElement btn2;
//    @AndroidFindBy(id = "module6.calc.mobile:id/btnPlus")
//    public MobileElement btnPlus;
//    @AndroidFindBy(id = "module6.calc.mobile:id/btnEquals")
//    public MobileElement btnEquals;
//    @AndroidFindBy(id = "module6.calc.mobile:id/btnErase")
//    public MobileElement btnErase;
//    @AndroidFindBy(id = "module6.calc.mobile:id/outputField")
//    public MobileElement outputField;
//
//
//
//    public CalcPage (AppiumDriver driver) throws Exception{
//        super(driver);
//
//    }
//
//    public void doSomething () {
//
//        btn1.click();
//        btn2.click();
//        btnPlus.click();
//        btn2.click();
//        btnEquals.click();
//
//    }
//
//    public void clickBtnErase (){
//        btnErase.click();
//    }
//
//}
