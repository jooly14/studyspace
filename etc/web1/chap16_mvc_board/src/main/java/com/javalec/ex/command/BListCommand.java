 p a c k a g e   c o m . j a v a l e c . e x . c o m m a n d ;  
  
 i m p o r t   j a v a . u t i l . A r r a y L i s t ;  
  
 i m p o r t   o r g . s p r i n g f r a m e w o r k . u i . M o d e l ;  
  
 i m p o r t   c o m . j a v a l e c . e x . d a o . B D a o ;  
 i m p o r t   c o m . j a v a l e c . e x . d t o . B D t o ;  
  
 p u b l i c   c l a s s   B L i s t C o m m a n d   i m p l e m e n t s   B C o m m a n d   {  
  
 	 @ O v e r r i d e  
 	 p u b l i c   v o i d   e x e c u t e ( M o d e l   m o d e l )   {  
 	 	 / /   T O D O   A u t o - g e n e r a t e d   m e t h o d   s t u b  
 	 	 B D a o   b D a o   =   n e w   B D a o ( ) ;  
 	 	 A r r a y L i s t < B D t o >   b D t o s   =   b D a o . l i s t ( ) ;  
 	 	  
 	 	 m o d e l . a d d A t t r i b u t e ( " l i s t " ,   b D t o s ) ;  
 	 }  
  
 }  
