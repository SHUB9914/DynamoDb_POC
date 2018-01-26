import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Spec {

    private String engine;
    private String wheelbase;
    private String length;
    private String width;
    private String height;

    public String getEngine() { return engine; }
    public void setEngine(String engine) { this.engine = engine; }

    public String getWheelbase() { return wheelbase; }
    public void setWheelbase(String wheelbase) { this.wheelbase = wheelbase; }

    public String getLength() { return length; }
    public void setLength(String length) { this.length = length; }

    public String getWidth() { return width; }
    public void setWidth(String width) { this.width = width; }

    public String getHeight() { return height; }
    public void setHeight(String height) { this.height = height; }

}