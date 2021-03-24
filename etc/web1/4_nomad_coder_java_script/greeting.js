const form = document.querySelector(".js-form"),
    input = form.querySelector("input"),
    greeting = document.querySelector(".js-greetings");
    
const USER_LS = "currentUser",
    SHOWING_CN = "showing";


function paintGreeting(text){
    form.classList.remove(SHOWING_CN);
    //console.log(greeting);
    greeting.classList.add(SHOWING_CN);
    greeting.innerHTML = `HELLO ${text.toUpperCase()}`;
}

function saveName(name){
    localStorage.setItem("currentUser",name);
}
function handleSubmit(event){
   // console.log(event);
    event.preventDefault();
    const currentValue = input.value;
    saveName(currentValue);
    paintGreeting(currentValue);
}

function askForName(){
    form.classList.add(SHOWING_CN);
    form.addEventListener("submit",handleSubmit);
}
function loadName(){
    const currentUser = localStorage.getItem(USER_LS);
    if(currentUser === null){
        askForName();
    }else{
        //console.log(currentUser);
        paintGreeting(currentUser);
    }

}

function init(){
    loadName();
}
init();
