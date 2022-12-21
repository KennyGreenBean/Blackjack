public class Human extends Player{

    private int money;

    public Human(String playerName, int money) {
        super(playerName);
        this.money = money;
    }

    public int bet(int betMoney){
        if(betMoney > money){
            return 0;
        }
        money -= betMoney;
        return betMoney;
    }
}
