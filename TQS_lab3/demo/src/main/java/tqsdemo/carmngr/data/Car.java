package tqsdemo.carmngr.data;

import javax.persistence.*;



@Entity
@Table(name="tqs_car")
public class Car {
    static final int MAX_NAME_SIZE = 30;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String maker;
    private String model;


    public Car(){
    }

    public Car(String maker, String model){
        this.maker = maker;
        this.model = model;
    }

    public Car(String maker, String model, Long id){
        this.maker = maker;
        this.model=model;
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setId(long Id){
        this.id = Id;
    }

    public String getMaker(){
        return maker;
    }

    public void setMaker(String maker){
        this.maker=maker;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model=model;
    }

    
}
