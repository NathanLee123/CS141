door_between(bedroom,hiddenchamber).
door_between(hiddenchamber, basement).


door_between(a,b).
door_between(a,c).
door_between(a,d).
door_between(b,c).
door_between(b,e).
door_between(d,c).
door_between(d,e).
door_between(e,c).

path_from(X,X,[]).
path_from(S,D,R):- path(S,D,L,R).

path(X,X,L,R):- append(L,[X],R).
path(S,D,L,R):- (L = [] -> NewL = [S]; append(L,[S],NewL)) ,(door_between(S,X); door_between(X,S)) , \+member(X,NewL), path(X,D,NewL,R). 

deriv(X,Y):- d(X,Y).
d(X,0):- number(X).
d(x,1).
d(-x,-1).
d(X^0,0).
d(X^1, 1).
d(X^2, 2*X).
d(C * x, C).
d(x^N, DX):- M is N -1, (N > 0 -> DX = N*x^M ; NewM is -1 * M, DX = N/x^NewM ). 
d(X1 * X^N, DX):- DX1 is X1 * N, Temp is N-1, (Temp = 1 -> DX2 = X ;DX2 = X^Temp), DX = DX1 * DX2. 
d(X1+X2-X3+X4-X5,DX):- d(X1,DX1),d(X2,DX2),d(X3,DX3),d(X4,DX4),d(X5,DX5),check(DX5,D5), DX = DX1 + DX2 - DX3 + DX4 + D5.
d(X1+X2,DX1 + DX2 ):- d(X1,DX1),d(X2,DX2).
d(X1/X2,DX):- d(X2^(-1),DX). 
d(-(X),DX):- d((-1)*X,DX).

check(X1/X2, X3/X2):- X3 is (-1) * X1.



female(emily).
female(heidi).
female(susan).
female(beth).
female(jane).

speaks(emily,english).
speaks(heidi,english).
speaks(beth,french).
speaks(susan,french).
speaks(susan,spanish).
speaks(jane,spanish).
speaks(klefstad,english).
speaks(klefstad,spanish).
speaks(bill,english).
speaks(bill,spanish).
speaks(mark,french).
speaks(fred,spanish).
speaks(issac, english).
speaks(issac,french).

male(klefstad).
male(bill).
male(issac).
male(mark).
male(fred).


party_seating(L):- seating(L,S,0).
seating(L,S,10).
seating(L,S,R):- (R = 0 -> female(G), append([G],[],NewL), seating(NewL,S,R+1); [H|T] = L,(female(H) -> (male(M),\+member(M,L),speaks(M,Lang),speaks(H,Lang)), append([M],L,NewL), seating(NewL,S,R+1); (female(G),\+member(G,L),speaks(G,Lang),speaks(H,Lang)), append([G],L,NewL), seating(NewL,S,R+1))).




