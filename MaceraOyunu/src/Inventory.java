public class Inventory {
    private Weapons weapons;
    private Armor armors;

    private String[] awardItems;
    public Inventory(){
        this.weapons =new Weapons("Yumruk",-1,0,0);
        this.armors=new Armor(-1,"Günlük Giysi",0,0);
        this.awardItems = new String[4];
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }

    public String[] getAwardItems() {
        return awardItems;
    }
    public void printAwardItems() {
        System.out.println("######################");
        System.out.println("# Envanterdeki Ödüller #");
        for (String award : awardItems) {
            if (award != null ) {
                System.out.print(award+"-");
            }
        }
        System.out.println();
        System.out.println("######################");
    }

    public boolean checkAllEarnedItems(Player player){
        for (String earnedAward : player.getInventory().getAwardItems()) {
            if (earnedAward == null) {
                return false;
            }
        }
        return true;
    }
    private boolean isAwardExist(String award) {
        for (String existedAward : awardItems) {
            if (existedAward != null && existedAward.equals(award)) {
                return true;
            }
        }
        return false;
    }

    public void setAwardItems(String awardItem) {
        if (!isAwardExist(awardItem)) {
            for (int i = 0; i < this.awardItems.length; i++) {
                if (this.awardItems[i] == null) {
                    this.awardItems[i] = awardItem;
                    System.out.println("Ödül envantere eklendi: " + awardItem);
                    break;
                }
            }
        } else {
            System.out.println("Bu ödül zaten mevcut. Eklenmedi.");
        }
    }


    public Armor getArmors() {
        return armors;
    }

    public void setArmors(Armor armors) {
        this.armors = armors;
    }
}
