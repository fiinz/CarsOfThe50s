// Car of 50´s generator
// -- by jaime fins '04




import java.applet.Applet;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.text.*;
import java.awt.font.TextAttribute;




public class cars50 extends java.applet.Applet {
    
    
    
    
    //variaveis de parametrização
    
    public Color harvestGold = new Color(233,222,132), onixBlack = new Color(50,49,55)
    ,seaMistGreen = new Color(133,166,155),neptuneGreen = new Color(49,94,99),
    skylineBlue = new Color(166,190,202),glacierBlue = new Color(60,166,155),copperMaroon = new Color(133,166,155),
    shorelineBeige= new Color(248,239,206),autumnBronze = new Color(207,95,73),
    indiaIvory = new Color(252,249,230),shadowGray = new Color(133,137,136),
    gypsyRed  = new Color(172,84,72), regalTurquoise = new Color(63,108,114),
    coral = new Color(186,138,116),incaSilver = new Color(165,166,160),imperialIvory = new Color(252,250,238),
    matadorRed = new Color(187,81,68),harborBlue = new Color(28,83,121),tropicaTurquoise = new Color(73,132,148),
    surfGreen = new Color(157,189,178),highlandGreen = new Color(154,161,117),colonialGreen = new Color(87,101,68),
    coronadoYellow = new Color(184,174,103),canyonCoral = new Color(148,115,100),sierraGold= new Color(186,127,85),
    adobeBeige = new Color(235,231,196),duskPearl = new Color(148,130,120),laurelGreen = new Color(175,173,125);
    
    private double ox,oy,width,dy,axleDistance,cx,cy,carHeight,frontBumperHeight,posyrearlight,widthRearLight,heightRearLight,
    rearFenderHeight,frontFenderHeight,rearBumperWidth,rearBumperHeight,rearWidth;
    
    private Color colors [] = new Color [4];
    private int typeRearFender,typeFrontFender,typeWheel,model,typeFlame,numDoors;
    private AffineTransform lowering;
    private double radiusWheel,rearAngle,headWidth;
    
    
    // variaveis auxiliares no desenho do carro
    private double rearX,rearY,headX,headY,headX2,headY2;  
    private Point2D rearFenderAuxBackDoor[] = new Point2D[3],flame [] = new Point2D[5];
    
    
    
    
    //variaveis no desenho de pormenores não parametrizaveis 
    private GeneralPath speculationFender,rearLightLowerShadow,rearLightUpperShadow,carSpeculation,supheadbumper;
    private Point2D rearLightUpperShadowaux;
    
    
    
    
    
    public void fiftyCars(){
        
        modifySize(0,0,1000);
        defineCarHeight(5);  
        defineFlames(1);
        toLower(3);
        defineNumDoors(3);
        defineModel(1);
        defineColors(0,this.onixBlack);
        defineColors(1,this.tropicaTurquoise);
        defineColors(2,this.colors[1]);
        defineColors(3,this.colors[0]);
        defineWheels(7);    
        defineHeadWidth(5);
        defineHeadBumper(4);
        defineHeadFender(1,5);        
        defineRearFender(0,5);
        defineRear(1,5);
        defineRearLights(4,4,5);        
        defineRearBumper(3,4);   
        
        
    }
    
    public void fiftyCars(Color color){
        modifySize(0,0,1000);
        defineCarHeight(5);
        defineFlames(1);
          toLower(3);
        defineNumDoors(3);
        defineModel(1);
        defineColors(0,color);
        defineColors(1,this.tropicaTurquoise);
        defineColors(2,this.colors[1]);
        defineColors(3,this.colors[0]);
        defineWheels(7);
        defineHeadWidth(5);
        defineHeadBumper(4);
        defineHeadFender(1,5);        
        defineRearFender(0,5);
        defineRear(1,5);
        defineRearLights(4,4,5);        
        defineRearBumper(3,4);   
    }
    
    public void fiftyCars(int model){
        
        modifySize(0,0,1000);
        defineCarHeight(5);
        defineFlames(1);
          toLower(3);
        defineNumDoors(3);
        defineModel(model);
        defineColors(0,this.onixBlack);
        defineColors(1,this.tropicaTurquoise);
        defineColors(2,this.colors[1]);
        defineColors(3,this.colors[0]);
        defineWheels(7);
        defineHeadWidth(5);
        defineHeadBumper(4);
        defineHeadFender(1,5);        
        defineRearFender(0,5);
        defineRear(1,5);
        defineRearLights(4,4,5);        
        defineRearBumper(3,4);   
        
        
        
    }
    
    
    public void fiftyCars(double ox, double oy, double width){
        
        modifySize(ox,oy,width);
        defineFlames(1);
        defineCarHeight(5);
        toLower(3);
        defineNumDoors(3);
        defineModel(1);
        defineColors(0,this.onixBlack);
        defineColors(1,this.tropicaTurquoise);
        defineColors(2,this.colors[1]);
        defineColors(3,this.colors[0]);
        defineWheels(7);
        defineHeadWidth(5);
        defineHeadBumper(4);
        defineHeadFender(1,5);        
        defineRearFender(0,5);
        defineRear(1,5);
        defineRearLights(4,4,5);        
        defineRearBumper(3,4);   
        
        
        
    }
    
    public void modifySize(double ox,double oy, double width){
        
        
        
        //modificar o comprimento e o canto esquerdo da area de desenho
        //  if(width<100||width>1800)width=800;
        
        this.ox=ox; //atribuir os valores ás variaveis da classe
        this.oy=oy+60;
        this.width=width;
        this.dy = width*0.3;
        this.cx =ox+(width/2);
        this.cy= oy+(dy/2);
        this.axleDistance = width*0.39;
        this.radiusWheel=this.axleDistance*0.115;
        
    }
    
    
    public void defineModel(int model){
        
        
        //método responsável por definir o modelo do carro
        //1-NORMAL
        //2-CONVERTIBLE
        //3-STATION_WAGON
        
        if(model<1||model>3)model=1;
        this.model=model;
        
        
    }
    
        
    public void defineCarHeight(double height){
        
        
        //forçar que os valores recebidos situam-se entre 1 e 5
        if(height<1||height>5)height=1;
        
        this.carHeight = this.radiusWheel*1.03*(1+((height+7)*0.048));
        
    }
    
        
    
    public void defineFlames(int type){
        
        //tipo 0 - 5
        //0 -sem flame
        
        //forçar os valores
        
        if(type<0||type>5)type=0;
        this.typeFlame=type;
        
        
    }
    
    
    
    public void defineNumDoors(int doors){
        
        //definir numero de portas
        
        // 3 - 5
        //forçar os valores inseridos
        if(doors!=5 && doors!=3){
            doors=3;
        }
        
        this.numDoors=doors;
        
    }
    
      
    public void toLower(double lowering){
        
        
        //método que permite definir o rebaixamento do carro
        //0-5
        
        if(lowering<0 || lowering >5)
            lowering=3;
        
     
        
        this.lowering = AffineTransform.getTranslateInstance(0,lowering*this.axleDistance*0.006);
        
    }
    
    
    
    public void defineColors(int piece,Color c){
        
        //método para personalizar as colors
        //0-3
        //tipos
        // 0 chassis
        // 1 flames
        // 2 stands windows
        // 3 roof        
        
        if(piece<0||piece>3)piece=0;
        this.colors[piece]=c;
    }
    
    
    public void defineColors(Color c){
        
        //este método recebe como argumento uma cor,  para que todo o carro seja pintado de uma cor
        
        //atribuir  chassis todas as partes do carro chassis mesma cor
        for(int k=0;k<colors.length;k++)
            this.colors[k]=c;
        
    }

    

    
    
    public void defineWheels(int type){
        //forçar valores
        if(type<0 || type>9)
            type=0;
    
        this.typeWheel=type;
    }
    
    
    public void defineHeadWidth(double width){
        
        
        //1-10
        if(width<0 || width>10)
            width=5;
            
        this.headWidth=this.axleDistance*0.05+(width*this.axleDistance*0.009);
        
        
    }
    
    
    public void defineHeadBumper(double height){
        //valores entre 1-5;
        
        
        if(height<1||height>5)height=1;
        this.frontBumperHeight=(height*this.axleDistance*0.005)+this.axleDistance*0.03;
        
    }
    
    
    public void defineHeadFender(int type,double height){
        
        // 0 - curve
        // 1- rectilinear
        //este método permite definir chassis altura e o tipo do guarda lamas da frente
        
        //forçar valores entre 0-5
        if(height<0||height>5)height=0;
        if(type<0||type>1)type=0;
        
        this.frontFenderHeight =height;
        this.typeFrontFender=type;
    }
    
    
        
    public void defineRearFender(int type, double height){
        
        //este método permite definir chassis altura e o tipo do guarda lamas de trunk
        //tipo 0 - curvo 
        //tipo 1 -rectilineo
        //forçar valores entre 0-5
        if(height>5 || height<0)
            height=3;
        if(type<0||type>1)type=0;
        
        this.rearFenderHeight = height;
        
        this.typeRearFender=type;
 
        
    }
    
    
    public void defineRear(double angle,double rearWidth){
        
        
        
        //este método permite personalizar o comprimento, o angulo e o tipo de trunkeira do carro
        
          if(rearWidth<0 || rearWidth>10)
            rearWidth=5;
          
        this.rearWidth=this.axleDistance*0.26+rearWidth*(this.axleDistance*0.016);
        
        if(angle>5 || angle<-5)
            angle=0;
        
        
        //ajustar angulo de trunk -10º - 10º
        this.rearAngle = Math.PI+(angle*Math.PI/180);
        
        
        
    }
    
    
    

    
    
    public void defineRearBumper(double width, double height){
        
        
        
        //método que possibilita definir o comprimento e altura do para choques trunkeiro
        
        if(height>5 || height<0)
            height=3;
        
        if(width>5 || width<0)
            width=3;
        
        this.rearBumperHeight = height;
        this.rearBumperWidth = width;
        
        
        
    }
    
    
    
    public void defineRearLights(double width,double height,double posy){
        
        //método que possibilita definir as luzes trunkeiras
        
          if(height>5 || height<0)
            height=3;
        
        if(width>5 || width<0)
            width=3;
          
        if(posy>5 || posy<0)
            posy=3;
          
          
        //width 0-5
        //heigth 0-5
        //posy 0-5
        
        this.posyrearlight=this.carHeight*0.8+(posy*this.carHeight*0.05*rearBumperHeight*0.07);
        this.heightRearLight=this.carHeight*0.05+(this.carHeight*0.1*height)-rearBumperHeight*0.02;
        this.widthRearLight = (this.carHeight*0.07)+(this.carHeight*0.14*width*1.2)-heightRearLight*0.5;
        
    }
    
    
    
  
    
    
    public void drawCar(Graphics2D g2){
        credits(g2);
        shadow(g2);
        g2.transform(lowering);
        g2.translate(lowering.getTranslateX(),-lowering.getTranslateY());
        wheels(g2,cx-this.axleDistance/2,oy+dy);
        wheels(g2,cx+this.axleDistance/2,oy+dy);
        g2.transform(lowering);
        higherPart(g2);
        chassis(g2);
        //especulação dos paralamas
        AffineTransform at = AffineTransform.getTranslateInstance(0,-this.axleDistance*0.019/2);
        g2.transform(at);
        Stroke traço = new BasicStroke((float)(this.axleDistance*0.018));
        g2.setStroke(traço);
        g2.setPaint(new Color(255,255,255,30));
        g2.draw(speculationFender);
        traço = new BasicStroke((float)(0.5));
        g2.setStroke(traço);
        at = AffineTransform.getTranslateInstance(0,this.axleDistance*0.019/2);
        g2.transform(at);
        
        headBumper(g2);
        rearBumper(g2);
        g2.translate(lowering.getTranslateX(),-lowering.getTranslateY());
        
        
        
    }
    
    
    
