 p a c k a g e   c o m . j a v a l e c . e x ;  
  
 p u b l i c   c l a s s   M y C a l c u l a t o r   {  
 	 p r i v a t e   i n t   f i r s t N u m ;  
 	 p r i v a t e   i n t   s e c o n d N u m ;  
 	 C a l c u l a t o r   c a l c u l a t o r ;  
 	  
 / * 	 p u b l i c   M y C a l c u l a t o r ( i n t   f i r s t N u m ,   i n t   s e c o n d N u m )   {  
 	 	 t h i s . f i r s t N u m   =   f i r s t N u m ;  
 	 	 t h i s . s e c o n d N u m   =   s e c o n d N u m ;  
 	 } * /  
 	  
  
 	 p u b l i c   i n t   g e t F i r s t N u m ( )   {  
 	 	 r e t u r n   f i r s t N u m ;  
 	 }  
 	 p u b l i c   v o i d   s e t F i r s t N u m ( i n t   f i r s t N u m )   {  
 	 	 t h i s . f i r s t N u m   =   f i r s t N u m ;  
 	 }  
 	 p u b l i c   i n t   g e t S e c o n d N u m ( )   {  
 	 	 r e t u r n   s e c o n d N u m ;  
 	 }  
 	 p u b l i c   v o i d   s e t S e c o n d N u m ( i n t   s e c o n d N u m )   {  
 	 	 t h i s . s e c o n d N u m   =   s e c o n d N u m ;  
 	 }  
 	 p u b l i c   C a l c u l a t o r   g e t C a l c u l a t o r ( )   {  
 	 	 r e t u r n   c a l c u l a t o r ;  
 	 }  
 	 p u b l i c   v o i d   s e t C a l c u l a t o r ( C a l c u l a t o r   c a l c u l a t o r )   {  
 	 	 t h i s . c a l c u l a t o r   =   c a l c u l a t o r ;  
 	 }  
 	 p u b l i c   v o i d   a d d ( )   {  
 	 	 c a l c u l a t o r . a d d i t i o n ( f i r s t N u m ,   s e c o n d N u m ) ;  
 	 }  
 	 p u b l i c   v o i d   s u b ( )   {  
 	 	 c a l c u l a t o r . s u b t r a c t ( f i r s t N u m ,   s e c o n d N u m ) ;  
 	 }  
 	 p u b l i c   v o i d   m u l ( )   {  
 	 	 c a l c u l a t o r . m u l t i p l y ( f i r s t N u m ,   s e c o n d N u m ) ;  
 	 }  
 	 p u b l i c   v o i d   d i v ( )   {  
 	 	 c a l c u l a t o r . d i v i s i o n ( f i r s t N u m ,   s e c o n d N u m ) ;  
 	 }  
  
 }  
