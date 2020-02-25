
/* Function for reversing list */
my_reverse([H|T],R) :- h_reverse([H|T], R, []).
h_reverse([H|T], L, SoFar) :- h_reverse(T, L, [H|SoFar]).  
h_reverse([], L, L).

/* Function for giving size of List */
my_length([_|T], Y) :- my_length(T ,NewY), Y is NewY + 1.
my_length([],0).

/* my_subset */
my_subset(_, [], []).
my_subset(X, [H|T], Y):- Cond =.. [X,H], (Cond -> Y = [H|Ytail], my_subset(X, T, Ytail); my_subset(X,T,Y)).

/*my_member */
my_member(X, [X|_]).
my_member(X, [_|T]) :- my_member(X,T).

/*my_intersect*/
my_intersect([], _, []).
my_intersect([H|T], L2, L3) :- my_member(H, L2), !, L3 = [H|L3tail], my_intersect(T, L2, L3tail).
my_intersect([_|T], L2, L3) :- intersection(T, L2,L3).


/*compute change */
compute_change(M,Q,D,N,P):- Q is M//25, D is (M - Q * 25)//10, N is (M - Q * 25 - D * 10)//5, P is (M - Q * 25 - D * 10 - N * 5)//1.


/* compose */

compose(L1,L2,L3):- h_compose(L1,L2,L3,0).
h_compose([L1head|L1tail],[L2head|L2tail],L3,A):- (0 is A mod 2 -> NewA is A + 1, L3 = [L1head|L3tail], h_compose(L1tail,[L2head|L2tail],L3tail, NewA); NewA is A + 1, L3 = [L2head|L3tail], h_compose([L1head|L1tail], L2tail, L3tail, NewA)).
h_compose([],L2,L3,_):- append(L3,L2,L3).
h_compose(L1,[],L3,_):- append(L3,L1,L3).

/*palindrome*/
palindrome(L, R) :- my_reverse(L,Temp), append(L,Temp,R).
palindrome(X, L) :- my_length(L,Length), Len is Length//2, h_palindrome(X, L, Len).
h_palindrome(X, [H|T], Len) :- NewLen is Len - 1, NewX = [H|Xtail], h_palindrome(NewX, T, NewLen).
h_palindrome(_, _, 0). 
