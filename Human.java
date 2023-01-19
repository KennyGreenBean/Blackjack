public class Human extends Player{

    int money;
    int betMoney = 0;

    public Human(String playerName, int money) {
        super(playerName);
        this.money = money;
    }

    public void bet(int betMoney){
        if(betMoney > money){
            return;
        }
        money -= betMoney;
        this.betMoney = betMoney;
    }
}
