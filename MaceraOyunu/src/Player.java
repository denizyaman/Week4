import java.util.Scanner;

public class Player {
    private Scanner inp = new Scanner(System.in);
    private Inventory inventory;
    private int damage;
    private int health;
    private int money;

    private String name;

    private String charType;
    private int originalHealth;



    public Player(String name) {

        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        Samurai samurai = new Samurai();
        Archer archer = new Archer();
        Knight knight = new Knight();
        CharacterType[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("Karakterler:");
        for (CharacterType characterType : charList) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("ID:" + characterType.getId() +
                    "\t Karakter: " + characterType.getName() +
                    "\t\t Hasar: " + characterType.getDamage() +
                    "\t\t Sağlık: " + characterType.getHealth() +
                    "\t\tPara: " + characterType.getMoney());
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Lütfen oynayacağınız karakteri seçiniz: ");
        int selectChar = inp.nextInt();//Karakter seçimi yapılır
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Karakter: " + this.charType//KArakterin özellikleri yazdırılır.
                + ", Hasar: " + this.damage
                + ", Sağlık: " + this.health
                + ", Para: " + this.money);

    }

    public void initPlayer(CharacterType characterType) {
        this.setDamage(characterType.getDamage());
        this.setHealth(characterType.getHealth());
        this.setMoney(characterType.getMoney());
        this.setOriginalHealth(characterType.getHealth());
        this.setCharType(characterType.getName());

    }

    public void printInfo() {
        System.out.println("Silahınız: " + this.getInventory().getWeapons().getName()
                + ", Zırhınız: " + this.getInventory().getArmors().getName()
                + ", Koruma: " +this.getInventory().getArmors().getBlock()
                + ", Hasar: " + this.getTotalDamage()
                + ", Sağlık: " + this.health
                + ", Para: " + this.money);
    }
    public int getTotalDamage(){
        return damage + this.getInventory().getWeapons().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health<0){
            health=0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharType() {
        return charType;
    }

    public void setCharType(String charType) {
        this.charType = charType;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapons getWeapon(){
        return this. getInventory().getWeapons();
    }
    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
