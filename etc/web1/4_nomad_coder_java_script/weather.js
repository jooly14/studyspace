const weather = document.querySelector(".js-weather");
const API_KEY = "b97d5ce5452a7892bf0ee5a4c67e156d";
const COORD='coords';


function getWeather(lat, lon){
    fetch(`https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${API_KEY}&units=metric`
    ).then(function(response){
        return response.json();
    })
    .then(function(json){
        const temperature = json.main.temp;
        const place = json.name;
        weather.innerText = `${temperature} @ ${place}`;
    });

}

function saveCoords(obj){
    localStorage.setItem(COORD,JSON.stringify(obj));
}

function handleGeoSuccess(position){
    const latitude =position.coords.latitude;
    const longitude = position.coords.longitude;
    const coordObj = {
        latitude,
        longitude
        };
    saveCoords(coordObj);
    getWeather(latitude,longitude);
}
function handleGeoError(){
    console.log(`Can't access geo location`);
}

function askForCoord(){
    navigator.geolocation.getCurrentPosition(handleGeoSuccess, handleGeoError);
}

function loadCoords(){
    const loadedCoords = localStorage.getItem(COORD);
    if(loadedCoords === null){
        askForCoord();
    }else{
       const parsedLoadedCoord = JSON.parse(loadedCoords);
        getWeather(parsedLoadedCoord.latitude,parsedLoadedCoord.longitude);
    }
}

function init(){
    loadCoords();
}
init();
