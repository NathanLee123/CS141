#ifndef VECTOR_H
#define VECTOR_H
#include <iostream>
using namespace std;

template
	<typename T> // Assume Vector only takes in int or double for T
class Vector {
private:
	int sz; 	// the number of elements in this Vector
	T* buf; 	// the base of the array of Ts, you must allocate it
public:
	Vector(int n) // Vector v1(10); -- create a 10 element Vector
	{
		// Allocate buf and set size
		buf = new T[n];
		sz = n;
	}
	Vector(initializer_list<T> L) // Vector v1{T1, T2, T3};
	{
		// Allocate buf and set size
		sz = L.size();
		buf = new T[sz];
		int count = 0;
		for (typename std::initializer_list<T>::iterator it = L.begin(); it != L.end(); it ++)
		{
			buf[count] = *it;
			count++;
		}
	}
	~Vector() //destructor called automatically when a Vector dies 
	{
		// Deallocate buf
		delete [] buf;
	}
// Destructor should free memory used. your program should have no leak/lost/still-reachable/errors(suppressed or not), besides 72704 bytes in one still-reachable block (a g++/valgrind bug on some versions). 
	Vector(const Vector & v) // Vector v2(v1); deep-copy
	{
		// Implementation Here;
		T * tempbuf = new T[v.sz];
		sz = v.sz;
		for ( int i = 0 ; i < sz; i++)
		{
			tempbuf[i] = v.buf[i];
		}
		buf = tempbuf;

	}
int size() const // v1.size() returns 10 for v1 example above
	{
		// Implementation Here;
		return sz;
	}
T & operator [] (const int i) // T x = V[i]; 
	{
		// Implementation Here;
		if (i >= sz)
		{
			throw;
		}
		return buf[i];
	}
//Access out-of-bound index should throw an error to be caught in outside scope 
	T operator * (const Vector & v) const
	{
		// Implementation Here;
		T x = 0;
		if (v.sz == 0  or sz == 0)
		{
			return x;
		}
		else
		{
			if (v.sz >= sz)
			{
				T * vtemp = v.buf;
				T * temp = buf;
				for (int i = 0 ; i < sz ; i++)
				{
					x += vtemp[i] * temp[i];
					
				}			
			}

			else
			{
				T * vtemp = v.buf;
				T * temp = buf;
				for (int i = 0 ; i < v.sz ; i++)
				{
					x += vtemp[i] * temp[i];
					
				}	
			}
		}
		return x;
	}

// T x = V1 * V2; dot product
// e.g. [1, 2] * [3, 4, 5] = 1 * 3 + 2 * 4 + 0 = 11
// Assume an empty Vector will cause the product to be 0.
	Vector operator + (const Vector & v) const 
// V3 = V1 + V2; [1, 2, 3] + [4, 5, 6, 7] = [5, 7, 9, 7]
	{

		// Implementation Here;
		if (v.sz >= sz)
		{
			Vector<T> n = Vector<T>(v.sz);
			std::copy(v.buf, v.buf+v.sz, n.buf);
			for (int i = 0 ; i < sz; i++)
			{
				n.buf[i] += buf[i];
			}
			return n;
		}
		
		else
		{
			Vector<T> n = Vector<T>(sz);
			std::copy(buf, buf+sz, n.buf);
			for (int i = 0 ; i < v.sz; i++)
			{
				n.buf[i] += v.buf[i];
			}
			return n;
		}
	}
	const Vector & operator = (const Vector & v) // V1 = V2;
	{
		// Implementation Here;

	}
	bool operator == (const Vector & v) const // if (V1 == V2)...
	{
		// Implementation Here;
		if (v.sz != sz)
		{
			return false;
		}
		else
		{
			for( int i = 0 ; i < sz; i++)
			{
				if (buf[i] != v.buf[i])
					return false;
			}
		}
		return true;
	}
	bool operator != (const Vector & v) const // if (V1 != V2)...
	{
		// Implementation Here;
		if (v.sz != sz)
		{
			return true;
		}
		else
		{
			for( int i = 0 ; i < sz; i++)
			{
				if (buf[i] != v.buf[i])
					return true;
			}
		}
		return false;
	}
	friend Vector operator * (const int n, const Vector & v)
	// V1 = 20 * V2; -- each element of V1 is element of V2 * 20
	{
		// Implementation Here;
		Vector<T> ret = Vector<T>(v.sz);
		for (int i = 0; i < v.sz; i++)
		{
			ret.buf[i] = v.buf[i] * n;
		}
		return ret;
	}
	friend Vector operator + (const int n, const Vector & v)
	// V1 = 20 + V2; -- each element of V1 is element of V2 + 20
	{
		// Implementation Here;
		Vector<T> ret = Vector<T>(v.sz);

		for (int i = 0; i < v.sz; i++)
		{
			ret.buf[i] = v.buf[i] + n;
		}
		return ret;
	}
	friend ostream& operator << (ostream & o, const Vector & v)
	// cout << V2; -- prints the vector in this format 
// (v0, v1, v2, ... vn-1);
	{
		// Implementation Here;
		o << "(";
		for(int i = 0 ; i < v.sz-1; i++)
		{
			o << v.buf[i] << ", ";
		}
		o << v.buf[v.sz-1];
		o << ")" << endl;;
		return o;
	}
};
#endif
