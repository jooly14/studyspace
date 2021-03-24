/*//const title = document.getElementById("title");
const title = document.querySelector("#title");
//console.dir(title); //dir을 쓰면 내가 사용가능한 요소들을 확인할 수 있음.
title.innerHTML ="Hi. From JS"; //DOM(document object modle) 모든 요소들을 객체로 사용가능.
title.style.color = 'red';
//console.dir(document);

function handleMouseEnter(event){
    //console.log("I have been resized"); //resize 이벤트에서 사용.
    //console.log(event);
    title.style.color ="blue";
} 

title.addEventListener("click",handleMouseEnter); //ctrl+shift+l
*/

/* 
//조건문 공부함.
const age = prompt("How old are you?");
if(age>=18 && age<=21)    {
console.log("You can drink, but you shouldn't");
}else if (age>21){
    console.log("go ahead");
}else{
    console.log("Too young");
}
*/

//event로 color 바꾸기
const title = document.querySelector("#title");
const BASE_COLOR = "rgb(52, 73, 94)"; //rgb이여야 제대로 동작함.
const OTHER_COLOR ="#7f8c8d";

function handleMouseEnter(){
    const currentColor = title.style.color
        if(currentColor === BASE_COLOR){
            console.log('other color');
            title.style.color =OTHER_COLOR;
        }else{
            title.style.color =BASE_COLOR;
            console.log('base color');
        }
}

function init(){
    title.style.color = "BASE_COLOR";
    title.addEventListener("mouseenter", handleMouseEnter);
}
//mdn 에서 event의 종류를 모두 확인할수 있다.
init();