//Base Class for implemented Shapes
class Shape
{
String name;

//Constructor
Shape(String newName)
{
name = newName;
}
//Returns Area (double)
double area()
{
return 0.0;
}
//Draws the Shape
void draw(){}
}

//Triangle Class
class Triangle extends Shape
{
int height,base;
int[][] dimensions;
Triangle(String newName, int newheight, int newbase)
{
super(newName + "(" + String.valueOf(newheight) + "," + String.valueOf(newbase) + ")");
height = newheight;
base = newbase;

}
@Override
double area()
{
return 0.5*height*base;
}
@Override
void draw()
{
   for (int i = 0; i < 3; i++)
   {
      switch(i)
      {
         case(0):
            System.out.print("  * \n");
	    break;
         case(1):
            System.out.print(" * *\n");
	    break;
         case(2):
            System.out.print(" ***\n");
	    break;
      }
   }    
}

}//End Triangle Class

//Circle Class
class Circle extends Shape
{
int radius;
Circle(String newname, int newradius)
{
super(newname + "(" + String.valueOf(newradius) + ")");
radius = newradius;

}
@Override
double area()
{
return 3.14159265359*(radius*radius);
}
@Override
void draw()
{
for (int i = 0; i < 5; i++)
{
switch(i)
{
case(0):
case(4):
   System.out.print(" *** \n");
   break;

case(1):
case(2):
case(3):
   System.out.print("*****\n");
   break;
}
}
}

}//End Circle Class

//Square Class
class Square extends Shape
{
int length;
Square(String newname, int newlength)
{
super(newname + "(" + String.valueOf(newlength) + ")");
length = newlength;
}

Square(String newname, int newwidth, int newlength)
{
super(newname + "(" + String.valueOf(newwidth) + "," + String.valueOf(newlength) + ")");
length = newlength;
}
@Override
double area()
{
return length*length;
}

@Override
void draw()
{
for(int i = 0; i < 3; i++)
{
switch(i)
{
case(0):
case(2):
   System.out.print(" ***\n");
   break;
case(1):
   System.out.print(" * *\n");
   break;
}
}

}
}//End Square Class


//Rectangle Class
class Rectangle extends Square
{
int width;
Rectangle(String newname, int newwidth, int newlength)
{
super(newname, newwidth, newlength);
width = newwidth;

}

@Override
double area()
{
return width * length;
}

@Override
void draw(){
for(int i = 0; i < 5; i++)
{
switch(i)
{
case(0):
case(4):
   System.out.print("****\n");
   break;
case(1):
case(2):
case(3):
   System.out.print("*  *\n");
   break;
}
}
}

}//End Rectangle Class

//ListNode Class
class ListNode
{
Shape info;
ListNode next;

ListNode(Shape newinfo, ListNode newnext)
{
info = newinfo;
next = newnext;
}

}

//Picture Class as LinkedList
class Picture
{
ListNode head;
ListNode tail;

Picture(){
head = null;
tail = null;
}

void add(Shape sh)
{
   if (head == null)
   {
     head = new ListNode(sh, null);
     tail = head;
   }
   else
   {
     tail.next = new ListNode(sh,null);
     tail = tail.next;
   }
}

void drawAll()
{
   for (ListNode p = head; p != null; p = p.next)
   {
	p.info.draw();
	System.out.print("\n\n\n");
   }
}

double totalArea()
{
   double count = 0.0;
   for (ListNode p = head; p != null; p=p.next)
   {
	double area = p.info.area();
	count += area;
        System.out.print(p.info.name + " : " + String.valueOf(area) + "\n\n\n");
   }
   return count;
}
}//End of Picture Class



public class mainClass
{
   static void println(double d)
   {
      System.out.println("Double d is " + String.valueOf(d));
   }

   public static void main(String[] args)
   {
      Picture p = new Picture();
      p.add(new Triangle("FirstTriangle",5,5));
      p.add(new Triangle("SecondTriangle",4,4));
      p.add(new Circle("FirstCircle",5));
      p.add(new Circle("SecondCircle", 4));
      p.add(new Square("FirstSquare",5));
      p.add(new Square("SecondSquare", 4));
      p.add(new Rectangle("FirstRectangle",5,5));
      p.add(new Rectangle("SecondRectangle",4,4));
      double totalArea = p.totalArea();
      System.out.print("Total Area : " + String.valueOf(totalArea) + "\n");
      p.drawAll();  
   }
}



