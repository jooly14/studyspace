 p a c k a g e   c o m . j a v a l e c . e x ;  
  
 i m p o r t   o r g . s p r i n g f r a m e w o r k . c o n t e x t . s u p p o r t . A b s t r a c t A p p l i c a t i o n C o n t e x t ;  
 i m p o r t   o r g . s p r i n g f r a m e w o r k . c o n t e x t . s u p p o r t . G e n e r i c X m l A p p l i c a t i o n C o n t e x t ;  
  
 p u b l i c   c l a s s   H o m e C o n t r o l l e r {  
 	  
 	 p u b l i c   s t a t i c   v o i d   m a i n ( S t r i n g [ ]   a r g s )   {  
  
 / *  
 	 	 c a l c . s e t F i r s t N u m ( 3 ) ;  
 	 	 c a l c . s e t S e c o n d N u m ( 2 ) ;  
 	 	 c a l c . a d d ( ) ;  
 	 	 c a l c . s u b ( ) ;  
 	 	 c a l c . m u l ( ) ;  
 	 	 c a l c . d i v ( ) ;  
 	 * /  
 	 	 S t r i n g   c o n f i g L o c a t i o n   =   " c l a s s p a t h : a p p l i c a t i o n C T X . x m l " ;  
 	 	 A b s t r a c t A p p l i c a t i o n C o n t e x t   c t x   =   n e w   G e n e r i c X m l A p p l i c a t i o n C o n t e x t ( c o n f i g L o c a t i o n ) ;  
 	 	 M y C a l c u l a t o r   m y C a l   =   c t x . g e t B e a n ( " m y C a l c u l a t o r " ,   M y C a l c u l a t o r . c l a s s ) ;  
 	 	  
 	 	 m y C a l . a d d ( ) ;  
 	 	 m y C a l . s u b ( ) ;  
 	 	 m y C a l . m u l ( ) ;  
 	 	 m y C a l . d i v ( ) ;  
 	 	  
 	 	  
 	 }  
 }