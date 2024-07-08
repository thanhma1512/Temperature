package Temperature.Command;

public class CommandProcessor {
    private static CommandProcessor commandProcessor = null;

    private CommandProcessor() {}

    public static CommandProcessor makeCommandProcessor() {
        if (commandProcessor == null) {
            commandProcessor = new CommandProcessor();
        }
        return commandProcessor;
    }

    public void execute(Command command) {
        command.execute();
    }
}
