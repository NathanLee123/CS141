#include "vector.h"


int main() // I’ll start it for you
{
	Vector<int> intVec{1,3,5,7,9};
	Vector<double> doubleVec{1.5,2.5,3.5,4.5};
	Vector<int> iv{1,3,5,7};
	Vector<double> dv(doubleVec);
	double x = doubleVec * dv;
	cout << x << endl;



	Vector<int> addVector = intVec + iv;

	cout << "addVector" << addVector << endl;

	Vector<int> op_plus = 5 + addVector;

	cout << "op_plus" << op_plus << endl;

	Vector<int> op_mult = 5 * addVector;

	cout << "op_mult" << op_mult << endl;

	if (addVector != intVec)
	{
		cout << "Correct" << endl;
	}

	if (addVector == addVector)
	{
		cout << "Correct" << endl;
	}

	cout << "intVec" << intVec << endl;
// "intVec(1, 3, 5, 7, 9)" 
	cout << "iv" << iv << endl; 
// "iv(1, 3, 5, 7, 9)"
	cout << "doubleVec" << doubleVec << endl; 
// "doubleVec(1.5, 2.5, 3.5, 4.5)" 
    cout << "dv" << dv << endl; 
// "dv(1.5, 2.5, 3.5, 4.5)" 

	// add at least one test case for each method defined in Vector
return 0;
}
