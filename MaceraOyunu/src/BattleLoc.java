import java.io.Console;
import java.util.Arrays;
import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String awardItem;
    private int maxObstacle;
    private int starter=0;

    public BattleLoc(Player player, String name,Obstacle obstacle, String awardItem, int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.awardItem=awardItem;
        this.maxObstacle=maxObstacle;
    }
    public int randomObstacleNumber(){
        Random r =new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }
    public void headsOrTails (){
        final Random random = new Random();
        if (random.nextBoolean()) {
            this.starter = 1;
        } else {
            this.starter = 2;
        }
    }

    @Override
    boolean onLocation() {
        int obsNumber=this.randomObstacleNumber();
        System.out.println("Şuan buaradasınız: "+ this.getName());
        System.out.println("DİKKAT ET !!! Burada "+obsNumber+" adet "+this.getObstacle().getName()+" Var!!!");
        System.out.println("<S>AVAŞ yada <K>AÇ: ");
        String selectCase =inp.nextLine();
        selectCase=selectCase.toUpperCase();
        if(selectCase.equals("S")&&combat(obsNumber)){
            System.out.println(this.getPlayer().getName()+ " Tebrikler Tüm Canavarları Yendiniz!!!");
            System.out.println(this.getAwardItem()+ " Ödülü envantere ekleniyor!");
            this.getPlayer().getInventory().setAwardItems(this.getAwardItem());
            this.getPlayer().getInventory().printAwardItems();

            return true;
        }
        if(this.getPlayer().getHealth()<=0){
            System.out.println("!!! Öldünüz !!!");

            return false;
        }
        return true;
    }
    public void attackEnemy(){
        System.out.println("Canavar Size Vurdu");
        int obsDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmors().getBlock() ;
        if(obsDamage<0){
            obsDamage=0;
        }
        this.getPlayer().setHealth(this.getPlayer().getHealth()-obsDamage);
        afterHit();
    }
    public void attackMe(){
        System.out.println("Siz Vurdunuz");
        this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
        afterHit();
    }
    private void collectItems(){
        if(this.getObstacle().getAward()==-1) {
            if (this.getObstacle().getName().equals("Yılan")) {
                this.getObstacle().randomSnakeAward(this.getPlayer());
            }
        }else{
            System.out.println(this.getObstacle().getAward()+" Birim para Kazandınız.");
            this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
            System.out.println("Güncel Paranız "+this.getPlayer().getMoney());
        }
    }
    public boolean combat(int obsNumber){
        for(int enemyNumber=1; enemyNumber<= obsNumber; enemyNumber++){
            this.getObstacle().setHealth(this.getObstacle().getOrginalHealth());
            playerStats();
            obstacleStats(enemyNumber);
            while (this.getPlayer().getHealth()>0 && this.getObstacle().getHealth() >0){
                if(starter==0){
                    headsOrTails();
                }
                if(this.getObstacle().getHealth()>0 && starter==2){
                    attackEnemy();
                }

                System.out.println("<V>ur ya da <K>aç");

                String selectedCombat = inp.nextLine().toUpperCase();

                if(selectedCombat.equals("V")){
                    attackMe();
                    if(this.getObstacle().getHealth()>0 && starter==1){
                        attackEnemy();
                    }
                }else {
                    return false;
                }
            }
            if(this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("Tebrikler Canavarı Yendiniz!!");
                collectItems();
            }else{
                return false;
            }
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Canınız : "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" Canı: "+this.getObstacle().getHealth());
    }
    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("------------------------");
        System.out.println("Sağlık : "+this.getPlayer().getHealth());
        System.out.println("Hasar : "+this.getPlayer().getTotalDamage());
        System.out.println("Silah : "+this.getPlayer().getWeapon().getName() );
        System.out.println("Zırh : "+this.getPlayer().getInventory().getArmors().getName() );
        System.out.println("Bloklama : "+this.getPlayer().getInventory().getArmors().getBlock() );
        System.out.println("Para : "+this.getPlayer().getMoney());
    }
    public void obstacleStats(int obsNumber){
        System.out.println();
        System.out.println(obsNumber+"."+this.getObstacle().getName()+" Değerleri");
        System.out.println("------------------------");
        System.out.println("Sağlık : "+this.getObstacle().getHealth());
        System.out.println("Hasar : "+this.getObstacle().getDamage());
        System.out.println("Para : "+this.getObstacle().printAward());
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAwardItem() {
        return awardItem;
    }

    public void setAwardItem(String awardItem) {
        this.awardItem = awardItem;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
