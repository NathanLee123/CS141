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


party_seating(L):- seating(L,0).
seating(_,10).
seating(L,R):- [H|_] = L,  (R = 0 -> female(G), R is 1 , seating([G|L],R); R is R + 1, (female(H) -> male(M), speaks(M,Lang), speaks(H,Lang), seating([M|L],R) ; female(G),speaks(G,Lang),speaks(H,Lang),seating([G|L],R))).



