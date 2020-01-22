#include <malloc.h>
#include <stdio.h>



typedef double(*VirtualMethodPointer)(void *);
typedef VirtualMethodPointer * VTableType;


//---------------------------------------------------------Start of Class Shape
typedef struct Shape
{
   VTableType VPointer;
   char* name;
}Shape;

double Shape_area(Shape* _this)
{
   return 0.0;
}

void Shape_draw(Shape* _this)
{
   printf("\n");
}

void Shape_name(Shape* _this)
{
   printf(_this->name);
}

VirtualMethodPointer Shape_VTable [] = 
{
   (VirtualMethodPointer)Shape_area,
   (VirtualMethodPointer)Shape_draw,
   (VirtualMethodPointer)Shape_name
};

Shape * Shape_Shape(Shape * _this, char* newName)
{
   _this->VPointer = Shape_VTable;
   _this->name = newName;
   return _this;
}

//---------------------------------------------------------End of Class Shape


//--------------------------------------------------------Start of Class Circle
typedef struct Circle
{
   VTableType VPointer;
   char* name;
   double radius;
}Circle;


double Circle_area(Circle* _this)
{
   double PI = 3.141592;
   return PI * _this->radius * _this->radius;
}

void Circle_draw(Circle* _this)
{
  printf("\n") ;
  for(int i = 0; i < 5 ; i++)
  {
     switch(i)
     {
        case 0:
        case 4:
	  printf(" *** \n");
	  break;
	case 1:
	case 2:
	case 3:
	  printf("*****\n");
	  break; 
     }
  }
}

void Circle_args(Circle* _this)
{
   printf("(%f,%f) : ", _this->radius, _this->radius);
}

VirtualMethodPointer CircleVTable [] = 
{
   (VirtualMethodPointer)Circle_area,
   (VirtualMethodPointer)Circle_draw,
   (VirtualMethodPointer)Shape_name,
   (VirtualMethodPointer)Circle_args
};

Circle * Circle_Circle(Circle* _this, char* newName, double newRadius)
{
   Shape_Shape((Shape *)_this, newName);
   _this->VPointer = CircleVTable;
   _this->radius = newRadius;
   return _this;
}
//--------------------------------------------------------End of Class Circle

//-------------------------------------------------------Start of Class Square
typedef struct Square
{
   VTableType VPointer;
   char* name;
   double length;
}Square;

double Square_area(Square* _this)
{
   return _this->length * _this->length;
}

void Square_draw(Square* _this)
{
   printf("\n");
   for(int i = 0 ; i < 5; i++)
   {
      switch(i)
     {
        case 0:
        case 4:
	  printf("*****\n");
	  break;
	case 1:
	case 2:
	case 3:
	  printf("*   *\n");
	  break; 
     }
   }
}

void Square_args(Square* _this)
{
   printf("(%f) : ", _this->length);
}

VirtualMethodPointer SquareVTable [] = 
{
   (VirtualMethodPointer)Square_area,
   (VirtualMethodPointer)Square_draw,
   (VirtualMethodPointer)Shape_name,
   (VirtualMethodPointer)Square_args
};

Square * Square_Square(Square* _this, char * newName, double newLength)
{
   Shape_Shape((Shape *)_this, newName);
   _this->VPointer = SquareVTable;
   _this->length = newLength;
   return _this;
   
}
//-------------------------------------------------------End of Class Square

//-------------------------------------------------------Start of Class Triangle

typedef struct Triangle
{
   VTableType VPointer;
   char* name;
   double height;
   double base;
}Triangle;

double Triangle_area(Triangle* _this)
{
   return 0.5 * _this->height * _this->base;
}

void Triangle_draw(Triangle* _this)
{
   printf("\n");
   for(int i = 0; i < 5; i++)
   {
      switch(i)
     {
        case 0:
	  printf("    *\n");
	  break;
	case 1:
	  printf("   **\n");
	  break;
	case 2:
	  printf("  ***\n");
	  break;
	case 3:
	  printf(" ****\n");
	  break;
	case 4:
	  printf("*****\n");
          break;
     } 
   }
}

