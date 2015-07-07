//package module6.week5.restAssuredTask1;
//
//import com.jayway.restassured.RestAssured;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static com.jayway.restassured.RestAssured.expect;
//import static org.hamcrest.Matchers.equalTo;
//
///**
// * Created by Ihar_Chekan on 7/1/2015.
// */
//public class RestTestTask1 {
//
//    String productID;
//
//    @BeforeClass
//    public void init() {
//        InitRest.initRestA();
//        productID = InitRest.intGenerate();
//    }
//
//    @Test
//    public void createNewProduct () {
//        System.out.println("!!!generated productID = " + productID);
//
//        expect(). statusCode(201).
//        given(). body("<resource><ID>" + productID + "</ID><NAME>name</NAME><PRICE>23.3</PRICE></resource>").
//        when(). post("sqlrest/PRODUCT/");
//
//        RestAssured.get("sqlrest/PRODUCT/" + productID + "/").then().assertThat().body("PRODUCT.ID", equalTo(productID));
//    }
//
//    @Test
//    public void deleteProduct () {
//        expect(). statusCode(200).
//        when(). delete("sqlrest/PRODUCT/" + productID + "/");
//
//        expect(). statusCode(404).
//        when(). get("sqlrest/PRODUCT/" + productID + "/");
//    }
//}
