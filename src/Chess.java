import cli.CommandParser;

public class Chess {
    public static void main(String[] args) {
        CommandParser runGame = new CommandParser();
        runGame.createGameWithParams(args);
    }
}