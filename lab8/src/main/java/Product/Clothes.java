package Product;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.persistence.*;
import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Caps.class, name = "Caps"),
        @JsonSubTypes.Type(value = T_shorts.class, name = "T_shorts"),
})
@Entity
@Table(name = "Clothes")
public abstract class Clothes implements ICrudAction {
    transient protected static int number;
    transient private static int count;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;

    @Column(name = "money")
    public String money;

    @Column(name = "name")
    public String name;

    @Column(name = "firma")
    public String firma;


    public UUID getId() {
        return id;
    }

    public String getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public String getFirma() {
        return firma;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

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
