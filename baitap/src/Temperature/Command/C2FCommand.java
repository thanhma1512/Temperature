package Temperature.Command;

import Temperature.TemperatureModel;

public class C2FCommand extends Command {
    private double celsius;

    public C2FCommand(TemperatureModel model, double celsius) {
        super(model);
        this.celsius = celsius;
    }

    @Override
    public void execute() {
        model.c2f(celsius);
    }
}
