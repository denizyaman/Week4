import java.util.Random;

public class Snake extends Obstacle{
    public Snake() {
        super(4, "Yılan", 3,12,-1);
        Random r=new Random();//Yılanın hasarını random olarak 3-6 arasında bir değer olrak atıyoruz.
        int snakeDamage=r.nextInt(4)+3;// 3 ile 6 arasında rastgele sayı uretılır

        this.setDamage(snakeDamage);
    }

}
