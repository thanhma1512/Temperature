package Temperature.Command;

import Temperature.TemperatureModel;

public class F2CCommand extends Command {
    private double fahrenheit;

    public F2CCommand(TemperatureModel model, double fahrenheit) {
        super(model);
        this.fahrenheit = fahrenheit;
    }

    @Override
    public void execute() {
        model.f2c(fahrenheit);
    }
}
