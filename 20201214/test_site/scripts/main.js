let myHeading = document.querySelector('h1');
myHeading.textContent = 'Hello World';

let myImage = document.querySelector('img');
myImage.onclick = function(){
    if(myImage.getAttribute('src')==="images/smile.png"){
        myImage.setAttribute('src',"images/soso.png");
    }else{
        myImage.setAttribute('src',"images/smile.png")
    }
}