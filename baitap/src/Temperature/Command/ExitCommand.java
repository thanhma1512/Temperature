package Temperature.Command;

import javax.swing.JFrame;
import Temperature.TemperatureModel;

public class ExitCommand extends Command {
    private JFrame frame;

    public ExitCommand(TemperatureModel model, JFrame frame) {
        super(model);
        this.frame = frame;
    }

    @Override
    public void execute() {
        frame.dispose();
    }
}
