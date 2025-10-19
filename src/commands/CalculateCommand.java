package commands;

public class CalculateCommand implements Command{
    @Override
    public CommandResult execute(String argument) {
        if (argument.isEmpty()) {
            return new CommandResult("Ошибка: Не указано число для проверки.\nИспользование: /calculate <число>");
        }

        try {
            int number = Integer.parseInt(argument.trim());
            return checkEvenOdd(number);
        } catch (NumberFormatException e) {
            return handleErrors(argument);
        }
    }
    private CommandResult checkEvenOdd(int number){
        String equality = (number % 2 == 0)?"четное":"нечетное";
        String sign = (number >= 0)?"положительное":"отрицательное";
        String resultMessage = String.format(
                "Число: %d\n" + "Свойство1: %s\n" + "Свойство2: %s\n", number, equality, sign
        );
        return new CommandResult(resultMessage);
    }
    private CommandResult handleErrors(String input){
        input = input.trim();
        if (input.contains(".") || input.contains(",")) {
            return new CommandResult("Введено десятичное число. Пожалуйста, введите целое число");
        }

        if (input.matches(".*[a-zA-Zа-яА-Я].*")) {
            return new CommandResult("Введена строка. Пожалуйста, введите целое число.");
        }

        try {
            long largeNumber = Long.parseLong(input);
            return new CommandResult("Число слишком большое. Пожалуйста, введите число в диапазоне Integer (-2,147,483,648 до 2,147,483,647).");
        } catch (NumberFormatException e) {
            return new CommandResult("Неверный формат числа. Пожалуйста, введите целое число.");
        }
    }
}
