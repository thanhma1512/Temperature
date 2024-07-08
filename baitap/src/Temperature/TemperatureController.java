package Temperature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Temperature.Command.C2FCommand;
import Temperature.Command.Command;
import Temperature.Command.CommandProcessor;
import Temperature.Command.ExitCommand;
import Temperature.Command.F2CCommand;

public class TemperatureController implements ActionListener {
    private CommandProcessor commandProcessor;
    private TemperatureModel model;
    private TemperatureView view;

    public TemperatureController(TemperatureView view, TemperatureModel model) {
        commandProcessor = CommandProcessor.makeCommandProcessor();
        this.model = model;
        this.view = view;
    }

   
    @Override
    public void actionPerformed(ActionEvent e) {
        double celsius = Double.parseDouble(view.getjTextCelsius().getText());
        double fahrenheit = Double.parseDouble(view.getjTextFahrenheit().getText());
        Command command = null;
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "C2F":
                command = new C2FCommand(model, celsius);
                commandProcessor.execute(command);
                break;
            case "F2C":
                command = new F2CCommand(model, fahrenheit);
                commandProcessor.execute(command);
                break;
            case "Exit":
                command = new ExitCommand(model, view);
                commandProcessor.execute(command);
                break;
        }
    }
}
