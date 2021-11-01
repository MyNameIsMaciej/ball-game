package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

class MyJPanel extends JPanel {
    public MyJPanel() throws FileNotFoundException {
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 1000);
    }
    static int x=0;
    static int y=0;
   static ArrayList<Integer> arrListX =new ArrayList<>();
   static ArrayList<Integer> arrListY =new ArrayList<>();
    static  ArrayList<Integer>arrSpeed= new ArrayList<>();
   static int point;
    static int supportA=0;
    static int supportB=300;
    static  int coinX=0;
    static int coinY=0;
   static int life=0;
   static int lifeHelp=0;
    static boolean flagKeyP=false;
    int startSet=0;
    static boolean flagKey1=false;
    static boolean flagKey2=false;
    static boolean flagKey3=false;
    static boolean flagKey4=false;
    static boolean flagKey5=false;
    static boolean flagKeyS=false;
    static String kT=" ";
    static String kS=" ";
    static String kP=" ";
    static String k1="";
    static String k2="";
    static String k3="";
    static String k4="";
    static String k5="";
    public void setArray() {
        arrListX.add(200);
        arrListX.add(300);
        arrListX.add(400);
        arrListX.add(600);
        arrListX.add(550);
        arrListY.add(0);
        arrListY.add(0);
        arrListY.add(0);
        arrListY.add(0);
        arrListY.add(0);
        arrSpeed.add(1);
        arrSpeed.add(0);
        arrSpeed.add(0);
        arrSpeed.add(1);
        arrSpeed.add(1);
        startSet++;
    }
    public void border()
    {
        if(x+100> getWidth())
            {
                x=getWidth()-100;
            }
        if(y+100> getHeight())
            {
                y=getHeight()-100;
            }
    }
    public static void test()
    {
        MyJPanel.kT=" ";
        MyJPanel.kP=" ";
        MyJPanel.kS=" ";
        MyJPanel.k1=" ";
        MyJPanel.k2=" ";
        MyJPanel.k3=" ";
        MyJPanel.k4=" ";
        MyJPanel.k5=" ";
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
       border();
        if(!flagKeyP)
        {
            kT="press ' t ' to load game";
            kS="press ' s ' to save game";
            kP="press ' p ' to start game";
            k1="press' 1 ' to add new enemy object ";
            k2="press' 2 ' to delete new enemy object";
            k3="press' 3 ' to move the object using the keys i,j,k,l";
            k4="press' 4 ' to change way the enemy object on left";
            k5="press' 5 ' to change way the enemy object on right";
        }
        if(startSet<1){
    setArray(); }
        if(flagKey1){
            arrListX.add(200);
            arrListY.add(0);
            arrSpeed.add(1);
        }
        if(flagKey2)
        {
            if(arrListX.size()>1){
            arrListX.remove(1);
            arrListY.remove(1);
            arrSpeed.remove(1);}
        }
        flagKey1=false;
        flagKey2=false;
        g.setColor(new Color(	2551400));
        LocalTime localTime = LocalTime.now();
        boolean flag=true;
        g.fillOval(x,y,100,100);
        g.setColor(new Color(	17325547));
        g.fillRect(supportA,supportB,400,30);
        Toolkit t=Toolkit.getDefaultToolkit();
        Image im=t.getImage("C:\\Users\\Macie\\Desktop\\zadania\\moneta.jfif");
        g.drawImage(im,coinX,coinY,70,50,this);

        g.setColor(new Color(560000));
        for(int i=0; i<arrListX.size();i++)
        {
            g.fillRect(arrListX.get(i), arrListY.get(i), 30,100);
            if((x+100>arrListX.get(i)&&x<arrListX.get(i)+30)&&(y+100>arrListY.get(i)&&y<arrListY.get(i)+100))
            {
                if((x+100<supportA+420&&x>supportA)&&(y>supportB+30))
                {
                    g.drawString("super: "+point,500,700);
                }
                else {
                    coinX= (int) (Math.random()*100*10);
                    arrListX.set(i,(int) (Math.random()*100*10));
                    arrListY.set(i,0);
                    coinY=0;

                    if(life<3) {
                        point = 0;
                        lifeHelp=0;
                    }else {
                        life-=3;
                    }
                }
            }
        }
        if((x+100>coinX&&x<coinX+70)&&(y+100>coinY&&y<coinY+50)){
            coinX= (int) (Math.random()*100*10);
            coinY=0;
            life++;
            lifeHelp++;
            if(lifeHelp==3)
            {
                lifeHelp=0;
            }
        }
        int i=localTime.getSecond();
        g.setColor(new Color(000000));
        g.drawString("points: "+point,5,600);
        g.drawString("coins: "+lifeHelp+"/3",5,620);
        g.drawString("life: "+life/3,5,640);
        g.drawString(kP,300,500);
        g.drawString(kS,300,520);
        g.drawString(kT,300,540);
        g.drawString(k1,620,600);
        g.drawString(k2,620,620);
        g.drawString(k3,620,640);
        g.drawString(k4,620,660);
        g.drawString(k5,620,680);
        while (i<localTime.getSecond()+1&&flag){
            i++;
            boolean flagInWhile=true;
            while (flagInWhile)
            {
                    for(int j=0; j<arrListX.size();j++)
                    {
                        int temporaryRandom=(int)(Math.random()*10);
                        if(temporaryRandom==0||temporaryRandom>4){
                            flagInWhile =true;
                        }else {
                            flagInWhile=false;
                            arrSpeed.set(j,temporaryRandom);
                        }
                        if(flagKey3&&(j==0)){
                        }
                        else {
                            int tempS=arrSpeed.get(j);
                            int tempC=arrListY.get(j);
                            arrListY.set(j,tempC+tempS);
                            if(flagKey4){
                            arrListX.set(j,arrListX.get(j)+2);}
                            if(flagKey5){
                                arrListX.set(j,arrListX.get(j)-2);}
                        }
                    }
                supportA+=2;
                coinY+=2;
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(coinY>getHeight())
            {coinX= (int) (Math.random()*100*10);
                coinY=0;
            }
        for(int k=0;k<arrListX.size();k++)
        { if(arrListY.get(k)>getHeight())
        { arrListX.set(k,(int) (Math.random()*100*10));
            arrListY.set(k,0);
            point++;
        }}
            if(supportA>getWidth())
            {
                supportA=0;
            }
            if(flagKeyP){
                repaint();}
        }
    }
}
class MyJFrame extends JFrame implements KeyListener,MouseMotionListener {
    int i=0;
    int j=0;
    int k=0;
    int l=0;
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()=='1'){
            MyJPanel.flagKey1=true;
        }
        if(e.getKeyChar()=='2'){
            MyJPanel.flagKey2=true;
        } if(e.getKeyChar()=='3'){
            if(MyJPanel.flagKeyP) {
                j++;
                if (j % 2 == 1) {
                    MyJPanel.flagKey3 = true;
                } else {
                    MyJPanel.flagKey3 = false;
                }
            }
        }if(e.getKeyChar()=='4'){
            k++;
            if(MyJPanel.flagKey5)
            {MyJPanel.flagKey5=false;}
            if(k%2==1) {
                MyJPanel.flagKey4 = true;
            }else {
                MyJPanel.flagKey4 = false;
            }
        }
        if(e.getKeyChar()=='5'){
            l++;
            if(MyJPanel.flagKey4)
            {MyJPanel.flagKey4=false;}
            if(l%2==1) {
                MyJPanel.flagKey5 = true;
            }else {
                MyJPanel.flagKey5 = false;
            }
        }
        if(e.getKeyChar()=='s'){
            if(!MyJPanel.flagKeyP){
            System.out.println("działa");
                PrintWriter save = null;
                PrintWriter saveEnemy = null;
                PrintWriter saveSpeed = null;
                try {
                saveEnemy = new PrintWriter("C:\\Users\\Macie\\Desktop\\zadania\\saveEnemy.txt");
                    save = new PrintWriter("C:\\Users\\Macie\\Desktop\\zadania\\save.txt");
                    saveSpeed = new PrintWriter("C:\\Users\\Macie\\Desktop\\zadania\\saveSpeed.txt");
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            for(int i=0; i<MyJPanel.arrListX.size();i++) {
                saveEnemy.println(MyJPanel.arrListX.get(i));
                saveEnemy.println(MyJPanel.arrListY.get(i));
            }
            save.println(MyJPanel.x);
            save.println(MyJPanel.y);
            save.println(MyJPanel.supportA);
            save.println(MyJPanel.supportB);
            save.println(MyJPanel.coinX);
            save.println(MyJPanel.coinY);
            save.println(MyJPanel.point);
            save.println(MyJPanel.life);
            save.println(MyJPanel.lifeHelp);
            for(int i=0;i<MyJPanel.arrSpeed.size();i++)
            {
                saveSpeed.println(MyJPanel.arrSpeed.get(i));
            }
            save.close();
            saveEnemy.close();
            saveSpeed.close();}
        }
        if(e.getKeyChar()=='p'){
            i++;

            if(i%2==1){
                MyJPanel.flagKeyP=true;
              MyJPanel.test();
              repaint();
            }else {
                MyJPanel.flagKeyP=false;
                MyJPanel.test();
                repaint();
            }
        }
        if(e.getKeyChar()=='t') {
            if (!MyJPanel.flagKeyP) {
                File file = new File("C:\\Users\\Macie\\Desktop\\zadania\\save.txt");
                File fileEnemy = new File("C:\\Users\\Macie\\Desktop\\zadania\\saveEnemy.txt");
                File fileSpeed = new File("C:\\Users\\Macie\\Desktop\\zadania\\saveSpeed.txt");
                try {
                    Scanner read = new Scanner(file);
                    Scanner readEnemy = new Scanner(fileEnemy);
                    Scanner readSpeed = new Scanner(fileSpeed);
                    int i = 0;
                    int j = 0;
                    int k = 0;
                    int s = 0;
                    int speed = 0;
                    MyJPanel.arrListX.clear();
                    MyJPanel.arrListY.clear();
                    while (readEnemy.hasNext()) {
                        int number = readEnemy.nextInt();
                        if (i % 2 == 0) {
                            if (k < MyJPanel.arrListX.size()) {
                                MyJPanel.arrListX.set(k, number);
                            } else {
                                MyJPanel.arrListX.add(number);
                            }
                            i++;
                            k++;
                        } else if (i % 2 == 1) {
                            if (j < MyJPanel.arrListY.size()) {
                                MyJPanel.arrListY.set(j, number);
                            } else {
                                MyJPanel.arrListY.add(number);
                            }
                            i++;
                            j++;
                        }
                    }
                    while ((read.hasNext())) {
                        int number = read.nextInt();
                        switch (s) {
                            case 0: {
                                MyJPanel.x = number;
                                break;
                            }
                            case 1: {
                                MyJPanel.y = number;
                                break;
                            }
                            case 2: {
                                MyJPanel.supportA = number;
                                break;
                            }
                            case 3: {
                                MyJPanel.supportB = number;
                                break;
                            }
                            case 4: {
                                MyJPanel.coinX = number;
                                break;
                            }
                            case 5: {
                                MyJPanel.coinY = number;
                                break;
                            }
                            case 6: {
                                MyJPanel.point = number;
                                break;
                            }
                            case 7: {
                                MyJPanel.life = number;
                                break;
                            }
                            case 8: {
                                MyJPanel.lifeHelp = number;
                                break;
                            }
                        }
                        s++;
                    }
                    MyJPanel.arrSpeed.clear();
                    while (readSpeed.hasNext()) {
                        int number = readSpeed.nextInt();
                        if (speed < MyJPanel.arrSpeed.size()) {
                            MyJPanel.arrSpeed.set(speed, number);
                        } else {
                            MyJPanel.arrSpeed.add(number);
                        }
                        speed++;
                    }
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                repaint();
            }
        }
        if(e.getKeyChar()=='j'){
            if(MyJPanel.flagKey3){
            MyJPanel.arrListX.set(0,MyJPanel.arrListX.get(0)-10);
            repaint();}
        } if(e.getKeyChar()=='l'){
            if(MyJPanel.flagKey3){
            MyJPanel.arrListX.set(0,MyJPanel.arrListX.get(0)+10);
            repaint();}
        } if(e.getKeyChar()=='k'){
            if(MyJPanel.flagKey3){
            MyJPanel.arrListY.set(0,MyJPanel.arrListY.get(0)+10);
            repaint();}
        } if(e.getKeyChar()=='i'){
            if(MyJPanel.flagKey3){
            MyJPanel.arrListY.set(0,MyJPanel.arrListY.get(0)-10);
            repaint();}
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

    public MyJFrame(){
        addKeyListener(this);
        addMouseMotionListener(this);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        MyJPanel.x = e.getX();
        MyJPanel.y = e.getY();
        if(MyJPanel.flagKeyP){
            repaint();}
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        MyJPanel.x = e.getX();
        MyJPanel.y = e.getY();
        if(MyJPanel.flagKeyP){
            repaint();}
    }
}
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MyJPanel myp = new MyJPanel();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyJFrame window = new MyJFrame();
                window.setVisible(true);
                window.setTitle("Moje okno do rysowania");
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.add(myp);
                window.pack();
            }
        });
    }
}

