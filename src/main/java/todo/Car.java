package todo;

public class Car {

    private Engine engine;

    private Engine backupEngine;

    public Car(Engine engine, Engine backupEngine) {
        this.engine = engine;
        this.backupEngine = backupEngine;
    }

    public void wroom() {
        System.out.println(engine.wroom());
    }
}
