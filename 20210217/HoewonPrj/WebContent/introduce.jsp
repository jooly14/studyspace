<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
  />
  	<link rel="stylesheet" href="css/introduce.css">
</head>
<body>
  <div id="wrap">
     <jsp:include page="header.jsp"></jsp:include>
        
             <div class="p1" id="p1">
                 <div class="b-img">
                      <h1>������ �Ұ�</h1>
                      <form action="#">
                      <div class="sear-box">
                       <select name="se1" class="se1">
                           <option value="o1" selected>�ڷ�˻�</option>
                           <option value="o2">ǥ��</option>
                           <option value="o3">����</option>
                           <option value="o4">������</option>
                           <option value="o5">Ű����</option>
                       </select>
                       <input type="search" placeholder="�˻�� �Է��ϼ���">
                       <input type="submit" value="�˻�">
                      </div>
       </form>
                 
                 </div>
             </div>
             <div class="page-index">
         <div class="page-index2">
           
             <ul>
                 <a href="#p1-2"><li>�ü�/�ڷ���Ȳ</li></a>
                 <a href="#p2"><li>��1,2�ڷ��</li></a>
                 <a href="#p3"><li>����ڷ��</li></a>
                 <a href="#p4"><li>���Ӱ��๰��</li></a>
                 <a href="#p5"><li>�������ڷ��</li></a>
                 <a href="#p6"><li>�����н���</li></a>
                 <a href="#p7"><li>����/�����ȳ�</li></a>
                 <a href="#p8"><li>ã�ƿ��ô±�</li></a>
             </ul>
         </div>
     </div>
             
             
             
             <div class="p1-2" id="p1-2">
               <div class="wrap">
                <h2>�ü�/�ڷ���Ȳ</h2>
                <div class="b1">
                   <img src="img/library-img.png">
                   
                    <p><br>��ġ : â���� ����ȸ���� 3��15��� 558(ȸ���� 167-1)</p>
                    <p>���� : ���� 1��, ���� 3��</p>
                    <p>�������� : 5,173��</p>
                    <p>������ : 2,007��</p>
                    <p>�� �¼� : 404��</p>
                </div>
                <div class="b2">
                  
                   <h4>���� �ȳ���</h4>
                   <div class="imgbox">
                      <span class="btnX">X</span>
                       <img class="fac-img1" src="img/img_fac_b1.png">
                       <img class="fac-img2" src="img/img_fac_1f.png">
                       <img class="fac-img3" src="img/img_fac_2f.png">
                       <img class="fac-img4" src="img/img_fac_3f.png">
                   </div>
                    <p>���� 1��</p>
                    
                    <p>1��</p>
                    
                    <p>2��</p>
                    
                    <p>3��</p>
                    <p>�� ������ �ȳ����� ���÷��� �ش� ���� Ŭ���غ�����~</p>
                    <i class="fas fa-bookmark"></i>
                </div>
                 <h3><i class="fas fa-feather-alt"></i> ���� �ü���Ȳ</h3>
                 <table>
                     <tr>
                        <td>��</td>
                         <td>�ü���</td>
                         <td>�¼���</td>
                         <td>�ü��ȳ�</td>
                     </tr>
                     <tr>
                       <td rowspan="3">���� 1��</td>
                       <td>��û����</td>
                       <td>52</td>
                       <td>���� ��� �� ��ȭ��</td>
                     </tr>
                     <tr>
                     <td>��ȸ�ǽ�</td>
                     <td>16</td>
                     <td>-</td>
                     </tr>
                     <tr>
                      <td>�ްԽ�</td>
                      <td>20</td>
                      <td>�޽� �� ���� �н�</td>
                      </tr>
                     <tr>
                         <td rowspan="2">1��</td>
                         <td>����ڷ��</td>
                         <td>40</td>
                         <td>���� �� �Ƶ� ���� ����, ����</td>
                     </tr>
                     <tr>
                     <td>�繫��</td>
                     <td>-</td>
                     <td>������ �繫, ������ �ڷ� �з� �� ����</td>
                     </tr>
                     <tr>
                         <td rowspan="4">2��</td>
                         <td>��1�ڷ��</td>
                         <td>-</td>
                         <td>�Ϲݵ��� ���� �� ����, �����ڷ� �� �����ڷ� ����</td>
                     </tr>
                     <tr>
                         <td>���Ӱ��๰��</td>
                         <td>14</td>
                         <td>�Ź�, ���� �� ����</td>
                     </tr>
                     <tr>
                         <td>�����н���(����)</td>
                         <td>98</td>
                         <td>���� ���� �н�</td>
                     </tr>
                     <tr>
                     <td>�ްԽ�</td>
                     <td>-</td>
                     <td>�޽İ���</td>
                     </tr>
                     <tr>
                         <td rowspan="4">3��</td>
                         <td>��2�ڷ��</td>
                         <td>16</td>
                         <td>�Ϲݵ��� ���� �� ����</td>
                     </tr>
                     <tr>
                         <td>�������ڷ��</td>
                         <td>34</td>
                         <td>���ͳ�, ��������, DVD, ���ڵ��� �̿�</td>
                     </tr>
                     <tr>
                         <td>�����н���(����)</td>
                         <td>114</td>
                         <td>���� ���� �н�</td>
                     </tr>
                     <tr>
                         <td>�ްԽ�</td>
                         <td>-</td>
                         <td>�޽� ����</td>
                     </tr>
                 </table>
                 <h3><i class="fas fa-feather-alt"></i> �ڷ� ��Ȳ</h3>
                    <h4><i class="far fa-check-circle"></i> ���� ��Ȳ</h4>
                     <table class="tb2 tb3">
                        <caption>2021�� 1�� 10�� ����</caption>
                         <tr>
                             <td>����</td>
                             <td>�ѷ�</td>
                             <td>ö��</td>
                             <td>����</td>
                             <td>��ȸ<br>����</td>
                             <td>����<br>����</td>
                             <td>���<br>����</td>
                             <td>����</td>
                             <td>����</td>
                             <td>����</td>
                             <td>����</td>
                             <td>��</td>
                         </tr>
                            <tr>
                             <td>����<br>ȸ��<br>������</td>
                             <td>7,365</td>
                             <td>10,890</td>
                             <td>5,351</td>
                             <td>32,638</td>
                             <td>13,562</td>
                             <td>15,201</td>
                             <td>8,594</td>
                             <td>11,813</td>
                             <td>70,837</td>
                             <td>16,138</td>
                             <td>192,389</td>
                         </tr>
                     </table>
                <h4><i class="far fa-check-circle"></i> ���Ӱ��๰ ��Ȳ</h4>
                       <table class="tb2">
                        <caption>2021�� 1�� 10�� ����</caption>
                         <tr>
                             <td>����</td>
                             <td colspan="3">�Ѱ�</td>
                             <td colspan="3">�����Ұ�</td>
                             <td colspan="3">��������</td>
                             <td colspan="3">��������</td>
                             <td colspan="3">�Ź�</td>
                             <td colspan="3">��ȸ��</td>
                         </tr>
                            <tr>
                             <td rowspan="2">��</td>
                             <td>��</td>
                             <td>����</td>
                             <td>����</td>
                             <td>��</td>
                             <td>����</td>
                             <td>����</td>
                             <td>��</td>
                             <td>����</td>
                             <td>����</td>
                             <td>��</td>
                             <td>����</td>
                             <td>����</td>
                             <td>��</td>
                             <td>����</td>
                             <td>����</td>
                             <td>��</td>
                             <td>����</td>
                             <td>����</td>
                         </tr>
                             <tr>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                         </tr>
                     </table>
                <h4><i class="far fa-check-circle"></i> �񵵼� ��Ȳ</h4>
                        <table class="tb2  tb4">
                        <caption>2021�� 1�� 10�� ����</caption>
                         <tr>
                             <td>����</td>
                             <td>�񵵼���</td>
                             <td>DVD</td>
                             <td>E-BOOK</td>
                             <td>���������</td>
                             <td>�������</td>
                             <td>CD</td>
                             <td>CD-ROM</td>
                             <td>LD</td>
                             <td>LP</td>
                             <td>TAPE</td>
                             <td>VT</td>
                             <td>MAP</td>
                         </tr>
                            <tr>
                             <td>�Ѱ�</td>
                             <td>6,584</td>
                             <td>5,002</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>1,554</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>0</td>
                             <td>28</td>
                             <td>0</td>
                         </tr>
                     </table>
                 </div>
             </div>
             
             
             
             <div class="p2" id="p2">
               <div class="wrap">
                <h2>��1,2�ڷ��</h2>
                 
