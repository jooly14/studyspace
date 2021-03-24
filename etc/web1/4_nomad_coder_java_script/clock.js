const clockContatiner = document.querySelector(".js-clock"),
    clockTitle = clockContatiner.querySelector("h1");

function getTime(){
    const date = new Date();
    const minutes = date.getMinutes();
    const hours = date.getHours();
    const seconds = date.getSeconds();
    clockTitle.innerText = `${hours<10? `0${hours}` : hours
}:${minutes<10? `0${minutes}`: minutes
}:${seconds<10?`0${seconds}` : seconds}`; //삼항연산자
}
function init(){
setInterval(getTime,1000);
}

init();
