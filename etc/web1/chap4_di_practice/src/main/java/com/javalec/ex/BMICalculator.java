 p a c k a g e   c o m . j a v a l e c . e x ;  
  
 p u b l i c   c l a s s   B M I C a l c u l a t o r   {  
 	  
 	 p r i v a t e   d o u b l e   l o w W e i g h t ;  
 	 p r i v a t e   d o u b l e   n o r m a l W e i g h t ;  
 	 p r i v a t e   d o u b l e   o v e r W e i g h t ;  
 	 p r i v a t e   d o u b l e   o b e s i t y ;  
 	  
 	 p u b l i c   v o i d   b m i C a l c u l a t i o n ( d o u b l e   w e i g h t ,   d o u b l e   h e i g h t )   {  
 	 	 d o u b l e   h   =   h e i g h t   *   0 . 0 1 ;  
 	 	 d o u b l e   r e s u l t   =   w e i g h t / ( h * h ) ;  
 	 	  
 	 	 i f ( r e s u l t >   o b e s i t y )   {  
 	 	 	 S y s t e m . o u t . p r i n t l n ( "�D��ǅ�Ȳ� . " ) ;  
 	 	 } e l s e   i f   ( r e s u l t   > o v e r W e i g h t )   {  
 	 	 	 S y s t e m . o u t . p r i n t l n ( "��̴�ǅ�Ȳ� . " ) ;  
 	 	 } e l s e   i f ( r e s u l t > n o r m a l W e i g h t )   {  
 	 	 	 S y s t e m . o u t . p r i n t l n ( "���ǅ�Ȳ� " ) ;  
 	 	 } e l s e   {  
 	 	 	 S y s t e m . o u t . p r i n t l n ( "� ̴�ǅ�Ȳ� " ) ;  
 	 	 }  
 	 }  
 	  
 	 p u b l i c   d o u b l e   g e t L o w W e i g h t ( )   {  
 	 	 r e t u r n   l o w W e i g h t ;  
 	 }  
  
 	 p u b l i c   v o i d   s e t L o w W e i g h t ( d o u b l e   l o w W e i g h t )   {  
 	 	 t h i s . l o w W e i g h t   =   l o w W e i g h t ;  
 	 }  
  
 	 p u b l i c   d o u b l e   g e t N o r m a l W e i g h t ( )   {  
 	 	 r e t u r n   n o r m a l W e i g h t ;  
 	 }  
  
 	 p u b l i c   v o i d   s e t N o r m a l W e i g h t ( d o u b l e   n o r m a l W e i g h t )   {  
 	 	 t h i s . n o r m a l W e i g h t   =   n o r m a l W e i g h t ;  
 	 }  
  
 	 p u b l i c   d o u b l e   g e t O v e r W e i g h t ( )   {  
 	 	 r e t u r n   o v e r W e i g h t ;  
 	 }  
  
 	 p u b l i c   v o i d   s e t O v e r W e i g h t ( d o u b l e   o v e r W e i g h t )   {  
 	 	 t h i s . o v e r W e i g h t   =   o v e r W e i g h t ;  
 	 }  
  
 	 p u b l i c   d o u b l e   g e t O b e s i t y ( )   {  
 	 	 r e t u r n   o b e s i t y ;  
 	 }  
  
 	 p u b l i c   v o i d   s e t O b e s i t y ( d o u b l e   o b e s i t y )   {  
 	 	 t h i s . o b e s i t y   =   o b e s i t y ;  
 	 }  
  
 }  