<!--                 <img src="img/book-img%20(2).png">-->
                 <div class="b1">
                    <img src="img/img_ready.png">
                     <p>�Ϲݵ��� ���� �� ����</p>
                     <p>�����ڷ� ����(���� ���� �Ұ�)</p>
                     <p>��ȭ��ȣ : 225-7477</p>
                     <p>��ġ : 2~3��</p>
                     <h4>�̿�ð�</h4>
                     <p>ȭ~�Ͽ��� 09:00~18:00</p>
                     
                 </div>
                 <div class="b2">
                 <i class="fas fa-bookmark"></i>
                 <h4>�̿���</h4>
                     <p>���л� �̻� �̿� ����</p>
                     
                 <h4>�̿�ȳ�</h4>
                     <table>
                         <tr>
                             <td>����</td>
                             <td>��1�ڷ��<br>(2��)</td>
                             <td>��2�ڷ��<br>(2��)</td>
                         </tr>
                         <tr>
                             <td>����<br>����</td>
                             <td>�Ϲݵ���(���, ����, ����)<br>���嵵��, ������, ���ڵ���</td>
                             <td>�Ϲݵ���(�ѷ�, ö��, ����, ��ȸ����, �ڿ�����, �������, ����)</td>
                         </tr>
                         <tr>
                             <td>�̿�<br>����</td>
                             <td>���� ���� �ݳ�, �ڷ� �˻�</td>
                             <td>ȸ���� �߱�,<br> �ڷ� �˻�,<br> �ڷ� ����</td>
                         </tr>
                         <tr>
                             <td>���</td>
                             <td colspan="2">3���� 2�� ������ �����Ͽ�<br> ���� ����</td>
                         </tr>
                     </table>
                 </div>
                 
                 </div>
             </div>
             <div class="p3" id="p3">
                 <div class="wrap">
                    <h2>��� �ڷ��</h2>
                     <div class="b1">
                    <img src="img/img_ready.png">
                     <p>���� �� ��� ���� ����, ����</p>
                     <p>��ȭ��ȣ : 225-7476</p>
                     <p>��ġ : 1��</p>
                     <h4>�̿�ð�</h4>
                     <p>ȭ~�Ͽ��� 09:00~18:00</p>
                     
                 </div>
                 <div class="b2">
                 <i class="fas fa-bookmark"></i>
                 <h4>�̿���</h4>
                     <p>����, �ʵ��л�</p>
                     
                 <h4>�̿�ȳ�</h4>
                    <ul>
                        <li>���� �� ��� ���� ����, ����</li>
                        <li>��� �����ڷ� ����<br>(���� ���� �ȵ�)</li>
                        <li>��� ���Ⱓ�๰ ����<br>(���� ���� �ȵ�)</li>
                        <li>������ ȸ���� �߱�</li>
                        <li>�ڷ� �˻�</li>
                    </ul>
                 </div>
                 </div>
             </div>
             <div class="p4" id="p4">
                 <div class="wrap">
                     <h2>���� ���๰��</h2>
                      <div class="b1">
                    <img src="img/img_ready.png">
                     <p>�Ź�, ���� �� ���� ���๰ ����</p>
                     <p>��ġ : 2��</p>
                     <h4>�̿�ð�</h4>
                     <p>ȭ~�Ͽ��� 09:00~18:00</p>
                     
                 </div>
                 <div class="b2">
                 <i class="fas fa-bookmark"></i>
                 <h4>�̿���</h4>
                     <p>���л� �̻� �̿� ����</p>
                     
                 <h4>�̿�ȳ�</h4>
                    <ul>
                        <li>�Ź�, ����, �����ڷ�, ��������ڷ� �� ����</li>
                        <li>���Ӱ��๰�� �� ��� �ڷ�� ������� ������, ������ ����� ����(��, ����ȣ ������ ����)</li>
                        <li>����ȣ ��������<br> - ��� : 3���� ����� ����ȣ ����<br>
