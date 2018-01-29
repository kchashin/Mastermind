package constants;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Constants{
public static final ArrayList<Color> codeColors = 
        new ArrayList<Color>(Arrays.asList(Color.BLUE, Color.BLACK, Color.ORANGE,
        Color.WHITE, Color.YELLOW, Color.RED, Color.GREEN, Color.PINK));

public static final ArrayList<Color> responseColors = new ArrayList(Arrays.asList(Color.RED, Color.WHITE));
 public static final int MAX_ATTEMPTS = 10;
public static final int MAX_PEGS = 4;
public static final int COLORS = 8;
}