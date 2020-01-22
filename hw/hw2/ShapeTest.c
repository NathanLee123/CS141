#include <malloc.h>
#include <iostream>
using namespace std;

//---------------------------------------------------------Start of Class Shape

struct Shape
{
   VTableType Vpointer;
   char[30] name;
};

double Shape_area(Shape* _this)
{
   return 0.0;
}

void Shape_draw(Shape* _this)
{
   cout << "" << endl;
}

VirtualMethodPointer Shape_VTable [] = 
{
   (VirtualMethodPointer)Shape_area,
   (VirtualMethodPointer)Shape_draw
};

Shape * Shape_Shape(Shape * _this, char[30] newName)
{
   _this->VPointer = Shape_VTable;
   _this->name = newName;
   return void;
}

//---------------------------------------------------------End of Class Shape


//--------------------------------------------------------Start of Class Circle
struct Circle
{
   VtableType VPointer;
   double radius;
};


double Circle_area(Circle* _this)
{
   return PI * _this->radius * _this->radius * 0.5;
}

void Circle_draw(Circle* _this)
{
  for(int i = 0; i < 5 ; i++)
  {
     switch(i)
     {
        case 0:
        case 4:
	  cout << " *** " << endl;
	  break;
	case 1:
	case 2:
	case 3:
	   cout << "*****" << endl;
	   break; 
     }
  }
}

VirtualMethodPointer CircleVTable [] = 
{
   (VirtualMethodPointer)Circle_area,
   (VirtualMethodPointer)Circle_draw
};
 Circle* Circle_Circle(Circle* _this, char[30] newName, double newRadius)
{
   Shape_Shape((Shape *)_this, newName);
   _this->VPointer = CircleVTable;
   _this->radius = newRadius;
   return void;
}
//--------------------------------------------------------End of Class Circle

//--------------------------------------------------------Main Function

int main()
{
   Shape * a[] = {
      Shape_Shape((Shape *)malloc(sizeof(Shape)), "FirstShape"),
      Shape_Shape((Shape *)malloc(sizeof(Shape)), "SecondShape"),
      Shape_Shape((Shape *)malloc(sizeof(Shape)), "ThirdShape"),
      ((Shape *)Circle_Circle((Circle *), "FirstCircle", 1.0)),
      ((Shape *)Circle_Circle((Circle *), "SecondCircle", 2.0)),
      ((Shape *)Circle_Circle((Circle *), "ThirdCircle", 3.0))
   };

//   for (int i = 0 ; i <sizeof(a)/sizeof(*a); i++)
//   {
//   }
}
