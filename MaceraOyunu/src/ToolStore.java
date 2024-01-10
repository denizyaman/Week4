public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("--------------- Mağazaya Hoşgeldiniz! ---------------");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("1- Silahlar");
            System.out.println("2- Zırhlar");
            System.out.println("3- Çıkış Yap!");
            System.out.print("Seçiminiz: ");
            int selectCase= inp.nextInt();
            while (selectCase<1 || selectCase>3){
                System.out.println("Geçersiz değer girdiniz. Lütfen tekrar giriniz: ");
                selectCase= inp.nextInt();
            }
            switch (selectCase){//Silah seçimi
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmors();
                    break;
                case 3:
                    System.out.println("Yine bekleriz.");
                    showMenu=false;
                    break;
            }

        }
        return true;
    }
    public void printWeapon(){
        System.out.println("=========== Silahlar ===========");
        for(Weapons w :Weapons.weapons()){
            System.out.println(w.getId()+" - "+w.getName()+" Para: "+w.getPrice()+" Hasar: "+w.getDamage());
        }
        System.out.println("0 - Çıkış Yap!");

    }
    public void buyWeapon(){
        System.out.println("Bir silah seçiniz? ");
        int selectWeaponID= inp.nextInt();
        while (selectWeaponID<0 || selectWeaponID>Weapons.weapons().length){
            System.out.println("Geçersiz değer, tekrar giriniz: ");
            selectWeaponID= inp.nextInt();
        }
        if(selectWeaponID!=0){
            Weapons selectedWeapon = Weapons.getWeaponObjByID(selectWeaponID);

            if (selectedWeapon != null){//Oyuncu bakiyesi sorgulanarak silah alımını yaptırıyoruz
                if (selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Yeterli bakiyeniz bulunmamaktadır.");
                }else{
                    System.out.println(selectedWeapon.getName()+" silahını satın aldınız.");
                    int balance= this.getPlayer().getMoney()-selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Güncel bakiyeniz: "+ this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapons(selectedWeapon);

                }
            }
        }
    }
    public void printArmor(){
        System.out.println("=========== Zırhlar ===========");
        for (Armor a: Armor.armors()){
            System.out.println(a.getId()+" - "+a.getName()
                    +" Para: "+ a.getPrice()
                    +" Zırh: "+a.getBlock());
        }
        System.out.println("0 - Çıkış Yap!");
    }
    public void buyArmors(){
        System.out.println("Bir zırh seçiniz? ");
        int selectArmorID= inp.nextInt();
        while (selectArmorID<0 || selectArmorID>Armor.armors().length){
            System.out.println("Geçersiz değer, tekrar giriniz: ");
            selectArmorID= inp.nextInt();
        }
        if(selectArmorID!=0){

            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

            if (selectedArmor != null){
                if (selectedArmor.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Yeterli bakiyeniz bulunmamaktadır.");
                }else{
                    System.out.println(selectedArmor.getName()+" Zırhını satın aldınız.");
                    int balance= this.getPlayer().getMoney()-selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Güncel bakiyeniz: "+ this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmors(selectedArmor);

                }
            }
        }

    }
}
