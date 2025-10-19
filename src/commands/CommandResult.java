package commands;

public class CommandResult{
    private final String message;
    private final boolean shouldExit;
    public CommandResult(String message){
        this(message, false);
    }

    CommandResult(String message, boolean shouldExit) {
        this.message = message;
        this.shouldExit = shouldExit;
    }
    public String getMessage(){
        return message;
    }

    public boolean isShouldExit() {
        return shouldExit;
    }
}

