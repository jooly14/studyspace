 p a c k a g e   c o m . j a v a l e c . e x . c o n t r o l l e r ;  
  
 i m p o r t   j a v a x . s e r v l e t . h t t p . H t t p S e r v l e t R e q u e s t ;  
  
 i m p o r t   o r g . s p r i n g f r a m e w o r k . s t e r e o t y p e . C o n t r o l l e r ;  
 i m p o r t   o r g . s p r i n g f r a m e w o r k . u i . M o d e l ;  
 i m p o r t   o r g . s p r i n g f r a m e w o r k . w e b . b i n d . a n n o t a t i o n . R e q u e s t M a p p i n g ;  
 i m p o r t   o r g . s p r i n g f r a m e w o r k . w e b . b i n d . a n n o t a t i o n . R e q u e s t M e t h o d ;  
  
 i m p o r t   c o m . j a v a l e c . e x . c o m m a n d . B C o m m a n d ;  
 i m p o r t   c o m . j a v a l e c . e x . c o m m a n d . B C o n t e n t C o m m a n d ;  
 i m p o r t   c o m . j a v a l e c . e x . c o m m a n d . B D e l e t e C o m m a n d ;  
 i m p o r t   c o m . j a v a l e c . e x . c o m m a n d . B L i s t C o m m a n d ;  
 i m p o r t   c o m . j a v a l e c . e x . c o m m a n d . B M o d i f y C o m m a n d ;  
 i m p o r t   c o m . j a v a l e c . e x . c o m m a n d . B R e p l y C o m m a n d ;  
 i m p o r t   c o m . j a v a l e c . e x . c o m m a n d . B R e p l y V i e w C o m m a n d ;  
 i m p o r t   c o m . j a v a l e c . e x . c o m m a n d . B W r i t e C o m m a n d ;  
  
 @ C o n t r o l l e r  
 p u b l i c   c l a s s   B C o n t r o l l e r   {  
 	  
 	 B C o m m a n d   b C o m m a n d ;  
 	  
 	 @ R e q u e s t M a p p i n g ( " / l i s t " )  
 	 p u b l i c   S t r i n g   l i s t ( M o d e l   m o d e l )   {  
 	 	 S y s t e m . o u t . p r i n t l n ( " l i s t ( ) " ) ;  
 	 	 b C o m m a n d   =   n e w   B L i s t C o m m a n d ( ) ;  
 	 	 b C o m m a n d . e x e c u t e ( m o d e l ) ;  
 	 	 r e t u r n   " l i s t " ;  
 	 }  
 	 @ R e q u e s t M a p p i n g ( " / w r i t e _ v i e w " )  
 	 p u b l i c   S t r i n g   w r i t e _ v i e w ( )   {  
 	 	 S y s t e m . o u t . p r i n t l n ( " w r i t e _ v i e w ( ) " ) ;  
 	 	 r e t u r n   " w r i t e _ v i e w " ;  
 	 }  
 	  
 	 @ R e q u e s t M a p p i n g ( " / w r i t e " )  
 	 p u b l i c   S t r i n g   w r i t e ( H t t p S e r v l e t R e q u e s t   h t t p S e r v l e t R e q u e s t , M o d e l   m o d e l )   {  
 	 	 S y s t e m . o u t . p r i n t l n ( " w r i t e ( ) " ) ;  
 	 	 m o d e l . a d d A t t r i b u t e ( " r e q u e s t " ,   h t t p S e r v l e t R e q u e s t ) ;  
 	 	 b C o m m a n d   =   n e w   B W r i t e C o m m a n d ( ) ;  
 	 	 b C o m m a n d . e x e c u t e ( m o d e l ) ;  
 	 	 r e t u r n   " r e d i r e c t : l i s t " ;  
 	 }  
 	 @ R e q u e s t M a p p i n g ( " / c o n t e n t _ v i e w " )  
 	 p u b l i c   S t r i n g   c o n t e n t _ v i e w ( H t t p S e r v l e t R e q u e s t   h t t p S e r v l e t R e q u e s t ,   M o d e l   m o d e l )   {  
 	 	 S y s t e m . o u t . p r i n t l n ( " c o n t e n t _ v i e w " ) ;  
 	 	 m o d e l . a d d A t t r i b u t e ( " r e q u e s t " , h t t p S e r v l e t R e q u e s t ) ;  
 	 	 b C o m m a n d   =   n e w   B C o n t e n t C o m m a n d ( ) ;  
 	 	 b C o m m a n d . e x e c u t e ( m o d e l ) ;  
 	 	 r e t u r n   " c o n t e n t _ v i e w " ;  
 	 }  
 	  
 	 @ R e q u e s t M a p p i n g ( v a l u e = " / m o d i f y " ,   m e t h o d   =   R e q u e s t M e t h o d . P O S T )  
 	 p u b l i c   S t r i n g   m o d i f y ( H t t p S e r v l e t R e q u e s t   h t t p S e r v l e t R e q u e s t ,   M o d e l   m o d e l )   {  
 	 	 S y s t e m . o u t . p r i n t l n ( " m o d i f y ( ) " ) ;  
 	 	 m o d e l . a d d A t t r i b u t e ( " r e q u e s t " , h t t p S e r v l e t R e q u e s t ) ;  
 	 	 b C o m m a n d   =   n e w   B M o d i f y C o m m a n d ( ) ;  
 	 	 b C o m m a n d . e x e c u t e ( m o d e l ) ;  
 	 	 r e t u r n   " r e d i r e c t : l i s t " ;  
 	 }  
 	  
 	 @ R e q u e s t M a p p i n g ( " / r e p l y _ v i e w " )  
 	 p u b l i c   S t r i n g   r e p l y _ v i e w ( H t t p S e r v l e t R e q u e s t   h t t p S e r v l e t R e q u e s t ,   M o d e l   m o d e l )   {  
 	 	 S y s t e m . o u t . p r i n t l n ( " r e p l y _ v i e w ( ) " ) ;  
 	 	 m o d e l . a d d A t t r i b u t e ( " r e q u e s t " , h t t p S e r v l e t R e q u e s t ) ;  
 	 	 b C o m m a n d   =   n e w   B R e p l y V i e w C o m m a n d ( ) ;  
 	 	 b C o m m a n d . e x e c u t e ( m o d e l ) ;  
 	 	 r e t u r n   " r e p l y _ v i e w " ;  
 	 }  
 	  
 	 @ R e q u e s t M a p p i n g ( " / r e p l y " )  
 	 p u b l i c   S t r i n g   r e p l y ( H t t p S e r v l e t R e q u e s t   h t t p S e r v l e t R e q u e s t ,   M o d e l   m o d e l )   {  
 	 	 S y s t e m . o u t . p r i n t l n ( " r e p l y ( ) " ) ;  
 	 	 m o d e l . a d d A t t r i b u t e ( " r e q u e s t " , h t t p S e r v l e t R e q u e s t ) ;  
 	 	 b C o m m a n d   =   n e w   B R e p l y C o m m a n d ( ) ;  
 	 	 b C o m m a n d . e x e c u t e ( m o d e l ) ;  
 	 	 r e t u r n   " r e d i r e c t : l i s t " ;  
 	 }  
 	  
 	 @ R e q u e s t M a p p i n g ( " / d e l e t e " )  
 	 p u b l i c   S t r i n g   d e l e t e ( H t t p S e r v l e t R e q u e s t   h t t p S e r v l e t R e q u e s t ,   M o d e l   m o d e l )   {  
 	 	 S y s t e m . o u t . p r i n t l n ( " d e l e t e ( ) " ) ;  
 	 	 m o d e l . a d d A t t r i b u t e ( " r e q u e s t " , h t t p S e r v l e t R e q u e s t ) ;  
 	 	 b C o m m a n d   =   n e w   B D e l e t e C o m m a n d ( ) ;  
 	 	 b C o m m a n d . e x e c u t e ( m o d e l ) ;  
 	 	 r e t u r n   " r e d i r e c t : l i s t " ;  
 	 }  
 }  
