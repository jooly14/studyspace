 p a c k a g e   c o m . j a v a l e c . e x . c o m m a n d ;  
  
 i m p o r t   j a v a . u t i l . M a p ;  
  
 i m p o r t   j a v a x . s e r v l e t . h t t p . H t t p S e r v l e t R e q u e s t ;  
  
 i m p o r t   o r g . s p r i n g f r a m e w o r k . u i . M o d e l ;  
  
 i m p o r t   c o m . j a v a l e c . e x . d a o . B D a o ;  
 i m p o r t   c o m . j a v a l e c . e x . d t o . B D t o ;  
  
 p u b l i c   c l a s s   B C o n t e n t C o m m a n d   i m p l e m e n t s   B C o m m a n d {  
  
 	 @ O v e r r i d e  
 	 p u b l i c   v o i d   e x e c u t e ( M o d e l   m o d e l )   {  
 	 	 / /   T O D O   A u t o - g e n e r a t e d   m e t h o d   s t u b  
 	 	 M a p < S t r i n g ,   O b j e c t >   m a p   =   m o d e l . a s M a p ( ) ;  
 	 	 H t t p S e r v l e t R e q u e s t   r e q u e s t   =   ( H t t p S e r v l e t R e q u e s t ) m a p . g e t ( " r e q u e s t " ) ;  
 	 	 S t r i n g   b I d   =   r e q u e s t . g e t P a r a m e t e r ( " b I d " ) ;  
 	 	 B D a o   b D a o   =   n e w   B D a o ( ) ;  
 	 	 B D t o   b D t o   =   b D a o . c o n t e n t V i e w ( b I d ) ;  
 	 	 m o d e l . a d d A t t r i b u t e ( " c o n t e n t _ v i e w " ,   b D t o ) ;  
 	 	  
 	 }  
  
 }  
