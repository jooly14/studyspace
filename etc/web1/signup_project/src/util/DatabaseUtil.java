 p a c k a g e   u t i l ;  
  
 i m p o r t   j a v a . s q l . C o n n e c t i o n ;  
 i m p o r t   j a v a . s q l . D r i v e r M a n a g e r ;  
  
 p u b l i c   c l a s s   D a t a b a s e U t i l   {  
 	 p u b l i c   s t a t i c   C o n n e c t i o n   g e t C o n n e c t i o n ( )   {  
 	 	 t r y   {  
 	 	 	 S t r i n g   d b U R L   =   " j d b c : m y s q l : / / l o c a l h o s t : 3 3 0 6 / T U T O R I A L " ;  
 	 	 	 S t r i n g   d b I D   =   " r o o t " ;  
 	 	 	 S t r i n g   d b P W   =   " r o o t " ;  
 	 	 	   C l a s s . f o r N a m e ( " c o m . m y s q l . c j . j d b c . D r i v e r " ) ;  
 	 	 	 r e t u r n   D r i v e r M a n a g e r . g e t C o n n e c t i o n ( d b U R L , d b I D , d b P W ) ;  
 	 	 } c a t c h ( E x c e p t i o n   e ) {  
 	 	 	 e . p r i n t S t a c k T r a c e ( ) ;  
 	 	 }  
 	 	 r e t u r n   n u l l ;  
 	 }  
 }  
