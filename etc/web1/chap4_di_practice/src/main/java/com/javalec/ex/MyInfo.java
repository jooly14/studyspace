 p a c k a g e   c o m . j a v a l e c . e x ;  
  
 i m p o r t   j a v a . u t i l . A r r a y L i s t ;  
  
 p u b l i c   c l a s s   M y I n f o   {  
 	 p r i v a t e   S t r i n g   n a m e ;  
 	 p r i v a t e   d o u b l e   w e i g h t ;  
 	 p r i v a t e   d o u b l e   h e i g h t ;  
 	 p r i v a t e   B M I C a l c u l a t o r   b m i C a l c u l a t o r ;  
 	 p r i v a t e   A r r a y L i s t < S t r i n g >   h o b b y s ;  
 	  
 	 p u b l i c   v o i d   g e t I n f o ( )   {  
 	 	 S y s t e m . o u t . p r i n t l n ( n a m e   + "???X  ̴??@   "   +   w e i g h t   + "?t??  Ф??   " +   h e i g h t   + "ǅ?Ȳ? . " ) ;  
 	 	 b m i C a l c u l a t o r . b m i C a l c u l a t i o n ( w e i g h t ,   h e i g h t ) ;  
 	 	 S y s t e m . o u t . p r i n t l n ( "??????   "   +   h o b b y s   + "  ǅ?Ȳ? . " ) ;  
 	 }  
 	 p u b l i c   S t r i n g   g e t N a m e ( )   {  
 	 	 r e t u r n   n a m e ;  
 	 }  
 	 p u b l i c   v o i d   s e t N a m e ( S t r i n g   n a m e )   {  
 	 	 t h i s . n a m e   =   n a m e ;  
 	 }  
 	 p u b l i c   d o u b l e   g e t W e i g h t ( )   {  
 	 	 r e t u r n   w e i g h t ;  
 	 }  
 	 p u b l i c   v o i d   s e t W e i g h t ( d o u b l e   w e i g h t )   {  
 	 	 t h i s . w e i g h t   =   w e i g h t ;  
 	 }  
 	 p u b l i c   d o u b l e   g e t H e i g h t ( )   {  
 	 	 r e t u r n   h e i g h t ;  
 	 }  
 	 p u b l i c   v o i d   s e t H e i g h t ( d o u b l e   h e i g h t )   {  
 	 	 t h i s . h e i g h t   =   h e i g h t ;  
 	 }  
 	 p u b l i c   B M I C a l c u l a t o r   g e t B m i C a l c u l a t o r ( )   {  
 	 	 r e t u r n   b m i C a l c u l a t o r ;  
 	 }  
 	 p u b l i c   v o i d   s e t B m i C a l c u l a t o r ( B M I C a l c u l a t o r   b m i C a l c u l a t o r )   {  
 	 	 t h i s . b m i C a l c u l a t o r   =   b m i C a l c u l a t o r ;  
 	 }  
 	 p u b l i c   A r r a y L i s t < S t r i n g >   g e t H o b b y s ( )   {  
 	 	 r e t u r n   h o b b y s ;  
 	 }  
 	 p u b l i c   v o i d   s e t H o b b y s ( A r r a y L i s t < S t r i n g >   h o b b y s )   {  
 	 	 t h i s . h o b b y s   =   h o b b y s ;  
 	 }  
 	  
 	  
 }  
