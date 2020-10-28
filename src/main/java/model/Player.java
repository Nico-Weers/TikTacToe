package model;

public class Player {
    private final Symbol symbol;
    private String username;

    public Player(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public String getUsername() {
        if(username == null){
            username = "";
        }
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
