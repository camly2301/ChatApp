
import com.project.swing.blurHash.BlurHash;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Test {

    public static void main(String[] args) {
        try {
            //encoder
            BufferedImage image = ImageIO.read(new File("F:\\hinh anh\\co4la.jpg"));
            String blurhashStr = BlurHash.encode(image); //LGF5]+Yk^6#M@-5c,1J5@[or[Q6.
            System.out.println(blurhashStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
