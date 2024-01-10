public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }
    private void checkGameStatus(){
       if(this.getPlayer().getInventory().checkAllEarnedItems(this.getPlayer())){
           System.out.println("Tebrikler! Tüm ödülleri aldınız. Oyun Bitti!");
           System.exit(0);
       }
    }
    @Override
    public boolean onLocation(){
        System.out.println("Güvenli Evdesiniz!");
        this.checkGameStatus();
        System.out.println("Canınız Yenilendi.");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());//Güvenli evde can yenileme işlemi
        return true;
    }
}
