 p a c k a g e   u s e r ;  
  
  
 i m p o r t   j a v a . s q l . C o n n e c t i o n ;  
 i m p o r t   j a v a . s q l . P r e p a r e d S t a t e m e n t ;  
  
 i m p o r t   u t i l . D a t a b a s e U t i l ;  
  
 p u b l i c   c l a s s   U s e r D A O   {  
 	 p u b l i c   i n t   j o i n ( S t r i n g   u s e r I D ,   S t r i n g   u s e r P W )   {  
 	 	 S t r i n g   S Q L   =   " I N S E R T   I N T O   U S E R   V A L U E S ( ? , ? ) " ;  
 	 	 S y s t e m . o u t . p r i n t l n ( " j o i n ( ) " ) ;  
 	 	 t r y   {  
 	 	 	 C o n n e c t i o n   c o n n   =   D a t a b a s e U t i l . g e t C o n n e c t i o n ( ) ;  
 	 	 	 P r e p a r e d S t a t e m e n t   p s t m t   =   c o n n . p r e p a r e S t a t e m e n t ( S Q L ) ;  
 	 	 	 p s t m t . s e t S t r i n g ( 1 , u s e r I D ) ;  
 	 	 	 p s t m t . s e t S t r i n g ( 2 , u s e r P W ) ;  
 	 	 	 r e t u r n   p s t m t . e x e c u t e U p d a t e ( ) ;  
 	 	 } c a t c h ( E x c e p t i o n   e )   {  
 	 	 	 e . p r i n t S t a c k T r a c e ( ) ;  
 	 	 }  
 	 	 r e t u r n   - 1 ;  
 	 }  
 }  
