import java.util.Random;

public class Obstacle {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int award;
    private int orginalHealth;

    public Obstacle(int id, String name, int damage, int health,int award) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.orginalHealth = health;
        this.award=award;
    }

    public void randomSnakeAward(Player player){//Yılan oyunundan kazanılan ödül hesaplaması
        System.out.println(this.getName()+" Canavarından düşen ödül");
        Random random = new Random();
        int dropChance = random.nextInt(100) + 1;
        if (dropChance <= 15){ // Silah kazanma
            int weaponDropChance = random.nextInt(100) + 1;
            if (weaponDropChance <= 20){
                System.out.println("Tüfek Kazandınınz!!");
                player.getInventory().setWeapons(Weapons.getWeaponObjByID(3));
            }else if (weaponDropChance <= 50){
                System.out.println("Tabanca kazandınız!! ");
                player.getInventory().setWeapons(Weapons.getWeaponObjByID(1));
            }else {
                System.out.println("Kılıç kazandınız!!");
                player.getInventory().setWeapons(Weapons.getWeaponObjByID(2));
            }
        }else if (dropChance <= 30){ // zırh kazanma
            int armorDropChance = random.nextInt(100) + 1;
            if (armorDropChance <= 20){
                System.out.println("Ağır Zırh kazandınız");
                player.getInventory().setArmors(Armor.getArmorObjByID(3));
            }else if (armorDropChance <= 50){
                System.out.println("Orta Zırh kazandınız.");
                player.getInventory().setArmors(Armor.getArmorObjByID(2));
            }else {
                System.out.println("Hafif Zırh Kazandınız ");
                player.getInventory().setArmors(Armor.getArmorObjByID(1));
            }
        }else if (dropChance <= 55){ // para kazanma
            int moneyDropChance = random.nextInt(100) + 1;
            if (moneyDropChance <= 20 ){
                System.out.println("10 birim para kazandınız.");
                player.setMoney(player.getMoney() + 10);
            }else if (moneyDropChance <= 50 ){
                System.out.println("5 birim para kazandınız.");
                player.setMoney(player.getMoney() + 5);
            }else {
                System.out.println("1 birim para kazandınız");
                player.setMoney(player.getMoney() + 1);
            }
        }else System.out.println("Ödül kazanamadınız");
        System.out.println("--------------------------");
    }

    public int getOrginalHealth() {
        return orginalHealth;
    }

    public int getAward() {
        return award;
    }
    public int printAward() {
        return award<0 ? 0 : award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if(health<0)
            health=0;
        this.health = health;
    }
}
