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
	<link href="css/libraryuse.css" rel="stylesheet">
 
</head>
<body>
  <div id="wrap">
     <jsp:include page="header.jsp"></jsp:include>
      <nav class="nav1">
           <ul>
               <li>�α���</li>
               <li>ȸ������</li>
               <li>å����ȸ�����Խ�û</li>
           </ul>
        </nav>
        </div>
        
             <div class="p1" id="p1">
                 <div class="b-img">
                     <h1>������ �̿�</h1>
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
                 <a href="#p2"><li>�̿�ð�/�ް���</li></a>
                 <a href="#p3"><li>������ȸ�����Ծȳ�</li></a>
                 <a href="#p4"><li>��������/�ݳ�/����</li></a>
                 <a href="#p5"><li>�������̿�ȳ�</li></a>
                 <a href="#p6"><li>��������ó����ħ</li></a>

             </ul>
         </div>
     </div>
             
             
             <div class="p2" id="p2">
               <div class="wrap">
                <h2>�̿�ð�/�ް���</h2>
                 <h3><i class="fas fa-feather-alt"></i> ������ �Ǻ� �̿�ð�</h3>
                 <table>
                     <tr>
                        <td>�Ǻ�</td>
                         <td>����</td>
                         <td>��,�Ͽ���</td>
                     </tr>
                     <tr>
                       <td>����ڷ��</td>
                         <td colspan="2" rowspan="4">09:00~18:00</td>
                     </tr>
                     <tr>
                     <td>�����н�</td>
                     
                     </tr>
                     <tr> <td>��1,2�ڷ��</td></tr>
                     <tr><td>���Ӱ��๰��</td></tr>
                     <tr><td>�����н���</td>
                     <td colspan="2">09:00~18:00</td></tr>
                 </table>
                 <h3><i class="fas fa-feather-alt"></i> �ް���</h3>
                     <table class="tb2">
                         <tr>
                             <td>���� �ް���(�ڷ��)</td>
                             <td>���� ������(������ ��ü)</td>
                             <td>�ӽ� �ް���</td>
                         </tr>
                         <tr>
                             <td><span class="red">���� ������</span><br>����������</td>
                             <td>����,��,�߼� ����</td>
                             <td>������ ������ ����<br>������ ������ ��</td>
                         </tr>
                     </table>
                 </div>
             </div>
             
             <div class="p3" id="p3">
                 <div class="wrap">
                     <h2>������ ȸ������ �ȳ�</h2>
                     <h3><i class="fas fa-feather-alt"></i> ������ ȸ������</h3>
                     <h4><i class="far fa-check-circle"></i> ���Դ��</h4>
                     <p>������</p>
                     <h4><i class="far fa-check-circle"></i> ���񼭷�(��߱� ����)</h4>
                     <table>
                         <tr>
                             <td>���</td>
                             <td colspan="2">���񼭷�</td>
                             <td>�߱�ó</td>
                         </tr>
                         <tr>
                             <td>�� 14�� �̸���</td>
                             <td>�����븮�� ����,<br>�ֹε�ϵ</td>
                             <td rowspan="3">������ ȸ������<br>��û��<br>(������ �������)</td>
                             <td>����ڷ��(1��)</td>
                         </tr>
                         <tr>
                             <td>��,����л�</td>
                             <td>�л���</td>
                             <td rowspan="2">��1�ڷ��(2��)</td>
                         </tr>
                         <tr>
                             <td>�Ϲ���</td>
                             <td>�ź���(�ֹε�Ϲ�ȣ,<br>���� ����)</td>
                         </tr>
                     </table>
                     <h4><i class="far fa-check-circle"></i> ������ ȸ���� ��߱�</h4>
                     <ul>
                         <li>�ʿ伭�� �����Ͽ� ��û ��� �߱�</li>
                         <li>4ȸ(���� 1ȸ ����) �߱� �ú��� 1���� �� ȸ���� �߱� �� ���� ����</li>
                     </ul>
                     <h3><i class="fas fa-feather-alt"></i> ��������ȸ������ �</h3>
                     <h4><i class="far fa-check-circle"></i> ���Թ��</h4>
                     <ul>
                         <li>��� : �ּ����� ������ ��������� �� 2�� �̻� ���� ȸ�������� �Ǿ� �ִ� ����</li>
                         <li>���񼭷� : �ֹε�ϵ</li>
                         <li>��� : ��1�ڷ��, ����ڷ�</li>
                     </ul>
                     <h4><i class="far fa-check-circle"></i> ���� å�� �� ����</h4>
                     <p>ȸ�����Ե� ������x5��, 14�ϰ� ����</p>
                     
                     <h4><i class="far fa-check-circle"></i> �̿���</h4>
                     <p>����ȸ�� �� ������ ������ ������ ȸ������ ����</p>
                 </div>
             </div>
             <div class="p4" id="p4">
                 <div class="wrap">
                     <h2>��������/�ݳ�����</h2>
                     <h3><i class="fas fa-feather-alt"></i> ��������</h3>
                     <h4><i class="far fa-check-circle"></i> ������</h4>
                     <ul>
                         <li>â���� ��ȭ����������� ������ ȸ�� ������</li>
                         <li>���� �Ǽ� : 1�δ� ��10��(��,�������������� 5�� ���� )<br>��) ��â������5��,���굵����5��<br>
      ��â������5��, ��������н�����3��, �ȹθ���������2��</li>
                         <li>���� �Ⱓ : 14��(2��)</li>
                     </ul>
                     <h3><i class="fas fa-feather-alt"></i> �����ݳ�</h3>
                     <ul>
                         <li>���� �����ð� ���� �Ŀ��� 1�� �κ� ���� �ڵ��ݳ��⿡�� �ݳ� ����</li>
                         <li>�ݳ� �������� ������ �ް����� ��� �������� �ݳ��� �ڵ� ����</li>
                         <li>�ݳ� �������� ������ ������ �ݳ��Ͽ��� ���<br>
