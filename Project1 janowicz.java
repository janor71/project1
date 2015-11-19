


/// PROJECT 1

// REBECA JANOWICZ   CST 112 EVENING 11/12/2015

/* THE BID, BAD monsterTER CHASES THE BRAVE HERO, LITTLE HERO WHO CHASES AFTER 
THE GOLD, WHILE THE SUN MOVES ACROSS THE SKY */

String author = "Rebeca Janowicz";
//String title = " SCORE = ";
String help = " Click ' r ' to reset" ;
// Global cordinates, hero, gold and monsterter variables

float gold = 0;
float horizon;
float sunX,sunY;
float tree = 0;
float heroX, heroY;
float heroDX, heroDY;
float monsterX, monsterY;
float monsterDX,  monsterDY;
float goldX, goldY;
float goldDX, goldDY;
int score;
int count  = 0;



void setup (){
   size(1000,800);
  // score = 0;
   horizon = height/4;
   monsterDX= random(1,3);                 monsterDY= random(1,3);
   monsterX= width/3;                      monsterY= random(horizon, height);
   reset();
}
  void  reset () {
   heroX= 105;
   heroY= 245;     
  //frameRate(30);
  heroDX= 3;
  heroDY= 2;
  goldX = random(0, width);               goldDX = random(1,5);
  goldY = random(horizon, height);        goldDY = random(1,5);
  score = 0;
  }

  
void draw(){
    scene();
    house();
    tree(320,150);
    tree(320,185);
    tree(270,170);
    tree(270,200);
    tree(350,175);
    tree(350,200);
    monster();
    hero();
    gold();
    messages();
    count = count +1;
}

//grass and sky
  void scene(){
    
   // GRASS 
   background(168,171,245);
   fill(20,142,43);
   rect(0,horizon+100, width, height*3/4);              
   
 // SUN   
    fill( 247,237,32); 
    noStroke();
    ellipse(sunX+20, sunY+50, 100,100);
    
   sunX = sunX+1;
      if (sunX > width){ sunX = sunX *-1; }
      
   sunY = sunY + 1;
      if (sunY > horizon/4 || sunY < height) {sunY = sunY * -1;  }
 
  
  }
  void messages () {
     fill(0);
     textSize(15);
     text( help, 800, 280 );
     text( author, 800,260 );
     textSize(20);
     text( "Score = ", 800,300 );
  }
  
    // HOUSE   
   void house() {
    stroke(0);
    fill(167,161,98);       
    rect(50,175,150,125);                                    //frame
    fill(77,66,67);
    triangle(50, 175, 125, 50, 200,175);                    // roof
    fill(160,10,20); 
    rect(90,50,20,60);                                     // cheminee
    fill(255);
    rect(65,185,30,50);                                    //  windows
    rect(155,185,30,50);                                   //  windows
    fill(75,71,57); 
    rect(105,245,30,55);                                   //  door
    fill(0); 
  }
  
//TREE 
  void tree (float treeX, float treeY) {  
    fill(19,131,49);
    noStroke();
    triangle(treeX+40,treeY+65,treeX+80,treeY+10,treeX+115,treeY+65);
    fill(116,65,33);
    rect(treeX+70,treeY+80,15,45);
  }
 
 void hero() {
 // BODY
     fill(69,185,142);                    //body's color
     rect( heroX,heroY-5, 40,80 );               // body
     //rect( x+90,y+235, 40,80 );               // body
     fill(250,210,172);                  //head color
     ellipse(heroX+18,heroY-40,50,50);           // head
     fill(250,210,172);                  //neck color
     rect(heroX+15,heroY-15,10,10);              //neck
 // ARMS  
     float shoulder = heroY-30; strokeWeight(5);                 
     stroke(250,210,175);       // arm color
     if (count /30%2==0) {
       line(heroX, shoulder+25, heroX-25, heroY-10);     //  Left shoulder 
       line(heroX+40, shoulder+25, heroX+60, heroY+10);  //  Rigth shoulder
   
     }else {
       line(heroX, shoulder+25, heroX-25, heroY+20);     //  Left shoulder 
       line(heroX+40, shoulder+25, heroX+60, heroY-20);  //  Rigth shoulder
     }
     
     stroke(0);
     strokeWeight(1);
// FACIAL FEUTURES     
     fill(255);                          // eye color
     ellipse(heroX+7,heroY-50,9,5);              // eye sclera
     ellipse(heroX+25,heroY-50,9,5);             // eye sclera
     fill(88,144,198,198);               // pupil color
     ellipse(heroX+7,heroY-50,2,5);              // pupil
     ellipse(heroX+25,heroY-50,2,5);             // pupil
     fill(0);                            // nose's color
     ellipse(heroX+15,heroY-40,3,6);             // nose
     fill(255);                      // lip's color
     ellipse(heroX+15,heroY-30,12,3);            // upper lip
     ellipse(heroX+16,heroY-27,9,3);             // lower lip
// FEET     
     fill(149,81,35);                    // shoes' color 
     ellipse(heroX+5, heroY+75,25,7);            // left shoe
     ellipse(heroX+35, heroY+75,25,7);           // right shoe
     fill(255,255,0);
     textSize(11);
     text( "Vienna", heroX+3,heroY+20 );

// hero follows gold
      /* heroX= heroX - ( heroX - goldX)/30;
       heroY= heroY- (heroY - goldY)/40; 
 if (dist(goldX, goldY, heroX, heroY)<20) { reset(); score+= 100;
 }*/
}
  void monster() { 
    
   fill(219,68,27);
   stroke(0);
  // arc(monsterX+40, monsterY+40, 80, 80, 0, PI+QUARTER_PI, PIE);               // body
  if((count /45%2==0)  ) 
     arc(monsterX+40, monsterY+40, 80, 80, 0, PI+QUARTER_PI, PIE);               // body
  else
     arc(monsterX+40, monsterY+40, 80, 80, -PI*0.125, 1.75*PI, PIE);               // body

   fill(255);
   ellipse(monsterX+20, monsterY+35, 12, 12);                                 // sclera
   fill(0);
   ellipse(monsterX+20, monsterY+35,5,5);                                    // pupil
 
   
   // Monster moves around 
  monsterX = monsterX + monsterDX;                            
    if (monsterX > width-40) { monsterDX= monsterDX *-1 ; }
    if (monsterX < 20) {  monsterDX= monsterDX* -1; }
    
  monsterY= monsterY+ monsterDY; 
      if (monsterY > height-75 || monsterY < 350) { monsterDY= monsterDY *-1; }
      
      monsterX = monsterX - ( monsterX - heroX)/50;
       monsterY= monsterY- (monsterY - heroY)/80; 
 if (dist(heroX, heroY, monsterX, monsterY)<20) { score-= 50;}
 
 }
 void gold () {
   fill(219,204,66);
   noStroke();
   ellipse(goldX,goldY,40,40);
  
   heroX= heroX - ( heroX - goldX)/30;
   heroY= heroY- (heroY - goldY)/40; 
 if (dist(goldX, goldY, heroX, heroY)<20) { reset(); score+= 100;
 }
   
 }
 void keyPressed() {
      if (key == 'q') exit();
      if (key == 'r') reset();
    }
     
