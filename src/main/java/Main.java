import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

import java.lang.reflect.Array;
import java.net.SocketPermission;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AmazonDynamoDBClient client = new AmazonDynamoDBClient().withEndpoint("http://localhost:8000") ;

        Car carObj = new Car() ;
        Spec specObj = new Spec();
        Spec specObj2 = new Spec();

        List<String> list = Arrays.asList("sup1", "sup2", "sup3");

        specObj.setEngine("setEngine");
        specObj.setWheelbase("setWheelbase");
        specObj.setLength("setLength");
        specObj.setWidth("setWidth");
        specObj.setHeight("setHeight");


        specObj2.setEngine("setEngine2");
        specObj2.setWheelbase("setWheelbase2");
        specObj2.setLength("setLength2");
        specObj2.setWidth("setWidth2");
        specObj2.setHeight("setHeight2");


        List<Spec> listSpec = Arrays.asList(specObj , specObj2);



        carObj.setName("karan");
        carObj.setYear(2012);
        carObj.setMake("mymake");
        carObj.setColors(list);
        carObj.setSpec(listSpec);

        DynamoDBMapper mapper = new DynamoDBMapper(client);
        System.out.println("====key===="+carObj.getId());

        mapper.save(carObj);

        System.out.println("====key===="+carObj.getId());


       Car res =  mapper.load(Car.class , "rahul");

       System.out.println("====res===="+res);
       System.out.println("====res===="+res.getName());
       System.out.println("====res===="+res.getYear());
       System.out.println("====res===="+res.getMake());
        List<Spec> specRes = res.getSpec();
        for (Spec item : specRes) {
            System.out.println("====getEngine===="+item.getEngine());
            System.out.println("====getWheelbase===="+item.getWheelbase());
            System.out.println("====getHeight===="+item.getHeight());
            System.out.println("====getLength===="+item.getLength());
            System.out.println("====getWidth===="+item.getWidth());
            System.out.println(">>>>>>>>>>>>>>>>>>>>.");
        }


    }
}
