package sportmanagement;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import splashscreen.SplashScreen;

public class SportManagement {
    public static void main(String[] args) {
        FlatRobotoFont.install();
                FlatLaf.registerCustomDefaultsSource("themes");
                UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
                UIManager.put( "Button.arc", 999 );
                UIManager.put( "TextComponent.arc", 999 ); 
                UIManager.put("Label.foreground", Color.WHITE);
                UIManager.put("ScrollBar.track", new Color(0x16222A));
                UIManager.put("ScrollBar.thumb", new Color(60, 60, 60));
                UIManager.put("ScrollBar.width", 5);
                UIManager.put("ScrollBar.thumbArc", 12);
                UIManager.put("OptionPane.messageForeground", Color.BLACK);
                FlatMacLightLaf.setup();
        SplashScreen ss = new SplashScreen();
        ss.setVisible(true);
    }
    
}