- 30�� �̸� : ��ü �ϼ���ŭ ���� ����<br>
- 30�� �̻� : ��ü �ϼ��� 2�� �Ⱓ ���� ����(�ִ� 2��)<br>
�� ����ȸ���� ��� �� ���� 15�� �̻� ��ü�� ��� ���� ��ü �������� ���� ����<br></li>
                    <li>�ݳ� ����� 1ȸ�� ���Ͽ� ����, �ݳ� �����Ϸκ��� 7�� ���� ����<br>
- �ݳ� ���� ���<br>
<ol>
<li>
Ȩ������ : Ȩ������ �α��� �� ����������(���� ���) �� �������� ������ȸ ��ȸ �� �ݳ����⵵�� üũ �� �ݳ����� ��ư Ŭ��</li>
<li>������ �湮 : ������ ȸ���� ����</li>
 </ol>
- �ݳ� ���� �Ұ� : �������� ȸ��, ��ü ����, ���� ����<br>
- ����ȸ�� �ݳ� ���� : ����ȸ�� �� �� ���� ���̵�� �α����ϸ� ���� ��ü �ϰ� �ݳ� ���� ����<br></li>
                    <li>���⵵���� �н�, �Ѽ� �� ���� ����(��, ������ ������ ��� ������ ���� ���� ����)</li>
                     </ul>
                     <h3><i class="fas fa-feather-alt"></i> ��������</h3>
                     <ul>
                     <li>���� �Ǽ� : 1�� 2��(1�Ǵ� 2����� ���� ����)</li>
                     <li>���� ��� : ���� ���� ����</li>
                     <li>���� ��� : Ȩ������ �α��� �� ���� �˻� �� ���� ���� �� ���⿹���ϱ� ��ư Ŭ��</li>
                     <li>���൵�� �ȳ� : ���൵�� �ݳ� �� ������ �޴������� ���� ���� �ȳ� ���� �߼�</li>
                     <li>���൵�� ���� : ���൵�� �ݳ����� �����Ͽ� 3�� �̳� ���� ����</li>
                </ul>
                 </div>
             </div>
             <div class="p5" id="p5">
                 <div class="wrap">
                     <h2>������ �̿�ȳ�</h2>
                     <h3><i class="fas fa-feather-alt"></i> ������ �̿����� ����</h3>
                     <ul>
                         <li>������ ��Ģ�̳� ����� �� ���Ѿ� �մϴ�. ���� �� �ݳ������� �� �����ּ���. (����Ⱓ 14��)</li>
                         <li>������������ ���ߵ����� ���Ѿ� �մϴ�.</li>
                         <li>������ �ڷ� �� �ü��� ������ �ٷ��� �մϴ�. (å�� �Ѽ� �� �ļ�����, å�� ��ġ�� ���� ����)</li>
                         <li>�ڷ�ǿ����� ���Ĺ��� ������ �� �����Ƿ� �ްԽ��� �̿��ϼ���.</li>
                         <li>�ٸ� ����鿡�� ���ذ� �Ǵ� ������ ���� �ʵ��� �սô�. (ū �Ҹ��� ����� ���� ��)</li>
                         <li>������ �������� �޴��� ����� ������ �ּ���.</li>
                         <li>�̿��� �ڷ�� �ݳ� å���̿� �����ּ���.</li>
                     </ul>
                 </div>
             </div>
             <div class="p6" id="p6">
                 <div class="wrap">
                     <h2>��������ó����ħ</h2>
                     <h3><i class="fas fa-feather-alt"></i> ��������ó������� ��ġ �ٰ� �� ��ġ ����</h3>
                     <h4><i class="far fa-check-circle"></i> �� �������� ����������ȣ�� ��25�� ��1�׿� ���� ������ ���� �������� ��������ó����⸦ ��ġ��� �մϴ�.</h4>
                     <ul>
                         <li>�ü��� �������� �� ����(�н�, ����) ����</li>
                         <li>���� �赵</li>
                     </ul>
                     <h3><i class="fas fa-feather-alt"></i> ��ġ���, ��ġ ��ġ �� �Կ�����</h3>
                     <table>
                         <tr>
                             <td>��ġ ���</td>
                             <td>��ġ ��ġ �� �Կ� ����</td>
                         </tr>
                         <tr>
                             <td>22��</td>
                             <td>�ǹ�����,�ܺ�,������(������20m�̳�)</td>
                         </tr>
                     </table>
                     <h3><i class="fas fa-feather-alt"></i> ����å���� �� ���ٱ�����</h3>
                     <h4><i class="far fa-check-circle"></i> ������ ���������� ��ȣ�ϰ� ���ο��������� ������ �Ҹ��� ó���ϱ� ���Ͽ� �Ʒ��� ���� ���ο������� ��ȣå���ڸ� �ΰ� �ֽ��ϴ�.</h4>
                     <table class="tb2">
                         <tr>
                             <td></td>
                             <td>�̸�</td>
                             <td>����</td>
                             <td>�Ҽ�</td>
                             <td>����ó</td>
                         </tr>
                         <tr>
                             <td>����å����</td>
                             <td>ȸ����������</td>
                             <td>����</td>
                             <td>ȸ��������</td>
                             <td>055)225-7460</td>
                         </tr>
                         <tr>
                             <td>���ٱ�����</td>
                             <td>�ü��� �����<br>û������</td>
                             <td>�ֹ���<br>û������</td>
                             <td>ȸ��������</td>
                             <td>055)225-7460</td>
                         </tr>
                     </table>
                     <h3><i class="fas fa-feather-alt"></i> ���������� �Կ��ð�,�����Ⱓ,������� �� ó�����</h3>
                     <table class="tb3">
                         <tr>
                             <td>�Կ��ð�</td>
                             <td>�����Ⱓ</td>
                             <td>�������</td>
                         </tr>
                         <tr>
                             <td>24�ð�</td>
                             <td>�Կ��Ϸκ��� 5��</td>
                             <td>�ȳ���</td>
                         </tr>
                     </table>
                     <ul>
                         <li>ó����� : ���ο��������� ������ �̿�, ��3�� ����, �ı�, ���� �� �䱸�� ���� ������ ��Ϥ������ϰ�, �����Ⱓ ����� ������ �Ұ����� ������� ���� ����(��¹��� ��� �ļ� �Ǵ� �Ұ�)�մϴ�.</li>
                     </ul>
                     <h3><i class="fas fa-feather-alt"></i> ���ο��������� Ȯ�� ��� �� ��ҿ� ���� ����</h3>
                     <ul>
                         <li>Ȯ�� ��� : �������� ����å���ڿ��� �̸� �����ϰ� �� �������� �湮�Ͻø� Ȯ�� �����մϴ�.</li>
                         <li>Ȯ�� ��� : ��â������ ������� 055)225-7331</li>
                     </ul>
                     <h3><i class="fas fa-feather-alt"></i> ������ü�� �������� ���� �� �䱸�� ���� ��ġ</h3>
                     <h4><i class="far fa-check-circle"></i> ���ϴ� ���ο��������� ���Ͽ� ���� �Ǵ� ����Ȯ�Τ������� ���ϴ� ��� �������� ��������ó����� ��ڿ��� �䱸�Ͻ� �� �ֽ��ϴ�. ��, ���ϰ� �Կ��� ���ο������� �� ����� ������ü�� �޹��� ����, ��ü, ����� ������ ���Ͽ� �ʿ��� ���ο��������� �����˴ϴ�. �� �������� ���ο��������� ���Ͽ� ���� �Ǵ� ����Ȯ�Τ������� �䱸�� ��� ��ü���� �ʿ��� ��ġ�� �ϰڽ��ϴ�.<br>
