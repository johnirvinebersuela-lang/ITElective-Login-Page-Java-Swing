import javax.swing.*;
import java.io.File;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javax.sound.sampled.*;

public class HomePage extends JFrame {
    public HomePage() {
        super("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(900, 600);
        setLocationRelativeTo(null);
        
        JLabel bg = new JLabel(new javax.swing.ImageIcon("For Project Bypass.png"));
        bg.setLayout(null); 
        setContentPane(bg);
        
        JButton soundButton = new JButton("MAMBO");
        
        // Triggers the sound method safely
        soundButton.addActionListener(e -> playSound("Mambo sound effect.wav"));
        
        // Exact location you drew out on the screenshot
        soundButton.setBounds(100, 480, 100, 40); 
        bg.add(soundButton);

        setVisible(true);
    }

    private void playSound(String filename) {
        // Runs the audio on a separate background thread to guarantee it executes cleanly
        new Thread(() -> {
            try {
                File file = new File(filename);
                
                if (!file.exists()) {
                    System.out.println("❌ FILE LOCATION ERROR!");
                    System.out.println("Move your file here: " + file.getAbsolutePath());
                    return;
                }

                // Uses a robust stream method to ensure the bytes are completely buffered before playback
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                    new BufferedInputStream(new FileInputStream(file))
                );
                
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                
                // Forces the audio clip line to fire immediately
                clip.start();
                System.out.println("🎵 Audio stream executed successfully for: " + filename);
                
            } catch (UnsupportedAudioFileException e) {
                System.out.println("❌ AUDIO CODEC ERROR: Your file extension says .wav, but the internal encoding isn't PCM 16-bit.");
                System.out.println("Fix: Re-convert the file online specifically to a 16-bit PCM WAV layout.");
            } catch (Exception e) {
                System.out.println("❌ ERROR DETAILS:");
                e.printStackTrace();
            }
        }).start();
    }
}
