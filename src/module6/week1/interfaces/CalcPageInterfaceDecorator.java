package module6.week1.interfaces;

import io.appium.java_client.AppiumDriver;
import module6.week1.pageObject.CalcPage;

/**
 * Created by Ihar_Chekan on 6/26/2015.
 */
public class CalcPageInterfaceDecorator implements CalcPageInterface {

    protected AppiumDriver driver;

    @Override
    public CalcPage clickBtnErase (){
        return null;
    }
}
