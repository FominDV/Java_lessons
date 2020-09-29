import java.awt.*;

public class BackgroundOfCanvas {
    private static int red = 0, green = 0, blue = 0, flagColor = 0;

    BackgroundOfCanvas(GameCanvas canvas) {
        canvas.setBackground(backgroundColor());
    }

    private static Color backgroundColor() {
        if (flagColor == 4 && red < 255) {
            red++;
            green++;
            blue++;
        } else if ((green == 0 || flagColor == 1) && red < 255) {
                red++;
            } else if (blue == 0 && green < 255) {
                green++;
            } else if (blue < 255) {
                blue++;
            } else {
                int[] valuesRGB = valuesRGB();
                red = valuesRGB[0];
                green = valuesRGB[1];
                blue = valuesRGB[2];

        }
        return new Color(red, green, blue);
    }

    private static int[] valuesRGB() {
        int[] valuesOfColors = new int[3];
        switch (flagColor) {
            case 0:
                flagColor++;
                valuesOfColors[0] = 0;
                valuesOfColors[1] = 255;
                valuesOfColors[2] = 0;
                break;
            case 1:
                flagColor++;
                valuesOfColors[0] = 0;
                valuesOfColors[1] = 255;
                valuesOfColors[2] = 255;
                break;
            case 2:
                flagColor++;
                valuesOfColors[0] = 0;
                valuesOfColors[1] = 0;
                valuesOfColors[2] = 255;
                break;
            case 3:
                flagColor++;
                valuesOfColors[0] = 0;
                valuesOfColors[1] = 0;
                valuesOfColors[2] = 0;
                break;
            case 4:
                flagColor = 0;
                valuesOfColors[0] = 0;
                valuesOfColors[1] = 0;
                valuesOfColors[2] = 0;
                break;
        }
        return valuesOfColors;
    }
}
