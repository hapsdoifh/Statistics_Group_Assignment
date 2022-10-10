import javax.swing.*;
import java.util.*;
import java.awt.*;

public class outputGUI extends JPanel{
    private int Xsize=0;
    private int Ysize=0;
    private Statistic GraphStats;
    
    public void setGphStats(Statistic StatIn){
        GraphStats = StatIn;
    }
    public void SetDrawSize(int x, int y){
        Xsize = x;
        Ysize = y;
    }
    public void paintComponent(Graphics g){
        PaintBoxWhisker(g);
    }
    private void PaintBoxWhisker(Graphics g){
        Graphics2D NewG = (Graphics2D)g;
        Color plotColor = new Color(0,0,0);
        double[] Quarts = GraphStats.Quartiles();
        int GrHeight = 50;
        int Offset = 10;
        double PixelIncre = (double)GraphStats.Range()/(double)(Xsize-2*Offset);
        int Vstart = Ysize/2-GrHeight/2,Hstart = Offset;
        int VEnd = Vstart+GrHeight;

        NewG.setColor(plotColor);
        NewG.fillRect(Xsize, Ysize, WIDTH, HEIGHT);
        NewG.fillRect(Hstart, Vstart, 4, GrHeight);
        for(int i = 0; i<3;i++){
            NewG.fillRect((int)(Quarts[i]/PixelIncre)+Offset, Vstart, 4, GrHeight);
        }
        NewG.setStroke(new BasicStroke(4));

        NewG.drawLine((int)(Quarts[0]/PixelIncre)+2+Offset, Vstart, (int)(Quarts[2]/PixelIncre)+2+Offset, Vstart);
        NewG.drawLine((int)(Quarts[0]/PixelIncre)+2+Offset, Vstart+GrHeight, (int)(Quarts[2]/PixelIncre)+2+Offset, Vstart+GrHeight);
        NewG.drawLine(Hstart+2,Vstart+GrHeight/2,Xsize-Offset-2,Vstart+GrHeight/2);
        NewG.fillRect(Xsize-Offset-4, Vstart, 4, GrHeight);
        NewG.setColor(new Color(150,150,100));
        int testVoffset=15;
        for (int i = 0; i<3;i++){
            NewG.drawString(Quarts[i]+"",(int)(Quarts[i]/PixelIncre)+Offset-10, VEnd+testVoffset);
        }
        NewG.drawString(GraphStats.getArray()[0]+"", Hstart-10, VEnd+testVoffset);
        NewG.drawString(GraphStats.getArray()[GraphStats.getArray().length-1]+"", Xsize-Offset-10, VEnd+testVoffset);
    }
    public static void outputGraph(Statistic statsParam){
        JFrame GraphingFrame = new JFrame("Graph output");
        outputGUI DrawGUI = new outputGUI();
        GraphingFrame.setSize(600, 300);
        DrawGUI.setGphStats(statsParam);
        GraphingFrame.add(DrawGUI);
        DrawGUI.SetDrawSize(600, 300);
        DrawGUI.setPreferredSize(new Dimension(600,300));
        GraphingFrame.getContentPane().getPreferredSize();
        GraphingFrame.pack();
        GraphingFrame.setVisible(true);
        DrawGUI.repaint();
        
    }
}