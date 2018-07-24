package Product;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Caps.class, name = "Caps"),
        @JsonSubTypes.Type(value = T_shorts.class, name = "T_shorts"),
})
public abstract class Clothes implements ICrudAction {
    transient protected static int number;
    transient private static int count;

    public UUID id;
    public String money;
    public String name;
    public String firma;

    /*
    Clothes(UUID id) {
        this.id = id;
    }
    */
    Clothes(){
        id = UUID.randomUUID();
    }

    @Override
    public void create(){
        count++;
        //System.out.println("Счетчик товаров:\t" + count);
    }

    @Override
    public void delete(){
        count--;
        //System.out.println("Счетчик товаров:\t" + count);
    }

    @Override
    public void read() {
        number++;
    }

    @Override
    public void update() {
    }

    @Override
    public void readBasket(){

    }

}