    private void  higherPart(Graphics2D g2){
        
        //método responsável pelo desenho de todos os componentes da parte superior do carro
        
        steeringWheel(g2);
        rearViewMirror(g2);
        headWindow_Chrome(g2);
        smallSideWindow(g2);
        //se o carro nao for descapotavel desenha o pane de trunk
        if(this.model!=2)
            rearWindow(g2);
        
        //se o carro nao for descapotavel desenha o tejadilho
        //caso contrario desenha o assento de trunk
        if(this.model!=2)
            roof(g2);
        else
            backSeat(g2);
        
        stands(g2);
        capot(g2);
        
        
    }
    
    
    private void rearViewMirror(Graphics2D g2){
        
        //desenho do retrovisor
        
        Stroke traço = new BasicStroke((float)(this.axleDistance*0.006));
        g2.setStroke(traço);
        GeneralPath rearViewMirror = new GeneralPath();
        rearViewMirror.moveTo((float)(cx+this.axleDistance*0.2),(float)(oy+dy-this.carHeight*3.1));
        rearViewMirror.lineTo((float)(cx+this.axleDistance*0.2),(float)(oy+dy-this.carHeight*2.9));
        rearViewMirror.quadTo((float)(cx+this.axleDistance*0.212),(float)(oy+dy-this.carHeight*2.8),(float)(cx+this.axleDistance*0.2),(float)(oy+dy-this.carHeight*2.7));
        rearViewMirror.lineTo((float)(cx+this.axleDistance*0.2),(float)(oy+dy-this.carHeight*2.9));
        g2.setPaint(Color.black);
        g2.draw(rearViewMirror);
        
        
    }
    
    
    private void steeringWheel(Graphics2D g2){
        
        //desenho do volante
        
        Line2D steeringWheel = new Line2D.Double(cx+this.axleDistance/2-this.carHeight*2.25,oy+dy-this.carHeight*2,cx+this.axleDistance/2-this.carHeight*2,oy+dy-this.carHeight*2.45);
        Stroke traço = new BasicStroke((float)(this.axleDistance*0.01),BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        g2.setStroke(traço);
        g2.setPaint(Color.black);
        g2.draw(steeringWheel);
        
        
        
    }
    
    
    private void headWindow_Chrome(Graphics2D g2){
        
        
        //desenho do pane  da frente e da armação
        
        Stroke traço = new BasicStroke((float)(1));
        g2.setStroke(traço);
        GeneralPath headWindow_Chrome = new GeneralPath();
        GeneralPath headWindow = new GeneralPath();
        
        
        
        
        headWindow_Chrome.moveTo((float)(cx+this.axleDistance/2-this.carHeight),(float)(oy+dy-this.carHeight*2.26));
        headWindow_Chrome.quadTo((float)(cx+this.axleDistance/2-this.carHeight*1.1),(float)(oy+dy-this.carHeight*2.2),(float)(cx+this.axleDistance/2-this.carHeight*2.3),(float)(oy+dy-this.carHeight*2));
        headWindow_Chrome.lineTo((float)(cx+this.axleDistance*0.165),(float)(oy+dy-this.carHeight*2));
        headWindow_Chrome.lineTo((float)(cx+this.axleDistance*0.165),(float)(oy+dy-this.carHeight*3.1));
        headWindow_Chrome.quadTo((float)(cx+this.axleDistance*0.19),(float)(oy+dy-this.carHeight*3.123),(float)(cx+this.axleDistance*0.204),(float)(oy+dy-this.carHeight*3.1));
        headWindow.moveTo((float)(headWindow_Chrome.getCurrentPoint().getX()),(float)(headWindow_Chrome.getCurrentPoint().getY()));
        headWindow_Chrome.quadTo((float)(cx+this.axleDistance*0.212),(float)(oy+dy-this.carHeight*3.08),(float)(cx+this.axleDistance*0.212),(float)(oy+dy-this.carHeight*3.02));
        
        
        
        headWindow_Chrome.quadTo((float)(cx+this.axleDistance*0.1795),(float)(oy+dy-this.carHeight*3.05),(float)(cx+this.axleDistance*0.1795),(float)(oy+dy-this.carHeight*2.9));
        headWindow_Chrome.lineTo((float)(cx+this.axleDistance*0.1795),(float)(oy+dy-this.carHeight*2.25));
        headWindow_Chrome.quadTo((float)(cx+this.axleDistance*0.185),(float)(oy+dy-this.carHeight*2.15),(float)(cx+this.axleDistance/2-this.carHeight*1.15),(float)(oy+dy-this.carHeight*2.35));
        headWindow.lineTo((float)(headWindow_Chrome.getCurrentPoint().getX()),(float)(headWindow_Chrome.getCurrentPoint().getY()));
        headWindow_Chrome.quadTo((float)(cx+this.axleDistance/2-this.carHeight*1.1),(float)(oy+dy-this.carHeight*2.33),(float)(cx+this.axleDistance/2-this.carHeight),(float)(oy+dy-this.carHeight*2.26));
        
        
        
        
        headWindow.lineTo((float)(cx+this.axleDistance*0.165),(float)(oy+dy-this.carHeight));
        
        headWindow.lineTo((float)(cx+this.axleDistance*0.165),(float)(oy+dy-this.carHeight*3.1));
        g2.setPaint(new Color(0,0,255,8));
        g2.fill(headWindow);
        g2.setPaint(Color.black);
        g2.draw(headWindow);
        
        
        GradientPaint gp2 = new GradientPaint((float)(cx),(float)(oy+dy-this.carHeight*3.1),Color.white,(float)(cx),(float)(oy+dy-this.carHeight*2.7),Color.lightGray,true);
        g2.setPaint(gp2);
        g2.fill(headWindow_Chrome);
        
        g2.setPaint(Color.black);
        g2.draw(headWindow_Chrome);
        
        
        
        //desenho dos vidros das janelas lateriais caso o carro  nao seja um descapotavel
        if(this.model!=2){
            
            GeneralPath pane = new GeneralPath();
            //desenho dos vidros das janelas
            if(this.model==1){
                
                pane.moveTo((float)(cx-this.axleDistance*0.53),(float)(oy+dy-this.carHeight*2.4));
                pane.lineTo((float)(cx-this.axleDistance*0.43),(float)(oy+dy-this.carHeight*3));
                pane.lineTo((float)(cx-this.axleDistance*0.33),(float)(oy+dy-this.carHeight*3.1));
                pane.lineTo((float)(cx+this.axleDistance*0.07),(float)(oy+dy-this.carHeight*3.1));
                pane.lineTo((float)(cx+this.axleDistance*0.07),(float)(oy+dy-this.carHeight*2.1));
                pane.lineTo((float)(cx-this.axleDistance*0.52),(float)(oy+dy-this.carHeight*2.1));
                pane.closePath();
            }
            else{
                pane.moveTo((float)(cx-this.axleDistance*0.473-this.rearWidth),(float)(oy+dy-this.carHeight*2.1));
                pane.lineTo((float)(cx-this.axleDistance*0.45-this.rearWidth),(float)(oy+dy-this.carHeight*3.1));
                pane.lineTo((float)(cx-this.axleDistance*0.33),(float)(oy+dy-this.carHeight*3.1));
                pane.lineTo((float)(cx+this.axleDistance*0.07),(float)(oy+dy-this.carHeight*3.1));
                pane.lineTo((float)(cx+this.axleDistance*0.07),(float)(oy+dy-this.carHeight*2.1));
                pane.lineTo((float)(cx-this.axleDistance*0.52),(float)(oy+dy-this.carHeight*2.1));
                pane.closePath();
                
            }
            
            
            g2.setPaint(new Color(0,0,255,8));
            g2.fill(pane);
            g2.setPaint(Color.black);
            g2.draw(pane);
        }
        
        
        
    }
    
    private void smallSideWindow(Graphics2D g2){
        
        
         Stroke traço = new BasicStroke((float)(axleDistance*0.002));
       g2.setStroke(traço);
        
        GeneralPath smallSideWindow = new GeneralPath();
        
        //neste caso a pequena janela lateral será diferente caso o carro seja descapotavel 
        if(this.model!=2){
            smallSideWindow.moveTo((float)(cx+this.axleDistance*0.145),(float)(oy+dy-this.carHeight*3.05));
            smallSideWindow.lineTo((float)(cx+this.axleDistance*0.145),(float)(oy+dy-this.carHeight*2.1));
            smallSideWindow.lineTo((float)(cx+this.axleDistance*0.081),(float)(oy+dy-this.carHeight*2.1));
            smallSideWindow.lineTo((float)(cx+this.axleDistance*0.081),(float)(oy+dy-this.carHeight*2.17));
            smallSideWindow.lineTo((float)(cx+this.axleDistance*0.126),(float)(oy+dy-this.carHeight*2.17));
            smallSideWindow.quadTo((float)(cx+this.axleDistance*0.132),(float)(oy+dy-this.carHeight*2.17),(float)(cx+this.axleDistance*0.132),(float)(oy+dy-this.carHeight*2.27));
            smallSideWindow.lineTo((float)(cx+this.axleDistance*0.132),(float)(oy+dy-this.carHeight*2.93));
            smallSideWindow.quadTo((float)(cx+this.axleDistance*0.132),(float)(oy+dy-this.carHeight*3.002),(float)(cx+this.axleDistance*0.126),(float)(oy+dy-this.carHeight*3));
            smallSideWindow.lineTo((float)(cx+this.axleDistance*0.081),(float)(oy+dy-this.carHeight*3));
            smallSideWindow.lineTo((float)(cx+this.axleDistance*0.081),(float)(oy+dy-this.carHeight*3.05));
            smallSideWindow.closePath();}
        else{
            
            smallSideWindow.moveTo((float)(cx+this.axleDistance*0.145),(float)(oy+dy-this.carHeight*3.1));
            smallSideWindow.lineTo((float)(cx+this.axleDistance*0.145),(float)(oy+dy-this.carHeight*2.1));
            smallSideWindow.lineTo((float)(cx+this.axleDistance*0.081),(float)(oy+dy-this.carHeight*2.1));
            smallSideWindow.lineTo((float)(cx+this.axleDistance*0.081),(float)(oy+dy-this.carHeight*2.17));
            smallSideWindow.lineTo((float)(cx+this.axleDistance*0.126),(float)(oy+dy-this.carHeight*2.17));
            smallSideWindow.quadTo((float)(cx+this.axleDistance*0.132),(float)(oy+dy-this.carHeight*2.17),(float)(cx+this.axleDistance*0.132),(float)(oy+dy-this.carHeight*2.27));
            smallSideWindow.lineTo((float)(cx+this.axleDistance*0.132),(float)(oy+dy-this.carHeight*2.93));
            smallSideWindow.quadTo((float)(cx+this.axleDistance*0.132),(float)(oy+dy-this.carHeight*2.98),(float)(cx+this.axleDistance*0.126),(float)(oy+dy-this.carHeight*3.03));
            smallSideWindow.lineTo((float)(cx+this.axleDistance*0.081),(float)(oy+dy-this.carHeight*3.03));
            smallSideWindow.lineTo((float)(cx+this.axleDistance*0.081),(float)(oy+dy-this.carHeight*3.1));
            smallSideWindow.closePath();
            
            
        }
        
        Rectangle2D pane = new Rectangle2D.Double((float)(cx+this.axleDistance*0.081),(float)(oy+dy-this.carHeight*3.1),this.axleDistance*0.081,this.axleDistance*0.27);
        g2.setPaint(new Color(0,0,255,8));
        g2.fill(pane);
        g2.setPaint(Color.black);
        g2.draw(pane);
        
        
        Shape supvidro = new Rectangle2D.Double((float)(cx+this.axleDistance*0.071),(float)(oy+dy-this.carHeight*3.1),this.axleDistance*0.0115,this.axleDistance*0.27);
        
        Shape armvidro = (Shape)smallSideWindow;
        Area area1 = new Area(armvidro);
        Area area2 = new Area(supvidro);
        area1.add(area2);
        
        GradientPaint gp2 = new GradientPaint((float)(cx),(float)(oy+dy-this.carHeight*3.1),Color.white,(float)(cx),(float)(oy+dy-this.carHeight*2.8),Color.lightGray,true);
        g2.setPaint(gp2);
        g2.fill(area1);
        g2.setPaint(Color.black);
        g2.draw(area1);
        
        
        
    }
    
    
    private void roof(Graphics2D g2){
        
        // desenho do tejadilho
        
        GeneralPath roof = new GeneralPath();
        roof.moveTo((float)(cx+this.axleDistance*0.188),(float)(oy+dy-this.carHeight*3.1));
        
        //caso o carro seja um station wagon , o tejadilho será diferente
        if(this.model==1){
            roof.lineTo((float)(cx-this.axleDistance*0.075),(float)(oy+dy-this.carHeight*3.1));
            roof.quadTo((float)(cx-this.axleDistance*0.295),(float)(oy+dy-this.carHeight*3.1),(float)(cx-this.axleDistance*0.37),(float)(oy+dy-this.carHeight*2.5));
            roof.quadTo((float)(cx-this.axleDistance*0.42),(float)(oy+dy-this.carHeight*2.1),(float)(cx-this.axleDistance*0.35),(float)(oy+dy-this.carHeight*2.1));
            roof.lineTo((float)(cx-this.axleDistance*0.47),(float)(oy+dy-this.carHeight*2.1));
            roof.quadTo((float)(cx-this.axleDistance*0.4),(float)(oy+dy-this.carHeight*2.4),(float)(cx-this.axleDistance*0.35),(float)(oy+dy-this.carHeight*2.7));
            roof.quadTo((float)(cx-this.axleDistance*0.43),(float)(oy+dy-this.carHeight*2.9),(float)(cx-this.axleDistance*0.43),(float)(oy+dy-this.carHeight*3));
            roof.quadTo((float)(cx-this.axleDistance*0.3),(float)(oy+dy-this.carHeight*3.4),(float)(cx+this.axleDistance*0.1),(float)(oy+dy-this.carHeight*3.34));
            roof.quadTo((float)(cx+this.axleDistance*0.188),(float)(oy+dy-this.carHeight*3.33),(float)(cx+this.axleDistance*0.20532),(float)(oy+dy-this.carHeight*3.1));
            roof.closePath();
        }
        else{
            roof.lineTo((float)(cx-this.axleDistance*0.45-this.rearWidth),(float)(oy+dy-this.carHeight*3.1));
            roof.quadTo((float)(cx-this.axleDistance*0.39-this.rearWidth),(float)(oy+dy-this.carHeight*3.34),(float)(cx-this.axleDistance*0.35-this.rearWidth),(float)(oy+dy-this.carHeight*3.34));
            roof.lineTo((float)(cx+this.axleDistance*0.1),(float)(oy+dy-this.carHeight*3.34));
            roof.quadTo((float)(cx+this.axleDistance*0.188),(float)(oy+dy-this.carHeight*3.33),(float)(cx+this.axleDistance*0.20532),(float)(oy+dy-this.carHeight*3.1));
            
        }
        
        g2.setPaint(colors[3]);
        g2.fill(roof);
        g2.setPaint(Color.black);
        g2.draw(roof);
        
        
        
        
        
    }
    
    private void rearWindow(Graphics2D g2){
        
        
        GeneralPath rearWindowChrome = new GeneralPath();
        GeneralPath trunk = new GeneralPath();
        
        if(this.model==1){
            
            rearWindowChrome.moveTo((float)(cx-this.axleDistance*0.35),(float)(oy+dy-this.carHeight*2.7));
            rearWindowChrome.quadTo((float)(cx-this.axleDistance*0.43),(float)(oy+dy-this.carHeight*2.9),(float)(cx-this.axleDistance*0.43),(float)(oy+dy-this.carHeight*3));
            rearWindowChrome.quadTo((float)(cx-this.axleDistance*0.43),(float)(oy+dy-this.carHeight*2.98),(float)(cx-this.axleDistance*0.441),(float)(oy+dy-this.carHeight*2.95));
            rearWindowChrome.quadTo((float)(cx-this.axleDistance*0.43),(float)(oy+dy-this.carHeight*2.81),(float)(cx-this.axleDistance*0.38),(float)(oy+dy-this.carHeight*2.672));
            rearWindowChrome.quadTo((float)(cx-this.axleDistance*0.395),(float)(oy+dy-this.carHeight*2.6),(float)(cx-this.axleDistance*0.46),(float)(oy+dy-this.carHeight*2.3));
            rearWindowChrome.quadTo((float)(cx-this.axleDistance*0.53),(float)(oy+dy-this.carHeight*2.3),(float)(cx-this.axleDistance*0.53),(float)(oy+dy-this.carHeight*2.4));
            rearWindowChrome.quadTo((float)(cx-this.axleDistance*0.55),(float)(oy+dy-this.carHeight*2.3),(float)(cx-this.axleDistance*0.53),(float)(oy+dy-this.carHeight*2.23));
            rearWindowChrome.quadTo((float)(cx-this.axleDistance*0.5),(float)(oy+dy-this.carHeight*2.17),(float)(cx-this.axleDistance*0.421),(float)(oy+dy-this.carHeight*2.2));
            rearWindowChrome.closePath();
            
            
            trunk.moveTo((float)(cx-this.axleDistance*0.53),(float)(oy+dy-this.carHeight*2.331));
            trunk.lineTo((float)(cx-this.axleDistance*0.7-this.rearWidth*0.5),(float)(oy+dy-this.carHeight*2.1));
            trunk.lineTo((float)(cx-this.axleDistance*0.4),(float)(oy+dy-this.carHeight*2));
            trunk.lineTo((float)(cx-this.axleDistance*0.4),(float)(oy+dy-this.carHeight*2.18));
            trunk.closePath();
            
        }
        
        
        
        
        //diferentes tipos de preenchimento conforme o flame escolhido
        if(this.typeFlame==0 || this.typeFlame==3 || this.typeFlame==5 )
            g2.setPaint(colors[0]);
        else
            g2.setPaint(colors[1]);
        
        g2.fill(trunk);
        g2.setPaint(Color.black);
        g2.draw(trunk);
        
        GradientPaint gp2 = new GradientPaint((float)(cx),(float)(oy+dy-this.carHeight*3.1),Color.white,(float)(cx),(float)(oy+dy-this.carHeight*2.9),Color.lightGray,true);
        g2.setPaint(gp2);
        g2.fill(rearWindowChrome);
        g2.setPaint(Color.black);
        g2.draw(rearWindowChrome);
        
        
        
        
        
        
    }
    
    private void backSeat(Graphics2D g2){
        
        //desenho do assento de trunk caso o carro seja descapotavel
        
        GeneralPath trunk = new GeneralPath();
        trunk.moveTo((float)(cx-this.axleDistance*0.55),(float)(oy+dy-this.carHeight*2.331));
        trunk.lineTo((float)(cx-this.axleDistance*0.7-this.rearWidth*0.5),(float)(oy+dy-this.carHeight*2.1));
        trunk.lineTo((float)(cx-this.axleDistance*0.5),(float)(oy+dy-this.carHeight*2));
        trunk.lineTo((float)(cx-this.axleDistance*0.46),(float)(oy+dy-this.carHeight*2.18));
        trunk.closePath();
        
        GeneralPath backSeat = new GeneralPath();
        backSeat.moveTo((float)(cx-this.axleDistance*0.35),(float)(oy+dy-this.carHeight*2));
        backSeat.quadTo((float)(cx-this.axleDistance*0.35),(float)(oy+dy-this.carHeight*2.34),(float)(cx-this.axleDistance*0.4),(float)(oy+dy-this.carHeight*2.34));
        backSeat.lineTo((float)(cx-this.axleDistance*0.55),(float)(oy+dy-this.carHeight*2.34));
        backSeat.quadTo((float)(cx-this.axleDistance*0.56),(float)(oy+dy-this.carHeight*2.37),(float)(cx-this.axleDistance*0.58),(float)(oy+dy-this.carHeight*2.4));
        
        backSeat.quadTo((float)(cx-this.axleDistance*0.6),(float)(oy+dy-this.carHeight*2.3),(float)(cx-this.axleDistance*0.59),(float)(oy+dy-this.carHeight*2.23));
        backSeat.quadTo((float)(cx-this.axleDistance*0.59),(float)(oy+dy-this.carHeight*2.1),(float)(cx-this.axleDistance*0.51),(float)(oy+dy-this.carHeight*2.1));
        backSeat.closePath();
        
        if(this.typeFlame==0 || this.typeFlame==3 || this.typeFlame==5 )
            g2.setPaint(colors[0]);
        else
            g2.setPaint(colors[1]);
        
        g2.fill(trunk);
        g2.setPaint(Color.black);
        g2.draw(trunk);
        
        g2.setPaint(colors[0]);
        g2.fill(backSeat);
        g2.setPaint(Color.black);
        g2.draw(backSeat);
        
        
    }
    
    private void stands(Graphics2D g2){
        
        //desenho dos suportes do carro
        
        Stroke traco = new BasicStroke((float)(1));
        g2.setStroke(traco);
        Shape standsupwagon;
        Shape headStand= new Rectangle2D.Double(cx+this.axleDistance*0.145,oy+dy-this.carHeight*3.1,this.axleDistance*0.020,this.axleDistance*0.19);
        
        standsupwagon= new Rectangle2D.Double(cx-this.axleDistance*0.45-this.rearWidth,oy+dy-this.carHeight*3.1,this.axleDistance*0.6+this.rearWidth,this.axleDistance*0.009);
        
        if(this.model==1)
            standsupwagon= new Rectangle2D.Double(cx-this.axleDistance*0.115,oy+dy-this.carHeight*3.1,this.axleDistance*0.26,this.axleDistance*0.009);
        
        GeneralPath rearStand = new GeneralPath();
        GeneralPath rearWagonStand = new GeneralPath();
        
        
        // os suportes trunkeiros são difentes conforme o modelo do carro
        
        if(this.model==1){
            
            rearStand.moveTo((float)(cx-this.axleDistance*0.3),(float)(oy+dy-this.carHeight*2.1));
            rearStand.lineTo((float)(cx-this.axleDistance*0.47),(float)(oy+dy-this.carHeight*2.1));
            rearStand.quadTo((float)(cx-this.axleDistance*0.4),(float)(oy+dy-this.carHeight*2.5),(float)(cx-this.axleDistance*0.35),(float)(oy+dy-this.carHeight*2.7));
            rearStand.quadTo((float)(cx-this.axleDistance*0.25),(float)(oy+dy-this.carHeight*3.1),(float)(cx-this.axleDistance*0.121),(float)(oy+dy-this.carHeight*3.1));
            rearStand.lineTo((float)(cx-this.axleDistance*0.121),(float)(oy+dy-this.carHeight*3.05));
            rearStand.quadTo((float)(cx-this.axleDistance*0.25),(float)(oy+dy-this.carHeight*3.05),(float)(cx-this.axleDistance*0.33),(float)(oy+dy-this.carHeight*2.7));
            rearStand.quadTo((float)(cx-this.axleDistance*0.42),(float)(oy+dy-this.carHeight*2.33),(float)(cx-this.axleDistance*0.36),(float)(oy+dy-this.carHeight*2.1));
            rearStand.closePath();
        }
        
        
        
        if(this.model==3){
            
            rearStand.moveTo((float)(cx-this.axleDistance*0.43),(float)(oy+dy-this.carHeight*2.1));
            rearStand.lineTo((float)(cx-this.axleDistance*0.46),(float)(oy+dy-this.carHeight*2.1));
            rearStand.lineTo((float)(cx-this.axleDistance*0.4),(float)(oy+dy-this.carHeight*3.1));
            rearStand.lineTo((float)(cx-this.axleDistance*0.37),(float)(oy+dy-this.carHeight*3.1));
            
            rearWagonStand.moveTo((float)(cx-this.axleDistance*0.45-this.rearWidth),(float)(oy+dy-this.carHeight*3.1));
            rearWagonStand.lineTo((float)(cx-this.axleDistance*0.51-this.rearWidth),(float)(oy+dy-this.carHeight*2.1));
            rearWagonStand.lineTo((float)(cx-this.axleDistance*0.47-this.rearWidth),(float)(oy+dy-this.carHeight*2.1));
            rearWagonStand.lineTo((float)(cx-this.axleDistance*0.41-this.rearWidth),(float)(oy+dy-this.carHeight*3.1));
            
        }
        
        //stands
        Stroke traço = new BasicStroke((float)(this.axleDistance*0.001));
        g2.setStroke(traço);
        
        //suporte da frente
        
        Shape aa = (Shape)(rearStand);
        Shape st = (Shape)(rearWagonStand);
        Area areasuportefrente = new Area(headStand);
        Area sabrang = new Area(aa);
        Area suportetottrunk = new Area(st);
        Area suportetottrunk2 = new Area(standsupwagon);
        sabrang.add(areasuportefrente);
        sabrang.add(suportetottrunk2);
        
        
        if(this.model==3)
            sabrang.add(suportetottrunk);
        
        
        if(this.model==2){
            g2.setPaint(colors[2]);
            g2.fill(headStand);
            g2.setPaint(Color.black);
            g2.draw(headStand);
            
        }
        
        
        
        
        //middleStand
        if(this.model!=2){
            Shape middleStand= new Rectangle2D.Double(cx-this.axleDistance*0.11,oy+dy-this.carHeight*3.1,this.axleDistance*0.015,this.axleDistance*0.19);
            
            g2.setPaint(colors[2]);
            g2.fill(middleStand);
            g2.setPaint(Color.darkGray);
            g2.draw(middleStand);
            middleStand= new Rectangle2D.Double(cx-this.axleDistance*0.125,oy+dy-this.carHeight*3.1,this.axleDistance*0.015,this.axleDistance*0.19);
            Area s2 = new Area(middleStand);
            sabrang.add(s2);
            
            if(this.numDoors==5){
                middleStand= new Rectangle2D.Double(cx-this.axleDistance*0.135,oy+dy-this.carHeight*3.1,this.axleDistance*0.015,this.axleDistance*0.19);
                s2 = new Area(middleStand);
                sabrang.add(s2);
                
            }
            
            if(this.numDoors==5){
                g2.setPaint(Color.black);
                g2.draw(middleStand);
            }
            
            
            g2.setPaint(colors[2]);
            g2.fill(sabrang);
            g2.setPaint(Color.black);
            g2.draw(sabrang);
            
            
        }
        
        if(this.model==3){
            GeneralPath trunk = new GeneralPath();
            trunk.moveTo((float)(cx-this.axleDistance*0.5195-this.rearWidth),(float)(oy+dy-this.carHeight*2.1));
            trunk.lineTo((float)(cx-this.axleDistance*0.501-this.rearWidth),(float)(oy+dy-this.carHeight*2.2));
            trunk.lineTo((float)(cx-this.axleDistance*0.1),(float)(oy+dy-this.carHeight*2.1));
            trunk.lineTo((float)(cx-this.axleDistance*0.1),(float)(oy+dy-this.carHeight*2.1));
            g2.setPaint(colors[0]);
            g2.fill(trunk);
            g2.setPaint(Color.black);
            g2.draw(trunk);
            
            
        }
        
        
    }
    
    
    
    private void capot(Graphics2D g2){
        
        //desenho do capot
        
        GeneralPath capot = new GeneralPath();
        capot.moveTo((float)(cx+this.axleDistance/2+this.carHeight*0.7+this.headWidth),(float)(oy+dy-this.carHeight*2));
        capot.quadTo((float)(cx+this.axleDistance/2+this.carHeight*0.7+this.headWidth),(float)(oy+dy-this.carHeight*2.235),(float)(cx+this.axleDistance/2+this.carHeight*0.7-this.headWidth*0.2),(float)(oy+dy-this.carHeight*2.24));
        capot.lineTo((float)(cx+this.axleDistance/2-this.carHeight),(float)(oy+dy-this.carHeight*2.26));
        capot.quadTo((float)(cx+this.axleDistance/2-this.carHeight*1.1),(float)(oy+dy-this.carHeight*2.2),(float)(cx+this.axleDistance/2-this.carHeight*2.3),(float)(oy+dy-this.carHeight*2));
        capot.closePath();
        
        if(this.typeFlame==0 || this.typeFlame==3 || this.typeFlame==4 || this.typeFlame==5  )
            g2.setPaint(colors[0]);
        else
            g2.setPaint(colors[1]);
        
        g2.fill(capot);
        g2.setPaint(Color.black);
        g2.draw(capot);
        
        
    }
    
    
    
   
        
    private void wheels(Graphics2D g2,double cx,double cy){
        
        
        Stroke traço = new BasicStroke((float)0.5);
        g2.setStroke(traço);
        
        
        double raio2 = this.radiusWheel*0.85;
        double raio3 = this.radiusWheel*0.25;
        double raio4 = this.radiusWheel*0.63;
        double raio5 = this.radiusWheel*0.35;
        double raio6 = this.radiusWheel*0.1;
        cy = cy-this.radiusWheel;
        
        //pneu
        Ellipse2D pneu = new Ellipse2D.Double(cx-this.radiusWheel,cy-this.radiusWheel,this.radiusWheel*2,this.radiusWheel*2);
        
        g2.setPaint(Color.black);
        g2.fill(pneu);
        
        //parte branca do pneu
        
        Ellipse2D riscaBranca = new Ellipse2D.Double(cx-raio2,cy-raio2,raio2*2,raio2*2);
        g2.setPaint(Color.white);
        g2.fill(riscaBranca);
        
        //parte preta centro fora
        GradientPaint gp1 = new GradientPaint((float)(cx),(float)(cy-raio4),Color.white,(float)(cx),(float)(cy+raio4*0.1),Color.lightGray,true);
        Ellipse2D centrofora = new Ellipse2D.Double(cx-raio4,cy-raio4,raio4*2,raio4*2);
        g2.setPaint(gp1);
        g2.fill(centrofora);
        
        
        
        if(this.typeWheel==0 || this.typeWheel==2 || this.typeWheel>=5){
            traço = new BasicStroke((float)(raio4*0.11));
            g2.setStroke(traço);
            gp1 = new GradientPaint((float)(cx),(float)(cy-raio4),Color.lightGray,(float)(cx),(float)(cy+raio4*0.6),Color.darkGray,true);
            g2.setPaint(gp1);
            
        }
        
        if(this.typeWheel==1){
            traço = new BasicStroke((float)(raio4*0.11));
            g2.setStroke(traço);
            gp1 = new GradientPaint((float)(cx),(float)(cy-raio4),colors[0],(float)(cx),(float)(cy+raio4*0.6),new Color(colors[0].getRed()-20,colors[0].getGreen()-20,colors[0].getBlue()-20,150),true);
            g2.setPaint(gp1);
            
        }
        
        if(this.typeWheel==3 || this.typeWheel==4){
            traço = new BasicStroke((float)(raio4*0.3));
            g2.setStroke(traço);
            gp1 = new GradientPaint((float)(cx),(float)(cy-raio4),colors[0],(float)(cx),(float)(cy+raio4*0.6),new Color(colors[0].getRed()-20,colors[0].getGreen()-20,colors[0].getBlue()-20,150),true);
            g2.setPaint(gp1);
            
            
        }
        
        
        g2.draw(centrofora);
        
        traço = new BasicStroke((float)1.5);
        g2.setStroke(traço);
        raio4=raio4*0.9;
        gp1 = new GradientPaint((float)(cx),(float)(cy-raio4),Color.lightGray,(float)(cx),(float)(cy+raio4*0.3),new Color(130,130,130),true);
        centrofora = new Ellipse2D.Double(cx-raio4,cy-raio4,raio4*2,raio4*2);
        g2.setPaint(gp1);
        g2.draw(centrofora);
        
        
        raio4=raio4*0.9;
        gp1 = new GradientPaint((float)(cx),(float)(cy-raio4),Color.lightGray,(float)(cx),(float)(cy+raio4*0.04),new Color(130,130,130),true);
        centrofora = new Ellipse2D.Double(cx-raio4,cy-raio4,raio4*2,raio4*2);
        g2.setPaint(gp1);
        g2.draw(centrofora);
        
        
        
        g2.setPaint(Color.darkGray);
        
        
        
        if(this.typeWheel>=5){
            traço = new BasicStroke((float)0.5);
            g2.setStroke(traço);
            double passo = 2*Math.PI/(40);
            double ang;
            double ax,ay,bx,by,width,dy;
            
            for(ang=0;ang<=2*Math.PI-.01;ang+=passo){
                if(this.typeWheel!=7 && this.typeWheel!=10){
                    g2.setPaint(Color.lightGray);
                    bx = cx + raio4 * Math.cos(ang-passo*4);
                    by = cy + raio4 * Math.sin(ang-passo*4);
                    Line2D l = new Line2D.Double(cx,cy,bx,by);
                    g2.draw(l);
                }
                if(this.typeWheel==7){
                    //cruzado
                    g2.setPaint(new Color(90,90,90));
                    double auxx,auxy,auxx2,auxy2,ex,ey,ex2,ey2;
                    auxx =cx + raio3* Math.cos(ang-passo);
                    auxy =cy + raio3* Math.sin(ang-passo);
                    auxx2 =cx + raio3* Math.cos(ang+passo);
                    auxy2 =cy + raio3* Math.sin(ang+passo);
                    ex = cx + raio4* Math.cos(ang-passo);
                    ey = cy + raio4*Math.sin(ang-passo);
                    ex2 = cx + raio4* Math.cos(ang+passo);
                    ey2 = cy + raio4*Math.sin(ang+passo);
                    
                    
                    Line2D l = new Line2D.Double(auxx,auxy,ex2,ey2);
                    g2.draw(l);
                    
                    
                    l = new Line2D.Double(auxx2,auxy2,ex,ey);
                    g2.draw(l);
                    
                }
                if (this.typeWheel == 8) {
                    ax = cx + raio4*0.8 * Math.cos(ang-passo*4);
                    ay = cy + raio4*0.8 * Math.sin(ang-passo*4);
                    Ellipse2D bolitas = new Ellipse2D.Double(ax-raio4*0.1,ay-raio4*0.1,raio4*0.1*2,raio4*0.1*2);
                    g2.setPaint(new Color(80,80,80));
                    g2.fill(bolitas);
                    g2.setPaint(Color.lightGray);
                    g2.draw(bolitas);
                    
                    
                }
                
                
                if (this.typeWheel == 9) {
                    
                    ax = cx + raio4*0.8 * Math.cos(ang-passo*4);
                    ay = cy + raio4*0.8 * Math.sin(ang-passo*4);
                    Rectangle2D quadraditos = new Rectangle2D.Double(ax-raio4*0.05,ay-raio4*0.05,raio4*0.1,raio4*0.1);
                    g2.setPaint(new Color(80,80,80));
                    g2.fill(quadraditos);
                    g2.setPaint(Color.lightGray);
                    g2.draw(quadraditos);
                    
                    
                }
                
            }
            
        }
        //parte preta centro interno
        
        
        traço = new BasicStroke((float)0.5);
        g2.setStroke(traço);
        //parte centro do pneu
        Ellipse2D centro = new Ellipse2D.Double(cx-raio3,cy-raio3,raio3*2,raio3*2);
        
        
        gp1 = new GradientPaint((float)(cx),(float)(cy-raio3),Color.white,(float)(cx),(float)(cy+raio3*0.1),Color.lightGray,true);
        
        if(this.typeWheel==4)
            gp1 = new GradientPaint((float)(cx),(float)(cy-raio3),colors[0],(float)(cx),(float)(cy+raio3*0.1),new Color(colors[0].getRed(),colors[0].getGreen(),colors[0].getBlue(),80),true);
        
        
        g2.setPaint(gp1);
        g2.fill(centro);
        traço = new BasicStroke((float)1);
        g2.setStroke(traço);
        g2.setPaint(new Color(0,0,0,50));
        g2.draw(centro);
        
        
        raio4=raio4*0.15;
        
        if (this.typeWheel!=2)
            gp1 = new GradientPaint((float)(cx),(float)(cy-raio4),Color.lightGray,(float)(cx),(float)(cy+raio4*0.04),colors[0],true);
        else
            gp1 = new GradientPaint((float)(cx),(float)(cy-raio4),Color.lightGray,(float)(cx),(float)(cy+raio4*0.04),Color.darkGray,true);
        
        if(this.typeWheel!=5){
            
            Ellipse2D circuloPequeno = new Ellipse2D.Double(cx-raio4,cy-raio4,raio4*2,raio4*2);
            
            if(this.typeWheel==4 || this.typeWheel>=6)
                gp1 = new GradientPaint((float)(cx),(float)(cy-raio4),Color.lightGray,(float)(cx),(float)(cy+raio4*0.06),Color.lightGray,true);
            
            g2.setPaint(gp1);
            g2.fill(circuloPequeno);
            g2.setColor(new Color(90,90,90));
            g2.draw(circuloPequeno);
        }
        
    }
    
    
    private void handle(double cx,double cy,Graphics2D g2,int n){
        
        //desenho do handle
        
        GeneralPath handle = new GeneralPath();
        handle.moveTo((float)(cx-this.axleDistance*0.11),(float)(oy+dy-this.carHeight*1.92));
        handle.quadTo((float)(cx-this.axleDistance*0.115),(float)(oy+dy-this.carHeight*1.87),(float)(cx-this.axleDistance*0.10),(float)(oy+dy-this.carHeight*1.84));
        handle.lineTo((float)(cx-this.axleDistance*0.095),(float)(oy+dy-this.carHeight*1.87));
        handle.quadTo((float)(cx-this.axleDistance*0.065),(float)(oy+dy-this.carHeight*1.9),(float)(cx-this.axleDistance*0.038),(float)(oy+dy-this.carHeight*1.87));
        handle.quadTo((float)(cx-this.axleDistance*0.036),(float)(oy+dy-this.carHeight*1.88),(float)(cx-this.axleDistance*0.038),(float)(oy+dy-this.carHeight*1.9));
        handle.quadTo((float)(cx-this.axleDistance*0.065),(float)(oy+dy-this.carHeight*1.925),(float)(cx-this.axleDistance*0.11),(float)(oy+dy-this.carHeight*1.92));
        Ellipse2D lock = new Ellipse2D.Double((float)(cx-this.axleDistance*0.105),(float)(oy+dy-this.carHeight*1.78),this.axleDistance*0.01,this.axleDistance*0.01);
        
        
        GradientPaint gp1 = new GradientPaint((float)(cx-this.axleDistance*0.11),(float)(oy+dy-this.carHeight*1.92),Color.white,(float)(cx-this.axleDistance*0.11),(float)(oy+dy-this.carHeight*1.87),Color.lightGray,true);
        // GradientPaint gp2 = new GradientPaint((float)(rearX-rearBumperWidth),(float)(rearY-rearBumperHeight*0.3),Color.darkGray,(float)(rearX-rearBumperWidth),(float)(rearY-rearBumperHeight),Color.white,true);
        g2.setPaint(gp1);
        if(n==1)
            g2.fill(lock);
        
        g2.fill(handle);
        g2.setPaint(Color.darkGray);
        g2.draw(handle);
        
        if(n==1)
            g2.draw(lock);
    }
    
    private void doors(Graphics2D g2){
        //desenho das portas e respectivos handles
        
        
        Stroke traço = new BasicStroke((float)1);
        g2.setStroke(traço);
        
        //chamar metodo handle
        handle(cx+this.axleDistance*0.025,cy,g2,1);
        
        
        GeneralPath frontDoor = new GeneralPath();
        frontDoor.moveTo((float)(cx-this.axleDistance*0.11),(float)(oy+dy-this.carHeight*2.12));
        frontDoor.lineTo((float)(cx+this.axleDistance*0.24),(float)(oy+dy-this.carHeight*2.12));
        frontDoor.quadTo((float)(cx+this.axleDistance*0.272),(float)(oy+dy-this.carHeight*1.94),(float)(cx+this.axleDistance*0.272),(float)(oy+dy-this.carHeight*1.82));
        frontDoor.quadTo((float)(cx+this.axleDistance*0.28),(float)(oy+dy-this.carHeight*1.4),(float)(cx+this.axleDistance*0.27),(float)(oy+dy-this.carHeight*0.49));
        frontDoor.quadTo((float)(cx+this.axleDistance*0.272),(float)(oy+dy-this.carHeight*0.48),(float)(cx+this.axleDistance*0.262),(float)(oy+dy-this.carHeight*0.45));
        frontDoor.lineTo((float)(cx-this.axleDistance*0.11),(float)(oy+dy-this.carHeight*0.45));
        frontDoor.quadTo((float)(cx-this.axleDistance*0.11),(float)(oy+dy-this.carHeight*0.45),(float)(cx-this.axleDistance*0.11),(float)(oy+dy-this.carHeight*0.49));
        frontDoor.quadTo((float)(cx-this.axleDistance*0.11),(float)(oy+dy-this.carHeight*1.4),(float)(cx-this.axleDistance*0.11),(float)(oy+dy-this.carHeight*2.12));
        frontDoor.closePath();
        g2.setPaint(new Color(0,0,0,60));
        g2.draw(frontDoor);
        
        
        
        //verficar se o modelo em causa possui 5 portas
        if(this.numDoors==5){
            
            handle(cx-this.axleDistance*0.32,cy,g2,2);
            GeneralPath trunkDoor = new GeneralPath();
            trunkDoor.moveTo((float)(cx-this.axleDistance*0.46),(float)(oy+dy-this.carHeight*2.12));
            trunkDoor.lineTo((float)(cx-this.axleDistance*0.12),(float)(oy+dy-this.carHeight*2.12));
            trunkDoor.quadTo((float)(cx-this.axleDistance*0.121),(float)(oy+dy-this.carHeight*1.4),(float)(cx-this.axleDistance*0.12),(float)(oy+dy-this.carHeight*0.45));
            trunkDoor.lineTo((float)(rearFenderAuxBackDoor[0].getX()+this.axleDistance*0.02),(float)(oy+dy-this.carHeight*0.45));
            if(this.typeRearFender==1)
                trunkDoor.quadTo((float)(rearFenderAuxBackDoor[1].getX()+this.axleDistance*0.005),(float)(rearFenderAuxBackDoor[1].getY()-this.axleDistance*0.03),(float)(cx-this.axleDistance*0.46),(float)(rearFenderAuxBackDoor[1].getY()-this.axleDistance*0.03));
            else{
                
                if(this.rearFenderHeight>2)
                    trunkDoor.quadTo((float)(rearFenderAuxBackDoor[1].getX()+this.axleDistance*0.005),(float)(rearFenderAuxBackDoor[1].getY()+this.axleDistance*0.05),(float)(cx-this.axleDistance*0.46),(float)(rearFenderAuxBackDoor[1].getY()+this.axleDistance*0.05));
                else
                    trunkDoor.quadTo((float)(rearFenderAuxBackDoor[1].getX()+this.axleDistance*0.005),(float)(rearFenderAuxBackDoor[1].getY()+this.axleDistance*0.015),(float)(cx-this.axleDistance*0.46),(float)(rearFenderAuxBackDoor[1].getY()+this.axleDistance*0.015));
                
            }
            trunkDoor.quadTo((float)(cx-this.axleDistance*0.465),(float)(oy+dy-this.carHeight*1.4),(float)(cx-this.axleDistance*0.46),(float)(oy+dy-this.carHeight*2.12));
            trunkDoor.closePath();
            g2.setPaint(new Color(0,0,0,60));
            g2.draw(trunkDoor);
            
            
        }
        
    }
    
    private void flames(Graphics2D g2,GeneralPath chassis){
        
        
        //desenho dos flames
        
        // 5 tipos de flames
        
        Shape bb = (Shape)(chassis);
        Area area_chassis = new Area(bb);
        GradientPaint gp1 = new GradientPaint((float)(cx),(float)(flame[2].getY()),Color.white,(float)(cx),(float)(flame[2].getY()+this.radiusWheel*0.05),Color.darkGray,true);
        
        if(this.typeFlame==1){
            
            GeneralPath flames = new GeneralPath();
            GeneralPath flamesChrome = new GeneralPath();
            
            flames.moveTo((float)(flame[2].getX()),(float)(flame[2].getY()));            
            flames.lineTo((float)(cx),(float)(flame[2].getY()));
            flames.quadTo((float)(cx+axleDistance*0.1),(float)(flame[2].getY()),(float)(cx+axleDistance*0.2),(float)(flame[2].getY()+this.radiusWheel*0.3));
            flames.quadTo((float)(cx+axleDistance*0.3),(float)(flame[2].getY()-axleDistance*0.1),(float)(flame[0].getX()),(float)(flame[0].getY()));
            
            flamesChrome.moveTo((float)(flame[2].getX()),(float)(flame[2].getY()-axleDistance*0.012));           
            flamesChrome.lineTo((float)(cx),(float)(flame[2].getY()-axleDistance*0.012));
            flamesChrome.quadTo((float)(cx+axleDistance*0.1),(float)(flame[2].getY()-this.radiusWheel*0.1),(float)(cx+axleDistance*0.2),(float)(flame[2].getY()+this.radiusWheel*0.1));
            
            
            flamesChrome.quadTo((float)(cx+axleDistance*0.3),(float)(flame[2].getY()-axleDistance*0.11),(float)(flame[0].getX()),(float)(flame[0].getY()));
            flamesChrome.quadTo((float)(cx+axleDistance*0.3),(float)(flame[2].getY()-axleDistance*0.1),(float)(cx+axleDistance*0.2),(float)(flame[2].getY()+this.radiusWheel*0.3));
            
            flamesChrome.quadTo((float)(cx+axleDistance*0.1),(float)(flame[2].getY()),(float)(cx),(float)(flame[2].getY()));
            flamesChrome.lineTo((float)(flame[2].getX()),(float)(flame[2].getY()));
            flamesChrome.quadTo((float)(flame[2].getX()-this.axleDistance*0.1),(float)(flame[2].getY()*0.9799),(float)(flame[2].getX()-this.axleDistance*0.1),(float)(flame[2].getY()));
            flamesChrome.closePath();    
            
            flames.lineTo((float)(flame[0].getX()),(float)(cy));
            flames.lineTo((float)(ox),(float)(cy));
            flames.closePath();
            
            Shape cc = (Shape)(flames);
            Area areaFlames = new Area(cc);
            areaFlames.intersect(area_chassis);
            
            
            Shape ee = (Shape)(flamesChrome);
            Area areaFlamesChrome = new Area(ee);
            areaFlamesChrome.intersect(area_chassis);
            
            
            g2.setPaint(colors[1]);
            g2.fill(areaFlames);
            g2.setPaint(Color.black);
            g2.draw(areaFlames);
            GradientPaint gp2 = new GradientPaint((float)(cx),(float)(flame[2].getY()),Color.white,(float)(cx),(float)(flame[2].getY()+axleDistance*0.07),Color.lightGray,true);
            g2.setPaint(gp2);
            g2.fill(areaFlamesChrome);
            g2.setPaint(Color.black);
            g2.draw(areaFlamesChrome);
            
        }
        
        if(this.typeFlame==2){
            
            GeneralPath flames = new GeneralPath();
            GeneralPath flamesChrome = new GeneralPath();
            flames.moveTo((float)(flame[2].getX()),(float)(flame[4].getY()));
            flamesChrome.moveTo((float)(flame[2].getX()-axleDistance*0.1),(float)(flame[4].getY()+axleDistance*0.01));
            flames.lineTo((float)(flame[2].getX()+axleDistance*0.6),(float)(flame[4].getY()));
            flamesChrome.lineTo((float)(flame[2].getX()+axleDistance*0.6),(float)(flame[4].getY()+axleDistance*0.01));
            
            
            flames.quadTo((float)(flame[2].getX()+axleDistance*0.8),(float)(flame[4].getY()+axleDistance*0.01),(float)(flame[2].getX()+axleDistance*0.9),(float)(flame[1].getY()));
            flamesChrome.quadTo((float)(flame[2].getX()+axleDistance*0.78),(float)(flame[4].getY()+axleDistance*0.01),(float)(flame[2].getX()+axleDistance*0.89),(float)(flame[1].getY()+axleDistance*0.01));
            flames.lineTo((float)(flame[1].getX()),(float)(flame[1].getY()));
            flamesChrome.lineTo((float)(flame[1].getX()),(float)(flame[1].getY()+axleDistance*0.01));
            flames.lineTo((float)(flame[1].getX()+axleDistance*0.2),(float)(flame[1].getY()-axleDistance*0.2));
            flamesChrome.lineTo((float)(flame[1].getX()+axleDistance*0.2),(float)(flame[1].getY()-axleDistance*0.2));
            flamesChrome.lineTo((float)(flame[2].getX()-axleDistance*0.2),(float)(flame[1].getY()-axleDistance*0.2));
            
            
            flames.closePath();
            flamesChrome.closePath();
            
            
            
            
            Shape cc = (Shape)(flames);
            Shape ee = (Shape)(flamesChrome);
            Area areaFlames = new Area(cc);
            Area areaFlamesChrome = new Area(ee);
            areaFlames.intersect(area_chassis);
            areaFlamesChrome.intersect(area_chassis);
            
            GradientPaint gp2 = new GradientPaint((float)(cx),(float)(flame[2].getY()),Color.white,(float)(cx),(float)(flame[2].getY()+axleDistance*0.03),Color.lightGray,true);
            g2.setPaint(gp2);
            g2.fill(areaFlamesChrome);
            g2.setPaint(Color.black);
            g2.draw(areaFlamesChrome);
            
            g2.setPaint(colors[1]);
            g2.fill(areaFlames);
            g2.setPaint(Color.black);
            g2.draw(areaFlames);
            
            
            
            
            
            
        }
        if(this.typeFlame==3){
            
            GeneralPath flames = new GeneralPath();
            GeneralPath flamesChrome = new GeneralPath();
            
            flames.moveTo((float)(flame[2].getX()),(float)(flame[4].getY()));
            flamesChrome.moveTo((float)(flame[2].getX()-axleDistance*0.1),(float)(flame[4].getY()+axleDistance*0.01));
            flames.lineTo((float)(flame[2].getX()+axleDistance*0.6),(float)(flame[4].getY()));
            flamesChrome.lineTo((float)(flame[2].getX()+axleDistance*0.6),(float)(flame[4].getY()+axleDistance*0.01));
            
            flames.quadTo((float)(flame[2].getX()+axleDistance*0.8),(float)(flame[4].getY()+axleDistance*0.01),(float)(flame[2].getX()+axleDistance*0.9),(float)(flame[1].getY()+axleDistance*0.05));
            flamesChrome.quadTo((float)(flame[2].getX()+axleDistance*0.78),(float)(flame[4].getY()+axleDistance*0.01),(float)(flame[2].getX()+axleDistance*0.89),(float)(flame[1].getY()+axleDistance*0.06));
            flames.lineTo((float)(flame[1].getX()),(float)(flame[1].getY()));
            flamesChrome.lineTo((float)(flame[1].getX()),(float)(flame[1].getY()+axleDistance*0.01));
            flames.lineTo((float)(flame[1].getX()+axleDistance*0.2),(float)(flame[1].getY()-axleDistance*0.2));
            flamesChrome.lineTo((float)(flame[1].getX()+axleDistance*0.2),(float)(flame[1].getY()-axleDistance*0.2));
            flamesChrome.lineTo((float)(flame[2].getX()-axleDistance*0.2),(float)(flame[1].getY()-axleDistance*0.2));
            
            
            flames.closePath();
            flamesChrome.closePath();
            Shape rect = new Rectangle2D.Double(flame[2].getX()-axleDistance*0.2,flame[1].getY()+axleDistance*0.0043,axleDistance*2,axleDistance*0.1);
            Shape rect2 = new Rectangle2D.Double(flame[2].getX()+axleDistance*0.85,flame[1].getY(),axleDistance*1.5,axleDistance*0.0049);
            //  g2.setPaint(Color.red);
            // g2.draw(rect2);
            
            Shape cc = (Shape)(flames);
            Shape ee = (Shape)(flamesChrome);
            Area areaFlames = new Area(cc);
            Area areaFlamesChrome = new Area(ee);
            Area rects = new Area(rect);
            Area rects2 = new Area(rect2);
            
            rects.intersect(areaFlames);
            rects2.intersect(areaFlames);
            
            areaFlames.intersect(area_chassis);
            
            
            
            areaFlamesChrome.intersect(area_chassis);
            areaFlamesChrome.subtract(areaFlames);
            areaFlamesChrome.add(rects2);
            
            
            
            
            g2.setPaint(colors[0]);
            g2.fill(areaFlames);
            g2.setPaint(Color.black);
            g2.draw(areaFlames);
            
            
            
            
            g2.setPaint(colors[1]);
            g2.fill(rects);
            g2.setPaint(Color.black);
            
            g2.draw(rects);
            
            GradientPaint gp2 = new GradientPaint((float)(cx),(float)(flame[2].getY()),Color.white,(float)(cx),(float)(flame[2].getY()+axleDistance*0.05),Color.lightGray,true);
            g2.setPaint(gp2);
            g2.fill(areaFlamesChrome);
            g2.setPaint(Color.black);
            g2.draw(areaFlamesChrome);
            
            
            
        }
        
        
        if(this.typeFlame==4){
            
            
            GeneralPath flames = new GeneralPath();
            GeneralPath flamesChrome = new GeneralPath();
            
            flamesChrome.moveTo((float)(flame[2].getX()-axleDistance*0.2),(float)(flame[4].getY()));
            flamesChrome.lineTo((float)(flame[2].getX()+axleDistance*0.7),(float)(flame[4].getY()));
            flamesChrome.quadTo((float)(cx-axleDistance*0.16),(float)(flame[4].getY()+axleDistance*0.01),(float)(cx-axleDistance*0.13),(float)(flame[4].getY()+axleDistance*0.05));
            flamesChrome.quadTo((float)(cx-axleDistance*0.23),(float)(flame[3].getY()+this.heightRearLight),(float)(cx-axleDistance*0.38),(float)(flame[3].getY()+this.heightRearLight));
            flamesChrome.lineTo((float)(flame[3].getX()),(float)(flame[3].getY()+this.heightRearLight));
            flamesChrome.closePath();
            
            flames.moveTo((float)(flame[2].getX()-axleDistance*0.2),(float)(flame[4].getY()));
            flames.lineTo((float)(flame[2].getX()+axleDistance*0.75),(float)(flame[4].getY()));
            flames.quadTo((float)(cx-axleDistance*0.14),(float)(flame[4].getY()+axleDistance*0.01),(float)(cx-axleDistance*0.1),(float)(flame[4].getY()+axleDistance*0.05));
            flames.quadTo((float)(cx-axleDistance*0.23),(float)(flame[3].getY()+this.heightRearLight+axleDistance*0.01),(float)(cx-axleDistance*0.38),(float)(flame[3].getY()+this.heightRearLight+axleDistance*0.01));
            flames.lineTo((float)(flame[3].getX()),(float)(flame[3].getY()+this.heightRearLight+axleDistance*0.01));
            flames.closePath();
            
            
            
            
            
            Shape cc = (Shape)(flames);
            Shape ee = (Shape)(flamesChrome);
            Area areaFlames = new Area(cc);
            Area areaFlamesChrome = new Area(ee);
            areaFlames.intersect(area_chassis);
            areaFlamesChrome.intersect(area_chassis);
            
            GradientPaint gp2 = new GradientPaint((float)(cx),(float)(flame[2].getY()),Color.white,(float)(cx),(float)(flame[2].getY()+axleDistance*0.03),Color.lightGray,true);
            g2.setPaint(gp2);
            
            g2.fill(areaFlames);
            g2.setPaint(Color.black);
            g2.draw(areaFlames);
            
            g2.setPaint(colors[1]);
            g2.fill(areaFlamesChrome);
            g2.setPaint(Color.black);
            g2.draw(areaFlamesChrome);
            
            
            
            
            
            
        }
        if(this.typeFlame==5){
            
            
            GeneralPath flames = new GeneralPath();
            GeneralPath flamesChrome = new GeneralPath();
            
            flames.moveTo((float)(flame[1].getX()),(float)(flame[1].getY()-axleDistance*0.005));
            flames.quadTo((float)(flame[1].getX()-axleDistance/2-this.headWidth),(float)(flame[1].getY()-axleDistance*0.007),(float)(flame[1].getX()-axleDistance-this.headWidth),(float)(flame[1].getY()+axleDistance*0.06));
            flames.quadTo((float)(flame[1].getX()-axleDistance*1.037-this.headWidth),(float)(flame[1].getY()+axleDistance*0.068),(float)(flame[1].getX()-axleDistance-this.headWidth),(float)(flame[1].getY()+axleDistance*0.068));
            flames.quadTo((float)(flame[1].getX()-axleDistance/2-this.headWidth),(float)(flame[1].getY()+axleDistance*0.007),(float)(flame[1].getX()),(float)(flame[1].getY()+axleDistance*0.005));
            flames.closePath();
            
            
            flamesChrome.moveTo((float)(flame[3].getX()),(float)(flame[3].getY()-axleDistance*0.005));
            flamesChrome.quadTo((float)(flame[3].getX()+axleDistance*0.3+this.rearWidth),(float)(flame[3].getY()-axleDistance*0.005),(float)(flame[3].getX()+axleDistance*0.51+this.rearWidth),(float)(flame[1].getY()+axleDistance*0.035));
            flamesChrome.quadTo((float)(flame[3].getX()+axleDistance*0.51+this.rearWidth),(float)(flame[1].getY()+axleDistance*0.04),(float)(flame[3].getX()+axleDistance*0.51+this.rearWidth),(float)(flame[1].getY()+axleDistance*0.045));
            flamesChrome.quadTo((float)(flame[3].getX()+axleDistance*0.38+this.rearWidth),(float)(flame[1].getY()+axleDistance*0.051),(float)(flame[3].getX()+axleDistance*0.37+this.rearWidth),(float)(flame[1].getY()+axleDistance*0.059));
            flamesChrome.quadTo((float)(flame[3].getX()+axleDistance*0.38+this.rearWidth),(float)(flame[1].getY()+axleDistance*0.033),(float)(flame[3].getX()+axleDistance*0.37+this.rearWidth),(float)(flame[1].getY()+axleDistance*0.033));
            flamesChrome.quadTo((float)(flame[3].getX()+axleDistance*0.3+this.rearWidth),(float)(flame[3].getY()+axleDistance*0.005),(float)(flame[3].getX()),(float)(flame[3].getY()+axleDistance*0.005));
            flamesChrome.closePath();
            
            
            
            Shape cc = (Shape)(flames);
            Shape ee = (Shape)(flamesChrome);
            Area areaFlames = new Area(cc);
            Area areaFlamesChrome = new Area(ee);
            areaFlames.add(areaFlamesChrome);
            
            
            
            GradientPaint gp2 = new GradientPaint((float)(cx),(float)(flame[3].getY()),Color.white,(float)(cx),(float)(flame[3].getY()+this.heightRearLight*0.32),Color.lightGray,true);
            g2.setPaint(gp2);
            g2.fill(areaFlames);
            g2.setPaint(Color.black);
            g2.draw(areaFlames);
            
        }
        
    }
    
    private void chassis(Graphics2D g2){
        
        g2.setPaint(Color.black);
        Stroke traço = new BasicStroke((float)1);
        g2.setStroke(traço);
        GeneralPath chassis = new GeneralPath();
        Shape bb = (Shape)(chassis);
        
        chassis= head(g2,chassis);
        chassis= headFender(g2,chassis);
        chassis= rearFender(g2,chassis);
        chassis= rear(g2,chassis);
        chassis.closePath();
        g2.setPaint(Color.black);
        g2.draw(chassis);
        
        g2.setPaint(colors[0]);
        g2.fill(chassis);
        g2.setPaint(Color.black);
        g2.draw(chassis);
        
        
        Color cortransparente=new Color(255,255,255,0);
        Color corbranca = new Color(255,255,255,75);
        
        
        GradientPaint gp1;
        flames(g2,chassis);
        //aplicar sombra inferior do redLight trASEiro
        if(this.typeFlame==4)
            gp1 = new GradientPaint((float)(cx),(float)(cy*0.98),colors[1],(float)(cx),(float)(cy*1.1),new Color((int)(colors[1].getRed()*0.8),(int)(colors[1].getGreen()*0.8),(int)(colors[1].getBlue()*0.8),80),true);
        else
            gp1 = new GradientPaint((float)(cx),(float)(cy*0.98),colors[0],(float)(cx),(float)(cy*1.1),new Color((int)(colors[0].getRed()*0.8),(int)(colors[0].getGreen()*0.8),(int)(colors[0].getBlue()*0.8),80),true);
        
        g2.setPaint(gp1);
        g2.fill(rearLightLowerShadow);
        
        //aplicar sombra superior do rearLight 
        
        if(this.typeFlame==0 || this.typeFlame==2 || this.typeFlame==3 || this.typeFlame==5  )
            gp1 = new GradientPaint((float)(rearLightUpperShadow.getCurrentPoint().getX()),(float)(rearLightUpperShadow.getCurrentPoint().getY()),new Color((int)(colors[0].getRed()*0.8),(int)(colors[0].getGreen()*0.8),(int)(colors[0].getBlue()*0.8),80),(float)(rearLightUpperShadow.getCurrentPoint().getX()),(float)(this.rearLightUpperShadowaux.getY()*0.95),colors[0]);
        else
            gp1 = new GradientPaint((float)(rearLightUpperShadow.getCurrentPoint().getX()),(float)(rearLightUpperShadow.getCurrentPoint().getY()),new Color((int)(colors[1].getRed()*0.8),(int)(colors[1].getGreen()*0.8),(int)(colors[1].getBlue()*0.8),80),(float)(rearLightUpperShadow.getCurrentPoint().getX()),(float)(this.rearLightUpperShadowaux.getY()*0.95),colors[1]);
        
        g2.setPaint(gp1);
        g2.fill(rearLightUpperShadow);
        
        
        //aplicar especulação da parte superior do carro
        gp1 = new GradientPaint((float)(cx),(float)(carSpeculation.getCurrentPoint().getY()),cortransparente,(float)(cx),(float)(carSpeculation.getCurrentPoint().getY()*1.1),corbranca,true);
        g2.setPaint(gp1);
       g2.fill(carSpeculation);
        
        
        
        
        
        
        //converter para area o generalpath chassis , para que possa fazer de uma maneira simples chassis componentes de especulação da parte inferior do carro
        
        gp1 = new GradientPaint((float)(cx),(float)(oy+dy-this.radiusWheel),cortransparente,(float)(cx),(float)(oy+dy-this.radiusWheel*0.8),new Color(255,255,255,30));
        g2.setPaint(gp1);
        
        
        Area area_chassis = new Area(bb);
        Shape lowerSpeculation = new Rectangle2D.Double(ox,oy+dy-this.radiusWheel,ox+this.width,this.radiusWheel);
        Area areaLowerSpeculation = new Area(lowerSpeculation);
        areaLowerSpeculation.intersect(area_chassis);
        g2.fill(areaLowerSpeculation);
        
        
        gp1 = new GradientPaint((float)(cx),(float)(this.flame[4].getY()),cortransparente,(float)(cx),(float)(this.flame[4].getY()+axleDistance*0.01),new Color(255,255,255,30));
        g2.setPaint(gp1);
        
        Shape specular3 = new Rectangle2D.Double(ox,this.flame[4].getY(),ox+this.width,axleDistance*0.012);
        Area spec3 = new Area(specular3);
        spec3.intersect(area_chassis);
        g2.fill(spec3);
        
        gp1 = new GradientPaint((float)(cx),(float)(oy+dy-this.carHeight*2),cortransparente,(float)(cx),(float)(oy+dy-this.carHeight*2.001),new Color(255,255,255,30));
        g2.setPaint(gp1);        
        
        
        doors(g2);        
        gp1 = new GradientPaint((float)(cx),(float)(supheadbumper.getCurrentPoint().getY()),new Color(150,150,150),(float)(cx),(float)(supheadbumper.getCurrentPoint().getY()+this.axleDistance*0.004),Color.white,true);
        g2.setPaint(gp1);
        g2.fill(this.supheadbumper);
        g2.setPaint(Color.darkGray);
        g2.draw(this.supheadbumper);
        
        
    }
    
    
    
    
    private GeneralPath head(Graphics2D g2, GeneralPath chassis){
        
        
        
        
        carSpeculation = new GeneralPath();
        
        chassis.moveTo((float)(cx+this.axleDistance*0.6),(float)(oy+dy-this.carHeight*2.1));
        this.flame[0]=chassis.getCurrentPoint();
        chassis.quadTo((float)(cx+this.axleDistance*0.65+this.headWidth),(float)(oy+dy-this.carHeight*2.1),(float)(cx+this.axleDistance*0.7+this.headWidth),(float)(oy+dy-this.carHeight*2));
        this.carSpeculation.moveTo((float)(chassis.getCurrentPoint().getX()),(float)(chassis.getCurrentPoint().getY()));
        
        Point2D ponto =headLights(g2,chassis);
        chassis.quadTo((float)(cx+this.axleDistance*0.7+this.headWidth),(float)(oy+dy-this.carHeight*1.85),(float)(cx+this.axleDistance*0.68+this.headWidth),(float)(oy+dy-this.carHeight*1.55));
        this.flame[1]=chassis.getCurrentPoint();
        
        this.carSpeculation.lineTo((float)(chassis.getCurrentPoint().getX()),(float)(chassis.getCurrentPoint().getY()));
        
        chassis.lineTo((float)(ponto.getX()-this.axleDistance*0.009),(float)(ponto.getY()));
        chassis.lineTo((float)(ponto.getX()-this.axleDistance*0.029),(float)(ponto.getY()+this.axleDistance*0.006));
        this.supheadbumper = new GeneralPath();
        
        
        this.supheadbumper.moveTo((float)(ponto.getX()-this.axleDistance*0.029),(float)(ponto.getY()+this.axleDistance*0.04));
        this.supheadbumper.lineTo((float)(ponto.getX()-this.headWidth*1.65),(float)(ponto.getY()+this.axleDistance*0.04));
        this.supheadbumper.lineTo((float)(ponto.getX()-this.headWidth*1.3),(float)(ponto.getY()+this.carHeight*0.5));
        this.supheadbumper.lineTo((float)(ponto.getX()-this.axleDistance*0.029),(float)(ponto.getY()+this.carHeight*0.5));
        this.supheadbumper.quadTo((float)(ponto.getX()-this.axleDistance*0.017),(float)(ponto.getY()+this.carHeight*0.48),(float)(ponto.getX()-this.axleDistance*0.024),(float)(ponto.getY()+this.axleDistance*0.04));
        
        this.supheadbumper.closePath();
        
        chassis.lineTo((float)(cx+this.axleDistance*0.65+this.headWidth),(float)(oy+dy-this.radiusWheel*1.3));
        
        
        
        
        headX2=cx+this.axleDistance*0.65+this.headWidth;
        headY2=oy+dy-this.radiusWheel*1.3;
        chassis.lineTo((float)(cx+this.axleDistance/2+this.radiusWheel*1.1),(float)(oy+dy-this.radiusWheel*1.3));
        
        
        speculationFender = new GeneralPath();
        speculationFender.moveTo((float)(cx+this.axleDistance/2+this.radiusWheel*1.1),(float)(oy+dy-this.radiusWheel*1.3));
        headX=cx+this.axleDistance/2+this.radiusWheel*1.1;
        headY=oy+dy-this.radiusWheel*1.3;
        
        return chassis;
        
    }
    
    private Point2D headLights(Graphics2D g2,GeneralPath chassis){
        
        
        double headLightsWidth=this.axleDistance*0.05+(5*this.axleDistance*0.009);
        double headLightsHeight=this.axleDistance*0.05+(5*this.axleDistance*0.009);
        
        
        GeneralPath redLight= new GeneralPath();
        float x=(float)(chassis.getCurrentPoint().getX());
        float y=(float)(chassis.getCurrentPoint().getY());
        redLight.moveTo((float)(x-headLightsHeight*0.1),(float)(y+headLightsHeight*0.25));
        
        redLight.quadTo((float)(x+headLightsWidth*0.23),(float)(y+headLightsHeight*0.68),(float)(x-headLightsWidth*0.09),(float)(y+headLightsHeight*1.2));
        
        //headLightChrome
        
        GeneralPath headLightChrome= new GeneralPath();
        headLightChrome.moveTo((float)(x-headLightsHeight*0.31),(float)(y+headLightsHeight*0.3));
        headLightChrome.lineTo((float)(x-headLightsHeight*0.05),(float)(y+headLightsHeight*0.4));
        headLightChrome.quadTo((float)(x-headLightsHeight*0.05),(float)(y+headLightsHeight*0.65),(float)(x-headLightsHeight*0.05),(float)(y+headLightsHeight*1.15));
        Point2D ponto= headLightChrome.getCurrentPoint();
        headLightChrome.lineTo((float)(x-headLightsHeight*0.31),(float)(y+headLightsHeight*1.2));
        headLightChrome.closePath();
        
        
        
        GradientPaint gp1 = new GradientPaint((float)(x+headLightsWidth*0.085),(float)(y+headLightsHeight*0.1),Color.white,(float)(x+headLightsWidth*0.085),(float)(y+headLightsHeight*0.5),Color.lightGray,true);
        g2.setPaint(gp1);
        g2.fill(headLightChrome);
        g2.setPaint(Color.darkGray);
        g2.draw(headLightChrome);
        
        
        return ponto;
        
    }
    
    
    private void headBumper(Graphics2D g2){
        
        //desenho do para-choques da frente
        
        GeneralPath headBumper = new GeneralPath();
        
        headBumper.moveTo((float)(headX+this.axleDistance*0.01),(float)(headY-this.axleDistance*0.01));
        
        headBumper.lineTo((float)(headX2+this.axleDistance*0.03),(float)(headY-this.axleDistance*0.01));
        headBumper.quadTo((float)(headX2+this.axleDistance*0.05),(float)(headY2+frontBumperHeight-this.axleDistance*0.01),(float)(headX2+this.axleDistance*0.04),(float)(headY2+frontBumperHeight-this.axleDistance*0.01));
        headBumper.lineTo((float)(headX+this.axleDistance*0.03),(float)(headY2+frontBumperHeight-this.axleDistance*0.01));
        
        headBumper.closePath();
        GradientPaint gp1 = new GradientPaint((float)(headX*1.5),(float)(headY),Color.white,(float)(headX*1.5),(float)(headY*1.05),Color.lightGray,true);
        g2.setPaint(gp1);
        g2.fill(headBumper);
        g2.setPaint(Color.black);
        g2.draw(headBumper);
        
        
        
    }
    
    
    private GeneralPath  headFender(Graphics2D g2,GeneralPath chassis){
        
        //método que desenha o para lamas da frente
        
        double aux = oy+dy+this.radiusWheel*0.3-this.radiusWheel*0.75;
        
        this.frontFenderHeight = this.radiusWheel*(1.5+(this.frontFenderHeight/10));
        
        if(this.typeFrontFender==1){
            
            speculationFender.quadTo((float)(cx+this.axleDistance/2+this.radiusWheel*0.9),(float)(oy+dy-frontFenderHeight),(float)(cx+this.axleDistance/2+this.radiusWheel*0.4),(float)(oy+dy-frontFenderHeight));
            speculationFender.lineTo((float)(cx+this.axleDistance/2-this.radiusWheel*0.1),(float)(oy+dy-frontFenderHeight));
            speculationFender.quadTo((float)(cx+this.axleDistance/2-frontFenderHeight*0.45),(float)(oy+dy-frontFenderHeight),(float)(cx+this.axleDistance/2-frontFenderHeight*0.58),(float)(oy+dy-frontFenderHeight*0.65));
            speculationFender.quadTo((float)(cx+this.axleDistance/2-frontFenderHeight*0.67),(float)(oy+dy-this.radiusWheel*0.75),(float)(cx+this.axleDistance/2-frontFenderHeight*0.75),(float)(aux));
            
            
            chassis.quadTo((float)(cx+this.axleDistance/2+this.radiusWheel*0.9),(float)(oy+dy-frontFenderHeight),(float)(cx+this.axleDistance/2+this.radiusWheel*0.4),(float)(oy+dy-frontFenderHeight));
            chassis.lineTo((float)(cx+this.axleDistance/2-this.radiusWheel*0.1),(float)(oy+dy-frontFenderHeight));
            chassis.quadTo((float)(cx+this.axleDistance/2-frontFenderHeight*0.45),(float)(oy+dy-frontFenderHeight),(float)(cx+this.axleDistance/2-frontFenderHeight*0.58),(float)(oy+dy-frontFenderHeight*0.65));
            chassis.quadTo((float)(cx+this.axleDistance/2-frontFenderHeight*0.67),(float)(oy+dy-this.radiusWheel*0.75),(float)(cx+this.axleDistance/2-frontFenderHeight*0.75),(float)(aux));
            
            
        }
        
        else{
            speculationFender.quadTo((float)(cx+this.axleDistance/2+this.carHeight*0.5),(float)(oy+dy-frontFenderHeight),(float)(cx+this.axleDistance/2+frontFenderHeight*0.1),(float)(oy+dy-frontFenderHeight));
            speculationFender.quadTo((float)(cx+this.axleDistance/2-this.carHeight*0.55),(float)(oy+dy-frontFenderHeight*1.05),(float)(cx+this.axleDistance/2-frontFenderHeight*0.9),(float)(aux));
            
            chassis.quadTo((float)(cx+this.axleDistance/2+this.carHeight*0.5),(float)(oy+dy-frontFenderHeight),(float)(cx+this.axleDistance/2+frontFenderHeight*0.1),(float)(oy+dy-frontFenderHeight));
            chassis.quadTo((float)(cx+this.axleDistance/2-this.carHeight*0.55),(float)(oy+dy-frontFenderHeight*1.05),(float)(cx+this.axleDistance/2-frontFenderHeight*0.9),(float)(aux));
            
        }
        
        return chassis;
        
    }
    
    
    
    
    private GeneralPath rearFender(Graphics2D g2,GeneralPath chassis){
        
        
        double x;
        double y;
        
        double aux = oy+dy+this.radiusWheel*0.3-this.radiusWheel*0.75;
        
        //quando os paralamas são curvos o valor da aluraGuardaLamasTras deve duplicar em relação
        //aos não curvos
        
        if(this.typeRearFender==0){
            rearFenderHeight*=2;
        }
        
        rearFenderHeight = this.radiusWheel*(1+(rearFenderHeight/10));
        chassis.lineTo((float)(cx-this.axleDistance/2+this.radiusWheel),(float)(aux));
        rearFenderAuxBackDoor[0]= new Point2D.Double(cx-this.axleDistance/2+this.radiusWheel,aux);
        speculationFender.moveTo((float)(cx-this.axleDistance/2+this.radiusWheel),(float)(aux));
        if(this.typeRearFender==1){
            
            chassis.quadTo((float)(cx-this.axleDistance/2+this.radiusWheel),(float)(oy+dy-rearFenderHeight),(float)(cx-this.axleDistance/2+this.radiusWheel-this.radiusWheel*0.4),(float)(oy+dy-rearFenderHeight));
            rearFenderAuxBackDoor[1]=new Point2D.Double(cx-this.axleDistance/2+this.radiusWheel,oy+dy-rearFenderHeight);
            rearFenderAuxBackDoor[2]=chassis.getCurrentPoint();
            
            speculationFender.quadTo((float)(cx-this.axleDistance/2+this.radiusWheel),(float)(oy+dy-rearFenderHeight),(float)(cx-this.axleDistance/2+this.radiusWheel-this.radiusWheel*0.4),(float)(oy+dy-rearFenderHeight));
            
            chassis.lineTo((float)(cx-this.axleDistance/2-this.radiusWheel+this.radiusWheel*0.4),(float)(oy+dy-rearFenderHeight));
            speculationFender.lineTo((float)(cx-this.axleDistance/2-this.radiusWheel+this.radiusWheel*0.4),(float)(oy+dy-rearFenderHeight));
            
            chassis.quadTo((float)(cx-this.axleDistance/2-this.radiusWheel-this.radiusWheel*0.1),(float)(oy+dy-rearFenderHeight),(float)(cx-this.axleDistance/2-this.radiusWheel*1.2),(float)(aux-this.radiusWheel*0.3));
            speculationFender.quadTo((float)(cx-this.axleDistance/2-this.radiusWheel-this.radiusWheel*0.1),(float)(oy+dy-rearFenderHeight),(float)(cx-this.axleDistance/2-this.radiusWheel*1.2),(float)(aux-this.radiusWheel*0.3));
            
        }
        else{
            chassis.quadTo((float)(cx-this.axleDistance/2+this.radiusWheel),(float)(oy+dy-rearFenderHeight*1.2),(float)(cx-this.axleDistance/2-this.radiusWheel-rearFenderHeight*0.35),(float)(aux-this.radiusWheel*0.3));
            rearFenderAuxBackDoor[1]=new Point2D.Double(cx-this.axleDistance/2+this.radiusWheel,oy+dy-rearFenderHeight*1.2);
            rearFenderAuxBackDoor[2]=chassis.getCurrentPoint();
            speculationFender.quadTo((float)(cx-this.axleDistance/2+this.radiusWheel),(float)(oy+dy-rearFenderHeight*1.2),(float)(cx-this.axleDistance/2-this.radiusWheel-rearFenderHeight*0.35),(float)(aux-this.radiusWheel*0.3));}
        
        return chassis;
        
    }
    
    
    
    
    
    
    private GeneralPath rear(Graphics2D g2,GeneralPath chassis){
        
        
        rearBumperHeight=this.axleDistance*0.02+(rearBumperHeight*this.axleDistance*0.0025);
        
        
        // calculo do angulo
        //primeiro obtem-se o ponto currente do path
        //para calcular o ponto final influenciado pelo angulo desejado
        Point2D aux = new Point2D.Double();
        aux=chassis.getCurrentPoint();
        
        double jx = aux.getX()+rearWidth*Math.cos(this.rearAngle);
        double jy =aux.getY()+rearWidth*Math.sin(this.rearAngle);
        chassis.lineTo((float)(jx),(float)(jy));
        
        //guardo os valores do ponto inferior final do chassis em variaveis globais
        //para depois poder desenhar o parachoques
        this.rearX=jx;
        this.rearY=jy;
        
        
        
        //definição das variaveis relativas ao desenho dos farois tanto para o chassis como para
        //os farois
        
        //posição redLight 0-5
        
        
        
    
        
        
        
        chassis.lineTo((float)(jx+ this.carHeight*0.15),(float)(oy+dy- posyrearlight*1.4));
        
        this.rearLightLowerShadow = new GeneralPath();
        this.rearLightUpperShadow = new GeneralPath();
        this.rearLightLowerShadow.moveTo((float)(jx+ this.carHeight*0.15),(float)(oy+dy- posyrearlight*1.4));
        
        
        
        
        //chamar método para desenhar os farois de trás
        rearLights(g2,chassis,heightRearLight,widthRearLight);
        
        chassis.quadTo((float)(jx+heightRearLight*0.18),(float)(oy+dy-posyrearlight*1.4-heightRearLight*0.5),(float)(jx+this.carHeight*0.15),(float)(oy+dy-posyrearlight*1.4-heightRearLight));
        this.flame[3]=chassis.getCurrentPoint();
        this.rearLightUpperShadow.moveTo((float)(chassis.getCurrentPoint().getX()),(float)(chassis.getCurrentPoint().getY()));
        this.rearLightUpperShadow.lineTo((float)(jx+this.axleDistance*0.3+heightRearLight*2.58),(float)(chassis.getCurrentPoint().getY()));
        this.rearLightUpperShadowaux = rearLightUpperShadow.getCurrentPoint();
        
        this.rearLightLowerShadow.quadTo((float)(jx+heightRearLight*0.18),(float)(oy+dy-posyrearlight*1.4-heightRearLight*0.5),(float)(jx+this.carHeight*0.18),(float)(oy+dy-posyrearlight*1.4-heightRearLight*0.5));
        this.flame[2]=rearLightLowerShadow.getCurrentPoint();
        this.rearLightLowerShadow.lineTo((float)(jx+this.axleDistance*0.2+heightRearLight*2.58),(float)(oy+dy-posyrearlight*1.4-heightRearLight*0.5));
        
        
        
        this.carSpeculation.lineTo((float)(jx+heightRearLight*0.18),(float)(oy+dy-posyrearlight*1.4-heightRearLight*0.5));
        this.carSpeculation.lineTo((float)(jx+this.carHeight*0.15),(float)(oy+dy-posyrearlight*1.4-heightRearLight));
        
        
        //calcular ponto medio entre chassis parte superior do redLight e chassis ponta superior trunkeira do carro
        
        this.rearLightUpperShadow.lineTo((float)(chassis.getCurrentPoint().getX()+((jx-this.carHeight*0.2-chassis.getCurrentPoint().getX())/2)),(float)(chassis.getCurrentPoint().getY()+((
        (oy+dy-this.carHeight*2.12)-chassis.getCurrentPoint().getY())/2)));
        this.rearLightUpperShadow.closePath();
        chassis.lineTo((float)(jx-this.carHeight*0.2),(float)(oy+dy-this.carHeight*2.12));
        chassis.lineTo((float)(cx-this.axleDistance/2),(float)(oy+dy-this.carHeight*2.12));
        this.flame[4]=chassis.getCurrentPoint();
        
        this.carSpeculation.lineTo((float)(jx-this.carHeight*0.2),(float)(oy+dy-this.carHeight*2.12));
        this.carSpeculation.closePath();
        return chassis;
    }
    
    
    
    
    
    private void rearLights(Graphics2D g2,GeneralPath chassis,double heightRearLight,double widthRearLight){
        
        //método que desenha os faróis de trunk
        
        g2.setPaint(Color.black);
        Stroke traço = new BasicStroke((float)0.5);
        g2.setStroke(traço);
        
        
        
        Point2D pontoAux = new Point2D.Float();
        pontoAux = chassis.getCurrentPoint();
        
        
        
        //desehar luz
        GeneralPath c = new GeneralPath();
        c.moveTo((float)(pontoAux.getX()-heightRearLight*0.12),(float)(pontoAux.getY()-heightRearLight*0.14));
        c.quadTo((float)(pontoAux.getX()-widthRearLight),(float)(pontoAux.getY()-heightRearLight*0.45),(float)(pontoAux.getX()-heightRearLight*0.12),(float)(pontoAux.getY()-heightRearLight*0.85));
        c.closePath();
        g2.setPaint(Color.red);
        g2.fill(c);
        g2.setPaint(Color.black);
        g2.draw(c);
        
        
        //headLightChrome
        GeneralPath headLightChrome = new GeneralPath();
        
        headLightChrome.moveTo((float)(pontoAux.getX()+heightRearLight*0.25),(float)(pontoAux.getY()-heightRearLight*0.02));
        headLightChrome.lineTo((float)(pontoAux.getX()-heightRearLight*0.15-widthRearLight*(0.1)),(float)(pontoAux.getY()-heightRearLight*0.1));
        headLightChrome.quadTo((float)(pontoAux.getX()-heightRearLight*0.29-widthRearLight*(0.1)),(float)(pontoAux.getY()-heightRearLight*0.5),(float)(pontoAux.getX()-heightRearLight*0.15-widthRearLight*(0.1)),(float)(pontoAux.getY()-heightRearLight*0.9));
        headLightChrome.lineTo((float)(pontoAux.getX()+heightRearLight*0.25-widthRearLight*(0.1)),(float)(pontoAux.getY()-heightRearLight*0.98));
        headLightChrome.closePath();
        
        GradientPaint gp1 = new GradientPaint((float)(pontoAux.getX()-heightRearLight*0.2-widthRearLight*(0.1)),(float)(pontoAux.getY()-heightRearLight*0.98),Color.white,(float)(pontoAux.getX()-heightRearLight*0.2-widthRearLight*(0.1)),(float)(pontoAux.getY()-heightRearLight*0.4),Color.lightGray,true);
        
        g2.setPaint(gp1);
        g2.fill(headLightChrome);
        g2.setPaint(Color.black);
        g2.draw(headLightChrome);
        
    }
    
    
    private void rearBumper(Graphics2D g2){
        
        
        rearBumperWidth=this.axleDistance*0.03+(rearBumperWidth*this.axleDistance*0.006);
        
        
        GeneralPath rearUpperBumper = new GeneralPath();
        GeneralPath rearLowerBumper = new GeneralPath();
        
        //altura e comp 1-5
        
        //este pontos, irão fazer com que o parachoques coincida com o chassis
        double auxx= rearX-(rearBumperWidth*1.8)*Math.cos(rearAngle);
        double auxy=rearY-(rearBumperWidth*1.8)*Math.sin(rearAngle);
        
        rearUpperBumper.moveTo((float)(rearX),(float)(rearY-rearBumperHeight*2));
        rearUpperBumper.lineTo((float)(rearX+rearBumperWidth*2.1),(float)(rearY-rearBumperHeight*2));
        rearUpperBumper.quadTo((float)(rearX+rearBumperWidth*2.3),(float)(rearY-rearBumperHeight*1.5),(float)(rearX+rearBumperWidth*2.2),(float)(rearY-rearBumperHeight*0.6));
        
        //parte de baixo dos para choques rearLowerBumper
        rearLowerBumper.moveTo((float)(rearUpperBumper.getCurrentPoint().getX()-rearBumperWidth*0.2),(float)(rearUpperBumper.getCurrentPoint().getY()));
        
        rearUpperBumper.lineTo((float)(rearX-rearBumperWidth*0.08),(float)(rearY-rearBumperHeight*0.6));
        
        rearLowerBumper.lineTo((float)(auxx),(float)(auxy));
        rearLowerBumper.lineTo((float)(rearX),(float)(rearY));
        rearUpperBumper.quadTo((float)(rearX-rearBumperWidth*1.5),(float)(rearY-rearBumperHeight*0.5),(float)(rearX-rearBumperWidth*0.2),(float)(rearY-rearBumperHeight*2));
        rearUpperBumper.closePath();
        
        
        
        rearLowerBumper.quadTo((float)(rearX-rearBumperWidth*0.2),(float)(rearY-rearBumperHeight*0.3),(float)(rearX-rearBumperWidth*0.2),(float)(rearY-rearBumperHeight*0.6));
        rearLowerBumper.closePath();
        
        GradientPaint gp1 = new GradientPaint((float)(rearX-rearBumperWidth),(float)(rearY-rearBumperHeight*0.3),Color.white,(float)(rearX-rearBumperWidth),(float)(rearY-rearBumperHeight),Color.lightGray,true);
        GradientPaint gp2 = new GradientPaint((float)(rearX-rearBumperWidth),(float)(rearY-rearBumperHeight*0.3),Color.lightGray,(float)(rearX-rearBumperWidth),(float)(rearY-rearBumperHeight),Color.white,true);
        
        
        
        g2.setPaint(gp1);
        g2.fill(rearUpperBumper);
        g2.setPaint(gp2);
        g2.fill(rearLowerBumper);
        g2.setPaint(Color.black);
        g2.draw(rearUpperBumper);
        g2.draw(rearLowerBumper);
        
    }
    
 private void shadow(Graphics2D g2){
        
        //desenho da sombra do carro
        
        double  ir=255;
        double  ig=255;
        double  ib=255;
        
        double  fr=0;
        double  fg=0;
        double  fb=0;
        
        double passor=(fr-ir)/(this.width*0.059);
        double passog=(fg-ig)/(this.width*0.059);
        double passob=(fb-ib)/(this.width*0.059);
        
        
        
        Ellipse2D shadow;
        
        for(int k=0;k<(this.width*0.059);k++){
            
            
            g2.setPaint(new Color((int)(ir),(int)(ig),(int)(ib)));
            
            shadow = new Ellipse2D.Double(k/2+this.ox+(this.width*0.27)-this.rearWidth,k/2+this.oy+(this.width*0.25),(this.width*0.61)+this.headWidth-k,(this.width*0.059)-k);
            g2.fill(shadow);
            ir+=passor;
            ig+=passog;
            ib+=passob;
            
        }
    }
    
    
    
    private void credits(Graphics2D g2){
        
        //creditos
        
        g2.setPaint(new Color(180,180,190));
        Font fonte = new Font("Serif",Font.ITALIC,30);
        Font fonte2 = new Font("SansSerif",Font.PLAIN,12);
        
        AttributedString title =new AttributedString("Cars of the 50's");
        AttributedString owner =new AttributedString("(c) jaime fins'04");
        title.addAttribute(TextAttribute.FONT,fonte);
        title.addAttribute(TextAttribute.FOREGROUND,new Color(150,150,160),12,16);
        owner.addAttribute(TextAttribute.FONT,fonte2);
        owner.addAttribute(TextAttribute.FOREGROUND,new Color(100,100,120));
        
        g2.drawString(title.getIterator(),30,50);
        g2.drawString(owner.getIterator(),(int)(800),(int)(50));
        g2.setPaint(new Color(220,220,220));
        Line2D linha = new Line2D.Double(250,45,790,45);
        g2.draw(linha);
        
        
        
    }
 
    
}
