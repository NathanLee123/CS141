(defun my-length(L)
	(cond ((null L) 0)
		(t (+ 1 (my-length(cdr L))))))

(defun my-memq (A L)
	(cond ((null L) nil)
		((eq (car L) A) L)
		(t (my-memq A (cdr L)))
        )
)

(defun my-append (L1 L2)
	( cond ((null L1) L2)
		(t (cons (car L1) (my-append (cdr L1) L2)))
        )
)

(defun my-attach (O L)
	(my-append L (cons O nil))
)


(defun my-assoc (A L)
	(cond ((null L) nil)
		((eq A (car (car L))) (car L)) 	
		(t (my-assoc A (cdr L)))
	)
)

(defun freq (A L)
	(cond ((null L) 0)
		((and (eq (atom (car L)) t) (eq (car L) A))(+ 1 (freq A (cdr L))))
		((eq (atom (car L)) t)(+ 0 (freq A (cdr L)))) 
		
		((eq (listp (car L)) t)(+ (freq A (cdr L))(freq A (car L))))
	)		 
)

(defun mapping (L val)
	(cond ((null L) nil)
		(( < (car (car L)) val) (cons (car (cdr (car L))) (mapping (cdr L) val)))
		(t (mapping (cdr L) val))
	)
)


(defun my-last( A L)
	(cond ((null L) x)
		((eq A (car L))(setq x L)(my-last A (cdr L)))
		(t (my-last A (cdr L)))		
	)
)

(defun my-reverse (L)
	(cond ((null L) '())
		(t (my-append (my-reverse (cdr L)) (cons (car L) nil)))
	)
)

(defun is-pattern? (pat str)
	(cond ((null str) nil)
		((equal pat str) str)
		(t (is-pattern pat (cdr str)))	
	)
)

(defun first-atom (L)
	(cond ((null L) nil)
		((eq (listp (car L)) t)(first-atom (car L)))
		((eq (atom (car L)) t) (car L))

	)
)

(defun find-all (A L)
	(cond ((null L) '())
		((listp (car L))(setq x L)(my-append (find-all A (car L)) (find-all A (cdr L))))
		((and (atom (car L))(eq A (car L))(eq (cdr L) nil)) (my-append (cons (first-atom (cdr x)) nil)(find-all A (cdr L))))
		((and (atom (car L))(eq A (car L))) (my-append (cons (first-atom (cdr L)) nil) (find-all A (cdr L))))
		((atom (car L))(find-all A (cdr L)))
	)
)

		