��ó������ : ��������(����, ���� �� ����, ó�� ����)��� �� ����å���� ���� �� ��������(����, �Ϻο���, ���� ����, ���� ����)����</h4>
                     <h3><i class="fas fa-feather-alt"></i> ���������� ������ Ȯ����ġ</h3>
                     <h4><i class="far fa-check-circle"></i> �� ���������� ó���ϴ� ���������� ������ �� �������� ���� ���Ͽ� �����ϰ� �����ǰ� �ֽ��ϴ�. ���� �� �������� ���ο���������ȣ�� ���� ������ ��å���μ� ���������� ���� ���� ������ ����ο��ϰ� �ְ�, ���ο��������� �������� ������ ���Ͽ� ���ο��������� ���� �Ͻ�, ������ ���� �����������ڤ����� �Ͻ� ���� ����Ͽ� �����ϰ� �ֽ��ϴ�. �� �ܿ��� ���ο��������� ������ ������ ������ ���Ͽ� �����ġ�� ��ġ�ϰ� �ֽ��ϴ�.</h4>
                     <h3><i class="fas fa-feather-alt"></i> �������� ó����ħ ���濡 ���� ����</h3>
                     <h4><i class="far fa-check-circle"></i> ���� �� ��å �Ǵ� ���ȱ���� ���濡 ���� ������ �߰� �� ���� �� ������ ���� �ÿ��� �����ϱ� �ּ� 7������ �� ������ Ȩ�������� ���� ������� �� ���� ���� �����ϵ��� �ϰڽ��ϴ�.
                     <ul>
                         <li>�������� : 2012�� 5�� 29�� / �������� : 2014�� 9�� 5��</li>
                     </ul>
                     </h4>
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
                 console.log($("html, body").scrollTop());
                if($(window).width()>800){
                    if($("html, body").scrollTop()>=200){
                        $(".page-index").css("position","fixed");
                        $(".page-index").css("top","80px");
                    }else{
                         $(".page-index").css("position","inherit");
                        $(".page-index").css("top","0px");
                    }
                      $(".page-index").css("height","80px");
                    $(".page-index li").css({
                                            "font-size":"15px",
                                            "height":"30px",
                                            "padding-top":"10px"
                                            })
                }else{
                   
                      $(".page-index").css("position","fixed");
                    $(".page-index").css("top","80px");
                    $(".page-index").css("height","60px");
                    $(".page-index li").css({
                                            "font-size":"13px",
                                            "height":"25px",
                                            "padding-top":"10px"
                                            })
                }
                     $(".page-index li").css("font-weight","normal");
                if($("html, body").scrollTop()>=$(".p6").offset().top-20){
                    $(".page-index li").eq(4).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p5").offset().top-20){
                    $(".page-index li").eq(3).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p4").offset().top-20){
                    $(".page-index li").eq(2).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p3").offset().top-20){
                    $(".page-index li").eq(1).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p2").offset().top-20){
                    $(".page-index li").eq(0).css("font-weight","bold");
                }
            });
           if($(window).width()>800){
                     if($("html, body").scrollTop()>=200){
                        $(".page-index").css("position","fixed");
                        $(".page-index").css("top","80px");
                         
                    }else{
                         $(".page-index").css("position","inherit");
                        $(".page-index").css("top","0px");
                    }
                     $(".page-index").css("height","80px");
                    $(".page-index li").css({
                                            "font-size":"15px",
                                            "height":"30px",
                                            "padding-top":"10px"    
                                            })
                }else{
                      $(".page-index").css("position","fixed");
                    $(".page-index").css("top","80px");
                    $(".page-index").css("height","60px");
                    $(".page-index li").css({
                                            "font-size":"13px",
                                            "height":"25px",
                                            "padding-top":"10px"
                                            })
            }
//             var pageidx = -1;
            $(".page-index a").click(function(e){
                e.preventDefault();
//                $(".page-index li").css("font-weight","normal");
//                $(this).children("li").css("font-weight","bold");
                var idx = $(this).index();
                idx = ".p"+(idx+2);
                $("html, body").stop().animate({
                    scrollTop :$(idx).offset().top-20
                },500);
//                pageidx = $(this).index();
            });
//           
            $(".page-index a").hover(function(){
                $(this).children("li").css("font-weight","bold");
            },function(){
                    $(".page-index li").css("font-weight","normal");
                if($("html, body").scrollTop()>=$(".p6").offset().top-20){
                    $(".page-index li").eq(4).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p5").offset().top-20){
                    $(".page-index li").eq(3).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p4").offset().top-20){
                    $(".page-index li").eq(2).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p3").offset().top-20){
                    $(".page-index li").eq(1).css("font-weight","bold");
                }else  if($("html, body").scrollTop()>=$(".p2").offset().top-20){
                    $(".page-index li").eq(0).css("font-weight","bold");
                }
            });
            
            
            
        });
    </script>
</body>
</html>