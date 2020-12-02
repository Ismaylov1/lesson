package web.model;

public class Car {
    private String car;
    private String model;
    private String series;

    public Car() {

    }

    public Car(String car, String model, String series) {
        this.car = car;
        this.model = model;
        this.series = series;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car='" + car + '\'' +
                ", model='" + model + '\'' +
                ", series='" + series + '\'' +
                '}';
    }
}