void Triangle_arg(Triangle* _this)
{
   printf("(%f,%f) : ",_this->height,_this->base);
}

VirtualMethodPointer TriangleVTable [] = 
{
   (VirtualMethodPointer)Triangle_area,
   (VirtualMethodPointer)Triangle_draw,
   (VirtualMethodPointer)Shape_name,
   (VirtualMethodPointer)Triangle_arg
};

Triangle * Triangle_Triangle(Triangle * _this, char* newName, double newBase, double newHeight)
{
   Shape_Shape((Shape*)_this, newName);
   _this->VPointer = TriangleVTable;
   _this->height = newHeight;
   _this->base = newBase;
   return _this;
}

//-------------------------------------------------------End of Class Triangle

//-------------------------------------------------------Start of Class Rectangle

typedef struct Rectangle
{
   VTableType VPointer;
   char* name;
   double width;
   double height;
}Rectangle;

double Rectangle_area(Rectangle* _this)
{
   return _this->height * _this->width;
}

void Rectangle_draw(Rectangle* _this)
{
   printf("\n");
   for(int i = 0; i < 7 ; i++)
   {
       switch(i)
       {
	case 6:
        case 0:
	   printf("*****\n");
	   break;
	
	case 5:
        case 4:
	case 1:
	case 2:
	case 3:
	   printf("*   *\n");
	   break;
       }
   }
}

void Rectangle_args(Rectangle* _this)
{
   printf("(%f,%f) : ", _this->width, _this->height);
}


VirtualMethodPointer RectangleVTable[] = 
{
   (VirtualMethodPointer)Rectangle_area,
   (VirtualMethodPointer)Rectangle_draw,
   (VirtualMethodPointer)Shape_name,
   (VirtualMethodPointer)Rectangle_args
};

Rectangle * Rectangle_Rectangle(Rectangle * _this, char* newName, double newWidth, double newHeight)
{
   Square_Square((Square *)_this, newName, newWidth);
   _this->VPointer = RectangleVTable;
   _this->width = newWidth;
   _this->height = newHeight;
   return _this;
}

//-------------------------------------------------------End of Class Rectangle


//--------------------------------------------------------Main Function

int main()
{
   Shape * a[] = {
      (Shape*)Triangle_Triangle((Triangle *)malloc(sizeof(Triangle)),(char*)"FirstTriangle",12,15),
      (Shape*)Triangle_Triangle((Triangle *)malloc(sizeof(Triangle)),(char*)"SecondTriangle",11,14),

      (Shape*)Circle_Circle((Circle *)malloc(sizeof(Circle)),(char*)"FirstCircle",12),
      (Shape*)Circle_Circle((Circle *)malloc(sizeof(Circle)),(char*)"SecondCircle",11),

      (Shape*)Square_Square((Square *)malloc(sizeof(Square)),(char*)"FirstSquare",12),
      (Shape*)Square_Square((Square *)malloc(sizeof(Square)),(char*)"SecondSquare",11),
 
      (Shape*)Rectangle_Rectangle((Rectangle *)malloc(sizeof(Rectangle)), (char*)"FirstRectangle", 12,15),
      (Shape*)Rectangle_Rectangle((Rectangle *)malloc(sizeof(Rectangle)), (char*)"SecondRectangle",11,14),


   };
   double total = 0.0;
   for (int i = 0 ; i < sizeof(a)/sizeof(*a); i++)
   {
      (a[i]->VPointer[2])(a[i]);
      (a[i]->VPointer[3])(a[i]);
      printf("%f\n", (a[i]->VPointer[0])(a[i]));
      total += (a[i]->VPointer[0])(a[i]);
      (a[i]->VPointer[1])(a[i]);
   }
   printf( "Total : %f",total);
   return 0;
}
