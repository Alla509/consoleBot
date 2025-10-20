package commands;

public class StartCommand implements Command{

    @Override
    public CommandResult execute(String argument) {
        String welcomeMessage = """
                Привет. Я бот, который выясняет является ли число четным или нечетным.
                
                Команды:
                /start - начать работу
                /calculate <число> - проверка четности
                /help - справка по командам
                /exit - выход из бота
                """;
        return new CommandResult(welcomeMessage);
    }
}
