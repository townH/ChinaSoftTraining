import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class JavaTest {
    @Test
    public void test01(){
        String word="嘻嘻 呵呵      哈哈哈     吼吼          嘿嘿";
        String regex = " +";
        String[] split = word.split(regex);
        System.out.println("Arrays.toString(split) = " + Arrays.toString(split));
    }

    @Test
    public void drawIma() throws IOException {
        int width = 120;
        int height = 30;
        // 在内存中生成图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 先获取画笔对象
        Graphics2D g = (Graphics2D) image.getGraphics();
        // 设置灰色
        g.setColor(Color.GRAY);
        // 画填充的矩形
        g.fillRect(0, 0, width, height);
        // 设置颜色
        g.setColor(Color.BLUE);
        // 画边框
        g.drawRect(0, 0, width - 1, height - 1);
        // 准备数据，随机获取4个字符
        String words = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        // 设置颜色
        g.setColor(Color.YELLOW);
        // 设置字体
        g.setFont(new Font("隶书", Font.BOLD, 20));
        String code = "";
        //构造存储字符的数组
        char[] a = {};
        //构造存储字符串的集合
        ArrayList<String> list = new ArrayList<String>();
        Random random = new Random();
        int x = 20;
        int y = 20;
        for (int i = 0; i < 4; i++) {
            // void rotate(double theta, double x, double y)
            // theta 弧度
            // hudu = jiaodu * Math.PI / 180;
            // 获取正负30之间的角度
            int jiaodu = random.nextInt(60) - 30;
            double hudu = jiaodu * Math.PI / 180;
            g.rotate(hudu, x, y);
            // 获取下标
            int index = random.nextInt(words.length());
            // 返回指定下标位置的字符，随机获取下标
            char ch = words.charAt(index);
            //将字符存入字符数组中
            char[] chc = {ch};
            //使用字符数组构造字符串
            String string = new String(chc);
            //将构造好的字符串添加进list集合中
            list.add(string);
            // 写字符串
            g.drawString("" + ch, x, y);
            g.rotate(-hudu, x, y);
            x += 20;
        }
        for (int i = 0; i < list.size(); i++) {
            code += list.get(i);
        }

        // 设置颜色
        g.setColor(Color.GREEN);
        int x1, x2, y1, y2;
        // 画干扰线
        for (int i = 0; i < 4; i++) {
            x1 = random.nextInt(width);
            y1 = random.nextInt(height);
            x2 = random.nextInt(width);
            y2 = random.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }
        FileOutputStream fileOutputStream = new FileOutputStream("aaa.jpg");

        // 输出到客户端
        ImageIO.write(image, "jpg", fileOutputStream);
    }
}
