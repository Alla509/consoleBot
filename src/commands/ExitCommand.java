package commands;

public class ExitCommand implements Command {

    @Override
    public CommandResult execute(String argument) {
        return new CommandResult("Завершение работы...", true);
    }
}
