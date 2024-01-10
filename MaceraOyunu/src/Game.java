import java.util.Scanner;

public class Game {
    private static Scanner inp =new Scanner(System.in);
static void start() {
    System.out.println("Macera oyununa hoşgeldiniz.");
    System.out.print("Karakter ismini giriniz: ");
    String playerName = inp.nextLine();
    Player player = new Player(playerName);
    System.out.println("Sayın " + playerName + " Macera Adasına Hoşgeldiniz!!");
    player.selectChar();

    Location location = null;
    while (true) {
        player.printInfo();
        System.out.println();
        System.out.println("############### Bölgeler ###############");
        System.out.println();
        System.out.println("1- Güvenli Ev ---> Burası sizin için güvenli bir ev burda düşman yok!!");
        System.out.println("2- Eşya Dükkanı ---> Silah veya Zırh satın alabilirsiniz!");
        System.out.println("3- Mağara ---> Dikkat ZOMBİ Çıkabilir!! ");
        System.out.println("4 - Orman ---> Dikkat VAMPİR Çıkabilir!! ");
        System.out.println("5 - Nehir ---> Dikkat AYI Çıkabilir!!");
        System.out.println("6 - Maden ---> Dikkat YILAN Çıkabilir!!");
        System.out.println("0- Çıkış Yap ---> Oyunu Sonlandır.");
        System.out.println("Lütfen gideceğiniz bölgeyi seçiniz:");
        int selectLocation = inp.nextInt();
        switch (selectLocation) {
            case 0:
                location=null;
                break;
            case 1:
                location = new SafeHouse(player);
                break;
            case 2:
                location = new ToolStore(player);
                break;
            case 3:
                location=new Cave(player);
                break;
            case 4:
                location=new Forest(player);
                break;
            case 5:
                location=new River(player);
                break;
            case 6:
                location=new Mine(player);
            default:
                System.out.println("Lütfen Geçerli Bir Bölge Gİriniz!!");
        }
        if (location==null){
            System.out.println("Oyun bitti!!");
            break;
        }

        System.out.println(location.getName());
        if (!location.onLocation()){
            System.out.println("!!!GAME OVER!!!");
            break;
        }

    }
    }

}