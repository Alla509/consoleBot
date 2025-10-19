import java.util.Scanner;
import commands.*;
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandHandler commandHandler = new CommandHandler();

        System.out.println("Бот для проверки четности чисел");
        System.out.println("Введите команду (для справки введите /help):");

        boolean isRunning = true;

        while (isRunning) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split(" ", 2);
            String commandName = parts[0];
            String argument = parts.length > 1 ? parts[1] : "";

            CommandResult result = commandHandler.executeCommand(commandName, argument);

            if (result.shouldExit()) {
                isRunning = false;
            }

            if (!result.getMessage().isEmpty()) {
                System.out.println(result.getMessage());
            }
        }

        scanner.close();
        System.out.println("До свидания!");
    }
}

class CommandHandler {
    private final Command startCommand;
    private final Command calculateCommand;
    private final Command helpCommand;
    private final Command exitCommand;

    public CommandHandler() {
        this.startCommand = new StartCommand();
        this.calculateCommand = new CalculateCommand();
        this.helpCommand = new HelpCommand();
        this.exitCommand = new ExitCommand();
    }

    public CommandResult executeCommand(String commandName, String argument) {
        return switch (commandName.toLowerCase()) {
            case "/start" -> startCommand.execute(argument);
            case "/calculate" -> calculateCommand.execute(argument);
            case "/help" -> helpCommand.execute(argument);
            case "/exit" -> exitCommand.execute(argument);
            default -> new CommandResult("Неизвестная команда. Введите /help для списка команд.");
        };
    }
}