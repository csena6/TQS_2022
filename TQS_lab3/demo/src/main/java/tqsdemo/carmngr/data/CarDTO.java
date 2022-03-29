package tqsdemo.carmngr.data;

public class CarDTO {
    

    private Long id;
    private String maker;
    private String model;

    public static CarDTO fromCarEntity(Car car){
        return new CarDTO(car.getMaker(),car.getModel(),car.getId());
    }

    public Car toCarEntity () {
        return new Car(getMaker(),getModel(),getId());
    }

    public CarDTO(){
    }
    public CarDTO(String maker, String model, long id){
        this.id = id;
        this.maker = maker;
        this.model = model;
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
