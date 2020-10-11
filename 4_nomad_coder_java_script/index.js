const title = document.querySelector("#title");

const CLICKED_CLASS ="clicked";

function handleClick(){
   // const currentClass = title.className; //classlist를 모를때 사용. class여러개 사용할때는 classlist사용
   title.classList.toggle(CLICKED_CLASS);
   
    /* if(title.classList.contains(CLICKED_CLASS)){
        title.classList.remove(CLICKED_CLASS);
    }else{
        title.classList.add(CLICKED_CLASS);
    }
    */
}
function init(){
    title.addEventListener("click",handleClick);
}
init();