- �Ǽ� �� ���� : 1�� 3�� 2�ְ�<br>
(* 1ȸ�� ���Ͽ� 1���� ���� ����, ���� ���� �Ǽ��� ������)</li>
                        


                    </ul>
                 </div>
                 </div>
             </div>
               <div class="p5" id="p5">
                 <div class="wrap">
                     <h2>������ �ڷ��</h2>
                      <div class="b1">
                    <img src="img/img_ready.png">
                     <p>���ͳ� �ڷ�˻�,��������,������ �ڷ῭��(���ܴ��� �ȵ�)</p>
                     <p>��ȭ��ȣ : 225-7479</p>
                     <p>��ġ : 3��</p>
                     <h4>�̿�ð�</h4>
                     <p>ȭ~�Ͽ��� 09:00~18:00</p>
                       <h4>�̿���</h4>
                     <p>���л� �̻� �̿� ����</p>
                      <h4>��ǻ�� �̿���</h4>
                    <ul>
                        <li>�¼� ���� ��ǻ�Ϳ��� ȸ�������Ͽ� �ش� �¼� ���� �� �̿�</li>
                        <li>1�� 2�ð����� ���(2�ð� ���� ����)</li>
                    </ul>
                 </div>
                 <div class="b2">
                 <i class="fas fa-bookmark"></i>
               
                 <h4>�̿�ȳ�</h4>
                    <ul>
                        <li>������ �ڷ�(CD/DVD/���ڵ���), ���� ����, ���ͳ� �˻� �� 28��</li>
                        <li>��Ʈ�� 2��(�� ���� ���̵�� �������� ����)</li>
                        <li>���� ���� : ��ȸ������, �����߾ӵ�����</li>
                        <li>������ : ����ī�� �����Ͽ� ���(A4 1��� 60��)</li>
                        <li>��ĳ�� : ���� �̿�</li>
                    </ul>
                   
                    <h4>CD/DVD �̿���</h4>
                    <ul>
                        <li>�ȳ�����ũ�� �ź����� �����ϰ� �ڷḦ ����޾� ���� �¼����� �̿�</li>
                        <li>DVD�� 1�� 1�� ���� ����</li>
                    </ul>
                    <h4>���ǻ���</h4>
                    <ul>
                        <li>Ÿ�� ���Ƿ� ��ǻ�� ���� �� ��� ����</li>
                        <li>��ǻ�� ��� �� ä��, ����, ����, ���ػ���Ʈ �� �̿� ����</li>
                    </ul>
                 </div>
                 </div>
             </div>
               <div class="p6" id="p6">
                 <div class="wrap">
                     <h2>�����н���</h2>
                      <div class="b1">
                    <img src="img/img_ready.png">
                     <p>���� �� �ڷḦ ������ �� ������ �н��������ε� ����</p>
                     <p>��ȭ��ȣ : ������� 055-225-7461<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1�� �ȳ��� 055-225-7469</p>
                     <p>��ġ : 2��,3��</p>
                     <h4>�̿�ð�</h4>
                     <p>��~�� 09:00~18:00(����,��,�߼����� �ް�)</p>
                     <h4>�̿���</h4>
                     <p>���л� �̻� �̿� ����</p>
                 </div>
                 <div class="b2">
                 <i class="fas fa-bookmark"></i>
                 
                  <h4>�̿��¼���</h4>
                <ul>
                    <li>���� �н���(2��) : 98��(ĭ����)</li>
                    <li>���� �н���(3��) : 114��(ĭ����)</li>
                </ul>
                 <h4>�̿�ȳ�</h4>
                    <ul>
                        <li>1�� �κ�(�ȳ��� ��) �¼��߱ޱ⿡�� �¼���ȣǥ �߱� �� �̿�</li>
                        <li>5�ð����� ���� ��û (����ð� 1�ð� ������ ���� ����)</li>
                        <li>��� �� �¼��߱ޱ⿡�� �ݳ� ó��</li>
                    </ul>
                   <h4>���ǻ���</h4>
                    <ul>
                        <li>1�� 1�¼� �¼���ȣǥ �߱� �ؼ�</li>
                        <li>����, ���, ���Ĺ� ����, ��Ʈ�� ��� ����</li>
                        <li>���μ���ǰ ���� ����(������������ �н� �� ������ ���� å������ ����)</li>
                    </ul>
                  


                 </div>
                 </div>
             </div>
             
             <div class="p7" id="p7">
                 <div class="wrap">
                     <h2>����/�����ȳ�</h2>
                     <table>
                         <tr>
                             <td>����</td>
                             <td>������</td>
                             <td>��ȭ��ȣ</td>
                             <td>������</td>
                         </tr>
                         <tr>
                             <td>����</td>
                             <td>�̼�ȣ</td>
                             <td>225-7460</td>
                             <td>���������� �Ѱ�</td>
                         </tr>
                         <tr>
                             <td rowspan="5">�������</td>
                             <td>������</td>
                             <td>225-7462</td>
                             <td>���������� �Ѱ�</td>
                         </tr>
                         <tr>
                             <td>������</td>
                             <td>225-7463</td>
                             <td>����, ȸ��</td>
                         </tr>
                         <tr>
                             <td>���μ�</td>
                             <td>225-7464</td>
                             <td>û�� �� �ü� ���� ����</td>
                         </tr>
                         <tr>
                             <td>������</td>
                             <td>225-7466</td>
                             <td>����</td>
                         </tr>
                         <tr>
                             <td>�����,������,�̼���</td>
                             <td>225-7469</td>
                             <td>�ȳ�,ġ������</td>
                         </tr>
                         <tr>
                             <td rowspan="6">�缭���</td>
                             <td>������</td>
                             <td>225-7472</td>
                             <td>�缭��� ���� �Ѱ�</td>
                         </tr>
                         <tr>
                             <td>���ȭ</td>
                             <td>225-7473</td>
                             <td>���, ��ȭ����</td>
                         </tr>
                         <tr>
                             <td>������</td>
                             <td>225-7474</td>
                             <td>�ڷᱸ��,����,���</td>
                         </tr>
                         <tr>
                             <td>������</td>
                             <td>225-7467</td>
                             <td>1,2�ڷ�� �� ���Ӱ��๰��, ��Ÿ�η°���</td>
                         </tr>
                         <tr>
                             <td>�ڼ���</td>
                             <td>225-7476</td>
                             <td>����ڷ�� �� ��� ��ȭ��� �</td>
                         </tr>
                         <tr>
                             <td>�輱��</td>
                             <td>225-7475</td>
                             <td>���� ����</td>
                         </tr>
                     </table>
                 </div>
             </div>
                          
             <div class="p8" id="p8">
                 <div class="wrap">
                     <h2>ã�ƿ��ô� ��</h2>
   <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3259.2730560878526!2d128.5713597156035!3d35.22457216248714!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x356f320377a1c0c7%3A0x8fec3a9aec608230!2z66eI7IKw7ZqM7JuQ64-E7ISc6rSA!5e0!3m2!1sko!2skr!4v1611914213604!5m2!1sko!2skr"  frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                     <h3><i class="fas fa-feather-alt"></i> ���ô� ��</h3>
                     <ul>
                         <li>�ּ� : (51324) ��󳲵� â���� ����ȸ���� 3��15��� 558(ȸ����)</li>
                         <li>��ȭ : 055-225-7471</li>
                         <li>�ѽ� : 055-225-4804</li>
                     </ul>
                 </div>
             </div>
    	<jsp:include page="footer.jsp"></jsp:include>
        
    </div>
    
    
          <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js" type="text/javascript"></script>
     <script>
        $(function(){
            $(".link-top a").attr("href","#");
            $(".link-top a").click(function(e){
                e.preventDefault();
                $("html, body").stop().animate({
                    scrollTop:"0"
                },500);
            });
            
            $(window).on("scroll resize",function(){
                if($(window).width()>1200){
                    if($("html, body").scrollTop()>=200){
                        $(".page-index").css("position","fixed");
                        $(".page-index").css("top","80px");
                    }else{
                         $(".page-index").css("position","inherit");
                        $(".page-index").css("top","0px");
                    }
                      $(".page-index").css("height","70px");
                    $(".page-index li").css({
                                            "font-size":"15px",
                                            "height":"30px",
                                            "padding-top":"10px"
                                            })
                }else if($(window).width()>800){
                          if($("html, body").scrollTop()>=200){
                        $(".page-index").css("position","fixed");
                        $(".page-index").css("top","80px");
                    }else{
                         $(".page-index").css("position","inherit");
                        $(".page-index").css("top","0px");
                    }
                      $(".page-index").css("height","100px");
                    $(".page-index li").css({
                                            "font-size":"15px",
                                            "height":"30px",
                                            "padding-top":"10px"
                                            })
                }else{
                   
                      $(".page-index").css("position","fixed");
                    $(".page-index").css("top","80px");
                    $(".page-index").css("height","80px");
                    $(".page-index li").css({
                                            "font-size":"13px",
                                            "height":"25px",
                                            "padding-top":"5px"
                                            })
                }
                     $(".page-index li").css("font-weight","normal");
                if($("html, body").scrollTop()>=$(".p8").offset().top-50){
                    $(".page-index li").eq(7).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p7").offset().top-50){
                    $(".page-index li").eq(6).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p6").offset().top-50){
                    $(".page-index li").eq(5).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p5").offset().top-50){
                    $(".page-index li").eq(4).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p4").offset().top-50){
                    $(".page-index li").eq(3).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p3").offset().top-50){
                    $(".page-index li").eq(2).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p2").offset().top-50){
                    $(".page-index li").eq(1).css("font-weight","bold");
                }else if($("html, body").scrollTop()>=$(".p1-2").offset().top-50){
                    $(".page-index li").eq(0).css("font-weight","bold");
                }
               $(".p1-2 .imgbox span").css("transform","translate("+($(window).innerWidth()*0.7/2-$(".p1-2 .imgbox span").innerWidth()/1.3)+"px,-"+($(window).innerHeight()*0.7/2-$(".p1-2 .imgbox span").innerHeight()/3)+"px)");

            });
           if($(window).width()>1200){
                     if($("html, body").scrollTop()>=200){
                        $(".page-index").css("position","fixed");
                        $(".page-index").css("top","80px");
                         
                    }else{
                         $(".page-index").css("position","inherit");
                        $(".page-index").css("top","0px");
                    }
                     $(".page-index").css("height","70px");
                    $(".page-index li").css({
                                            "font-size":"15px",
                                            "height":"30px",
                                            "padding-top":"10px"
            
                    });
               
               
            }else if($(window).width()>800){
                     
                  if($("html, body").scrollTop()>=200){
                        $(".page-index").css("position","fixed");
                        $(".page-index").css("top","80px");
                    }else{
                         $(".page-index").css("position","inherit");
                        $(".page-index").css("top","0px");
                    }
                      $(".page-index").css("height","100px");
                    $(".page-index li").css({
                                            "font-size":"15px",
                                            "height":"30px",
                                            "padding-top":"10px"
                                            });
                     
            }else{
                      $(".page-index").css("position","fixed");
                    $(".page-index").css("top","80px");
                    $(".page-index").css("height","80px");
                    $(".page-index li").css({
                                            "font-size":"13px",
                                            "height":"25px",
                                            "padding-top":"5px"
                                            });
            
            }
            $(".page-index a").click(function(e){
                e.preventDefault();
//                $(".page-index li").css("font-weight","normal");
//                $(this).children("li").css("font-weight","bold");
                var idx = $(this).index();
                if(idx==0){
                    idx = ".p1-2";
                }else{
                    idx = ".p"+(idx+1);
                }
                $("html, body").stop().animate({
                    scrollTop :$(idx).offset().top-50
                },500);
            });
//           
            $(".page-index a").hover(function(){
                $(this).children("li").css("font-weight","bold");
            },function(){
                 $(".page-index li").css("font-weight","normal");
                if($("html, body").scrollTop()>=$(".p8").offset().top-50){
                    $(".page-index li").eq(7).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p7").offset().top-50){
                    $(".page-index li").eq(6).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p6").offset().top-50){
                    $(".page-index li").eq(5).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p5").offset().top-50){
                    $(".page-index li").eq(4).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p4").offset().top-50){
                    $(".page-index li").eq(3).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p3").offset().top-50){
                    $(".page-index li").eq(2).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p2").offset().top-50){
                    $(".page-index li").eq(1).css("font-weight","bold");
                }else if($("html, body").scrollTop()>=$(".p1-2").offset().top-50){
                    $(".page-index li").eq(0).css("font-weight","bold");
                }
            });
            
            /////////////////���� �ȳ��� Ŭ���� �����ִ� ȭ��////////////////
            var imgboxidx;
            $(".p1-2 .b2 p").not($(".p1-2 .b2 p:nth-child(7)")).click(function(){
                
                imgboxidx = $(this).index();
                 $(".imgbox").css("display","flex");
                $(".imgbox").animate({
                    height:"100vh",
                },500,function(){
                     $(".imgbox img").eq(imgboxidx-2).css("display","block");
                    $(".imgbox img").eq(imgboxidx-2).animate({
                        opacity:"1"
                    },500);
                });
            });
            $(".imgbox span").click(function(){
                $(".imgbox img").eq(imgboxidx-2).animate({
                   opacity:"0"
                },500,function(){
                     $(".imgbox img").eq(imgboxidx-2).css("display","none");
                    $(".imgbox").animate({
                        height:"0"
                    },500,function(){
                         $(".imgbox").css("display","none");
                    });
                });
            });
            $(".imgbox span").css("cursor","pointer");
            $(".p1-2 .imgbox span").css("z-index","30");
               $(".p1-2 .imgbox span").css("transform","translate("+($(window).innerWidth()*0.7/2-$(".p1-2 .imgbox span").innerWidth()/1.3)+"px,-"+($(window).innerHeight()*0.7/2-$(".p1-2 .imgbox span").innerHeight()/3)+"px)");
        });
    </script>
</body>
</html>