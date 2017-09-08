import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Point;
/**
 * La classe crea un triangolo di colore rosso che cambia colore quando viene cliccata la sua superficie
 * @author Patrick
 * @version 30.8.2017
 */
public class Triangolo extends JFrame implements MouseListener{
    private Color defaultColor;
    private int clickCount=1;
    private Polygon p = new Polygon();
    /**
     * Il costruttore del triangolo
     */
    public Triangolo(){
        defaultColor = Color.RED;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,300);
        this.addMouseListener(this);
    }
    /**
     * Il metodo che disegna il triangolo
     * @param g 
     */
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(defaultColor);
        int latoY = this.getHeight();
        int latoX = this.getWidth();
        int margine=latoY/10;
        int hTriangolo = latoY-2*margine;
        int wTriangolo=(int) (hTriangolo/Math.sin(90.0)*Math.sin(30.0));
        int[] x = {latoX/2,(latoX-wTriangolo)/2, (latoX-wTriangolo)/2+wTriangolo};
        int[] y = {margine, latoY-margine, latoY-margine};
        p = new Polygon(x, y, 3);
        g.fillPolygon(p);
        
        
        
    }
    /**
    *Legge il click del mouse
    *@param e l'evento del mouse
    */
    public void mouseClicked(MouseEvent e){
        if(p.contains(e.getPoint())){
            clickCount++;
            if(clickCount==2){
                defaultColor=Color.GREEN;
            }
            else if(clickCount==3){
                defaultColor=Color.BLUE;
            }
            else{
                defaultColor=Color.RED;
                clickCount=1;
            }
            repaint();
        }
    }
    /**
    *Legge la pressione del mouse
    *@param e l'evento del mouse
    */
    public void mousePressed(MouseEvent e){

    }
    /**
    *Legge il rilascio del mouse
    *@param e l'evento del mouse
    */
    public void mouseReleased(MouseEvent e){
    }
            /**
    *Legge l'entrata del mouse
    *@param e l'evento del mouse
    */
    public void mouseEntered(MouseEvent e){
    }
    /**
    *Legge l'uscita del mouse
    *@param e l'evento del mouse
    */
    public void mouseExited(MouseEvent e){
    }
    public static void main(String[] args) {
        Triangolo t = new Triangolo();
        t.setVisible(true);
    }
}