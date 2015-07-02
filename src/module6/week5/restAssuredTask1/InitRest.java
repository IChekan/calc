package module6.week5.restAssuredTask1;

import com.jayway.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by Ihar_Chekan on 7/1/2015.
 */
public class InitRest {

    public static void initRestA() {
        RestAssured.baseURI = "http://www.thomas-bayer.com/";
    }

    public static String intGenerate() {
        return RandomStringUtils.randomNumeric(8);
    }


}
