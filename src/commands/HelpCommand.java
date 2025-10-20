package commands;

public class HelpCommand implements Command{
    @Override
    public CommandResult execute(String argument) {
        String helpMessage = """
                Справка по командам бота
                
                /start
                -запускает бота и показывает приветственное сообщение
                -использование: /start
                
                /calculate <число>
                -определяет является ли число четным или нечетным
                -определяет является ли число положительными или отрицательным 
                -использование: /calculate 3
                
                /help
                -выводит справку по командам
                -использование: /help
                
                /exit
                -завершает работу бота
                -использование: /exit
                
                Обработка ошибок:
                -бот коррректно обрабатывает ошибки (строка, десятичное число, пустой ввод,
                большие числа)
                -выводит корректные сообщения
                """;
        return new CommandResult(helpMessage);
    }
}
